package com.ngedev.suitmediamobile.data.source.remote.response

data class PagingResponse<DataType>(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<DataType>
)
