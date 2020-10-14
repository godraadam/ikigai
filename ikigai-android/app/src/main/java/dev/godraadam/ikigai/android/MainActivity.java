package dev.godraadam.ikigai.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.otaliastudios.zoom.ZoomLayout;
import com.richpath.RichPath;
import com.richpath.RichPathView;

import java.util.Date;
import java.util.List;

import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.android.service.VisitService;

public class MainActivity extends AppCompatActivity {

    private RichPathView richPathView;
    private ZoomLayout zoomLayout;

    private VisitService visitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visitService = new VisitService(getApplicationContext());

        richPathView = findViewById(R.id.world_map_view);
        zoomLayout = findViewById(R.id.zoom_layout);
        zoomLayout.setHasClickableChildren(true);
        zoomLayout.setMaxZoom(10.0f);
        richPathView.setOnPathClickListener(e -> onCountryClicked(e));

        List<Visit> visits = visitService.getVisitedCountries();

        for (Visit visit : visits) {
            richPathView.findRichPathByName(visit.getCountry()).setFillColor(R.color.colorVisitedCountry);
        }

    }

    private void onCountryClicked(RichPath e) {
        e.setFillColor(R.color.colorVisitedCountry);
        visitService.addVisitedCountry(new Visit(e.getName()));
    }
}