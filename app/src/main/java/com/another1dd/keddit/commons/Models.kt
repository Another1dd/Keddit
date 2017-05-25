package com.another1dd.keddit.commons

import android.os.Parcel
import android.os.Parcelable
import com.another1dd.keddit.commons.Extensions.createParcel
import com.another1dd.keddit.commons.adapter.AdapterConstants
import com.another1dd.keddit.commons.adapter.ViewType


data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>) : Parcelable {
    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { RedditNews(it) }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.createTypedArrayList(RedditNewsItem.CREATOR))

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(after)
        dest?.writeString(before)
        dest?.writeTypedList(news)
    }
}

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String?
) : ViewType, Parcelable {

    override fun getViewType() = AdapterConstants.NEWS

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { RedditNewsItem(it) }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readInt(), source.readLong(), source.readString(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(author)
        dest?.writeString(title)
        dest?.writeInt(numComments)
        dest?.writeLong(created)
        dest?.writeString(thumbnail)
        dest?.writeString(url)
    }
}