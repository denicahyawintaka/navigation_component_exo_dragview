package com.example.navcompenenttest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navcompenenttest.R
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.findFragmentById(R.id.nav_host_home) as NavHostFragment

        setUpNavigation()
    }

    private fun setUpNavigation() {

        val navHostFragment = childFragmentManager
            .findFragmentById(R.id.nav_host_home) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottom_nav,
            navHostFragment.navController
        )
    }
}
