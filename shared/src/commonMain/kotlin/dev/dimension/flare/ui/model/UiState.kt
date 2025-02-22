package dev.dimension.flare.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import dev.dimension.flare.common.CacheData
import dev.dimension.flare.common.CacheState
import dev.dimension.flare.common.CacheableState
import dev.dimension.flare.common.LoadState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@Immutable
sealed class UiState<T : Any> {
    @Immutable
    data class Success<T : Any>(
        val data: T,
    ) : UiState<T>()

    @Immutable
    data class Error<T : Any>(
        val throwable: Throwable,
    ) : UiState<T>()

    @Immutable
    class Loading<T : Any> : UiState<T>()
}

inline fun <T : Any, R : Any> UiState<T>.map(transform: (T) -> R): UiState<R> =
    when (this) {
        is UiState.Success ->
            try {
                UiState.Success(transform(data))
            } catch (e: Throwable) {
                UiState.Error(e)
            }
        is UiState.Error -> UiState.Error(throwable)
        is UiState.Loading -> UiState.Loading()
    }

inline fun <T : Any, R : Any> UiState<T>.mapNotNull(transform: (T) -> R?): UiState<R> =
    when (this) {
        is UiState.Success -> transform(data)?.let { UiState.Success(it) } ?: UiState.Error(IllegalStateException())
        is UiState.Error -> UiState.Error(throwable)
        is UiState.Loading -> UiState.Loading()
    }

inline fun <T : Any, R : Any> UiState<T>.flatMap(
    onError: (Throwable) -> UiState<R> = { UiState.Error(it) },
    transform: (T) -> UiState<R>,
): UiState<R> =
    when (this) {
        is UiState.Success -> transform(data)
        is UiState.Error -> onError(throwable)
        is UiState.Loading -> UiState.Loading()
    }

fun <T : Any> List<UiState<T>>.merge(requireAllSuccess: Boolean = true): UiState<List<T>> {
    val success = filterIsInstance<UiState.Success<T>>().map { it.data }
    val error = filterIsInstance<UiState.Error<T>>().map { it.throwable }
    val loading = filterIsInstance<UiState.Loading<T>>()

    return when {
        requireAllSuccess && success.size != size && loading.isEmpty() ->
            UiState.Error(IllegalStateException("Not all success"))
        error.isNotEmpty() -> UiState.Error(error.first())
        loading.isNotEmpty() -> UiState.Loading()
        else -> UiState.Success(success)
    }
}

inline fun <T : Any> UiState<T>.onSuccess(action: (T) -> Unit): UiState<T> =
    apply {
        if (this is UiState.Success) {
            action(data)
        }
    }

inline fun <T : Any> UiState<T>.onError(action: (Throwable) -> Unit): UiState<T> =
    apply {
        if (this is UiState.Error) {
            action(throwable)
        }
    }

inline fun <T : Any> UiState<T>.onLoading(action: () -> Unit): UiState<T> =
    apply {
        if (this is UiState.Loading) {
            action()
        }
    }

fun <T : Any> UiState<T>.takeSuccess(): T? = (this as? UiState.Success)?.data

fun <T : Any> UiState<T>.takeSuccessOr(value: T): T = (this as? UiState.Success)?.data ?: value

val <T : Any> UiState<T>.isSuccess: Boolean get() = this is UiState.Success
val <T : Any> UiState<T>.isError: Boolean get() = this is UiState.Error
val <T : Any> UiState<T>.isLoading: Boolean get() = this is UiState.Loading

@OptIn(ExperimentalObjCRefinement::class)
@Composable
@HiddenFromObjC
fun <T : Any> Flow<T>.collectAsUiState(initial: UiState<T> = UiState.Loading()): State<UiState<T>> =
    produceState(initial, this) {
        onStart {
            value = UiState.Loading()
        }.catch {
            value = UiState.Error(it)
        }.collect {
            value = UiState.Success(it)
        }
    }

fun <T : Any> CacheableState<T>.toUi(): UiState<T> =
    data?.let {
        UiState.Success(it)
    } ?: run {
        when (val state = refreshState) {
            is LoadState.Error -> UiState.Error(state.error)
            LoadState.Loading -> UiState.Loading()
            LoadState.Success -> UiState.Error(IllegalStateException("Data is null"))
        }
    }

internal fun <T : Any> CacheData<T>.toUi(): Flow<UiState<T>> =
    combine(data, refreshState) { data, refresh ->
        if (data is CacheState.Success) {
            UiState.Success(data.data)
        } else {
            when (refresh) {
                is LoadState.Error -> UiState.Error(refresh.error)
                LoadState.Loading -> UiState.Loading()
                LoadState.Success -> UiState.Error(IllegalStateException("Data is null"))
            }
        }
    }
