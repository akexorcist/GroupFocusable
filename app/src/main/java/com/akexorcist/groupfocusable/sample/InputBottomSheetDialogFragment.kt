package com.akexorcist.groupfocusable.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akexorcist.groupfocusable.sample.databinding.BottomSheetInputBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InputBottomSheetDialogFragment : BottomSheetDialogFragment() {
    companion object {
        fun newInstance() = InputBottomSheetDialogFragment()
    }

    private lateinit var binding: BottomSheetInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetInputBinding.inflate(inflater, container, false)
        return binding.root
    }
}