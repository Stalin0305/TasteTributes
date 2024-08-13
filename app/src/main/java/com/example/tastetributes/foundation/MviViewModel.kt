package com.example.tastetributes.foundation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


interface ViewState
interface UserIntent
interface NavEffect
abstract class MviViewModel<Intent: UserIntent, State: ViewState, Effect: NavEffect> : ViewModel() {
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    val currentState: State
        get() = viewState.value

    private val _viewState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val viewState
        get() = _viewState.asStateFlow()

    private val _intent: MutableSharedFlow<Intent> = MutableSharedFlow()
    val intent
        get() = _intent.asSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect
        get() = _effect.receiveAsFlow()

    abstract fun handleIntent(intent: Intent)

    init {
        subscribeIntent()
    }

    fun performAction(intent: Intent) {
        viewModelScope.launch {
            _intent.emit(intent)
        }
    }

    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleIntent(it)
            }
        }
    }

    protected fun emitViewState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _viewState.value = newState
    }

    protected fun sendNavEffect(effect: Effect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}