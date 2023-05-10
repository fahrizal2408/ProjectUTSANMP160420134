package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Doctor
import com.squareup.picasso.Picasso

class DoctorAdapter(val doctorList:ArrayList<Doctor>)
    :RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>()
{
    class DoctorViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_doctor_list, parent, false)
        return DoctorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtId).text = doctorList[position].id
        holder.view.findViewById<TextView>(R.id.txtJudulBerita).text = doctorList[position].name
        holder.view.findViewById<TextView>(R.id.txtJenis).text =doctorList[position].profession
        Picasso.get().load(doctorList[position].photoUrl).into( holder.view.findViewById<ImageView>(R.id.imgObat))
        Log.d("Content: ",doctorList[position].photoUrl.toString())
        holder.view.findViewById<Button>(R.id.btnBaca).setOnClickListener {
            val action = DoctorFragmentDirections.actionItemDoctorToDetailDoctor(doctorList[position].id!!)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateDoctorList(newDoctorList: ArrayList<Doctor>) {
        doctorList.clear()
        doctorList.addAll(newDoctorList)
        notifyDataSetChanged()
    }
}