package com.ngedev.suitmediamobile.ui.screen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ngedev.suitmediamobile.databinding.ActivityFirstBinding
import com.ngedev.suitmediamobile.domain.di.firstModule
import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.utils.Resource
import com.ngedev.suitmediamobile.helper.ImageConverter
import com.ngedev.suitmediamobile.ui.screen2.SecondActivity
import org.koin.core.context.loadKoinModules
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    private val viewModel: FirstViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(firstModule)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {
        with(binding) {

            imgProfile.setOnClickListener {
                pickImage()
            }

            btnNext.setOnClickListener {
                if (isFieldNotEmpty()) {
                    allowedToContinue()
                }

            }

            btnCheck.setOnClickListener {
                observePalindrome()
            }
        }


    }

    private fun observePalindrome() {
        with(binding) {
            viewModel.checkPolindrome(tilPalindromeText.editText?.text.toString().lowercase())
            lifecycleScope.launchWhenStarted {
                viewModel.isPolindrome.collect {
                    when (it) {
                        is Resource.Loading -> {
                            loadingState(true)
                        }
                        is Resource.Success -> {
                            loadingState(false)
                            Snackbar.make(binding.root, "Palindrome!", Snackbar.LENGTH_LONG).show()
                        }
                        is Resource.Error -> {
                            loadingState(false)
                            Snackbar.make(binding.root, it.message.toString(), Snackbar.LENGTH_LONG).show()
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    private fun loadingState(state: Boolean) {
        binding.progressBar.isVisible = state
    }

    private fun allowedToContinue() {
        with(binding) {
            val profile = Profile(
                1,
                tilName.editText?.text.toString(),
                ImageConverter.uriToString(viewModel.getImageUri().value!!)
            )
            viewModel.saveProfile(profile)
        }

        startActivity(
            Intent(
                this@FirstActivity,
                SecondActivity::class.java
            )
        )

    }

    private fun isFieldNotEmpty(): Boolean {
        with(binding) {
            val errorMessage = "Field tidak boleh kosong"
            when {
                tilName.editText?.text.toString().isEmpty() -> {
                    tilName.editText?.error = errorMessage
                }
                tilPalindromeText.editText?.text.toString().isEmpty() -> {
                    tilPalindromeText.editText?.error = errorMessage
                }
                isImageUriEmpty() -> {
                    Snackbar.make(binding.root, "Field foto kosong", Snackbar.LENGTH_LONG).show()
                }
                else -> {
                    return true
                }
            }
            return false
        }
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            Glide.with(this).load(it)
                .into(binding.imgProfile)
            viewModel.setImage(it)
        }

    }

    private fun pickImage() = pickImage.launch("image/*")

    private fun isImageUriEmpty(): Boolean {
        viewModel.getImageUri().value.let {
            if (it != null) {
                return false
            }
        }
        return true
    }
}