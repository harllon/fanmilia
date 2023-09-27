package network

import com.example.fanmilia.BuildConfig
import data.youtube.ChannelResult
import data.youtube.SearchResult
import retrofit2.Callback
import retrofit2.Retrofit

class YoutubeHelper() {
    private val youtubePath = "https://youtube.googleapis.com/youtube/v3/"
    private val retrofitClient : Retrofit = RetrofitHelper
        .getRetrofitInstance(youtubePath)
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

    fun search(part: String, maxResults : Int = 25, query: String, type: String, attempt: Int = 0, callback: Callback<SearchResult>){
        var request = youtubeEndpoint.search(part, maxResults, query, type, apiKey)
        /*callback.enqueue(object : Callback<Example> {

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Log.e(TAG, "Call failed with message:  " + t.message, t)

                Log.i(TAG, "Starting retry call failed, attempt number: $attempt")
                if(attempt < 3)
                    search(part, maxResults, query, type, attempt+1)
            }
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                //do what i want to do
                //println(response?.body()?.items?.first()?.snippet?.thumbnails?._default?.url)
            }
        })*/
        request.enqueue(callback)
    }
}
