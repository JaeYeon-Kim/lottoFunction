package com.kjy.lottofunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.kjy.lottofunction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val binding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }

    private val lotteryNumbers: List<TextView> by lazy {
        listOf<TextView>(binding.number1, binding.number2, binding.number3, binding.number4,
            binding.number5, binding.number6)

    }

    val lotteryButton by lazy {
        binding.lotteryButton
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 익명 클래스 선언 3초짜리 타이머, 0.1초마다 작업
        // 따라서 0.1초마다 랜덤으로 숫자가 보여지는걸 보여주고 3초뒤에 랜덤설정된 숫자가 지정되는 애니메이션을 만들어줌.
        val countDownTimer = object : CountDownTimer(3000, 100) {

            override fun onFinish() {
            }

            override fun onTick(p0: Long) {

                lotteryNumbers.forEach {
                    //
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }
        }

        lotteryButton.setOnClickListener {
            if (lotteryButton.isAnimating) {
                lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            } else {
                lotteryButton.playAnimation()
                countDownTimer.start()
            }

        }
    }
}