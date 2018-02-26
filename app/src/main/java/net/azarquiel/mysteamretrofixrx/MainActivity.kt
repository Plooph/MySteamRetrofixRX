package net.azarquiel.mysteamretrofixrx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.azarquiel.mysteamretrofixrx.model.Games
import net.azarquiel.mysteamretrofixrx.api.SteamApiService
import net.azarquiel.mysteamretrofixrx.api.SteamStoreService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var games: Games

    // lazy => singleton de nuestra api
    private val steamApiService by lazy {
        SteamApiService.create()
    }
    private val steamStoreService by lazy {
        SteamStoreService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.visibility = View.VISIBLE
        loadGames()
    }

    private fun loadGames() {
        steamApiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { games ->
                            this.games = games
                            showGames()
                            progressBar.visibility = View.GONE
                        },
                        { error ->
                            progressBar.visibility = View.GONE
                            Log.e("**pabel**",error.message)
                        }
                )

    }

    private fun showGames() {
        //        games.applist.apps.forEach{ game ->
        //            Log.d("**Paco**",game.toString())
        //        }
        Log.d("**pabel**", games.applist.apps[0].toString())
        Log.d("**pabel**", games.applist.apps[games.applist.apps.size-1].toString())
        Log.d("**pabel**","sizegames="+games.applist.apps.size)

    }

}

