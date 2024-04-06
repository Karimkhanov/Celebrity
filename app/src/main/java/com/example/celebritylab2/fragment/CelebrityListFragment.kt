package com.example.celebritylab2.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.celebritylab2.adapter.CelebrityListAdapter
import com.example.celebritylab2.databinding.FragmentCelListBinding
import com.example.celebritylab2.model.entity.Celebrity
import com.example.celebritylab2.model.network.ApiClient
import com.example.celebritylab2.model.network.CelebrityService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CelebrityListFragment : Fragment() {

    private var _binding: FragmentCelListBinding? = null
    private val binding get() = _binding!!

    private val adapter: CelebrityListAdapter by lazy {
        CelebrityListAdapter()
    }

    private val celebrityService: CelebrityService by lazy {
        ApiClient.instance
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCelListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        fetchData("")
        setupSearch()
    }

    private fun setupUI() {
        binding.celList.adapter = adapter
    }

    private fun fetchData(query: String) {
        celebrityService.fetchCelebrityList(query).enqueue(object : Callback<List<Celebrity>> {
            override fun onResponse(
                call: Call<List<Celebrity>>,
                response: Response<List<Celebrity>>
            ) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                } else {
                    showError("Failed to fetch data: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
                showError("Network error: ${t.message}")
            }
        })
    }

    private fun setupSearch() {
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fetchData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
