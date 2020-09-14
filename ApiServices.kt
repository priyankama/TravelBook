package com.example.travelbook

import io.reactivex.Observable
import retrofit2.http.GET


interface ApiServices {

    @GET("")
    fun getData() : Observable<List<JsonFile>>
}