package code.com.kotlinmvvmretrofitlivedata.ui.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import code.com.kotlinmvvmretrofitlivedata.data.ArticleRepository

class ArticlesViewModelFactory(private val articleRepository: ArticleRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArticlesViewModel(articleRepository) as T
    }
}