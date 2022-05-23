package com.example.a11_nlivedata.room.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.a11_nlivedata.R
import com.example.a11_nlivedata.databinding.FragmentNoteListBinding
import com.example.a11_nlivedata.room.RoomActivity
import com.example.a11_nlivedata.room.db.NoteAdapter

class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentNoteListBinding
    private val noteAdapter : NoteAdapter by lazy { NoteAdapter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNoteListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            //Click and go to other fragment
            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.actionListToAdd)
            }

            //Get Data
            (activity as RoomActivity).noteDb.noteDao().getAllNotes().observe(viewLifecycleOwner){
                noteAdapter.differ.submitList(it)

                //recycler
                recyclerViewNoteList.apply {
                    layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                    adapter = noteAdapter
                }
            }
        }
    }
}