package com.example.projekkel3_bismillahbangget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class WesternActivity : AppCompatActivity() {
    val arrayList = ArrayList<KatalogMenu>()
    val displayList= ArrayList<KatalogMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_western)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")

        //set title in another activity
        actionBar.setTitle(aTitle)
        arrayList.add(KatalogMenu("Steak", "Steak adalah sepotong besar daging, biasanya daging sapi. Daging merah, dada ayam, dan ikan sering kali dipotong menjadi steik.", R.drawable.steak, resources.getString(R.string.steak), resources.getString(R.string.langkah_steak)))
        arrayList.add(KatalogMenu("Lasagna", "Lasagna atau lasagne adalah pasta yang dipanggang di oven dan merupakan makanan tradisional Italia. Lasagna sendiri secara harfiah adalah lasagne yang berisikan daging.", R.drawable.lasagna, resources.getString(R.string.lasagna), resources.getString(R.string.langkah_lasagna)))
        arrayList.add(KatalogMenu("Ratatouille", "Ratatouille adalah jenis masakan Provence yang berasal dari daerah Nice. Oleh karena itu, dalam bahasa Prancis makanan ini umum disebut sebagai ratatouille niçois", R.drawable.ratatouille, resources.getString(R.string.ratatouille), resources.getString(R.string.langkah_ratatouille)))
        arrayList.add(KatalogMenu("Macarani Schotel", "Makaroni schotel atau terkadang disebut sebagai makaroni schaal adalah sebuah hidangan kaserol makaroni Indonesia yang terbuat dari pasta, keju, susu, mentega, daging, sosis, tuna, telur, bawang bombay, jamur dan terkadang kentang. Asal hidangan tersebut adalah Eropa.", R.drawable.macaroni, resources.getString(R.string.macaroni), resources.getString(R.string.langkah_macaroni)))
        arrayList.add(KatalogMenu("Burger","Hamburger atau burger adalah sejenis roti berbentuk bundar yang diiris dua, dan di tengahnya diisi dengan patty yang biasanya diambil dari daging, kemudian sayur-sayuran berupa selada, tomat dan bawang bombai.", R.drawable.burger, resources.getString(R.string.burger), resources.getString(R.string.langkah_burger)))
        arrayList.add(KatalogMenu("Chicken Gordon Blue", "Cordon bleu atau schnitzel cordon bleu adalah hidangan daging yang dibungkus dengan keju, kemudian dilapisi tepung roti dan digoreng atau digoreng.", R.drawable.cgb, resources.getString(R.string.cgb), resources.getString(R.string.langkah_cgb)))
        arrayList.add(KatalogMenu("Pizza", "Pizza adalah hidangan asal Italia yang terdiri dari adonan berbasis gandum beragi yang biasanya bulat dan datar di atasnya dengan tomat, keju, dan seringkali berbagai bahan lainnya, yang kemudian dipanggang pada suhu tinggi, secara tradisional dalam oven berbahan bakar kayu.", R.drawable.pizza, resources.getString(R.string.pizza), resources.getString(R.string.langkah_pizza)))
        displayList.addAll(arrayList)

        val recyclerView = findViewById<RecyclerView>(R.id.westernView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WesternAdapter(displayList, this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        arrayList.forEach{
                            if (it.title.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        val recyclerView = findViewById<RecyclerView>(R.id.westernView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        val recyclerView = findViewById<RecyclerView>(R.id.westernView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}