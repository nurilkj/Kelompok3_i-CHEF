package com.example.projekkel3_bismillahbangget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class JajananActivity : AppCompatActivity() {

    val arrayList = ArrayList<KatalogMenu>()
    val displayList = ArrayList<KatalogMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jajanan)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")

        //set title in another activity
        actionBar.setTitle(aTitle)

        arrayList.add(
            KatalogMenu(
                "Kue Cucur",
                "Kue cucur adalah kue tradisional Indonesia yang terbuat dari tepung beras dan gula aren yang digoreng. ",
                R.drawable.cucur,
                resources.getString(R.string.cucurr),
                resources.getString(R.string.langkah_cucur)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Dodol",
                "Dodol adalah makanan manis yang berbahan utama santan kelapa, tepung ketan, gula pasir, gula merah dan garam. ",
                R.drawable.dodol,
                resources.getString(R.string.dodol),
                resources.getString(R.string.langkah_dodol)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Getuk",
                "Getuk adalah makanan ringan yang terbuat dengan bahan utama ketela pohon atau singkong.",
                R.drawable.getuk,
                resources.getString(R.string.getuk),
                resources.getString(R.string.langkah_getuk)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Klepon",
                "Klepon adalah jajanan tradisional yang terbuat dari kombinasi tepung beras, gula merah dan kelapa yang sudah diparut.",
                R.drawable.klepon,
                resources.getString(R.string.cucurr),
                resources.getString(R.string.langkah_cucur)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Kue Lumpur",
                "Kue lumpur adalah penganan ringan dengan bahan utama santan, kentang, tepung terigu, dan telur.",
                R.drawable.lumpur,
                resources.getString(R.string.dodol),
                resources.getString(R.string.langkah_dodol)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Onde-onde",
                "Onde-Onde merupakan jajanan pasar yang mempunyai bentuk bulat berwarna keemasan dan ditaburi biji wijen.",
                R.drawable.onde,
                resources.getString(R.string.getuk),
                resources.getString(R.string.langkah_getuk)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Pancong",
                "Kue pancong adalah kue tradisional asal betawi. Kue ini terbuat dari campuran tepung beras, santan, garam, gula pasir, dan kelapa parut.",
                R.drawable.pancong,
                resources.getString(R.string.cucurr),
                resources.getString(R.string.langkah_cucur)
            )
        )
        arrayList.add(
            KatalogMenu(
                "Putu Mayang",
                "Kue putu mayang khas Betawi terkenal dengan bentuknya yang unik seperti mi beragam warna.",
                R.drawable.putu_mayang,
                resources.getString(R.string.putu_mayang),
                resources.getString((R.string.langkah_putu))
            )
        )
        displayList.addAll(arrayList)

        val recyclerView = findViewById<RecyclerView>(R.id.jajananView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = JajananAdapter(displayList, this)
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
                        arrayList.forEach {
                            if (it.title.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        val recyclerView = findViewById<RecyclerView>(R.id.jajananView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        val recyclerView = findViewById<RecyclerView>(R.id.jajananView)
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