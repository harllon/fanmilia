package data.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PageInfo(

    @SerializedName("totalResults")
    @Expose
    var totalResults : Int,

    @SerializedName("resultsPerPage")
    @Expose
    var resultsPerPage : Int
)
