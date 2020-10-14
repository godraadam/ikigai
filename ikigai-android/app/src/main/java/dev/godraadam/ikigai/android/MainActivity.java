package dev.godraadam.ikigai.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.otaliastudios.zoom.ZoomLayout;
import com.richpath.RichPath;
import com.richpath.RichPathView;

public class MainActivity extends AppCompatActivity {

    private RichPathView richPathView;
    private ZoomLayout zoomLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        richPathView = findViewById(R.id.world_map_view);
        zoomLayout = findViewById(R.id.zoom_layout);
        zoomLayout.setHasClickableChildren(true);
        zoomLayout.setMaxZoom(10.0f);
        richPathView.setOnPathClickListener(e -> onCountryClicked(e));

    }

    private void onCountryClicked(RichPath e) {
        e.setFillColor(0xfadafaff);
    }
}