package com.maven.darktheme.adapter

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.maven.darktheme.R
import com.maven.darktheme.model.User
import java.util.*


class RecyclerViewAdapter(var context: Activity, var userArrayList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userArrayList[position]
        val viewHolder = holder as RecyclerViewViewHolder
        viewHolder.txtView_title.text = user.title
        viewHolder.txtView_description.text = user.description

        val generator = ColorGenerator.MATERIAL // or use DEFAULT
        val color1 = generator.randomColor
        val drawable = TextDrawable.builder()
            .buildRound("A", color1)


        viewHolder.imgView_icon.setImageDrawable(drawable);

    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgView_icon: ImageView
        var txtView_title: TextView
        var txtView_description: TextView

        init {
            imgView_icon = itemView.findViewById(R.id.imgView_icon)
            txtView_title = itemView.findViewById(R.id.txtView_title)
            txtView_description = itemView.findViewById(R.id.txtView_description)
        }
    }
}