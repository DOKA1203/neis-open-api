package com.github.doka.neis.openapi

import com.github.doka.neis.openapi.datas.info.SchoolInformation
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

fun main() {
    //println(School.find(key = "a7d9b63eda43415e8802a55fa0f4f2d2", type = "json", pSize = 1))
    val api:NeisOpenApi = NeisOpenApi.create()

    api.getSchoolInfo(key = "a7d9b63eda43415e8802a55fa0f4f2d2", type = "json", pSize = 1).enqueue(object : Callback<SchoolInformation> {
        override fun onResponse(call: Call<SchoolInformation>, response: Response<SchoolInformation>) {

            println(response.body()!!.schoolInfo[1].row)
        }
        override fun onFailure(call: Call<SchoolInformation>, t: Throwable) {
            println(call.request().url.toString())
        }
    })

   //println(api.getSchoolInfo(key = "a7d9b63eda43415e8802a55fa0f4f2d2", type = "json", pSize = 1).request().url.toString())
}

interface NeisOpenApi {
    companion object{
        private const val baseUrlDiscord = "https://open.neis.go.kr/hub/"

        fun create():NeisOpenApi {
            val client = OkHttpClient.Builder().build()

            return Retrofit.Builder()
                .baseUrl(baseUrlDiscord)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NeisOpenApi::class.java)
        }
    }

    @GET("schoolInfo")
    fun getSchoolInfo(
        @Query("KEY") key: String,
        @Query("Type") type: String,
        @Query("pIndex") pIndex: Int = 1,
        @Query("pSize") pSize: Int = 100,
        @Query("ATPT_OFCDC_SC_CODE") sido: String? = null,
        @Query("SD_SCHUL_CODE") schoolCode: String? = null,
        @Query("SCHUL_NM") schoolName: String? = null,
        @Query("SCHUL_KND_SC_NM") schoolType: String? = null,
    ): Call<SchoolInformation>
}
