package com.opensource.armnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.databinding.FragmentNewsBinding
import com.opensource.armnews.presentation.adapter.NewsAdapter
import com.opensource.armnews.presentation.viewmodel.NewsViewModel

class NewsFragment : Fragment() {

    private lateinit var fragmentNewsBinding: FragmentNewsBinding
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    private var page = 1
    private var isScrolling = false
    private var isLoading = false
    private var isLastPage = false
    private var pages = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentNewsBinding = FragmentNewsBinding.bind(view)
        newsViewModel = (activity as MainActivity).newsViewModel

        getNewsList()
        setUpRecyclerView()
    }

    private fun getNewsList() {
        newsAdapter = NewsAdapter()
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }

            findNavController().navigate(R.id.action_newsFragment_to_infoFragment, bundle)
        }

        newsViewModel.getNewsHeadLines("us", 1)
        newsViewModel.newsHeadLines.observe(viewLifecycleOwner) { response ->

            when (response) {
                is Resource.Success -> {
                    handleProgressBar(true)
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles.toList())
                        pages = if (it.totalResults % 20 == 0) {
                            it.totalResults / 20
                        } else {
                            it.totalResults / 20 + 1
                        }

                        isLastPage = page == pages
                    }
                }

                is Resource.Error -> {
                    handleProgressBar(false)
                    response.message?.let {
                        Toast.makeText(activity, "An error occurred: $it", Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading -> {
                    handleProgressBar(true)
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        fragmentNewsBinding.newsList.adapter = newsAdapter
        fragmentNewsBinding.newsList.layoutManager = LinearLayoutManager(activity)
    }

    private fun handleProgressBar(show: Boolean) {
        fragmentNewsBinding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }
}