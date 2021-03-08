package com.example.databindingwithretrofit

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.databindingwithretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var myListViewModel: MyListViewModel? = null
    private var adapter: MyAdapter? = null
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myListViewModel = ViewModelProviders.of(this).get(MyListViewModel::class.java)
        displayListHome(myListViewModel!!)
    }

    private fun displayListHome(myListViewModel: MyListViewModel) {
        myListViewModel.getMutableLiveData().observe(this, { myLists ->
            if(myLists.size>0){
                binding!!.progressBar.visibility=View.GONE
            }
            adapter = MyAdapter(myLists, this@MainActivity)
            binding!!.recyclerView.adapter = adapter
        })
    }

    fun displayToast(mContext: Context?, artistName: String?) {
        Toast.makeText(mContext, artistName, Toast.LENGTH_SHORT).show()
    }
}