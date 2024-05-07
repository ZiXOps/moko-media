package com.icerockdev.camerax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.databinding.ActivityCameraxPreviewBinding
import com.icerockdev.library.ImageSelectionViewModel
import dev.icerock.moko.media.picker.MediaPickerController
import dev.icerock.moko.mvvm.getViewModel
import dev.icerock.moko.permissions.PermissionsController

class CameraXPreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCameraxPreviewBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val viewModel = getViewModel {
            val permissionsController = PermissionsController(
                applicationContext = applicationContext
            )
            val mediaPickerController = MediaPickerController(permissionsController)
            ImageSelectionViewModel(mediaPickerController)
        }

        viewModel.mediaPickerController.bind(this)

        binding.imageCaptureButton.setOnClickListener { viewModel.onGalleryPressed() }
        binding.videoCaptureButton.setOnClickListener { viewModel.onCameraPressed() }
    }
}
