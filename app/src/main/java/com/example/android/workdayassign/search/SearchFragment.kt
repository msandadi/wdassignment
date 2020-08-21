package com.example.android.workdayassign.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.android.workdayassign.R
import com.example.android.workdayassign.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSearchBinding.inflate(inflater)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        return binding.root
    }


}