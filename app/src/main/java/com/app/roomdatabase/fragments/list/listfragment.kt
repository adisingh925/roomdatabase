package com.app.roomdatabase.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.roomdatabase.R
import com.app.roomdatabase.viewmodel.Userviewmodel
import com.app.roomdatabase.databinding.FragmentListfragmentBinding

class listfragment : Fragment() {

    lateinit var binding : FragmentListfragmentBinding

    private lateinit var mUserViewModel : Userviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListfragmentBinding.inflate(layoutInflater)

        setHasOptionsMenu(true)

        val adapter = ListAdapter()
        val recyclerview = binding.recyclerView
        recyclerview.adapter = adapter

        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(Userviewmodel::class.java)
        mUserViewModel.readalldata.observe(viewLifecycleOwner, Observer {user ->
            adapter.setdata(user)
        })

        binding.fab.setOnClickListener()
        {
            findNavController().navigate(R.id.action_listfragment_to_addfragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete)
        {
            deleteallusers()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteallusers() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mUserViewModel.deleteallusers()
            Toast.makeText(this.context,"successfully removed all users", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_,_ ->

        }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
}