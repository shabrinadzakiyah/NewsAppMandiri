package com.example.newsappmandiri.repository

import com.example.newsappmandiri.api.RetrofitInstance
import com.example.newsappmandiri.db.ArticleDatabase
import com.example.newsappmandiri.models.Article


class NewsRepository (val db: ArticleDatabase){

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun  deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)


}