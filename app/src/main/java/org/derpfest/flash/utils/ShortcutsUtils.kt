/*
 * SPDX-FileCopyrightText: 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.derpfest.flash.utils

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import org.derpfest.flash.CameraActivity
import org.derpfest.flash.R

object ShortcutsUtils {
    const val SHORTCUT_ID_SELFIE = "shortcut_selfie"
    const val SHORTCUT_ID_VIDEO = "shortcut_video"
    const val SHORTCUT_ID_QR = "shortcut_qr"

    @androidx.camera.camera2.interop.ExperimentalCamera2Interop
    @androidx.camera.core.ExperimentalZeroShutterLag
    fun registerShortcuts(context: Context) {
        val shortcutManager = context.getSystemService(ShortcutManager::class.java)
        shortcutManager.dynamicShortcuts = listOf(
            ShortcutInfo.Builder(context, SHORTCUT_ID_SELFIE)
                .setShortLabel(context.getString(R.string.shortcut_selfie))
                .setLongLabel(context.getString(R.string.shortcut_selfie))
                .setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_selfie))
                .setIntent(
                    Intent(context, org.derpfest.flash.CameraActivity::class.java)
                        .setAction(SHORTCUT_ID_SELFIE)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                )
                .build(),
            ShortcutInfo.Builder(context, SHORTCUT_ID_VIDEO)
                .setShortLabel(context.getString(R.string.shortcut_video))
                .setLongLabel(context.getString(R.string.shortcut_video))
                .setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_video))
                .setIntent(
                    Intent(context, org.derpfest.flash.CameraActivity::class.java)
                        .setAction(SHORTCUT_ID_VIDEO)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                )
                .build(),
            ShortcutInfo.Builder(context, SHORTCUT_ID_QR)
                .setShortLabel(context.getString(R.string.shortcut_qr))
                .setLongLabel(context.getString(R.string.shortcut_qr))
                .setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_qr))
                .setIntent(
                    Intent(context, org.derpfest.flash.CameraActivity::class.java)
                        .setAction(SHORTCUT_ID_QR)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                )
                .build()
        )
    }
}
