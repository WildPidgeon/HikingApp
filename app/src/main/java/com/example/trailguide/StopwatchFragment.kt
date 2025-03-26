package com.example.trailguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class StopwatchFragment : Fragment() {
    private lateinit var viewModel: StopwatchViewModel
    private lateinit var timeTextView: TextView
    private lateinit var lastSavedTimeTextView: TextView
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_stopwatch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timeTextView = view.findViewById(R.id.textViewTime)
        lastSavedTimeTextView = view.findViewById(R.id.textViewLastSavedTime)
        startButton = view.findViewById(R.id.buttonStart)
        stopButton = view.findViewById(R.id.buttonStop)
        resetButton = view.findViewById(R.id.buttonReset)
        saveButton = view.findViewById(R.id.buttonSave)

        viewModel = ViewModelProvider(this).get(StopwatchViewModel::class.java)

        viewModel.elapsedTime.observe(viewLifecycleOwner, Observer { time ->
            timeTextView.text = formatTime(time ?: 0L)
        })

        viewModel.lastSavedTime.observe(viewLifecycleOwner, Observer { lastSavedTime ->
            lastSavedTimeTextView.text = lastSavedTime?.let { formatTime(it) } ?: "brak"
        })

        startButton.setOnClickListener {
            viewModel.start()
        }

        stopButton.setOnClickListener {
            viewModel.stop()
        }

        resetButton.setOnClickListener {
            viewModel.reset()
        }

        saveButton.setOnClickListener {
            viewModel.saveLastTime()
        }
    }

    private fun formatTime(seconds: Long): String {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60

        return String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}