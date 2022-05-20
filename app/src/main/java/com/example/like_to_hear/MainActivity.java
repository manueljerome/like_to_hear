package com.example.like_to_hear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.like_to_hear.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'like_to_hear' library on application startup.
    static {
        System.loadLibrary("like_to_hear");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'like_to_hear' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}