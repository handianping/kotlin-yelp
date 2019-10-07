package com.example.kotlinyelp

import android.content.res.Configuration
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinyelp.util.InjectorUtil
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    lateinit var navController: NavController

    private lateinit var viewModel: BusinessViewModel

    private val foods = arrayOf("", "Sushi", "Pizza", "Chinese", "DummyDummy")
    private var indexFood = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        fab.setOnClickListener { button ->
            indexFood = (indexFood + 1) % foods.size;
            search(button);
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = InjectorUtil.provideBusinessViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(BusinessViewModel::class.java)

        search()
    }

    private fun search(view: View? = null) {
        var snackbar: Snackbar? = null
        if (view != null) {
            snackbar = Snackbar.make(view, R.string.searching, Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        viewModel.getBusinesses(foods[indexFood]).observe(this, androidx.lifecycle.Observer { businesses ->
            snackbar?.dismiss()
            val hasResults = businesses.size > 0
            noContent.isGone = hasResults
            listView.isVisible = hasResults
            if (hasResults) {
                val orientation = resources.configuration.orientation
                listView.layoutManager = GridLayoutManager(this.activity, if (orientation == Configuration.ORIENTATION_LANDSCAPE) 3 else 2)
                listView.adapter = BusinessListViewAdapter(businesses) { position, _ ->
                    var bundle = bundleOf("pos" to position)
                    navController.navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
                }
            } else {
                noContent.text = String.format(getString(R.string.no_content), foods[indexFood])
            }
        })
    }
}
