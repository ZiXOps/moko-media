/*
 * Copyright 2024 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.media.camera

import dev.icerock.moko.media.Media
import dev.icerock.moko.permissions.PermissionsController

expect interface MediaCameraController {

    val permissionsController: PermissionsController

    suspend fun takePhoto()

    suspend fun captureVideo()
}
