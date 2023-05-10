package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.android.volley.toolbox.StringRequest
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model.User
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class LoginFragment : Fragment() {
    private lateinit var localStorage: SharedPreferences
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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://kenhosting.ddns.net/fahrizal/userlogin.json"
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener{
            Log.d("Masuk BTN Login","masukbtn")
            val email = view.findViewById<EditText>(R.id.txtemail).text.toString()
            val password = view.findViewById<EditText>(R.id.txtPassword).text.toString()

            localStorage = requireActivity().getSharedPreferences("AndroidStorage", Context.MODE_PRIVATE)
            val editor = localStorage.edit()

            val request = StringRequest(
                Request.Method.GET,
                url,
                { response->
                    Log.d("Response","Masuk response")
                    val sType=object : TypeToken<ArrayList<User>>(){}.type
                    val result = Gson().fromJson<ArrayList<User>>(response,sType)
                    if(email.isNullOrEmpty() && password.isNullOrEmpty()|| email.isNullOrEmpty() || password.isNullOrEmpty()){
                        Toast.makeText(requireContext(),"Harap isi Email dan Password",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        for(item in result){
                            if(email==item.email && password==item.password){
                                val action = LoginFragmentDirections.actionLoginToHome()
                                findNavController(it).navigate(action)
                                editor.putString("id",item.id)
                                editor.putString("email",item.email)
                                editor.putString("dob",item.dob)
                                editor.putString("name",item.name)
                                editor.putString("photoUrl",item.photoUrl)
                                editor.apply()
                            }
                            else{
                                Toast.makeText(requireContext(),"Email atau Password salah",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                },{
                    Log.d("Error Response:",it.toString())
                })
            Log.d("Request",request.toString())
            Volley.newRequestQueue(requireContext()).add(request)
            Log.d("Test 3:","Test 3")
        }



    }

}