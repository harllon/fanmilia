package data.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResult(

    @SerializedName("kind")
    @Expose
    var kind : String,

    @SerializedName("etag")
    @Expose
    var etag : String,

    @SerializedName("regionCode")
    @Expose
    var regionCode : String,

    @SerializedName("pageInfo")
    @Expose
    var pageInfo : PageInfo,

    @SerializedName("items")
    @Expose
    var items : List<SearchItem>
)

data class SearchItem(
    @SerializedName("kind")
    @Expose
    var kind : String,

    @SerializedName("etag")
    @Expose
    var etag : String,

    @SerializedName("id")
    @Expose
    var id : KindId,

    @SerializedName("snippet")
    @Expose
    var snippet : SearchSnippet
)

data class SearchSnippet(
    @SerializedName("publishedAt")
    @Expose
    var publishedAt : String,

    @SerializedName("channelId")
    @Expose
    var channelId : String,

    @SerializedName("title")
    @Expose
    var title : String,

    @SerializedName("description")
    @Expose
    var description : String,

    @SerializedName("thumbnails")
    @Expose
    var thumbnails : Thumbnails,

    @SerializedName("channelTitle")
    @Expose
    var channelTitle : String,

    @SerializedName("liveBroadcastContent")
    @Expose
    var liveBroadcastContent : String,

    @SerializedName("publishTime")
    @Expose
    var publishTime : String
)

data class KindId(
    @SerializedName("kind")
    @Expose
    var kind : String,

    @SerializedName("kindId")
    @Expose
    var kindId : String
)

