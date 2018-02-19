package net.azarquiel.mysteamretrofixrx.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable


/**
 * Created by PabloHdezA on 19/02/2018.
 */

interface SteamApiService {
    @GET("ISteamApps/GetAppList/v0002/")
    fun getData(): Observable<Games>

    // común a todas las instancias de esa clase pues será un singleton
    companion object {
        fun create(): SteamApiService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://api.steampowered.com/")
                    .build()
            return retrofit.create(SteamApiService::class.java)
        }
    }
}