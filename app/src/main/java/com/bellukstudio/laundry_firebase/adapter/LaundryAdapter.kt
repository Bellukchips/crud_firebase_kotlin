package com.bellukstudio.laundry_firebase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bellukstudio.laundry_firebase.R
import com.bellukstudio.laundry_firebase.model.LaundryModel

class LaundryAdapter(private val context: Context, private val laundryList: ArrayList<LaundryModel>) : RecyclerView.Adapter<LaundryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rc,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaundryAdapter.ViewHolder, position: Int) {
        holder.bind(laundryList[position])
    }

    override fun getItemCount(): Int {
        return laundryList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = itemView.findViewById<TextView>(R.id.id_data)
        var name = itemView.findViewById<TextView>(R.id.name_data)
        var address = itemView.findViewById<TextView>(R.id.address_data)

        fun bind(laundry : LaundryModel){
            id.text = laundry.getId()
            name.text = laundry.getName()
            address.text = laundry.getAddress()
        }
    }
}