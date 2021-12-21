package com.avancera.mvvmarchitectureapp.utils

import android.content.Context
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.avancera.bogocanada.constants.AppConstant
import com.avancera.mvvmarchitectureapp.R


object DisplayNotification {


    fun showToast(ctx: Context?, msg: String?, type: Int) {


        when (type) {

            AppConstant.TOAST_TYPES.INFO -> {
                val inflater: LayoutInflater = LayoutInflater.from(ctx)
                val layout: View = inflater.inflate(R.layout.custom_toast_info,null)

                val c: LinearLayout = layout.findViewById(R.id.llInfo)

                val txt = c.findViewById<View>(R.id.txtMsg) as TextView
                txt.text = msg
                val toast = Toast(ctx)
                toast.setMargin(0F,0F)
                toast.setGravity(Gravity.FILL_HORIZONTAL or Gravity.BOTTOM, 0, 180)
                toast.duration = Toast.LENGTH_SHORT
                toast.view =c
                toast.show()

            }

            AppConstant.TOAST_TYPES.ERROR -> {
                val inflater: LayoutInflater = LayoutInflater.from(ctx)
                val layout: View = inflater.inflate(R.layout.custom_toast_error,null)

                val c: LinearLayout = layout.findViewById(R.id.llError)

                val txt = c.findViewById<View>(R.id.txtMsg) as TextView
                txt.text = msg
                val toast = Toast(ctx)
                toast.setMargin(0F,0F)
                toast.setGravity(Gravity.FILL_HORIZONTAL or Gravity.BOTTOM, 0, 180)
                toast.duration = Toast.LENGTH_SHORT
                toast.view =c
                toast.show()
            }

            AppConstant.TOAST_TYPES.SUCCESS -> {
                val inflater: LayoutInflater = LayoutInflater.from(ctx)
                val layout: View = inflater.inflate(R.layout.custom_toast_success,null)

                val c: LinearLayout = layout.findViewById(R.id.llSuccess)

                val txt = c.findViewById<View>(R.id.txtMsg) as TextView
                txt.text = msg
                val toast = Toast(ctx)
                toast.setMargin(0F,0F)
                toast.setGravity(Gravity.FILL_HORIZONTAL or Gravity.BOTTOM, 0, 180)
                toast.duration = Toast.LENGTH_SHORT
                toast.view =c
                toast.show()
            }


        }

    }
}