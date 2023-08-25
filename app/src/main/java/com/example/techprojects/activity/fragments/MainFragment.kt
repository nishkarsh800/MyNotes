package com.example.techprojects.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.techprojects.R
import com.example.techprojects.activity.adapters.MyAdapter
import com.example.techprojects.activity.viewmodel.NoteBookViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    lateinit var navController: NavController

    var adapter = MyAdapter()

    lateinit var viewModels:NoteBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        viewModels=ViewModelProvider(this)[NoteBookViewModel::class.java]

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        val button = view.findViewById<FloatingActionButton>(R.id.add_notebook)
        button.setOnClickListener{
            navController.navigate(R.id.action_mainFragment2_to_addFragment2)
        }

        val recycler=view.findViewById<RecyclerView>(R.id.recycler)

        context?.let { viewModels.getAllNotebooks(it) }
        viewModels.list.observe(viewLifecycleOwner) {
            adapter.setContentList(it)
            recycler.also { recycler ->

                recycler.adapter = adapter
            }
        }

    }

}