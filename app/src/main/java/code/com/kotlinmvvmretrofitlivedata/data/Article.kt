package code.com.kotlinmvvmretrofitlivedata.data

data class Article(val title:String,val author:String,val urlToImage:String,val publishedAt:String,val description:String) {
    override fun toString(): String {
        return "Article(title='$title', author='$author', urlToImage='$urlToImage', publishedAt='$publishedAt', description='$description')"
    }
}