package com.app.roomdatabase.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.roomdatabase.R
import com.app.roomdatabase.data.User
import com.app.roomdatabase.data.Userviewmodel
import com.app.roomdatabase.databinding.FragmentAddfragmentBinding


class addfragment : Fragment() {

    lateinit var binding: FragmentAddfragmentBinding

    private lateinit var userviewmodel: Userviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddfragmentBinding.inflate(layoutInflater)

        userviewmodel = ViewModelProvider(this).get(Userviewmodel::class.java)

        binding.button.setOnClickListener()
        {
            insertdatatodatabase()
        }

        return binding.root
    }

    private fun insertdatatodatabase() {

        val firstname = binding.firstname.text.toString()
        val lastname = binding.lastname.text.toString()
        val age = binding.age.text.toString()

        val user = User(0,firstname,lastname,age.toInt())
        userviewmodel.adduser(user)

        Toast.makeText(this.context,"successfully added",Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_addfragment_to_listfragment)
    }
}