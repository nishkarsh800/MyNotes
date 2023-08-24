package com.example.techprojects.activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.techprojects.R
import com.example.techprojects.activity.model.NoteBook

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    var list = listOf<NoteBook>()
    fun setContentList(list: List<NoteBook>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_notebook, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        holder.title.text = list[position].title
        holder.desc.text = list[position].desc
    }

    override fun getItemCount(): Int {

        return this.list.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.title_list_item)
        val desc = view.findViewById<TextView>(R.id.desc_list_item)
    }
}