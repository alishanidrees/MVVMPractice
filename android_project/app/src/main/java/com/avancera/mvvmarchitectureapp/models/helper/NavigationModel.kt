package com.avancera.mvvmarchitectureapp.models.helper

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import com.avancera.mvvmarchitectureapp.utils.Enums


data class NavigationModel(
    val id: Int,
    val bundle: Bundle = bundleOf(),
    val fragNavigatorExtras: FragmentNavigator.Extras? = null,
    val navigationType: Enums.NavigationType = Enums.NavigationType.ACTION,
    val navOptions: NavOptions? = null
)