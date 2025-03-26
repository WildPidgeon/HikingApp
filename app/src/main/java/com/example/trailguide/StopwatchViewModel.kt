package com.example.trailguide

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import kotlin.concurrent.timer

class StopwatchViewModel : ViewModel() {
    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long> get() = _elapsedTime

    private val _lastSavedTime = MutableLiveData<Long?>()
    val lastSavedTime: LiveData<Long?> get() = _lastSavedTime

    private var isRunning = false
    private var timerTask: Timer? = null

    init {
        _elapsedTime.value = 0L
        _lastSavedTime.value = null
    }

    fun start() {
        if (!isRunning) {
            isRunning = true
            timerTask = timer(period = 1000) {
                _elapsedTime.postValue((_elapsedTime.value ?: 0L) + 1)
            }
        }
    }

    fun stop() {
        isRunning = false
        timerTask?.cancel()
    }

    fun reset() {
        isRunning = false
        timerTask?.cancel()
        _elapsedTime.value = 0L
    }

    fun saveLastTime() {

        _lastSavedTime.value = _elapsedTime.value
    }

    override fun onCleared() {
        super.onCleared()
        timerTask?.cancel()
    }
}
