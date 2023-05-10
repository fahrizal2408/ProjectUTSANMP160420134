package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.ViewModel

import android.app.Application
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Medicine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListDetailObatViewModel (application: Application): AndroidViewModel(application){
    val obatLD = MutableLiveData<Medicine>()
    private var queue: RequestQueue? = null
    fun fetch(obatId:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://kenhosting.ddns.net/fahrizal/medicine.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<ArrayList<Medicine>>(it, object :TypeToken<ArrayList<Medicine>>(){}.type)
                result.forEach{obat->
                    if(obat.id == obatId){
                        obatLD.value = obat
                        Log.d("showvoley", result.toString())
                    }
                }
            },
            {
                Log.d("showvoley", it.toString())
            })
        stringRequest.tag = ContentValues.TAG
        queue?.add(stringRequest)
    }
}