package com.ngedev.suitmediamobile.ui.screen1

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.useCase.first.FirstUseCase
import com.ngedev.suitmediamobile.domain.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FirstViewModel(private val useCase: FirstUseCase): ViewModel() {

    private val imageUri = MutableLiveData<Uri>()

    private val _isPolindrome = MutableStateFlow<Resource<Boolean>>(Resource.Loading())
    val isPolindrome = _isPolindrome

    fun setImage(image: Uri) {
        this.imageUri.value = image
    }

    fun getImageUri(): LiveData<Uri> = imageUri

    fun saveProfile(profile: Profile) {
        viewModelScope.launch {
            useCase.saveProfile(profile)
        }
    }

    fun checkPolindrome(text: String) = viewModelScope.launch {
        _isPolindrome.value = Resource.Loading()
        delay(2000L)
        if(text.reversed() == text) {
            _isPolindrome.value = Resource.Success(true)
        } else {
            _isPolindrome.value = Resource.Error("Bukan Palindrome")
        }
    }
}