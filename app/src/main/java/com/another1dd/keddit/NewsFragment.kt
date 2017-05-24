package com.another1dd.keddit


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.another1dd.keddit.commons.Extensions.inflate
import com.another1dd.keddit.commons.RedditNewsItem
import com.another1dd.keddit.commons.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {

    private val newsList by lazy { news_list }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        newsList.setHasFixedSize(true)
        newsList.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            val news = (1..10).map {
                RedditNewsItem(
                        "author$it",
                        "Title $it",
                        it, // number of comments
                        1457207701L - it * 200, // time
                        "http://lorempixel.com/200/200/technics/$it", // image url
                        "url"
                )
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}
