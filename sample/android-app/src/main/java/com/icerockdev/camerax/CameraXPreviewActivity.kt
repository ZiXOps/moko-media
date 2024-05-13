package com.icerockdev.camerax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.databinding.ActivityCameraxPreviewBinding
import com.icerockdev.library.CameraPreviewViewModel
import dev.icerock.moko.media.camera.MediaCameraController
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
            val mediaCameraController = MediaCameraController(permissionsController)
            CameraPreviewViewModel(mediaCameraController)
        }

        viewModel.mediaCameraController.bind(binding.viewFinder, this)

        binding.imageCaptureButton.setOnClickListener { viewModel.onCameraCapturePressed() }
        binding.videoCaptureButton.setOnClickListener { viewModel.onVideoCapturePressed() }
    }
}
