package com.avancera.mvvmarchitectureapp.activities

import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.avancera.bogocanada.constants.AppConstant
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.avancera.mvvmarchitectureapp.databinding.ActivityMainBinding
import com.avancera.mvvmarchitectureapp.fragments.*
import com.avancera.mvvmarchitectureapp.viewmodels.MainActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel


    private fun setAndBindTitleBar() {

        mBinding.titleBar.visibility = View.VISIBLE

    }

    override fun getTitleBar(): TitleBar {

        return mBinding.titleBar

    }

    override fun getMainLayoutId(): Int {

        return R.layout.activity_main
    }

    override fun getFragmentFrameLayoutId(): Int {

        return R.id.fragmentContainer

    }

    override fun onViewReady() {


        init()
        addSupportFragment(HomeFragment(),AppConstant.TRANSITION_TYPES.SLIDE)

    }

    override fun getViewBinding() {

        mBinding = binding as ActivityMainBinding

    }


    private fun init() {

      //  initList()

        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        initBottomNavigation()
        setAndBindTitleBar()

      //  initNavController()

      //  observe()
    }

    private fun initBottomNavigation(){


       // mBinding.navView.setOnNavigationItemSelectedListener(this)

        mBinding.navView.menu.findItem(R.id.home).isChecked = true;



    }

//    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
//
//        when (menuItem.itemId) {
//            R.id.home -> {
//                changeToHomeFragment(Fragment1())
//            }
//            R.id.fragment1 -> {
//               // val restaurantFragment= Fragment2()
//               // restaurantFragment.setRestaurant(true)
//                changeToHomeFragment(Fragment2())
//            }
//            R.id.fragment2 -> {
//                changeToHomeFragment(Fragment3())
//            }
//            R.id.fragment3 ->{
//                changeToHomeFragment(Fragment4())
//            }
//
//            else -> return false
//        }
//        return true
//    }



}