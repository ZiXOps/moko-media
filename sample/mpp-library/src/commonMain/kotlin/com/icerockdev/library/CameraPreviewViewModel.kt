package com.icerockdev.library

import dev.icerock.moko.media.camera.MediaCameraController
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class CameraPreviewViewModel(
    val mediaCameraController: MediaCameraController,
) : ViewModel() {

    fun onCameraCapturePressed() {
        takePhoto()
    }

    fun onVideoCapturePressed() {
        captureVideo()
    }

    private fun takePhoto() {
        viewModelScope.launch {
            mediaCameraController.takePhoto()
        }
    }

    private fun captureVideo() {
        viewModelScope.launch {
            mediaCameraController.captureVideo()
        }
    }
}
