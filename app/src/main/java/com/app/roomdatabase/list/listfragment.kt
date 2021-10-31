package com.app.roomdatabase.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.roomdatabase.R
import com.app.roomdatabase.databinding.FragmentListfragmentBinding

class listfragment : Fragment() {

    lateinit var binding : FragmentListfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListfragmentBinding.inflate(layoutInflater)

        binding.fab.setOnClickListener()
        {
            findNavController().navigate(R.id.action_listfragment_to_addfragment)
        }

        return binding.root
    }


}