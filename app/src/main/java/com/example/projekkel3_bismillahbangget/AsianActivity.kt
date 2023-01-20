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

class AsianActivity : AppCompatActivity() {

    val arrayList = ArrayList<KatalogMenu>()
    val displayList= ArrayList<KatalogMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asian)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")

        //set title in another activity
        actionBar.setTitle(aTitle)

        arrayList.add(KatalogMenu("Bahn", "Bánh mì atau bánh mỳ adalah roti baguette khas Vietnam yang terbuat dari tepung gandum dan beras. Roti, atau lebih khusus lagi baguette, diperkenalkan oleh orang Prancis selama masa kolonial di Vietnam.", R.drawable.bahn, resources.getString(R.string.bahn), resources.getString(R.string.langkah_bahn)))
        arrayList.add(KatalogMenu("Bulgogi", "Bulgogi adalah olahan daging asal Korea. Daging yang digunakan antara lain daging sirloin atau bagian daging sapi pilihan. ", R.drawable.bulgogi, resources.getString(R.string.bulgogi), resources.getString(R.string.langkah_bulgogi)))
        arrayList.add(KatalogMenu("Canai", "Roti canai atau Paratha adalah sejenis roti pipih dengan pengaruh India yang dapat ditemukan di beberapa negara di Asia Tenggara, antara lain Brunei, Indonesia, Malaysia dan Singapura.", R.drawable.canai, resources.getString(R.string.canai), resources.getString(R.string.langkah_canai)))
        arrayList.add(KatalogMenu("Gyoza", "Gyoza adalah salah satu jenis dumpling yang berisi daging cincang dan sayuran yang dicincang dan dibungkus lembaran tepung terigu", R.drawable.gyoza, resources.getString(R.string.bahn), resources.getString(R.string.langkah_bahn)))
        arrayList.add(KatalogMenu("Ramen","Ramen adalah masakan mi kuah Jepang yang berasal dari Jepang dan Tiongkok.", R.drawable.ramen, resources.getString(R.string.bahn), resources.getString(R.string.langkah_bahn)))
        arrayList.add(KatalogMenu("Tteokbokki", "Tteokbokki adalah hidangan Korea berupa tepung beras yang dimasak dalam bumbu gochujang yang pedas dan manis.", R.drawable.tteok, resources.getString(R.string.bahn), resources.getString(R.string.langkah_bahn)))
        arrayList.add(KatalogMenu("Sushi", "Sushi adalah masakan Jepang dari nasi cuka yang disiapkan, biasanya dengan gula dan garam, disertai dengan berbagai bahan, seperti makanan laut, seringkali mentah, dan sayuran.", R.drawable.asian, resources.getString(R.string.bahn), resources.getString(R.string.langkah_bahn)))
        displayList.addAll(arrayList)

        val recyclerView = findViewById<RecyclerView>(R.id.asianView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AsianAdapter(displayList, this)
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
                        val recyclerView = findViewById<RecyclerView>(R.id.asianView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        val recyclerView = findViewById<RecyclerView>(R.id.asianView)
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