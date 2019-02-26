package com.firatveral.cakelist.ui.main

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.firatveral.cakelist.R
import com.firatveral.cakelist.data.model.Cake
import com.firatveral.cakelist.utils.GlideApp

    //TODO Adapter for the list of the cakes
class CakeAdapter(private val context: Context) : RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {

    /**
     * The list of posts of the adapter
     */
    private var cakeList: List<Cake> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_cakes, parent, false)

        return CakeViewHolder(itemView)
    }

    override fun onBindViewHolder(cakeViewHolder: CakeViewHolder, position: Int) {
        cakeViewHolder.bind(cakeList[position])

    }


    override fun getItemCount() = cakeList.size


    //TODO Updates the list of cakes of the adapter
    fun updateCakes(cakes: List<Cake>) {
        this.cakeList = cakes
        notifyDataSetChanged()
    }


    class CakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle = itemView.findViewById<TextView>(R.id.title)
        private val imgPoster = itemView.findViewById<ImageView>(R.id.image)

        fun bind(cake: Cake) {

            tvTitle.text = cake.title
            GlideApp.with(itemView.context)
                .load(cake.image)
                .placeholder(itemView.context.resources.getDrawable(R.drawable.placeholder))
                .centerCrop()
                .into(imgPoster)


            itemView.setOnClickListener {

                //TODO  Display the cake description popup when a cake entry is clicked
                val builder = AlertDialog.Builder(itemView.context)
                builder.setTitle(cake.title)
                builder.setMessage(cake.desc)
                builder.show()

            }



        }
    }
}
