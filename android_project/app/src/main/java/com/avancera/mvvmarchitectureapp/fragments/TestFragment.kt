package com.avancera.mvvmarchitectureapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.avancera.mvvmarchitectureapp.databinding.FragmentHomeBinding
import com.avancera.mvvmarchitectureapp.databinding.FragmentTestBinding
import com.avancera.mvvmarchitectureapp.fragments.base.BaseFragment
import com.avancera.mvvmarchitectureapp.models.request.RequestLogin
import com.avancera.mvvmarchitectureapp.viewmodels.MainActivityViewModel

class TestFragment : BaseFragment() {

    private lateinit var mBinding: FragmentTestBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun setTitleBar(titleBar: TitleBar?) {

        titleBar!!.showHeaderView()
    }

    override fun onFragmentViewReady(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        rootView: View?,
    ) {

    }

    override fun onCustomBackPressed() {

    }

    override fun getFragmentLayout(): Int {

        return R.layout.fragment_test
    }

    override fun getViewBinding() {

        mBinding = binding as FragmentTestBinding
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