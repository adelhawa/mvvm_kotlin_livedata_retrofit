package code.com.kotlinmvvmretrofitlivedata.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import code.com.kotlinmvvmretrofitlivedata.retrofit.ApiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleDao {
    // A fake database table
    private val artticleList = mutableListOf<Article>()
    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val articles = MutableLiveData<List<Article>>()

    init {
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        articles.value = artticleList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getArticles():LiveData<List<Article>> {
        ApiRequest.invoke().getMovieArticles("movies", "84a7decf3110498ea372bd16dd0601e8")
            .enqueue(object : Callback<ArticleResponse> {
                override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
                    articles.value = response.body()?.getArticles()
                }
            })
        return articles
    }
}