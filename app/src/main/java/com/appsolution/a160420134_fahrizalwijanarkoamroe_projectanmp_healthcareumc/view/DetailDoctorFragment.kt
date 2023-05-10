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
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.ViewModel.ListDetailDoctorViewModel
import com.squareup.picasso.Picasso

class DetailDoctorFragment : Fragment() {
    private lateinit var viewmodel: ListDetailDoctorViewModel
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
        return inflater.inflate(R.layout.fragment_detail_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var dokterid = DetailDoctorFragmentArgs.fromBundle(requireArguments()).dokterId
        super.onViewCreated(view, savedInstanceState)
        viewmodel=ViewModelProvider(this).get(ListDetailDoctorViewModel::class.java)
        viewmodel.fetch(dokterid)
        observeDetailViewModel()
    }
    fun observeDetailViewModel(){
        val doctorId= view?.findViewById<TextView>(R.id.txtId)
        val doctorName= view?.findViewById<TextView>(R.id.txtNamaObat)
        val doctorProf = view?.findViewById<TextView>(R.id.txtDescription)
        val doctorEdu = view?.findViewById<TextView>(R.id.txtEdukasiDokter)
        val doctorDOB = view?.findViewById<TextView>(R.id.txtDOBDokter)
        var imageView = view?.findViewById<ImageView>(R.id.imageDokter)
        viewmodel.doctorLD.observe(viewLifecycleOwner, Observer {
            doctorId?.setText(it.id);doctorName?.setText(it.name);doctorProf?.setText(it.profession);
            doctorEdu?.setText(it.education);doctorDOB?.setText(it.dob)
            Picasso.get().load(it.photoUrl).into(imageView)
        })
    }
}