package com.example.projekkel3_bismillahbangget

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Model) {
            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(model.image)
            itemView.findViewById<TextView>(R.id.text1).text = model.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {
            val model = arrayList.get(position)
            //get title with intent, which position si selected
            var gTitle : String = model.title

            if (position == 0) {
                val intent = Intent(context, JajananActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                context.startActivity(intent)
            }
            if (position == 1) {
                val intent = Intent(context, NusantaraActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                context.startActivity(intent)
            }
            if (position == 2) {
                val intent = Intent(context, AsianActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                context.startActivity(intent)
            }
            if (position == 3) {
                val intent = Intent(context, WesternActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                context.startActivity(intent)
            }
            if (position == 4) {
                val intent = Intent(context, ArabicActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                context.startActivity(intent)
            }
            if (position == 5) {
                val intent = Intent(context, MinumanActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                context.startActivity(intent)
            }
        }
    }
}