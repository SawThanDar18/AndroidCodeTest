package com.sawthandar.androidcodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.sawthandar.androidcodetest.api.response.BaseResponse
import com.sawthandar.androidcodetest.api.response.LogInResponse
import com.sawthandar.androidcodetest.databinding.ActivityLogInBinding
import com.sawthandar.androidcodetest.util.SessionManager
import com.sawthandar.androidcodetest.viewmodel.LogInViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private val viewModel by viewModels<LogInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val userKeyId = SessionManager.getUserKeyId(this)
        if (!userKeyId.isNullOrBlank()) {
            navigateToTeamMateList(userKeyId)
        }*/

        viewModel.logInResult.observe(this) {
            when(it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    hideLoading()
                    processLogIn(it.data)
                    //SessionManager.saveUserKeyId(this, it.data?.data?.keyId ?: "")

                }

                is BaseResponse.Error -> {
                    hideLoading()
                    processError(it.msg)
                }

                else -> {
                    hideLoading()
                }
            }
        }

        uiListener()
    }

    private fun uiListener() {
        binding.loginBtn.setOnClickListener {
            checkUserInputNull()
        }
    }

    private fun checkUserInputNull() {

        val companyId = binding.companyIdEdt.text.toString()
        val userId = binding.usernameEdt.text.toString()
        val password = binding.passwordEdt.text.toString()

        val fullInfo = (companyId.isNotBlank() && userId.isNotBlank() && password.isNotBlank())
        if (fullInfo) {
            viewModel.logInUser(companyId = companyId, userId = userId, password = password)
        } else {
            showToast("Please Fill All LogIn Information!")
        }
    }

    private fun navigateToTeamMateList(userKeyId: String?) {
        finish()
        StaffListActivity.start(this, userKeyId ?: "")
    }

    private fun showLoading() {
        binding.progressBar.isVisible = true
    }

    private fun hideLoading() {
        binding.progressBar.isVisible = false
    }

    private fun processLogIn(data: LogInResponse?) {
        showToast("LogIn Success")
        navigateToTeamMateList(data?.data?.keyId?: "")
    }

    private fun processError(msg: String?) {
        showToast("Error: $msg")
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}