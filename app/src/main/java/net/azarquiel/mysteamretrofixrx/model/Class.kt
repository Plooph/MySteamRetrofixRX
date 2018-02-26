package net.azarquiel.mysteamretrofixrx.model

/**
 * Created by PabloHdezA on 19/02/2018.
 * clase para serializar en un objeto de esa class el Json
 */

//Class SteamApiService
data class Games(val applist:Apps)
data class Apps(val apps:List<Game>)
data class Game(val appid:Int, val name:String)

//Class SteamStoreService
data class GameStore(val data:Data)
data class Data(val name:String,
                val short_description:String,
                val header_image:String,
                val website:String)
