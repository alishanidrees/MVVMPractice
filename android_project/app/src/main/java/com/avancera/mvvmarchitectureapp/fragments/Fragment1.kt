package com.avancera.mvvmarchitectureapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.activities.BaseActivity
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.avancera.mvvmarchitectureapp.databinding.Fragment1Binding
import com.avancera.mvvmarchitectureapp.databinding.FragmentHomeBinding
import com.avancera.mvvmarchitectureapp.fragments.base.BaseFragment
import com.avancera.mvvmarchitectureapp.models.request.RequestLogin
import com.avancera.mvvmarchitectureapp.viewmodels.MainActivityViewModel

class Fragment1 : BaseFragment() {

    private lateinit var mBinding: Fragment1Binding
    private lateinit var mViewModel: MainActivityViewModel

    override fun setTitleBar(titleBar: TitleBar?) {

        titleBar!!.showHeaderView()
        titleBar.setLeftTitleText("Test")
        titleBar.showLeftIconAndListener(View.OnClickListener {

            onCustomBackPressed()

        })

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

        return R.layout.fragment_1

    }

    override fun getViewBinding() {

        mBinding = binding as Fragment1Binding
    }

    override fun getViewModel() {

        mViewModel = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel::class.java)

    }

    override fun observe() {

        Log.i("observer","called")

    }

    override fun setLiveDataValues() {

    }

    override fun init() {

    }

    override fun setListeners() {

        mBinding.apply {

            btnLogin.setOnClickListener(this@Fragment1)


        }


    }

    override fun setLanguageData() {

    }

    override fun onClick(p0: View?) {

        when(p0!!.id){

            R.id.btnLogin -> {


                mBinding.apply {

                    mViewModel.callServerForLoginCustomer(RequestLogin(etEmail.text?.trim().toString(),
                         etPassword.text?.trim().toString()

                    ))


                }


            }


        }

    }
}