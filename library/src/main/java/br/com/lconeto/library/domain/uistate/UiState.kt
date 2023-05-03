package br.com.lconeto.library.domain.uistate

import br.com.lconeto.library.data.common.ErrorData

sealed class UiState<out T>

object UiLoading : UiState<Nothing>()

class UiSuccess<T>(val data: T) : UiState<T>()

class UiError(val errorData: ErrorData) : UiState<Nothing>()
