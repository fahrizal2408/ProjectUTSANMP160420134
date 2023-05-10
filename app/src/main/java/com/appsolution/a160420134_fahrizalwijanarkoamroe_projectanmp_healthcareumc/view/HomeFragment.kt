package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R

class HomeFragment : Fragment() {
    private lateinit var localStorage: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)
        localStorage = requireActivity().getSharedPreferences("AndroidStorage",Context.MODE_PRIVATE)
        val userId = localStorage.getString("id","null")
        val userName = localStorage.getString("name","Nama")
        if(userId == "null"){
            val action = HomeFragmentDirections.actionHomeToLogin()
            Navigation.findNavController(view).navigate(action)
        }
        else{
            var txtNama =  view.findViewById<TextView>(R.id.txtJudulBerita)
            txtNama.text = userName
        }
        var cardBaca = view.findViewById<CardView>(R.id.cardBaca)
        cardBaca.setOnClickListener{
            val action = HomeFragmentDirections.actionItemHomeToBeritaFragment()
            Navigation.findNavController(it).navigate(action)
        }
        var cardObat = view.findViewById<CardView>(R.id.cardObat)
        cardObat.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeToObat()
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}