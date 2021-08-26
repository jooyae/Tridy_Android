package org.journey.tridy_android.jejulife

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.journey.tridy_android.databinding.ItemJejuLifeBinding

class JejuLifeAdapter() : RecyclerView.Adapter<JejuLifeAdapter.JejuLifeViewHolder>() {
    val contentList = mutableListOf<JejuLifeModelItem>()
    val diffCallback = object : DiffUtil.ItemCallback<JejuLifeModelItem>(){
        override fun areItemsTheSame(
            oldItem: JejuLifeModelItem,
            newItem: JejuLifeModelItem
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: JejuLifeModelItem,
            newItem: JejuLifeModelItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)

    class JejuLifeViewHolder(val binding: ItemJejuLifeBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JejuLifeViewHolder {
        val binding = ItemJejuLifeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return JejuLifeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JejuLifeViewHolder, position: Int) {
        val item = differ.currentList[position]
    }

    override fun getItemCount() = differ.currentList.size
}