package dev.godraadam.ikigai.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.otaliastudios.zoom.ZoomLayout;
import com.richpath.RichPath;
import com.richpath.RichPathView;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLContext;

import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.android.service.VisitService;

public class MainActivity extends AppCompatActivity {

    private RichPathView richPathView;
    private ZoomLayout zoomLayout;
    private Button searchButton;
    private TextView searchBar;
    private List<Visit> visits;

    private VisitService visitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visitService = new VisitService(getApplicationContext());
        visitService.deleteAll();


        richPathView = findViewById(R.id.world_map_view);
        zoomLayout = findViewById(R.id.zoom_layout);
        zoomLayout.setHasClickableChildren(true);
        zoomLayout.setMaxZoom(10.0f);
        richPathView.setOnPathClickListener(e -> onCountryClicked(e));

        searchButton = findViewById(R.id.search_button);
        searchBar = findViewById(R.id.search_bar);

        searchButton.setOnClickListener(e -> onSearchClicked(e));

         visits = visitService.getVisitedCountries();

        for (Visit visit : visits) {
            richPathView.findRichPathByName(visit.getCountry()).setFillColor(R.color.colorVisitedCountry);
        }

    }

    private void onSearchClicked(View view) {
        String username = searchBar.getText().toString();
        List<Visit> otherVisits = visitService.getVisitsForUser(username);
        if (otherVisits != null) {
            repaintMap(otherVisits);
        }

    }

    private void repaintMap(List<Visit> otherVisits) {
        for (Visit visit : visits) {
            richPathView.findRichPathByName(visit.getCountry()).setFillColor(R.color.colorPrimary);
        }

        for (Visit visit : otherVisits) {
            richPathView.findRichPathByName(visit.getCountry()).setFillColor(R.color.colorVisitedCountry);
        }
        System.out.println("Here");
    }



    private void onCountryClicked(RichPath e) {
        e.setFillColor(R.color.colorVisitedCountry);
        System.out.println(e.getName());
        visitService.addVisitedCountry(new Visit(e.getName()));
    }
}