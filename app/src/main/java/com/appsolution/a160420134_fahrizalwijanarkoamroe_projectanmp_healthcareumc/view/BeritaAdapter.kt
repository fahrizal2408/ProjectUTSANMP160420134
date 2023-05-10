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
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Berita
import com.squareup.picasso.Picasso

class BeritaAdapter(val beritaList:ArrayList<Berita>)
    :RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>()
{
    class BeritaViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_berita_list, parent, false)
        return BeritaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtId).text = beritaList[position].id
        Picasso.get().load(beritaList[position].photoUrl).into( holder.view.findViewById<ImageView>(R.id.imgObat))
        holder.view.findViewById<TextView>(R.id.txtJudulBerita).text = beritaList[position].judul
        holder.view.findViewById<Button>(R.id.btnBaca).setOnClickListener {
            val action = BeritaFragmentDirections.actionBeritaToDetailBerita( beritaList[position].id!!)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateBeritaList(newBeritaList: ArrayList<Berita>) {
        beritaList.clear()
        beritaList.addAll(newBeritaList)
        notifyDataSetChanged()
    }
}