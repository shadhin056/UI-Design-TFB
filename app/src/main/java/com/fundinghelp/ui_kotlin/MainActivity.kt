package com.fundinghelp.ui_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.github.razir.progressbutton.attachTextChangeAnimator
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne()
    }

    private fun buttonOne() {
        bindProgressButton(buttonProgressRightText)
        buttonProgressRightText.attachTextChangeAnimator()
        buttonProgressRightText.setOnClickListener {
            showProgressRight(buttonProgressRightText)
        }
    }

    private fun showProgressRight(button: Button) {
        button.showProgress {
            buttonTextRes = R.string.loading
            progressColor = Color.WHITE
        }
        button.isEnabled = false
        Handler().postDelayed({
            button.isEnabled = true
            button.hideProgress(R.string.progressRight)
        }, 3000)
    }
}
