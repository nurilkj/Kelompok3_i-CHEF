package com.example.projekkel3_bismillahbangget


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DiscoverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val v = inflater!!.inflate(R.layout.fragment_discover, container, false)

        val arrayList = ArrayList<Model>()
        arrayList.add(Model("Jajanan Tradisional", R.drawable.cucur))
        arrayList.add(Model("Makanan Khas Nusantara", R.drawable.indonesia))
        arrayList.add(Model("Asian Food", R.drawable.asian))
        arrayList.add(Model("Western Food", R.drawable.lasagna))
        arrayList.add(Model("Arabic Food", R.drawable.arabic))
        arrayList.add(Model("Aneka Minuman", R.drawable.doger))

        val adapter  =  MyAdapter(arrayList, requireActivity())

        val recyclerView: RecyclerView = v.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = adapter
        return v
    }
}