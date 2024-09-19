package com.example.pam_4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_4.R
import com.example.pam_4.data.StudentModel

class StudentAdapter(private val itemList: List<StudentModel>) : RecyclerView.Adapter<StudentAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.studentImage)
        val nameTextView: TextView = itemView.findViewById(R.id.studentName)
        val nimTextView: TextView = itemView.findViewById(R.id.studentNim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.imageView.setImageResource(item.image)
        holder.nameTextView.text = item.name
        holder.nimTextView.text = item.nim
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
