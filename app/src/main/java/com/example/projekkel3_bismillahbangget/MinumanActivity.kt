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

class MinumanActivity : AppCompatActivity() {
    val arrayList = ArrayList<KatalogMenu>()
    val displayList= ArrayList<KatalogMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minuman)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")

        //set title in another activity
        actionBar.setTitle(aTitle)
        arrayList.add(KatalogMenu("Es Campur", "Es campur adalah salah satu minuman khas Indonesia yang cara membuatnya dengan mencampurkan berbagai jenis bahan dalam sirop manis. ", R.drawable.es_campur, resources.getString(R.string.escampur), resources.getString(R.string.langkah_escampur)))
        arrayList.add(KatalogMenu("Es Doger", "s doger adalah salah satu susu kelapa dingin yang sering ditemui di Bandung, Jawa Barat. Walaupun es doger berasal dari Cirebon, es doger juga bisa ditemui di kota-kota besar di Indonesia", R.drawable.doger, resources.getString(R.string.esdoger), resources.getString(R.string.langkah_esdoger)))
        arrayList.add(KatalogMenu("Alpukat Kocok", "Alpukat Kocok dibuat dari bahan dasar buah alpukat yang dipotong dan dihaluskan kasar, kemudian ditambah dengan air kelapa, gula, susu, dan es batu", R.drawable.alpukat_kocok, resources.getString(R.string.alpukat), resources.getString(R.string.langkah_alpukat)))
        arrayList.add(KatalogMenu("Es Cendol", "Es cendol adalah penganan yang dibuat dari tepung beras dan sebagainya yang dibentuk dengan penyaring, kemudian dicampur dengan air gula dan santan.", R.drawable.cendol, resources.getString(R.string.cendol), resources.getString(R.string.langkah_cendol)))
        arrayList.add(KatalogMenu("Es Pisang Ijo","Pisang ijo atau es pisang ijo adalah sejenis makanan khas di Sulawesi Selatan, terutama di kota Makassar. Makanan ini terbuat dari bahan utama pisang yang dibalut dengan adonan tepung berwarna hijau.", R.drawable.espisangijo, resources.getString(R.string.pisangijo), resources.getString(R.string.langkah_pisang)))
        arrayList.add(KatalogMenu("Es Selendang Mayang", "Es selendang mayang adalah salah satu minuman tradisional Indonesia asal Jakarta. Minuman ini sekarang jarang ditemukan karena dikalangan masyarakat Betawi sendiri minuman ini dianggap minuman kuno", R.drawable.selendangmayang, resources.getString(R.string.selendangmayang), resources.getString(R.string.langkah_selendangmayang)))
        arrayList.add(KatalogMenu("Es Cincau", "Es cincau adalah sejenis minuman penyegar dengan bahan utama gel yang mirip agar-agar yang dikenal sebagai cincau", R.drawable.escincau, resources.getString(R.string.escincau), resources.getString(R.string.langkah_escincau)))
        displayList.addAll(arrayList)

        val recyclerView = findViewById<RecyclerView>(R.id.minumanView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MinumanAdapter(displayList, this)
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
                        val recyclerView = findViewById<RecyclerView>(R.id.minumanView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        val recyclerView = findViewById<RecyclerView>(R.id.minumanView)
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