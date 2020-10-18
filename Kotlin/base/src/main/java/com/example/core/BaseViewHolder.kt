package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val  viewHashMap: MutableMap<Int, View>  =  HashMap()

    fun <T: View> getView(@IdRes id: Int): T? {
        var view = viewHashMap[id];
        if (view == null) {
            view = itemView.findViewById(id);
            viewHashMap[id] = view
        }
        return view as T;
    }

    fun  setText(@IdRes id: Int ,  text: String ){
        (getView<View>(id) as TextView).text = text
    }
}