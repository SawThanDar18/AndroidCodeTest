package com.sawthandar.androidcodetest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TeamMateListActivity: AppCompatActivity() {

    companion object {
        private const val KEY_MODEL = "key-model"

        fun start(context: Context, userKeyId: String) {
            val intent = Intent(context, TeamMateListActivity::class.java)
            intent.putExtra(KEY_MODEL, userKeyId)
            return context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val userKeyId: String? = intent.getStringExtra(KEY_MODEL)
    }
}