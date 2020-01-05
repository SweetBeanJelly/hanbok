package sweetbeanjelly.project.hanbok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AdapterHanbok extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private PageHanbok pageHanbok = new PageHanbok();
    private PageDefault pageDefault = new PageDefault();
    private PageWear pageWear = new PageWear();

    BottomNavigationView navigation;
    ImageButton backBtn;
    TextView tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_hanbok);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Fragment 처음
        fragmentTransaction.replace(R.id.fragment_container, pageDefault).commitAllowingStateLoss();

        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        backBtn = findViewById(R.id.imageButtonBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tipText = findViewById(R.id.txtTip);
        tipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipShow();
            }
        });
        tipText.setVisibility(View.VISIBLE);
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.navigation_inst:
                    fragmentTransaction.replace(R.id.fragment_container, pageDefault).commitAllowingStateLoss();
                    tipText.setVisibility(View.VISIBLE);
                    break;
                case R.id.navigation_category:
                    fragmentTransaction.replace(R.id.fragment_container, pageHanbok).commitAllowingStateLoss();
                    tipText.setVisibility(View.INVISIBLE);
                    break;
                case R.id.navigation_wear:
                    fragmentTransaction.replace(R.id.fragment_container, pageWear).commitAllowingStateLoss();
                    tipText.setVisibility(View.INVISIBLE);
                    break;
            }
            return true;
        }
    }

    public void tipShow() {
        final View hanbok_tip = getLayoutInflater().inflate(R.layout.alert_tip,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle);
        builder.setView(hanbok_tip);
        builder.setTitle("한복 용어 이해하기");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
