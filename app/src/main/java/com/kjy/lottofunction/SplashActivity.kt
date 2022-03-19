package com.kjy.lottofunction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kjy.lottofunction.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 메인쓰레드와 연결된 Looper를 가져와서 메인쓰레드 쪽에 Runnable 객체를 붙여줌
        Handler(Looper.getMainLooper()).postDelayed( {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}