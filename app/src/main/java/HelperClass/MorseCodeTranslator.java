package HelperClass;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;

/**
 * Created by user on 10/18/16.
 */

public class MorseCodeTranslator {
    Context context;
    Camera camera;
    public boolean Flash = false;

    public void A() {

    }
//
//    public final static String B(String B) {
//
//    }
//
//    public final static String C(String C) {
//
//    }
//
//    public final static String D(String D) {
//
//    }
//
//    public final static String E(String E) {
//
//    }
//
//    public final static String F(String F) {
//
//    }
//
//    public final static String G(String G) {
//
//    }
//
//    public final static String H(String H) {
//
//    }
//
//    public final static String I(String I) {
//
//    }
//
//    public final static String J(String J) {
//
//    }
//
//    public final static String K(String K) {
//
//    }
//
//    public final static String L(String L) {
//
//    }
//
//    public final static String M(String M) {
//
//    }
//
//    public final static String N(String N) {
//
//    }
//
//    public final static String O(String O) {
//
//    }
//
//    public final static String P(String P) {
//
//    }
//
//    public final static String Q(String Q) {
//
//    }
//
//    public final static String R(String R) {
//
//    }
//
//    public final static String S(String S) {
//
//    }
//
//    public final static String T(String T) {
//
//    }
//
//    public final static String U(String U) {
//
//    }
//
//    public final static String V(String V) {
//
//    }
//
//    public final static String W(String W) {
//
//    }
//
//    public final static String X(String X) {
//
//    }
//
//    public final static String Y(String Y) {
//
//    }
//
//    public final static String Z(String Z) {
//
//    }
    public void flash(int delay) {
        camera = Camera.open();
        final Camera.Parameters parameters = camera.getParameters();
        Handler handler = new Handler();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
        handler.postDelayed(new Runnable() {
            public void run() {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
                camera.release();
            }
        }, delay);
    }
}
