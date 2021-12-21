package com.avancera.mvvmarchitectureapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.avancera.mvvmarchitectureapp.databinding.FragmentHomeBinding
import com.avancera.mvvmarchitectureapp.fragments.base.BaseFragment
import com.avancera.mvvmarchitectureapp.models.helper.NavigationModel
import com.avancera.mvvmarchitectureapp.models.request.RequestLogin
import com.avancera.mvvmarchitectureapp.viewmodels.MainActivityViewModel

class HomeFragment : BaseFragment() {

    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun setTitleBar(titleBar: TitleBar?) {

       titleBar!!.showHeaderView()

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

        return R.layout.fragment_home

    }

    override fun getViewBinding() {

        mBinding = binding as FragmentHomeBinding
    }

    override fun getViewModel() {

        mViewModel = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel::class.java)

    }

    override fun observe() {

      /*  mViewModel.apply {
            responseCustomerDetails.observe(this@HomeFragment, Observer {
                it ?: return@Observer

                setNavigateTo(
                    NavigationModel(
                        id = R.id.action_splashFragment_to_homeFragment
                    )
                )

                notificationModel.value?.let {
                    setNavigateTo(
                        NavigationModel(
                            id = R.id.action_global_trackOrderFragment
                        )
                    )
                }

            })
        }*/

    }

    override fun setLiveDataValues() {

    }

    override fun init() {

    }

    override fun setListeners() {

        mBinding.apply {

            btnClick.setOnClickListener(this@HomeFragment)


        }


    }

    override fun setLanguageData() {

    }

    override fun onClick(p0: View?) {

        when(p0!!.id){

            R.id.btnClick -> {


                mBinding.apply {



                    mViewModel.apply {


                        setNavigateTo(
                            NavigationModel(
                                id = R.id.action_homeFragment_to_testFragment
                            )
                        )



                    }


                }


            }


        }

    }
}