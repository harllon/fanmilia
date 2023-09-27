package data.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ContentDetails(

    @SerializedName("relatedPlaylists")
    @Expose
    var relatedPlaylists : RelatedPlaylists
)

data class RelatedPlaylists(
    @SerializedName("likes")
    @Expose
    var likes : String,

    @SerializedName("uploads")
    @Expose
    var uploads : String
)

data class Statistics(
    @SerializedName("viewCount")
    @Expose
    var viewCount : String,

    @SerializedName("subscriberCount")
    @Expose
    var subscriberCount : String,

    @SerializedName("hiddenSubscriberCount")
    @Expose
    var hiddenSubscriberCount : Boolean,

    @SerializedName("videoCount")
    @Expose
    var videoCount : String
)