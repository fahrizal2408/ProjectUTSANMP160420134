package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.ViewModel.ListDoctorViewModel

class DoctorFragment : Fragment() {
    private lateinit var doctorVM:ListDoctorViewModel
    var doctorAdapt=DoctorAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doctorVM=ViewModelProvider(this).get(ListDoctorViewModel::class.java)
        doctorVM.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager=LinearLayoutManager(context)
        recView.adapter=doctorAdapt
        observe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor, container, false)
    }
    fun observe(){
        val recView = view?.findViewById<RecyclerView>(R.id.recView)
        val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoad)
        val txterror = view?.findViewById<TextView>(R.id.txtError)
        doctorVM.doctorLD.observe(viewLifecycleOwner, Observer {
            doctorAdapt.updateDoctorList(it)
        })
        doctorVM.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recView?.visibility = View.GONE
                txterror?.visibility=View.VISIBLE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
                txterror?.visibility=View.GONE
            }
        })

    }

}