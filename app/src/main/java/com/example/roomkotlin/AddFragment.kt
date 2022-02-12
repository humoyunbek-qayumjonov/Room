package com.example.roomkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomkotlin.model.User
import com.example.roomkotlin.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.save_btn.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val name = view?.edit_name?.text.toString()
        val lastName = view?.edit_lastName?.text.toString()
        val age = view?.edit_age?.text.toString()

        val user = User(0,name,lastName,age.toInt())

        mUserViewModel.addUser(user)
        Toast.makeText(context, "Succesfull...", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.listFragment)
    }


}