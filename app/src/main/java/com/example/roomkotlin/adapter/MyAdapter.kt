package com.example.roomkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomkotlin.ListFragment
import com.example.roomkotlin.R
import com.example.roomkotlin.model.User
import kotlinx.android.synthetic.main.rv_item.view.*

class MyAdapter(var rvItemClicked: RvItemClicked) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    inner class MyViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User) {
            itemView.tv_name.text = user.firstName
            itemView.tv_lastNAme.text = user.lastName
            itemView.tv_age.text = user.age.toString()
            itemView.rv_layout.setOnClickListener {
                rvItemClicked.onMyItemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

    interface RvItemClicked {
        fun onMyItemClick(user: User)
    }

}