package com.bryant.qrcodescan;

import android.hardware.Camera;

/**
 * @author zcs
 * @date 2018/2/2 0002
 */

public class CameraUtils {
    public static boolean isCameraCanUse() {
        boolean canUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open();
        } catch (Exception e) {
            canUse = false;
        }
        if (canUse) {
            if (mCamera != null)
                mCamera.release();
            mCamera = null;
        }
        return canUse;
    }
}
