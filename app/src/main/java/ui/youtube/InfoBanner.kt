package ui.youtube

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import data.youtube.SearchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class InfoBanner(chanThumbnail : ImageView, chanName : TextView, chanDescription : TextView) : Callback<SearchResult> {
    private var channelThumbnail: ImageView
    private var channelName : TextView
    private var channelDescription : TextView

    // initializer block
    init {
        channelThumbnail = chanThumbnail
        channelName = chanName
        channelDescription = chanDescription
    }

    companion object {
        const val TAG = "YoutubeInfoBanner"
    }

    override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
        channelName.text = response.body()?.items?.first()?.snippet?.channelTitle
        channelDescription.text = response.body()?.items?.first()?.snippet?.description

        val imgURL = response.body()?.items?.first()?.snippet?.thumbnails?._default?.url.toString()
        // Declaring executor to parse the URL
        val executor = Executors.newSingleThreadExecutor()

        // Once the executor parses the URL
        // and receives the image, handler will load it
        // in the ImageView
        val handler = Handler(Looper.getMainLooper())

        // Initializing the image
        var image: Bitmap?

        // Only for Background process (can take time depending on the Internet speed)
        executor.execute {
            // Image URL

            // Tries to get the image and post it in the ImageView
            // with the help of Handler
            try {
                val `in` = java.net.URL(imgURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                // Only for making changes in UI
                handler.post {
                    channelThumbnail.setImageBitmap(image)
                }
            }
            // If the URL does not point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
        Log.e(TAG, t.message.toString(), t)
    }
}