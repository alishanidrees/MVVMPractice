package com.avancera.mvvmarchitectureapp.customviews


import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.avancera.mvvmarchitectureapp.R

open class TitleBar : FrameLayout {
    var ivLeftBackIcon: ImageView? = null
    var tvTitle: TextView? = null
    var tvLogo: TextView? = null
    var headerLayout: FrameLayout? = null
    var ivRightEditIcon: ImageView? = null
    @get:JvmName("getContext()") private var context: Context? = null

    constructor(context: Context) : super(context) {
        this.context = context
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initLayout(context)
        attrs?.let { initAttrs(context, it) }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initLayout(context)
        attrs?.let { initAttrs(context, it) }
    }

    private fun initAttrs(context: Context, attrs: AttributeSet) {}
    private fun initLayout(context: Context) {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.titlebar, this)
        bindViews()
        resetViews()
    }

    fun resetViews() {
        headerLayout!!.visibility = GONE
        tvTitle!!.visibility = GONE
        ivLeftBackIcon!!.visibility = GONE
        tvLogo!!.visibility = GONE
        ivRightEditIcon!!.visibility = GONE
    }

    private fun bindViews() {
        headerLayout = findViewById<View>(R.id.headerLayout) as FrameLayout
        tvTitle = findViewById<View>(R.id.tvTitle) as TextView
        ivLeftBackIcon = findViewById<View>(R.id.ivLeftBackIcon) as ImageView
        tvLogo = findViewById(R.id.tvLogo)
        ivRightEditIcon = findViewById<View>(R.id.ivRightEditIcon) as ImageView
    }

    fun showHeaderView() {
        resetViews()
        headerLayout!!.visibility = VISIBLE
        tvTitle!!.visibility = VISIBLE
        ivLeftBackIcon!!.visibility = VISIBLE
        //showBottomShadowOfTitleBar();
    }

    fun showHeaderLogo() {
        resetViews()
        headerLayout!!.visibility = VISIBLE
        tvTitle!!.visibility = GONE
        ivLeftBackIcon!!.visibility = VISIBLE
        tvLogo!!.visibility = VISIBLE
        //showBottomShadowOfTitleBar();
    }

    fun showLeftIconAndListener(onClickListener: OnClickListener?) {
        ivLeftBackIcon!!.visibility = VISIBLE
        ivLeftBackIcon!!.setOnClickListener(onClickListener)
        //        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }

    fun setLeftTitleText(text: String?) {
        tvTitle!!.visibility = VISIBLE
        tvTitle!!.text = text
    }

    fun showRightEditIcon(onClickListener: OnClickListener?) {
        ivRightEditIcon!!.visibility = VISIBLE // For Arman bhai farmasih
        //        ivRightIconMore.setVisibility(View.GONE);// For Arman bhai farmasih gone
        ivRightEditIcon!!.setOnClickListener(onClickListener)
        //        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }

    fun hideHeaderView() {
        headerLayout!!.visibility = GONE
    }
}