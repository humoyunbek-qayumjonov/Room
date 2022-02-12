package com.example.roomkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomkotlin.model.User
import com.example.roomkotlin.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    lateinit var mUserViewmModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_update, container, false)
        var user = arguments?.getSerializable("key") as User
        mUserViewmModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.update_name.setText(user.firstName)
        view.update_lastName.setText(user.lastName)
        view.update_age.setText(user.age.toString())

        view.update_btn.setOnClickListener {
            val firstName = update_name.text.toString().trim()
            val lastName = update_lastName.text.toString().trim()
            val age = update_age.text.toString().trim()
            val updateUser = User(user.id,firstName,lastName,age.toInt())
            mUserViewmModel.updateUser(updateUser)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        return view
    }

}