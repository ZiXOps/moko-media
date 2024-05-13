/*
 * Copyright 2024 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.media.camera

import androidx.activity.ComponentActivity
import androidx.camera.view.PreviewView
import dev.icerock.moko.media.Media
import dev.icerock.moko.permissions.PermissionsController

actual interface MediaCameraController {

    actual val permissionsController: PermissionsController

    fun bind(previewView: PreviewView, activity: ComponentActivity)

    actual suspend fun takePhoto()

    actual suspend fun captureVideo()

    companion object {
        operator fun invoke(
            permissionsController: PermissionsController,
        ): MediaCameraController {
            return MediaCameraControllerImpl(
                permissionsController = permissionsController,
            )
        }
    }
}
