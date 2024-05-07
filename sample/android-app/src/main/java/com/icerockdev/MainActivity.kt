package com.icerockdev

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.camerax.CameraXPreviewActivity
import com.icerockdev.databinding.ActivityMainBinding
import com.icerockdev.library.ImageSelectionViewModel
import dev.icerock.moko.media.picker.MediaPickerController
import dev.icerock.moko.mvvm.getViewModel
import dev.icerock.moko.permissions.PermissionsController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val viewModel = getViewModel {
            val permissionsController = PermissionsController(
                applicationContext = applicationContext
            )
            val mediaPickerController = MediaPickerController(permissionsController)
            ImageSelectionViewModel(mediaPickerController)
        }

        viewModel.mediaPickerController.bind(this)

        binding.cameraButton.setOnClickListener { viewModel.onCameraPressed() }
        binding.galleryButton.setOnClickListener { viewModel.onGalleryPressed() }
        binding.fileButton.setOnClickListener { viewModel.onFilePressed() }
        binding.previewButton.setOnClickListener { routeToCameraXPreview() }
        viewModel.textState.ld().observe(this) { binding.textView.text = it }
        viewModel.selectedImage.ld()
            .observe(this) { binding.imageView.setImageBitmap(it?.platformBitmap) }
    }

    private fun routeToCameraXPreview() {
        val intent = Intent(this, CameraXPreviewActivity::class.java)
        startActivity(intent)
    }
}
