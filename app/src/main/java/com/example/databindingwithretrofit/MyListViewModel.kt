package com.example.databindingwithretrofit

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MyListViewModel : ViewModel() {
    private  var mutableLiveData = MutableLiveData<List<MyList>>()
    private lateinit var arrayList: MutableList<MyList>
    private var myList: List<MyList>?=null
    fun getMutableLiveData(): LiveData<List<MyList>> {
        arrayList = ArrayList()
        val api = MyClient.instance?.myApi
        val call = api?.getartistdata()
        call?.enqueue(object : Callback<List<MyList>> {
            override fun onResponse(call: Call<List<MyList>>, response: Response<List<MyList>>) {
                myList = ArrayList()
                myList = response.body()
                for (i in myList!!.indices) {
                    val myk = myList!![i]
                    (arrayList as ArrayList<MyList>).add(myk)
                    mutableLiveData.postValue(arrayList)
                }
            }

            override fun onFailure(call: Call<List<MyList>>, t: Throwable) {}
        })
        return mutableLiveData
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadimage(imageView: ImageView, imageUrl: String?) {
            Glide.with(imageView.context).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView)
        }
    }
}