package com.example.a11_nlivedata.room.db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a11_nlivedata.databinding.ListItemsBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private lateinit var binding : ListItemsBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ListItemsBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    //dont repet
    override fun getItemViewType(position: Int): Int {
        return position
    }

   //click
   private var itemClicked : ((Note) -> Unit)? = null
    fun whenClickedOnItems(listener : (Note) -> Unit) {
        itemClicked = listener
    }
    //

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        fun bind (items: Note) {
            binding.apply {
                titleTxt.text = items.title
                descTitle.text = items.description

                //continue for click
                root.setOnClickListener {
                    itemClicked?.let {
                        it(items)
                    }
                }
            }

        }
    }
    //don't repeat
    val differCallBack = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }

    //Async Accessibility to object in recycler
    val differ = AsyncListDiffer(this,differCallBack)
}