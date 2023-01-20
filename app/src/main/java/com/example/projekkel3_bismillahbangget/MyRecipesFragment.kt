package com.example.projekkel3_bismillahbangget

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class MyRecipesFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_my_recipes, container, false)

        val btnmovetoresep: Button = v.findViewById(R.id.resep)

        btnmovetoresep.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.resep -> {
                val moveresep = Intent(getActivity(), AddRecipesActivity::class.java)
                startActivity(moveresep)
            }
        }
    }
}