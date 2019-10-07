package com.example.kotlinyelp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinyelp.data.Business

class BusinessListViewAdapter(
    val businesses: List<Business>,
    private val itemClickedListener: (position: Int, type: Int) -> Unit)
    : RecyclerView.Adapter<BusinessListViewAdapter.ViewHolder>() {

    override fun getItemCount() = businesses.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_business, parent, false)
        return ViewHolder(view).listen(itemClickedListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(businesses[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.name)
        val address: TextView = itemView.findViewById(R.id.address)

        fun bind(business: Business) {
            Glide.with(image.context).load(business.image_url).into(image)
            name.text = business.name
            address.text = business.location.toString()
        }
    }
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(getAdapterPosition(), getItemViewType())
    }
    return this
}
