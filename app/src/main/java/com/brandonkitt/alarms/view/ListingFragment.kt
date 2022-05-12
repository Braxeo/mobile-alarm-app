package com.brandonkitt.alarms.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.brandonkitt.alarms.R
import com.brandonkitt.alarms.adapters.ListingAdapter
import com.brandonkitt.alarms.databinding.FragmentListingBinding
import com.brandonkitt.alarms.viewmodel.ListingViewModel
import com.brandonkitt.alarms.viewmodel.ListingViewModelAssistedFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListingFragment: Fragment() {

    @Inject
    lateinit var listingFactory: ListingViewModelAssistedFactory

    private val viewModel: ListingViewModel by navGraphViewModels(R.id.nav_graph) {
        listingFactory.create(this)
    }

    private val adapter = ListingAdapter()

    private lateinit var binding: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        viewModel.alarms.observe(viewLifecycleOwner) { adapter.submitList(it) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener { findNavController().navigate(R.id.action_ListingFragment_to_SecondFragment) }
    }
}

