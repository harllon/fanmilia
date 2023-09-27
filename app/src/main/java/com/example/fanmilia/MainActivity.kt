package com.example.fanmilia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.fanmilia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val URL = "https://youtube.googleapis.com/youtube/v3/"
    private var imgURL = ""
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        getData()

    }

    fun getData() {
/*

        callback.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                //binding.imageId.setImageURI(response?.body()?.items?.first()?.snippet?.thumbnails?._default?.url?.toUri())
                imgURL = response?.body()?.items?.first()?.snippet?.thumbnails?._default?.url.toString()
                // Declaring executor to parse the URL
                val executor = Executors.newSingleThreadExecutor()

                // Once the executor parses the URL
                // and receives the image, handler will load it
                // in the ImageView
                val handler = Handler(Looper.getMainLooper())

                // Initializing the image
                var image: Bitmap? = null

                // Only for Background process (can take time depending on the Internet speed)
                executor.execute {
                    // Image URL
                    val imageURL = imgURL

                    // Tries to get the image and post it in the ImageView
                    // with the help of Handler
                    try {
                        val `in` = java.net.URL(imageURL).openStream()
                        image = BitmapFactory.decodeStream(`in`)

                        // Only for making changes in UI
                        handler.post {
                            binding.imageId.setImageBitmap(image)
                        }
                    }

                    // If the URL doesnot point to
                    // image or any other kind of failure
                    catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        })*/



    }
    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

   override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}