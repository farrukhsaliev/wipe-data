package com.farrukhsaliev.myapplication

import android.annotation.SuppressLint
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farrukhsaliev.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val devicePolicyManager = this.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, "admin")
                putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "admin1")
            }
            startActivityForResult(intent, 1234)

            devicePolicyManager.wipeData(0)
        }
    }
}