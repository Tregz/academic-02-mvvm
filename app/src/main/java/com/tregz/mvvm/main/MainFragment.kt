package com.tregz.mvvm.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.tregz.mvvm.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainBackend

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameLabel = getString(R.string.label_username)
        image_button.setOnClickListener { it.isSelected = !it.isSelected }
        var input: String = nameLabel
        input_editor.doOnTextChanged { text, _, _, _ ->
            with(text.toString()) {
                input = if (this.isNotEmpty()) this else nameLabel
            }
        }
        negative_button.setOnClickListener { username.text = nameLabel }
        positive_button.setOnClickListener { username.text = input }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainBackend::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        //private val TAG: String = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }
}
