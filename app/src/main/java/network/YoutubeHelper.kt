package network

import com.example.fanmilia.BuildConfig
import data.youtube.SearchResult
import retrofit2.Callback
import retrofit2.Retrofit

class YoutubeHelper() {
    private val youtubePath = "https://youtube.googleapis.com/youtube/v3/"
    private val retrofitClient : Retrofit = RetrofitHelper.getRetrofitInstance(youtubePath)
    private var youtubeEndpoint = retrofitClient.create(IYoutube::class.java)
    private var apiKey = BuildConfig.YOUTUBE_API_KEY

    companion object {
        @Volatile
        private var instance: YoutubeHelper? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: YoutubeHelper().also { instance = it }
            }
    }

    fun search(part: String, query: String, type: String, callback: Callback<SearchResult>, maxResults : Int = 25, attempt: Int = 0){
        var request = youtubeEndpoint.search(part, maxResults, query, type, apiKey)
        request.enqueue(callback)
    }
}