package com.avancera.mvvmarchitectureapp.activities

import android.app.ProgressDialog.show
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.databinding.ActivityMainNavHostBinding
import com.avancera.mvvmarchitectureapp.models.helper.NavigationModel
import com.avancera.mvvmarchitectureapp.utils.Enums
import com.avancera.mvvmarchitectureapp.viewmodels.MainActivityViewModel
import com.google.android.material.navigation.NavigationBarView


class MainActivityNavHost : BaseActivityNavHost() {

    private lateinit var mBinding: com.avancera.mvvmarchitectureapp.databinding.ActivityMainNavHostBinding
    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var navController: NavController
    private lateinit var mNavDestination: NavDestination
    private lateinit var mListHideBottomNavIds: ArrayList<Int>
    private lateinit var appBarConfiguration: AppBarConfiguration

    /* override fun getTitleBar(): TitleBar? {
         TODO("Not yet implemented")
     }*/

    override fun getMainLayoutId(): Int {

        return R.layout.activity_main_nav_host
    }

  /*  override fun getFragmentFrameLayoutId(): Int {


    }*/

    override fun onViewReady() {

        initList()
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        initNavController()
        observer()

    }

    override fun getViewBinding() {

        mBinding = binding as com.avancera.mvvmarchitectureapp.databinding.ActivityMainNavHostBinding

    }

    private fun initNavController() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
         navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.fragment1,R.id.fragment2))
        mBinding.toolbar.setupWithNavController(navController,appBarConfiguration)

        navController.addOnDestinationChangedListener { _, _, arguments ->
            mBinding.appBar.isVisible = arguments?.getBoolean("ShowAppBar", false) == true
        }

        mBinding.bottomNavigationView.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun observer(){

        mViewModel.apply {


            navigateBack.observe(this@MainActivityNavHost, Observer {

                it.getContentIfNotHandled()?.let {

                    navController.navigateUp()

                }


            })

            navigateTo.observe(this@MainActivityNavHost, Observer {

                it.getContentIfNotHandled()?.let {

                        model ->

                    when (model.navigationType) {

                        Enums.NavigationType.ACTION -> {
                            navController.currentDestination?.getAction(model.id)?.let {
                                navController.navigate(
                                    model.id,
                                    model.bundle,
                                    model.navOptions,
                                    model.fragNavigatorExtras
                                )
                            }
                        }

                        Enums.NavigationType.ID -> {
                            navController.navigate(
                                model.id,
                                model.bundle,
                                model.navOptions,
                                model.fragNavigatorExtras
                            )
                        }
                    }
                }


            })



        }

    }


    private fun handleBottomNavVisibility() {
        mBinding.bottomNavigationView.apply {
            if (mNavDestination.id in mListHideBottomNavIds) {

                mBinding.bottomNavigationView.visibility = View.VISIBLE
             //   gone()

            } else {

                mBinding.bottomNavigationView.visibility = View.VISIBLE
            //   show()

            }
        }

    }

    private fun initList() {

        mListHideBottomNavIds = arrayListOf(

            R.id.homeFragment,
            R.id.fragment1,
            R.id.fragment2,
            R.id.fragment3,
            R.id.fragment4,


        )
    }



}