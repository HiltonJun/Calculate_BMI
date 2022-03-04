package com.hilton.calculate_bmi

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.hilton.calculate_bmi.databinding.ActivityBmiBinding
import java.lang.Integer.parseInt

class BMIActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBinding()
        checkBMI()
    }

    private fun startBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bmi)
        binding.root
    }

    private fun checkBMI() {
        binding.btCalculate.setOnClickListener { validation() }
    }

    private fun validation() {
        val heightCheck = binding.etHeight.validate()
        val weightCheck = binding.etWeight.validate()
        when {
            heightCheck -> binding.etHeight.error = getString(R.string.generic_error)
            weightCheck -> binding.etWeight.error = getString(R.string.generic_error)
            else -> {
                resultDisplay()
            }
        }
    }

    private fun resultDisplay() {
        val height = parseInt(binding.etHeight.get())
        val weight = parseInt(binding.etWeight.get())
        val resultBMI = calculateBMI(height, weight)
        val result = when {
            resultBMI < 18.5 -> getString(R.string.under_weight)
            resultBMI >= 18.5 && resultBMI < 25 -> getString(R.string.ideal_weight)
            resultBMI >= 25 && resultBMI < 30 -> getString(R.string.overweight)
            resultBMI >= 30 && resultBMI < 40 -> getString(R.string.obesity)
            else -> {
                getString(R.string.severe_obesity)
            }
        }
        animationStart(result)
    }

    private fun calculateBMI(height: Int, weight: Int): Double {
        return weight / (height.toDouble() / 100 * (height.toDouble() / 100))
    }

    private fun animationStart(result:String){
        binding.ltvAnimation.playAnimation()
        binding.ltvAnimation.visible()
        binding.ltvAnimation.addAnimatorListener(object :  Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                binding.tvResult.text = result
                binding.ltvAnimation.gone()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }

        })
    }
}