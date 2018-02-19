package net.azarquiel.mysteamretrofixrx.model

/**
 * Created by PabloHdezA on 19/02/2018.
 */

data class Games(val applist:Apps)
data class Apps(val apps:List<Game>)
data class Game(val appid:Int, val name:String)
