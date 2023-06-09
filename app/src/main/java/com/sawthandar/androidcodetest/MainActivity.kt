package com.sawthandar.androidcodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.sawthandar.androidcodetest.databinding.ActivityLogInBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uiListener()
    }

    private fun uiListener() {
        binding.loginBtn.setOnClickListener {
            //start teammate list activity
            checkUserInputNull()
        }
    }

    private fun checkUserInputNull() {
        val fullInfo = (binding.companyIdEdt.text.toString().isNotBlank() && binding.usernameEdt.text.toString().isNotBlank() && binding.passwordEdt.text.toString().isNotBlank())
        if (fullInfo) {
        } else {
        }
    }
}