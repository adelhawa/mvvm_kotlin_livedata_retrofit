package code.com.kotlinmvvmretrofitlivedata.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import code.com.kotlinmvvmretrofitlivedata.R
import code.com.kotlinmvvmretrofitlivedata.ui.articles.ArticleActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_each_row_movie_article.view.*

class ArticleAdapter(private val context: ArticleActivity, val articleArrayList: List<Article>?) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_each_row_movie_article, parent, false))
    }

    override fun getItemCount(): Int {
    return articleArrayList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle?.text=articleArrayList!!.get(position).title
        holder.tvAuthorAndPublishedAt?.text=articleArrayList!!.get(position).publishedAt
        holder.tvDescription?.text=articleArrayList!!.get(position).description
        Glide.with(context)
            .load(articleArrayList!!.get(position).urlToImage)
            .into(holder.imgViewCover)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgViewCover=itemView.imgViewCover
        val tvTitle=itemView.tvTitle
        val tvAuthorAndPublishedAt=itemView.tvAuthorAndPublishedAt
        val tvDescription=itemView.tvDescription
    }
}