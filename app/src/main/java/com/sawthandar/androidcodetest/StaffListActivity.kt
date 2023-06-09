package com.sawthandar.androidcodetest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sawthandar.androidcodetest.databinding.ActivityLogInBinding
import com.sawthandar.androidcodetest.databinding.ActivityStaffListBinding

class StaffListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityStaffListBinding

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

        val userKeyId: String? = intent.getStringExtra(KEY_MODEL)
        
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}