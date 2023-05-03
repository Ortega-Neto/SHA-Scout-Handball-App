package br.com.lconeto.sha.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lconeto.library.presentation.BaseFragment
import br.com.lconeto.sha.data.mainfeatures.MainFeaturesList
import br.com.lconeto.sha.data.model.MainFeature
import br.com.lconeto.sha.databinding.FragmentMainFeaturesBinding
import br.com.lconeto.sha.domain.listener.MainFeatureRecyclerViewClickListener
import br.com.lconeto.sha.presentation.adapter.MainFeaturesAdapter

class MainFeaturesFragment :
    BaseFragment<FragmentMainFeaturesBinding>(),
    MainFeatureRecyclerViewClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainFeaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
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
        startActivity(mainFeature.intent)
    }

    companion object {
        fun newInstance() = MainFeaturesFragment()
    }
}
