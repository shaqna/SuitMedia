package com.ngedev.suitmediamobile.ui.screen3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.ngedev.suitmediamobile.R
import com.ngedev.suitmediamobile.databinding.ActivityThirdBinding
import com.ngedev.suitmediamobile.ui.screen3.events.EventsFragment
import com.ngedev.suitmediamobile.utils.Constants

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<EventsFragment>(R.id.fragment_container_view)
            }
        }

        with(binding) {
            backIcon.setOnClickListener {
                onBackPressed()
            }
            mapViewIcon.setOnClickListener {

            }
            listIcon.setOnClickListener {

            }
        }
    }

}