package com.avancera.mvvmarchitectureapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.avancera.mvvmarchitectureapp.fragments.base.BaseFragment
import com.avancera.mvvmarchitectureapp.utils.SharedPrefDB

abstract class BaseActivityNavHost : AppCompatActivity() {

    protected lateinit var binding: ViewDataBinding
    var baseFragment: BaseFragment? = null
    val KEY_FRAG_FIRST = "firstFrag"
    protected lateinit var tinydb: SharedPrefDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LayoutId",""+getMainLayoutId())

        tinydb = SharedPrefDB.instance

        init()

    }


    private fun init() {

        binding = DataBindingUtil.setContentView(this, getMainLayoutId())

        getViewBinding()
        onViewReady()

    }

 //   abstract fun getTitleBar(): TitleBar?

    abstract fun getMainLayoutId(): Int
//    abstract fun getFragmentFrameLayoutId(): Int
    protected abstract fun onViewReady()
    abstract fun getViewBinding()
/*
    fun changeToHomeFragment(frag: BaseFragment?) {

        emptyBackStack()
        replaceSupportFragment(frag!!, AppConstant.TRANSITION_TYPES.SLIDE)

    }*/

    /*  fun addSupportFragment(frag: BaseFragment, transition: Int) {

          baseFragment = frag
          val transaction = supportFragmentManager.beginTransaction()
          if (transition == AppConstant.TRANSITION_TYPES.FADE) transaction.setTransition(
              FragmentTransaction.TRANSIT_FRAGMENT_FADE
          ) else if (transition == AppConstant.TRANSITION_TYPES.SLIDE) transaction.setCustomAnimations(
              R.anim.anim_enter,
              0
          )

          transaction.replace(getFragmentFrameLayoutId(), frag, frag.javaClass.name)
          transaction.addToBackStack(if (supportFragmentManager.backStackEntryCount == 0) KEY_FRAG_FIRST else null)
              .commitAllowingStateLoss()

      }

      private fun replaceSupportFragment(frag: BaseFragment, transition: Int) {
          baseFragment = frag
          val transaction = supportFragmentManager.beginTransaction()
          if (transition == AppConstant.TRANSITION_TYPES.FADE) transaction.setTransition(
              FragmentTransaction.TRANSIT_FRAGMENT_FADE
          ) else if (transition == AppConstant.TRANSITION_TYPES.SLIDE) transaction.setCustomAnimations(
              R.anim.anim_enter,
              0
          )
          //transaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN );
          transaction.replace(getFragmentFrameLayoutId(), frag, frag.javaClass.name)
          transaction.commitAllowingStateLoss() // AllowingStateLoss();
      }*/

    fun emptyBackStack() {
        try {
            popBackStackTillEntry(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun popBackStackTillEntry(entryIndex: Int) {

        if (supportFragmentManager == null) return
        if (supportFragmentManager.backStackEntryCount <= entryIndex) return
        val entry = supportFragmentManager.getBackStackEntryAt(
            entryIndex
        )
        if (entry != null) {
            supportFragmentManager.popBackStackImmediate(
                entry.id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }


}