package br.com.lconeto.library.domain.uistate

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import br.com.lconeto.library.data.common.ErrorData

typealias LiveDataState<T> = LiveData<UiState<T>>

fun <RESPONSE> LiveDataState<RESPONSE>.observeOnLoading(
    owner: LifecycleOwner,
    observer: () -> Unit
): LiveDataState<RESPONSE> {
    observe(
        owner,
        Observer {
            if (it is UiLoading) observer.invoke()
        }
    )
    return this
}

fun <RESPONSE> LiveDataState<RESPONSE>.observeOnSuccess(
    owner: LifecycleOwner,
    observer: (RESPONSE) -> Unit
): LiveDataState<RESPONSE> {
    observe(
        owner,
        Observer {
            if (it is UiSuccess) observer.invoke(it.data)
        }
    )
    return this
}

fun <RESPONSE> LiveDataState<RESPONSE>.observeOnSuccess(
    owner: LifecycleOwner,
    observer: () -> Unit
): LiveDataState<RESPONSE> {
    observe(
        owner,
        Observer {
            if (it is UiSuccess) observer.invoke()
        }
    )
    return this
}

fun <RESPONSE> LiveDataState<RESPONSE>.observeOnError(
    owner: LifecycleOwner,
    observer: (ErrorData) -> Unit
): LiveDataState<RESPONSE> {
    observe(
        owner,
        Observer {
            if (it is UiError) observer.invoke(it.errorData)
        }
    )
    return this
}
