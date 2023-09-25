package com.matiasmandelbaum.mercadopagoapitest.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.matiasmandelbaum.mercadopagoapitest.common.Result
import com.matiasmandelbaum.mercadopagoapitest.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.preferences.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Success -> handleLoading(false)
                is Result.Loading -> handleLoading(true)
                is Result.Error -> handleLoading(false)
            }
        }

        viewModel.subscription.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Success -> handleLoading(false)
                is Result.Loading -> handleLoading(true)
                is Result.Error -> handleLoading(false)
            }
        }

    }

    private fun handleLoading(isLoading: Boolean) {
        with(binding) {
            if (isLoading) {
                createPreferencesButton.visibility = View.GONE
                createSubscriptionButton.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            } else {
                createPreferencesButton.visibility = View.VISIBLE
                createSubscriptionButton.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }
}