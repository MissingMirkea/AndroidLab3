package com.example.laborator3;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView2;
    private Button buttonPlayVideo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize VideoView and Button
        mVideoView2 = findViewById(R.id.videoView);
        buttonPlayVideo2 = findViewById(R.id.button);

        // Set the URI for the video in the raw folder
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.porsche;
        Uri uri2 = Uri.parse(uriPath);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();

        // Set up the button click listener
        buttonPlayVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoView2.isPlaying()) {
                    mVideoView2.pause(); // Pause the video if it's playing
                    buttonPlayVideo2.setText("Play"); // Change button text to "Play"
                } else {
                    mVideoView2.start(); // Start the video if it's not playing
                    buttonPlayVideo2.setText("Stop"); // Change button text to "Stop"
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Adjust VideoView layout for fullscreen in landscape mode
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Optional: Add any additional logic for landscape mode
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Optional: Add any additional logic for portrait mode
        }
    }
}