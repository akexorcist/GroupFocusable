package com.akexorcist.groupfocusable.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akexorcist.groupfocusable.sample.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            buttonDialog.setOnClickListener { showDialog() }
            buttonBottomSheet.setOnClickListener { showBottomSheet() }
        }
    }

    private fun showDialog() {
        MaterialAlertDialogBuilder(this)
            .setView(R.layout.dialog_input)
            .show()
    }

    private fun showBottomSheet() {
        InputBottomSheetDialogFragment.newInstance()
            .show(supportFragmentManager, null)
    }
}
