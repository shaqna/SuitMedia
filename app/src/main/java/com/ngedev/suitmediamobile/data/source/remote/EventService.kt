package com.ngedev.suitmediamobile.data.source.remote

import com.ngedev.suitmediamobile.R
import com.ngedev.suitmediamobile.data.source.remote.response.ApiResponse
import com.ngedev.suitmediamobile.domain.model.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class EventService {
    object EventDummy {
        val listEvent = listOf(
            Event(
                1,
                "Event Dummy 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                2,
                "Event Dummy 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                3,
                "Event Dummy 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                4,
                "Event Dummy 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                5,
                "Event Dummy 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                6,
                "Event Dummy 6",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                7,
                "Event Dummy 7",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                8,
                "Event Dummy 8",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                9,
                "Event Dummy 9",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            ),
            Event(
                10,
                "Event Dummy 10",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "15 Jan 2021",
                "9.00 AM",
                R.drawable.card_view_image,
            )
        )

    }

    fun getListEvent(): Flow<List<Event>> = flow {
        emit(EventDummy.listEvent)
    }.flowOn(Dispatchers.IO)

}