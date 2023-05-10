package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.ViewModel.ListDetailObatViewModel
import com.squareup.picasso.Picasso

class DetailObatFragment : Fragment() {
    private lateinit var viewmodel: ListDetailObatViewModel
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
        return inflater.inflate(R.layout.fragment_detail_obat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var obatid=DetailObatFragmentArgs.fromBundle(requireArguments()).obatId
        super.onViewCreated(view, savedInstanceState)
        viewmodel= ViewModelProvider(this).get(ListDetailObatViewModel::class.java)
        viewmodel.fetch(obatid)
        observeDetailViewModel()
    }
    fun observeDetailViewModel(){
        val obatid= view?.findViewById<TextView>(R.id.txtId)
        val obatName= view?.findViewById<TextView>(R.id.txtNamaObat)
        val obatDesc = view?.findViewById<TextView>(R.id.txtDescription)
        var imageView = view?.findViewById<ImageView>(R.id.imageObat)
        viewmodel.obatLD.observe(viewLifecycleOwner, Observer {
            obatid?.setText(it.id);obatName?.setText(it.name);obatDesc?.setText(it.desc)
            Picasso.get().load(it.photoUrl).into(imageView)
        })
    }
}