package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.model
import com.google.gson.annotations.SerializedName

data class User(
    val id:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("email")
    val email:String?,
    @SerializedName("password")
    val password:String?,
    @SerializedName("date_of_birth")
    val dob:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)

data class Doctor(
    val id:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("profession")
    val profession:String?,
    @SerializedName("education")
    val education:String?,
    @SerializedName("date_of_birth")
    val dob:String?,
    @SerializedName("photo_url")
    val photoUrl:String?

)
 data class Medicine(
     val id:String?,
     @SerializedName("name")
     val name:String?,
     @SerializedName("desc")
     val desc:String?,
     @SerializedName("photo_url")
     val photoUrl:String?
 )
data class Berita(
    val id:String?,
    @SerializedName("judul")
    val judul:String?,
    @SerializedName("isi")
    val isi:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)