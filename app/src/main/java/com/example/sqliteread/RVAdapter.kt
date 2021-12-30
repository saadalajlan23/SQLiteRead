package com.example.sqliteread

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
class RVAdapter(private var notes: List<Note>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = notes[position]
        val personData = "${user.text} "

        holder.itemView.apply {
            tvMessage.text = personData




        }
    }

    override fun getItemCount() = notes.size
    fun update(students: List<Note>){
        this.notes = students
        notifyDataSetChanged()
    }
}
