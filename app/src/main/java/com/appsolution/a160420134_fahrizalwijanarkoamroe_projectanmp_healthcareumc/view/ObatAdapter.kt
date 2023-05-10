package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Medicine
import com.squareup.picasso.Picasso

class ObatAdapter(val obatList:ArrayList<Medicine>)
    :RecyclerView.Adapter<ObatAdapter.ObatViewHolder>()
{
    class ObatViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_obat_list, parent, false)
        return ObatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return obatList.size
    }

    override fun onBindViewHolder(holder: ObatViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtId).text = obatList[position].id
        Picasso.get().load(obatList[position].photoUrl).into( holder.view.findViewById<ImageView>(R.id.imgObat))
        holder.view.findViewById<TextView>(R.id.txtJudulBerita).text = obatList[position].name
        holder.view.findViewById<Button>(R.id.btnBaca).setOnClickListener {
            val action = ObatFragmentDirections.actionObatToDetailObat( obatList[position].id!!)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateObatList(newObatList: ArrayList<Medicine>) {
        obatList.clear()
        obatList.addAll(newObatList)
        notifyDataSetChanged()
    }
}