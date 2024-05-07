/*
 * Copyright 2024 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.media.camera

import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import dev.icerock.moko.media.Media

actual interface MediaCameraController {

    fun bind(previewView: PreviewView, lifecycleOwner: LifecycleOwner)

    actual suspend fun takePhoto(): Media

    actual suspend fun captureVideo()
}
