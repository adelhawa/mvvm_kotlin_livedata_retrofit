package code.com.kotlinmvvmretrofitlivedata.ui.articles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import code.com.kotlinmvvmretrofitlivedata.R
import code.com.kotlinmvvmretrofitlivedata.data.ArticleAdapter
import code.com.kotlinmvvmretrofitlivedata.utilties.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        initializeUi()
    }

    private fun initializeUi(){
        // Get the ArticleViewModelFactory with all of it's dependencies constructed
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // Use ViewModelProviders class to create / get already created ArticleViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory)
            .get(ArticlesViewModel::class.java)
        viewModel.getArticles().observe(this,Observer { val adapter = ArticleAdapter(this,it )
            moviesRecyclerView.adapter = adapter })
        }
    }

