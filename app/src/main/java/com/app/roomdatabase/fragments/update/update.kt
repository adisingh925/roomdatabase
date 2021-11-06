package com.app.roomdatabase.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.roomdatabase.R
import com.app.roomdatabase.databinding.FragmentListfragmentBinding
import com.app.roomdatabase.databinding.FragmentUpdateBinding
import com.app.roomdatabase.model.User
import com.app.roomdatabase.viewmodel.Userviewmodel
import kotlinx.android.synthetic.main.fragment_update.*

class update : Fragment() {

    private val args by navArgs<updateArgs>()

    lateinit var binding : FragmentUpdateBinding

    private lateinit var muserviewmodel:Userviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        muserviewmodel = ViewModelProvider(this).get(Userviewmodel::class.java)

        binding = FragmentUpdateBinding.inflate(layoutInflater)

        binding.updatefirstname.setText(args.currentuser.firstname)
        binding.updatelastname.setText(args.currentuser.lastname)
        binding.updateage.setText(args.currentuser.age.toString())

        setHasOptionsMenu(true)

        binding.updatebutton.setOnClickListener{
            updateitem()
        }

        return binding.root
    }

    private fun updateitem()
    {
        val firstname = updatefirstname.text.toString()
        val lastname = updatelastname.text.toString()
        val age = Integer.parseInt(updateage.text.toString())

        val updateuser = User(args.currentuser.id,firstname,lastname,age)

        muserviewmodel.updateuser(updateuser)

        Toast.makeText(this.context,"successfully updated", Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_update_to_listfragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete)
        {
            deleteuser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteuser()
    {
        val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes"){_,_ ->
                muserviewmodel.deleteuser(args.currentuser)
                Toast.makeText(this.context,"successfully removed",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_update_to_listfragment)
            }
        builder.setNegativeButton("No"){_,_ ->

        }
        builder.setTitle("Delete ${args.currentuser.firstname}")
        builder.setMessage("Are you sure you want to delete ${args.currentuser.firstname}")
        builder.create().show()
    }

}