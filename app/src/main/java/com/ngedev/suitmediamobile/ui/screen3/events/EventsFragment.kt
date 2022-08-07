package com.ngedev.suitmediamobile.ui.screen3.events

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ngedev.suitmediamobile.databinding.FragmentEventsBinding
import com.ngedev.suitmediamobile.domain.di.eventModule
import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.utils.Resource
import com.ngedev.suitmediamobile.utils.adapter.EventAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.context.loadKoinModules
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {

    private lateinit var _binding: FragmentEventsBinding
    private val binding get() = _binding
    private val viewModel: EventViewModel by viewModel()
    private lateinit var adapter: EventAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadKoinModules(eventModule)
        _binding = FragmentEventsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setContents()
    }

    private fun setContents() {
        lifecycle.coroutineScope.launch {
            viewModel.getEvents().collect {
                setList(it)
            }
        }

    }

    private fun setList(events: List<Event>) {
        Log.d("Eveve", events.toString())
        adapter = EventAdapter(requireContext())
        adapter.setItems(events)
        with(binding) {
            rvEvent.adapter = adapter
            rvEvent.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun loadingState(state: Boolean) {
        binding.progressBar.isVisible = state
    }


}