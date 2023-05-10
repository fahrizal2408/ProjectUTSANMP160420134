package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.ViewModel.ListBacaBeritaViewModel

import com.squareup.picasso.Picasso

class BacaBeritaFragment : Fragment() {
    private lateinit var viewmodel: ListBacaBeritaViewModel
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
        return inflater.inflate(R.layout.fragment_baca_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var beritaId=BacaBeritaFragmentArgs.fromBundle(requireArguments()).beritaId
        super.onViewCreated(view, savedInstanceState)
        viewmodel= ViewModelProvider(this).get(ListBacaBeritaViewModel::class.java)
        viewmodel.fetch(beritaId)
        observeDetailViewModel()
    }
    fun observeDetailViewModel(){
        val beritaid= view?.findViewById<TextView>(R.id.txtId)
        val imgBerita = view?.findViewById<ImageView>(R.id.imageObat)
        val beritaJudul= view?.findViewById<TextView>(R.id.txtNamaObat)
        val beritaIsi = view?.findViewById<TextView>(R.id.txtDescription)
        beritaIsi?.setMovementMethod(ScrollingMovementMethod())
        viewmodel.beritaLD.observe(viewLifecycleOwner, Observer {
            beritaid?.setText(it.id);beritaJudul?.setText(it.judul);beritaIsi?.setText(it.isi);
            Picasso.get().load(it.photoUrl).into(imgBerita)
        })
    }
}