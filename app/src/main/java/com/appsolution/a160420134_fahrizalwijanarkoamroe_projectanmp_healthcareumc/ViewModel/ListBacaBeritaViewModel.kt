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
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Berita
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Medicine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListBacaBeritaViewModel (application: Application): AndroidViewModel(application){
    val beritaLD = MutableLiveData<Berita>()
    private var queue: RequestQueue? = null
    fun fetch(beritaId:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://kenhosting.ddns.net/fahrizal/berita.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<ArrayList<Berita>>(it, object :TypeToken<ArrayList<Berita>>(){}.type)
                result.forEach{berita->
                    if(berita.id == beritaId){
                        beritaLD.value = berita
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