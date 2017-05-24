package com.another1dd.keddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.another1dd.keddit.R
import com.another1dd.keddit.commons.Extensions.getFriendlyTime
import com.another1dd.keddit.commons.Extensions.inflate
import com.another1dd.keddit.commons.Extensions.loadImg
import com.another1dd.keddit.commons.RedditNewsItem
import com.another1dd.keddit.commons.adapter.ViewType
import com.another1dd.keddit.commons.adapter.ViewTypeDelegateAdapter
import kotlinx.android.synthetic.main.news_item.view.*


class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {


        fun bind(item: RedditNewsItem) = with(itemView){
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
    }
}

}