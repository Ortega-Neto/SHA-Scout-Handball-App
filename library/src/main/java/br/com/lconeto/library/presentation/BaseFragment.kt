package br.com.lconeto.library.presentation

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<T>(
    @LayoutRes private val layoutResId: Int
) : Fragment(layoutResId) {

    protected var initialBinding: T? = null
    protected val binding: T get() = initialBinding!!

    override fun onDestroyView() {
        super.onDestroyView()
        initialBinding = null
    }
}
