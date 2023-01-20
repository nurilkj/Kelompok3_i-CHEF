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

class ArabicActivity : AppCompatActivity() {

    val arrayList = ArrayList<KatalogMenu>()
    val displayList= ArrayList<KatalogMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arabic)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")

        //set title in another activity
        actionBar.setTitle(aTitle)

        arrayList.add(KatalogMenu("Falafel", "Falafel adalah snack arab yang biasanya disajikan di dalam sebuah roti pipih mirip pita yang disebut lafa.", R.drawable.falafel, resources.getString(R.string.falafel), resources.getString(R.string.langkah_falafel)))
        arrayList.add(KatalogMenu("Hummus", "Hummus adalah makanan sehat yang berasal dari Timur Tengah, mirip dengan bubur namun dengan tekstur yang sedikit lebih keras, kental dan berminyak.", R.drawable.hummus, resources.getString(R.string.hummus), resources.getString(R.string.langkah_hummus)))
        arrayList.add(KatalogMenu("Nasi Mandhi", "Nasi Mandhi atau mandi, makanan khas Timur Tengah yang menggunakan rempah dan daging kambing.", R.drawable.mandhi, resources.getString(R.string.falafel), resources.getString(R.string.langkah_falafel)))
        arrayList.add(KatalogMenu("Margoog", "Margoog adalah hidangan yang mengandung serat dan vitamin yang tinggi.", R.drawable.margoog, resources.getString(R.string.hummus), resources.getString(R.string.langkah_hummus)))
        arrayList.add(KatalogMenu("Samosa","Samosa merupakan snack atau cemilan yang biasanya diisi dengan daging sapi, kambing, ayam, sayuran, telur, atau keju.", R.drawable.samosa, resources.getString(R.string.samosa), resources.getString(R.string.langkah_samosa)))
        arrayList.add(KatalogMenu("Shakshuka", "Shakshuka ini merupakan hidangan yang terbuat dari telur. Dicampur bersama saus tomat dan rempah-rempah.", R.drawable.shakshuka, resources.getString(R.string.falafel), resources.getString(R.string.langkah_falafel)))
        arrayList.add(KatalogMenu("Shawarma", "Shawarma merupakan hidangan yang biasanya dibungkus seperti sandwich atau hamburger yang berisi domba panggang, ayam, kalkun, juga beberapa sayuran lainnya.", R.drawable.shawarma, resources.getString(R.string.samosa), resources.getString(R.string.langkah_samosa)))
        displayList.addAll(arrayList)

        val recyclerView = findViewById<RecyclerView>(R.id.arabicView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ArabicAdapter(displayList, this)
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
                        val recyclerView = findViewById<RecyclerView>(R.id.arabicView)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        val recyclerView = findViewById<RecyclerView>(R.id.arabicView)
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