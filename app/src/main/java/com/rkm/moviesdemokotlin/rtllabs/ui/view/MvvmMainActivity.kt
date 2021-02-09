package com.rkm.moviesdemokotlin.rtllabs.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rkm.moviesdemokotlin.R
import com.rkm.moviesdemokotlin.rtllabs.data.api.ApiHelper
import com.rkm.moviesdemokotlin.rtllabs.data.api.RetrofitBuilder
import com.rkm.moviesdemokotlin.rtllabs.data.model.Movie
import com.rkm.moviesdemokotlin.rtllabs.ui.adapter.MainAdapter
import com.rkm.moviesdemokotlin.rtllabs.ui.base.ViewModelFactory
import com.rkm.moviesdemokotlin.rtllabs.ui.viewmodel.MainViewModel
import com.rkm.moviesdemokotlin.rtllabs.util.Status
import kotlinx.android.synthetic.main.activity_mvvm_main.*

class MvvmMainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_main)
        setupViewModel();
        setupUi();
        setUpObserver()
    }

    private fun setUpObserver() {

       /* viewModel.getUser().observe(this, Observer {
            it?.let {
                resource ->
                when(resource.status){
                    Status.SUCCESS ->{
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let {
                                users -> retrieveList(users)
                        }
                    }
                    Status.ERROR ->{
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING ->{
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })*/

        viewModel.getMOviesList().observe(this, Observer {
            it?.let {
                    resource ->
                when(resource.status){
                    Status.SUCCESS ->{
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let {
                                item ->
                            item.movies?.let { it1 -> retrieveList(it1) }
                        }
                    }
                    Status.ERROR ->{
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING ->{
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })

    }

    private fun retrieveList(listitem: List<Movie>) {
        /*mainAdapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }*/
        mainAdapter.apply {
            addUsers(listitem)
            notifyDataSetChanged()
        }

    }

    private fun setupUi() {

        recyclerView.layoutManager =LinearLayoutManager(this)
        mainAdapter = MainAdapter(arrayListOf())
        recyclerView.adapter = mainAdapter

    }

    private fun setupViewModel() {

        viewModel=ViewModelProviders.of(this
        ,ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(MainViewModel::class.java)

    }
}