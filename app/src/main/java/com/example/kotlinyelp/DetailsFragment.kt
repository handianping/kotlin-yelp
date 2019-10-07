package com.example.kotlinyelp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kotlinyelp.data.BusinessDao
import com.example.kotlinyelp.data.BusinessRepository
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var pos = arguments!!.getInt("pos")
        val business = BusinessRepository.getInstance(BusinessDao()).getBusiness(pos)
        name.text = business.name
        address.text = business.location.toString()
        alias.text = business.alias
        rating.text = business.rating
        Glide.with(image.context).load(business.image_url).into(image)
    }
}
