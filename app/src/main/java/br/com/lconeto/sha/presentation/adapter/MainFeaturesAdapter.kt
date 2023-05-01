package br.com.lconeto.sha.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.sha.data.model.MainFeature
import br.com.lconeto.sha.databinding.MainFeaturesListItemBinding
import br.com.lconeto.sha.domain.listener.MainFeatureRecyclerViewClickListener

class MainFeaturesAdapter(
    private val mainFeatures: List<MainFeature>,
    private val listenerMainFeature: MainFeatureRecyclerViewClickListener
) : RecyclerView.Adapter<MainFeaturesAdapter.MainFeatureViewHolder>() {

    inner class MainFeatureViewHolder(private val binding: MainFeaturesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mainFeature: MainFeature) {
            binding.imageViewMainFeatureItem.setImageResource(mainFeature.icon)
            binding.textViewMainFeatureItem.text = mainFeature.name
        }
    }

    override fun getItemCount() = mainFeatures.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFeatureViewHolder {
        val binding = MainFeaturesListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainFeatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainFeatureViewHolder, position: Int) {
        holder.bind(mainFeatures[position])

        holder.itemView.setOnClickListener {
            listenerMainFeature.onMainFeatureClickListener(
                mainFeatures[position]
            )
        }
    }
}
