package data.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("default")
    @Expose
    var _default : Default,

    @SerializedName("medium")
    @Expose
    var medium : Medium,

    @SerializedName("high")
    @Expose
    var high : High
)

data class Default(
    @SerializedName("url")
    @Expose
    var url : String,
)

data class Medium(
    @SerializedName("url")
    @Expose
    var url : String,
)

data class High(
    @SerializedName("url")
    @Expose
    var url : String,
)