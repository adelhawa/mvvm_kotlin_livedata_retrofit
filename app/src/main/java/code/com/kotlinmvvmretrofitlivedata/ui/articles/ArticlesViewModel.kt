package code.com.kotlinmvvmretrofitlivedata.ui.articles
import androidx.lifecycle.ViewModel
import code.com.kotlinmvvmretrofitlivedata.data.ArticleRepository

class ArticlesViewModel(val articleRepository: ArticleRepository):ViewModel() {
    fun getArticles()=articleRepository.getArticles()

    fun getArticleResponseLiveData() {

//        articleRepository.getMoviesArticles("movies", "84a7decf3110498ea372bd16dd0601e8",
//            object : ArticleRepository.onMoviesArticleListener {
//                override fun onSuccess(data: LiveData<ArticleResponse>) {
////                    articleResponseLiveData.value = data.value
//                }
//
//                override fun onFailure(message: String) {
//                    //REQUEST FAILED
//                }
//            })
    }
}