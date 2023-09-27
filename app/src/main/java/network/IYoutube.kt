package network

import data.youtube.ChannelResult
import data.youtube.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IYoutube {

    @GET("channels")
    fun listChannels(
        @Query("part") part : String,
        @Query("id") id : String,
        @Query("key") key : String
    ) : Call<ChannelResult>

    @GET("search")
    fun search(
        @Query("part") part : String,
        @Query("maxResults") maxResults : Int,
        @Query("q") q : String,
        @Query("type") type : String,
        @Query("key") key : String
    ) : Call<SearchResult>
}