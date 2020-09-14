package com.example.travelbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_view.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ViewActivity : AppCompatActivity() {

    lateinit var adapter: RecyclerActivity
    var arrayApi : ArrayList<JsonFile>?=null

    var cdisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        cdisposable = CompositeDisposable()

        adapter = RecyclerActivity(this,RoomDetails.types){categories ->
            val intent = Intent(this,ViewActivity::class.java)
            intent.putExtra("types",categories.type)
            startActivity(intent)
        }
        recyclerView.adapter = adapter


        val layoutmanager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutmanager
        recyclerView.setHasFixedSize(true)


    }
    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://localhost/view.php")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiServices::class.java)

        cdisposable?.add(retrofit.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse)
        )

    }

    private fun handleResponse(apiList : List<JsonFile>){
       // arrayApi = ArrayList(apiList)
        //adapter = RecyclerActivity(arrayApi!!,this)

   //     recyclerView.adapter=adapter
    }

    override fun onPause() {
        super.onPause()
        //cdisposable?.dispose()
    }
}