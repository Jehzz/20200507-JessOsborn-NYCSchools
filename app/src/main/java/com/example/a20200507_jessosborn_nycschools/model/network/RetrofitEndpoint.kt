package com.example.a20200507_jessosborn_nycschools.model.network

import com.example.a20200507_jessosborn_nycschools.model.data.SchoolSATData
import com.example.a20200507_jessosborn_nycschools.utils.Constant.SCHOOLS
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitEndpoint {

    @get:GET(SCHOOLS)
    val schoolsList: Call<List<SchoolSATData>>
}