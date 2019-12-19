package code.com.kotlinmvvmretrofitlivedata.retrofit

import code.com.kotlinmvvmretrofitlivedata.data.ArticleResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("v2/everything/")
    abstract fun getMovieArticles(
        @Query("q") query: String,
        @Query("apikey") apiKey: String
    ): Call<ArticleResponse>
    companion object{
        operator fun invoke():ApiRequest{
            return Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiRequest::class.java)

        }
    }
}