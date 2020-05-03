package com.fundinghelp.ui_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.core.content.ContextCompat
import com.github.razir.progressbutton.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne()
        buttonTwo()
    }

    private fun buttonTwo() {
        buttonProgressMixed.attachTextChangeAnimator()
        bindProgressButton(buttonProgressMixed)

        buttonProgressMixed.setOnClickListener {
            showMixed(buttonProgressMixed)
        }
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
            button.hideProgress(R.string.balance)
        }, 3000)
    }

    private fun showMixed(button: Button) {
        val animatedDrawable = ContextCompat.getDrawable(this, R.drawable.animated_check)!!
        //Defined bounds are required for your drawable
        val drawableSize = resources.getDimensionPixelSize(R.dimen.doneSize)
        animatedDrawable.setBounds(0, 0, drawableSize, drawableSize)

        button.showProgress {
            buttonTextRes = R.string.loading
            progressColor = Color.WHITE
        }
        button.isEnabled = false
        Handler().postDelayed({
            button.isEnabled = true

            button.showDrawable(animatedDrawable) {
                buttonTextRes = R.string.balance
            }
            Handler().postDelayed({
                button.hideDrawable(R.string.tab)
            }, 2000)
        }, 3000)
    }
}
