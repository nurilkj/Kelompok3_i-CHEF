package com.example.projekkel3_bismillahbangget

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WesternAdapter(val arrayList: ArrayList<KatalogMenu>, val context: Context) :
    RecyclerView.Adapter<WesternAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(katalog: KatalogMenu) {
            itemView.findViewById<ImageView>(R.id.imageWestern).setImageResource(katalog.image)
            itemView.findViewById<TextView>(R.id.titleWestern).text = katalog.title
            itemView.findViewById<TextView>(R.id.descWestern).text = katalog.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.western, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {
            val katalogMenu = arrayList.get(position)
            //get title and description with intent, which position si selected
            var gTitle : String = katalogMenu.title
            var gDesc : String = katalogMenu.desc
            var gImage : Int = katalogMenu.image
            var gBahan : String = katalogMenu.bahan
            var gLangkah : String = katalogMenu.langkah

            //get intent in kotlin
            val intent = Intent(context, JajananCookingActivity::class.java)
            intent.putExtra("iTitle", gTitle)
            intent.putExtra("iDesc", gDesc)
            intent.putExtra("iImageView", gImage)
            intent.putExtra("iBahan", gBahan)
            intent.putExtra("iLangkah", gLangkah)
            context.startActivity(intent)
        }
    }
}
