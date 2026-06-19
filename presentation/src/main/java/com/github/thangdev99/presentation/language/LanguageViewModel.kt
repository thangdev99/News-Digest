package com.github.thangdev99.presentation.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.github.thangdev99.domain.repository.PreferenceRepository
import com.github.thangdev99.presentation.utils.LANGUAGE_SYSTEM_DEFAULT
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val repository: PreferenceRepository,
) : ViewModel() {
    val language = repository.getLanguage()
        .map {
            it
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = LANGUAGE_SYSTEM_DEFAULT,
        )

    fun setLanguage(language: Int) {
        viewModelScope.launch {
            repository.setLanguage(language)
        }
    }
}
