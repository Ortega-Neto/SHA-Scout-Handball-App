package br.com.lconeto.sha.presentation.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lconeto.library.presentation.BaseFragment
import br.com.lconeto.sha.R
import br.com.lconeto.sha.data.mainfeatures.MainFeaturesList
import br.com.lconeto.sha.data.model.MainFeature
import br.com.lconeto.sha.databinding.FragmentMainFeaturesBinding
import br.com.lconeto.sha.domain.listener.MainFeatureRecyclerViewClickListener
import br.com.lconeto.sha.presentation.adapter.MainFeaturesAdapter

class MainFeaturesFragment :
    BaseFragment<FragmentMainFeaturesBinding>(R.layout.fragment_main_features),
    MainFeatureRecyclerViewClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialBinding = FragmentMainFeaturesBinding.bind(view)

        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.recyclerViewMainFeatures.also {
            it.layoutManager = GridLayoutManager(requireContext(), 2)
            it.setHasFixedSize(true)
            it.adapter = MainFeaturesAdapter(
                MainFeaturesList(requireContext()),
                this
            )
        }
    }

    override fun onMainFeatureClickListener(mainFeature: MainFeature) {
        print(mainFeature)
    }

    companion object {
        fun newInstance() = MainFeaturesFragment()
    }
}
