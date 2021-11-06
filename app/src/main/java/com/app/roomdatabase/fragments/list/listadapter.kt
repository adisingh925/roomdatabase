package com.app.roomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.app.roomdatabase.R
import com.app.roomdatabase.model.User

class ListAdapter :RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userlist = emptyList<User>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = userlist[position]
        holder.itemView.findViewById<TextView>(R.id.id).text = currentitem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.firstname).text = currentitem.firstname.toString()
        holder.itemView.findViewById<TextView>(R.id.lastname).text = currentitem.lastname.toString()
        holder.itemView.findViewById<TextView>(R.id.age).text = currentitem.age.toString()

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowlayout).setOnClickListener{
            val actions = listfragmentDirections.actionListfragmentToUpdate(currentitem)
            holder.itemView.findNavController().navigate(actions)
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    fun setdata(user : List<User>)
    {
        this.userlist = user
        notifyDataSetChanged()
    }

}