package com.example.databindingwithretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingwithretrofit.databinding.MyListBinding

class MyAdapter(private val arrayList: List<MyList>, private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var layoutInflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val myListBinding: MyListBinding = DataBindingUtil.inflate(layoutInflater!!, R.layout.mylist, parent, false)
        return ViewHolder(myListBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListViewModel = arrayList[position]
        holder.bind(myListViewModel)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(val myListBinding: MyListBinding) : RecyclerView.ViewHolder(myListBinding.root) {
        fun bind(myli: MyList?) {
            myListBinding.mylistmodel = myli
            myListBinding.executePendingBindings()
            myListBinding.mylistmodel = myli
            myListBinding.executePendingBindings()
            myListBinding.cardView.setOnClickListener(View.OnClickListener {
            MainActivity().displayToast(context,myli?.artistname)
        })

        }
    }
}