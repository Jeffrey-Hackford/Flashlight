package com.epicodus.flashlight;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;
import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.userInput) EditText mUserInput;
    @Bind(R.id.toggleButton) ToggleButton mToggleButton;

//    ToggleButton mToggleButton;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

//        mToggleButton = (ToggleButton) findViewById(R.id.toggleButton);


        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    camera = Camera.open();
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                } else {
//                    camera = Camera.open();
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.stopPreview();
                    camera.release();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
//        if (view == mToggleButton) {
//            if (mToggleButton.isChecked()) {
//                camera = Camera.open();
//                Camera.Parameters parameters = camera.getParameters();
//                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//                camera.setParameters(parameters);
//                camera.startPreview();
//                camera.release();
//            } else {
//                camera = Camera.open();
//                Camera.Parameters parameters = camera.getParameters();
//                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//                camera.setParameters(parameters);
//                camera.stopPreview();
//                camera.release();
//            }
//        }
    }
}


//            camera = Camera.open();
//            Camera.Parameters parameters = camera.getParameters();
//            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//            camera.setParameters(parameters);
//            camera.stopPreview();
//            camera.release();