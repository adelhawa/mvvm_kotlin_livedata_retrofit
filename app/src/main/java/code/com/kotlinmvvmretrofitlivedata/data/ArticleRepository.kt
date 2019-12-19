package code.com.kotlinmvvmretrofitlivedata.data


class ArticleRepository private constructor(private val articleDao: ArticleDao){
    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.

    fun getArticles() = articleDao.getArticles()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: ArticleRepository? = null

        fun getInstance(articleDao: ArticleDao) =
            instance ?: synchronized(this) {
                instance ?: ArticleRepository(articleDao).also { instance = it }
            }
    }
}