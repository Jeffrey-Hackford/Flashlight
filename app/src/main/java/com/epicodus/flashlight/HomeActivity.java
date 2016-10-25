package com.epicodus.flashlight;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import HelperClass.MorseCodeTranslator;
import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.userInput) EditText mUserInput;
    @Bind(R.id.toggleButton) ToggleButton mToggleButton;
    @Bind(R.id.morseCodeButton) Button mMorseCodeButton;
    Camera camera;
    public int dot = 250;
    public int dash = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mMorseCodeButton.setOnClickListener(this);

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
        if (view == mMorseCodeButton) {
            MorseCodeTranslator translator = new MorseCodeTranslator();
            translator.flash(dot);
        }
    }
}