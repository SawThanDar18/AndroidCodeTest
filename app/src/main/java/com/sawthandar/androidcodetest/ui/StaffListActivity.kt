package com.sawthandar.androidcodetest.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.sawthandar.androidcodetest.adapters.StaffListAdapter
import com.sawthandar.androidcodetest.api.response.BaseResponse
import com.sawthandar.androidcodetest.api.response.StaffListResponse
import com.sawthandar.androidcodetest.databinding.ActivityStaffListBinding
import com.sawthandar.androidcodetest.util.SessionManager
import com.sawthandar.androidcodetest.viewmodel.StaffListViewModel

class StaffListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityStaffListBinding
    private val viewModel by viewModels<StaffListViewModel>()
    private lateinit var staffListAdapter: StaffListAdapter

    companion object {
        private const val KEY_MODEL = "key-model"

        fun start(context: Context, userKeyId: String) {
            val intent = Intent(context, StaffListActivity::class.java)
            intent.putExtra(KEY_MODEL, userKeyId)
            return context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaffListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getStringExtra(KEY_MODEL) != null) {
            val userKeyId: String? = intent.getStringExtra(KEY_MODEL)
            viewModel.getStaffList(userKeyId?: "")
        }

        setUpRecyclerView()
        uiListener()

        viewModel.staffListResult.observe(this) {
            when(it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    hideLoading()
                    setUpStaffListData(it.data)

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
    }

    private fun setUpRecyclerView() {
        staffListAdapter = StaffListAdapter()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = staffListAdapter
    }

    private fun uiListener() {
        binding.logOutBtn.setOnClickListener {
            SessionManager.clearData(this)
            finish()
            MainActivity.start(this)
        }
    }

    private fun showLoading() {
        binding.progressBar.isVisible = true
    }

    private fun hideLoading() {
        binding.progressBar.isVisible = false
    }

    private fun setUpStaffListData(data: StaffListResponse?) {
        staffListAdapter.setDataSet(data?.data?.employees?: emptyList())
    }

    private fun processError(msg: String?) {
        showToast("Error: $msg")
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}