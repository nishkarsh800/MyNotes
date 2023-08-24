package com.example.techprojects.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.techprojects.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        val buttton = view.findViewById<FloatingActionButton>(R.id.add_notebook)
        buttton.setOnClickListener{
            navController.navigate(R.id.action_mainFragment2_to_addFragment2)
        }
    }


}