package com.ngedev.suitmediamobile.helper

import android.net.Uri

object ImageConverter {
    fun uriToString(uri: Uri): String =
        uri.toString()

    fun stringToUri(string: String): Uri =
        Uri.parse(string)

  }