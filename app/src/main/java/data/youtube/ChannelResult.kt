package data.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChannelResult(
    @SerializedName("kind")
    @Expose
    var kind : String,

    @SerializedName("etag")
    @Expose
    var etag : String,

    @SerializedName("pageInfo")
    @Expose
    var pageInfo : PageInfo,

    @SerializedName("items")
    @Expose
    var items : List<ChannelItem>
)

data class ChannelItem(
    @SerializedName("kind")
    @Expose
    var kind : String,

    @SerializedName("etag")
    @Expose
    var etag : String,

    @SerializedName("id")
    @Expose
    var id : String,

    @SerializedName("snippet")
    @Expose
    var snippet : Snippet,

    @SerializedName("contentDetails")
    @Expose
    var contentDetails: ContentDetails,

    @SerializedName("statistics")
    @Expose
    var statistics : Statistics
)

data class Snippet(
    @SerializedName("title")
    @Expose
    var title : String,

    @SerializedName("description")
    @Expose
    var description : String,

    @SerializedName("customUrl")
    @Expose
    var customUrl : String,

    @SerializedName("publishedAt")
    @Expose
    var publishedAt : String,

    @SerializedName("thumbnails")
    @Expose
    var thumbnails : Thumbnails,

    @SerializedName("localized")
    @Expose
    var localized : Localized,

    @SerializedName("country")
    @Expose
    var country : String
)

data class Localized(
    @SerializedName("title")
    @Expose
    var title : String,

    @SerializedName("description")
    @Expose
    var description : String
)