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

class NusantaraActivity : AppCompatActivity() {

    val arrayList = ArrayList<KatalogMenu>()
    val displayList= ArrayList<KatalogMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nusantara)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")

        //set title in another activity
        actionBar.setTitle(aTitle)

        arrayList.add(KatalogMenu("Gudeg", "Gudeg adalah makanan khas Provinsi Yogyakarta dan Jawa Tengah yang terbuat dari nagka muda yang dimasak dengan santan.", R.drawable.gudeg, resources.getString(R.string.falafel), resources.getString(R.string.langkah_falafel)))
        arrayList.add(KatalogMenu("Kerak Telor", "Kerak telor adalah makanan khas Jakarta (Betawi) yang dibuat dengan bahan dasar beras ketan putih dan telur ayam.", R.drawable.kerak_telor, resources.getString(R.string.samosa), resources.getString(R.string.langkah_samosa)))
        arrayList.add(KatalogMenu("Papeda", "Papeda adalah makanan berupa bubur sagu khas Maluku dan Papua.", R.drawable.papeda, resources.getString(R.string.hummus), resources.getString(R.string.langkah_hummus)))
        arrayList.add(KatalogMenu("Rawon", "Rawon adalah masakan Indonesia berupa sup daging yang menggunakan kluwek.", R.drawable.rawon, resources.getString(R.string.soto_betawi), resources.getString(R.string.langkah_soto)))
        arrayList.add(KatalogMenu("Soto Betawi","Soto Betawi merupakan soto khas dari daerah Jakarta.", R.drawable.indonesia, resources.getString(R.string.soto_betawi), resources.getString(R.string.langkah_soto)))
        arrayList.add(KatalogMenu("Rendang", "Rendang adalah salah satu makanan terenak di Dunia yang merupakan masakan daging yang berasal dari Minangkabau.", R.drawable.rendang, resources.getString(R.string.rendang), resources.getString(R.string.langkah_rendang)))
        arrayList.add(KatalogMenu("Sate", "Sate adalah makanan yang terbuat dari daging yang dipotong kecil-kecil dan ditusuk lalu dipanggan dan diberi bumbu kacang.", R.drawable.sate, resources.getString(R.string.sate_marangi), resources.getString(R.string.langkah_sate)))
        displayList.addAll(arrayList)

        val recyclerView = findViewById<RecyclerView>(R.id.nusantaraView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = KatalogAdapter(displayList, this)
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
                        val recyclerView = findViewById<RecyclerView>(R.id.nusantaraView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        val recyclerView = findViewById<RecyclerView>(R.id.nusantaraView)
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