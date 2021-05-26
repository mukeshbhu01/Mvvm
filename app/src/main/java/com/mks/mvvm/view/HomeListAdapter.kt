package com.mks.mvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mks.mvvm.R
import com.mks.mvvm.model.User

class HomeListAdapter(private var list : List<User>, private val context : Context) : RecyclerView.Adapter<HomeListAdapter.HomeListHolder>() {

    class HomeListHolder(view: View) : RecyclerView.ViewHolder(view) {
        val firstName : TextView = view.findViewById(R.id.firstName)
        val lastName : TextView = view.findViewById(R.id.lastName)
        val email : TextView = view.findViewById(R.id.email)
        val image : ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_list_view, parent, false)
        return HomeListHolder(view)
    }

    override fun onBindViewHolder(holder: HomeListHolder, position: Int) {
        holder.firstName.text = list[position].first_name
        holder.lastName.text = list[position].last_name
        holder.email.text = list[position].email
        Glide.with(context).load(list[position].avatar).centerCrop().into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateModel(list: List<User>) {
        this.list = list
        notifyDataSetChanged()
    }
}