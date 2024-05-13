/*
 * Copyright 2024 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("dev.icerock.moko.gradle.multiplatform.mobile")
    id("dev.icerock.moko.gradle.publication")
    id("dev.icerock.moko.gradle.stub.javadoc")
    id("dev.icerock.moko.gradle.detekt")
}

android {
    namespace = "dev.icerock.moko.media.camera"

    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    androidMainImplementation(libs.appCompat)
    androidMainImplementation(libs.androidx.core.ktx)

    androidMainImplementation(libs.camerax.camera.core)
    androidMainImplementation(libs.camerax.camera.camera2)
    androidMainImplementation(libs.camerax.camera.lifecycle)
    androidMainImplementation(libs.camerax.camera.video)
    androidMainImplementation(libs.camerax.camera.view)
    androidMainImplementation(libs.camerax.camera.extensions)
    commonMainApi(projects.media)
}
