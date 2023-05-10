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
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.Doctor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListDetailDoctorViewModel (application: Application): AndroidViewModel(application){
    val doctorLD = MutableLiveData<Doctor>()
    private var queue: RequestQueue? = null
    fun fetch(doctorId:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://kenhosting.ddns.net/fahrizal/Doctor.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<ArrayList<Doctor>>(it, object :TypeToken<ArrayList<Doctor>>(){}.type)
                result.forEach{dokter->
                    if(dokter.id == doctorId){
                        doctorLD.value = dokter
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