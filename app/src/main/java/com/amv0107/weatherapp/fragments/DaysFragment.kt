package com.amv0107.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amv0107.weatherapp.MainViewModel
import com.amv0107.weatherapp.R
import com.amv0107.weatherapp.adapters.WeatherAdapter
import com.amv0107.weatherapp.adapters.WeatherModel
import com.amv0107.weatherapp.databinding.FragmentDaysBinding

class DaysFragment : Fragment(), WeatherAdapter.Listener {

    private lateinit var binding: FragmentDaysBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it.subList(1, it.size))
        }
    }

    private fun init() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter(this@DaysFragment)
        rcView.adapter = adapter
    }

    override fun onClick(item: WeatherModel) {
        model.liveDataCurrent.value = item
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}