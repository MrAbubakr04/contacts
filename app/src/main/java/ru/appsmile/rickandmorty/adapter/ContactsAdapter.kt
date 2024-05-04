package ru.appsmile.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.appsmile.rickandmorty.ResultItem
import ru.appsmile.rickandmorty.databinding.ItemRickAndMortyBinding

class ContactsAdapter(private val results: List<ResultItem>) :
    RecyclerView.Adapter<ContactsAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRickAndMortyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRickAndMortyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = results[position]
        with(holder.binding) {
            textViewGender.text = currentItem.gender

            Glide.with(holder.binding.root)
                .load(currentItem.picture.large)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)

            textViewName.text = "${currentItem.name.title} ${currentItem.name.first} ${currentItem.name.last}"
            textViewPhone.text = "${currentItem.phone}"
            textViewEmail.text = "${currentItem.email}"

        }
    }

}