package com.example.basisscholengent.data.remote

import com.example.basisscholengent.BuildConfig
import com.example.basisscholengent.models.GetSchoolApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Mijn api is : https://data.stad.gent/explore/dataset/locaties-basisscholen-gent/table/
private const val BASE_URL = "https://data.stad.gent/"

//nodig om json string object naar kotlin class om te zetten en omgekeerd naar json strings
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

//gaan we meegeven aan client
//niet verplicht : interessant voor debuggen (gebeurd ook door setlevel enkel in debug)
//handig voor meer info van api calls te krijgen, zie je dan in logs
//handig als je ergens een fout hebt
private val interceptor = HttpLoggingInterceptor()
    .setLevel(
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    )

//gaan we meegeven aan retrofit builder
private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val retrofit = Retrofit.Builder()
    //Moshi als converter, vorige jaar was het gson
    //JSON data to class
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build() //maak

//http operaties uitschrijven
//enkel get is genoeg
interface GhentApiService {
    @GET("api/records/1.0/search/?dataset=locaties-basisscholen-gent&q=&facet=zetel&facet=aanbod&facet=onderwijsnet&facet=gemeente")
    //   Suspending functions are at the center of everything coroutines.
    //   A suspending function is simply a function that can be paused and resumed at a later time.
    //   They can execute a long running operation and wait for it to complete without blocking.

    suspend fun getScholen(): Response<GetSchoolApiResponse>
}

object GhentApi {
    val apiService: GhentApiService by lazy { retrofit.create(GhentApiService::class.java) }
}