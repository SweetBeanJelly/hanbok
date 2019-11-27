package sweetbeanjelly.project.hanbok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class AdapterHanbok extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private PageHanbok pageHanbok = new PageHanbok();

    BottomNavigationView navigation;
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_hanbok);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Fragment 처음
        fragmentTransaction.replace(R.id.fragment_container, pageHanbok).commitAllowingStateLoss();

        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        backBtn = findViewById(R.id.imageButtonBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.navigation_inst:
                    fragmentTransaction.replace(R.id.fragment_container, pageHanbok).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}
