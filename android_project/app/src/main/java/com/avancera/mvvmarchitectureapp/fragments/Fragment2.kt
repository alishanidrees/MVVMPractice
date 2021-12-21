package com.avancera.mvvmarchitectureapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.avancera.mvvmarchitectureapp.databinding.Fragment2Binding
import com.avancera.mvvmarchitectureapp.databinding.FragmentHomeBinding
import com.avancera.mvvmarchitectureapp.fragments.base.BaseFragment
import com.avancera.mvvmarchitectureapp.viewmodels.MainActivityViewModel

class Fragment2 : BaseFragment() {

    private lateinit var mBinding: Fragment2Binding
    private lateinit var mViewModel: MainActivityViewModel

    override fun setTitleBar(titleBar: TitleBar?) {

       titleBar!!.hideHeaderView()

    }

 /*   override val getMainLayout: Int
        get() = TODO("Not yet implemented")*/

    override fun onFragmentViewReady(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        rootView: View?
    ) {

    }

    override fun onCustomBackPressed() {


    }

    override fun getFragmentLayout(): Int {

        return R.layout.fragment_2
    }

    override fun getViewBinding() {

        mBinding = binding as Fragment2Binding
    }

    override fun getViewModel() {

        mViewModel = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel::class.java)

    }

    override fun observe() {

    }

    override fun setLiveDataValues() {

    }

    override fun init() {

    }

    override fun setListeners() {

    }

    override fun setLanguageData() {

    }

    override fun onClick(p0: View?) {

    }
}