package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.squareup.picasso.Picasso


class ProfileFragment : Fragment() {
    private lateinit var localStorage: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        localStorage = requireActivity().getSharedPreferences("AndroidStorage", Context.MODE_PRIVATE)
        var txtnama = view.findViewById<TextView>(R.id.txtJudulBerita)
        txtnama.text= localStorage.getString("name","Nama")
        var txtEmail = view.findViewById<TextView>(R.id.txtEmails)
        txtEmail.text= localStorage.getString("email","Email")
        var txtumur = view.findViewById<TextView>(R.id.txtUmurs)
        txtumur.text =  localStorage.getString("dob","0000-00-00")
        var btnLogout = view.findViewById<Button>(R.id.btnLogout)
        var imageview =view.findViewById<ImageView>(R.id.imgProfile)
        Log.d("Content 6: ",localStorage.getString("photoUrl","null").toString())
        Picasso.get().load(localStorage.getString("photoUrl","")).into(imageview)
        btnLogout.setOnClickListener{
            val editor = localStorage.edit()
            editor.clear()
            editor.commit()
            editor.apply()
            val action = ProfileFragmentDirections.actionProfileToLogout()
            Navigation.findNavController(view).navigate(action)
        }
    }

}