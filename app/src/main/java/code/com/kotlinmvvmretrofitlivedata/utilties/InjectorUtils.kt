package code.com.kotlinmvvmretrofitlivedata.utilties

import code.com.kotlinmvvmretrofitlivedata.data.ArticleDatabase
import code.com.kotlinmvvmretrofitlivedata.data.ArticleRepository
import code.com.kotlinmvvmretrofitlivedata.ui.articles.ArticlesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): ArticlesViewModelFactory {
        val articleRepository = ArticleRepository.getInstance(ArticleDatabase.getInstance().articleDao)
        return ArticlesViewModelFactory(articleRepository)
    }
}