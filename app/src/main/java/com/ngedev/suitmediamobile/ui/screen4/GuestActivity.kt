package com.ngedev.suitmediamobile.ui.screen4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngedev.suitmediamobile.R
import com.ngedev.suitmediamobile.databinding.ActivityGuestBinding
import com.ngedev.suitmediamobile.domain.di.guestModule
import com.ngedev.suitmediamobile.ui.screen2.SecondActivity
import com.ngedev.suitmediamobile.utils.Constants
import com.ngedev.suitmediamobile.utils.adapter.GuestAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class GuestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestBinding
    private val viewModel: GuestViewModel by viewModel()

    private var adapter: GuestAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(guestModule)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        collectUser()
        binding.backIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun collectUser() {

        lifecycleScope.launchWhenStarted {
            viewModel.getUsers().collect {
                Log.d("MyPaging", it.toString())
                binding.rvListUser.adapter = adapter
                binding.rvListUser.layoutManager = LinearLayoutManager(this@GuestActivity)
                adapter?.submitData(it)
            }

        }
    }

    private fun initView() {
        adapter = GuestAdapter()
    }


}