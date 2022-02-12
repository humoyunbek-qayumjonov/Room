package com.example.roomkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomkotlin.adapter.MyAdapter
import com.example.roomkotlin.model.User
import com.example.roomkotlin.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = MyAdapter(object :MyAdapter.RvItemClicked{
            override fun onMyItemClick(user: User) {
                findNavController().navigate(R.id.updateFragment, bundleOf("key" to user))
            }
        })
        view.rvList.adapter = adapter

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        view.add_btn.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        return view
    }

}