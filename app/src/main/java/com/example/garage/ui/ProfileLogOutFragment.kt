package com.example.garage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.garage.R
import com.example.garage.databinding.FragmentProfileLogoutBinding

class ProfileLogOutFragment : Fragment(R.layout.fragment_profile_logout) {

    private lateinit var binding : FragmentProfileLogoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileLogoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.enterButton.setOnClickListener{
            findNavController().navigate(R.id.logInFragment)
        }
    }
}