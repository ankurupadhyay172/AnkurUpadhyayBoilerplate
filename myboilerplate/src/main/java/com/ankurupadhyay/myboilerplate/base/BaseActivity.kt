package com.ankurupadhyay.myboilerplate.base

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ankurupadhyay.myboilerplate.R
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {
    private var progressDialog : ProgressDialog? = null
    fun showToast(s:String?)
    {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show()
    }
    fun showLoading(visible:Boolean){
        if (visible){
            progressDialog = showLoadingDialog(this)
        }else{
            hideLoading()
        }
    }


    private fun showLoadingDialog(context: Context): ProgressDialog? {

        val progressDialog = ProgressDialog(context)
        progressDialog.show()
        if (progressDialog.window!=null){
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
       // progressDialog.setContentView(R.layout.spin_view)
        progressDialog.isIndeterminate = true
        //  progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }

    fun hideLoading() {
        progressDialog?.cancel()
    }
}