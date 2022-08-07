package com.ngedev.suitmediamobile.ui.screen2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.coroutineScope
import com.ngedev.suitmediamobile.databinding.ActivitySecondBinding
import com.ngedev.suitmediamobile.domain.di.secondModule
import com.ngedev.suitmediamobile.ui.screen3.ThirdActivity
import com.ngedev.suitmediamobile.ui.screen4.GuestActivity
import com.ngedev.suitmediamobile.utils.Constants
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val viewModel: SecondViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(secondModule)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setIntentListener()
        setObserver()
        setBtnListener()
    }

    private fun setIntentListener() {
        val newText = intent.getStringExtra(Constants.EVENT_NAME)
        val name = intent.getStringExtra(Constants.GUEST_NAME)
        if(newText != null) {
            binding.btnChooseEvent.text = newText
        }
        if(name != null) {
            binding.btnChooseGuest.text =name
        }
    }

    private fun setBtnListener() {
        with(binding) {
            btnChooseEvent.setOnClickListener {
                Intent(
                    this@SecondActivity,
                    ThirdActivity::class.java
                ).apply {
                    startActivity(this)
                }

            }
            btnChooseGuest.setOnClickListener {
                Intent(
                    this@SecondActivity,
                    GuestActivity::class.java
                ).apply {
                    startActivity(this)
                    finishAffinity()
                }
            }

        }
    }

    private fun setObserver() {
        with(binding) {
            lifecycle.coroutineScope.launch {
                viewModel.getProfile().collect { profile ->
                    tvName.text = profile.name
                }
            }
        }

    }
}