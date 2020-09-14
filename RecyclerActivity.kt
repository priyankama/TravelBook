package com.example.travelbook

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity(  val context: Activity ,val items:List<Rooms>,val itemClick:(Rooms)->Unit) : RecyclerView.Adapter<RecyclerActivity.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerActivity.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.screen_layout,parent,false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(p0: RecyclerActivity.Holder, p1: Int) {
        p0?.bindItem(items[p1],context)
    }
    inner class Holder(
        itemView: View?,
        val itemClick: (Rooms) -> Unit
    ) : RecyclerView.ViewHolder(itemView!!) {
        val roomType: TextView = itemView!!.findViewById(R.id.tvRoomType)
        val capacity: TextView = itemView!!.findViewById(R.id.tvCapacity)
        val inDate: TextView = itemView!!.findViewById(R.id.tvInDate)
        val outDate: TextView = itemView!!.findViewById(R.id.tvOutDate)
        fun bindItem(room: Rooms, context: Context) {

            roomType.text = room.type
            capacity.text = room.capacity.toString()
            inDate.text = room.indate
            outDate.text = room.outdate
            itemView.setOnClickListener { itemClick(room) }

        }
    }

}