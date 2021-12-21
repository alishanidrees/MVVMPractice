package com.avancera.mvvmarchitectureapp.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.avancera.mvvmarchitectureapp.activities.BaseActivity
import com.avancera.mvvmarchitectureapp.customviews.TitleBar
import com.cartmates.customer.views.interfaces.InitMethods


abstract class BaseFragment : Fragment(), InitMethods {

    protected var activityReference: BaseActivity? = null
    protected lateinit var binding: ViewDataBinding
    var rootView: View? = null
    var isLoading = false
    protected abstract fun setTitleBar(titleBar: TitleBar?)
  //  protected abstract val getMainLayout:Int
    protected abstract fun onFragmentViewReady(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        rootView: View?


    )

    abstract fun onCustomBackPressed()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityReference = baseActivity

        getViewModel()
        observe()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewBinding()

        init()

        setLanguageData()

        setLiveDataValues()

        setListeners()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      /*  rootView = inflater.inflate(getMainLayout, container, false)
        unbinder = ButterKnife.bind(this, rootView!!)
        onFragmentViewReady(inflater, container, savedInstanceState, rootView)
        // Inflate the layout for this fragment
        return rootView*/

        binding = DataBindingUtil.inflate(
            inflater,
            getFragmentLayout(),
            container,
            false
        )

        return binding.root

    }

    protected val baseActivity: BaseActivity?
        protected get() = if (activity is BaseActivity) {
            activity as BaseActivity?
        } else null

   /* override fun onDestroyView() {
        super.onDestroyView()
        unbinder!!.unbind()
    }

    override fun onResume() {
        super.onResume()
        if (baseActivity != null) {
            setTitleBar(baseActivity!!.getTitleBar())
        }

//        if (getHomeActivity() != null) {
//            setTitleBar(getHomeActivity().getTitleBar());
//        }
//
//        if (getLoginActivity() != null) {
//            setTitleBar(getLoginActivity().getTitleBar());
//        }
    }

    fun loadingStarted() {
        isLoading = true
        if (baseActivity != null) baseActivity!!.onLoadingStarted()
    }

    fun loadingFinished() {
        isLoading = false
        if (baseActivity != null) baseActivity!!.onLoadingFinished()
    }
*/

    override fun onResume() {
        super.onResume()
        if (baseActivity != null) {
            setTitleBar(baseActivity!!.getTitleBar())
        }

//        if (getHomeActivity() != null) {
//            setTitleBar(getHomeActivity().getTitleBar());
//        }
//
//        if (getLoginActivity() != null) {
//            setTitleBar(getLoginActivity().getTitleBar());
//        }
    }

}