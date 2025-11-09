package com.opensource.armnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.opensource.armnews.databinding.FragmentInfoBinding
import com.opensource.armnews.presentation.viewmodel.NewsViewModel
import kotlin.getValue

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel : NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentInfoBinding.bind(view)

        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        viewModel=(activity as MainActivity).newsViewModel

        binding.wvInfo.apply {
            webViewClient = WebViewClient()
            article.url.let {
                loadUrl(it)
            }
        }
        binding.fabSave.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Saved Successfully!",Snackbar.LENGTH_LONG).show()
        }
    }
}