package sweetbeanjelly.project.hanbok;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import sweetbeanjelly.project.hanbok.pagerAdapter.PageWear_View1;
import sweetbeanjelly.project.hanbok.pagerAdapter.PageWear_View2;
import sweetbeanjelly.project.hanbok.pagerAdapter.PageWear_View3;
import sweetbeanjelly.project.hanbok.pagerAdapter.PageWear_View4;
import sweetbeanjelly.project.hanbok.pagerAdapter.PageWear_View5;

public class PageWear extends Fragment {

    Activity activity;
    Context context;

    private ImageButton btnOpenSilder, btnCloseSilder;
    TextView title;
    private TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    private DrawerLayout drawerLayout;
    private View drawer;

    ViewPager viewPager;
    PageWear_View1 wearView1; PageWear_View5 wearView5;
    PageWear_View2 wearView2;
    PageWear_View3 wearView3;
    PageWear_View4 wearView4;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle saveInstanceState){
        final View view=inflater.inflate(R.layout.page_wear,container,false);
        activity = getActivity();
        context = getContext();

        wearView1 = new PageWear_View1(context); wearView5 = new PageWear_View5(context);
        wearView2 = new PageWear_View2(context);
        wearView3 = new PageWear_View3(context);
        wearView4 = new PageWear_View4(context);

        btnOpenSilder = (ImageButton)view.findViewById(R.id.btn_drop);
        btnCloseSilder = (ImageButton)view.findViewById(R.id.btn_exit);
        title = (TextView)view.findViewById(R.id.name);
        drawerLayout = (DrawerLayout)view.findViewById(R.id.drawer_layout);
        drawer = (View)view.findViewById(R.id.drawer);
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        viewPager.setAdapter(wearView1);

        btnOpenSilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawer);
                drawerLayout.setVisibility(View.VISIBLE);
            }
        });
        btnCloseSilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                drawerLayout.setVisibility(View.INVISIBLE);
            }
        });

        drawerLayout.setDrawerListener(drawerListener);
        drawer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        title = (TextView)view.findViewById(R.id.name);

        txt1 = (TextView)view.findViewById(R.id.textView1);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt1.getText().toString();
                title.setText(name);
                viewPager.setAdapter(wearView1);
                closeDrawer();
            }
        });
        txt2 = (TextView)view.findViewById(R.id.textView2);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt2.getText().toString();
                title.setText(name);
                viewPager.setAdapter(wearView2);
                closeDrawer();
            }
        });
        txt3 = (TextView)view.findViewById(R.id.textView3);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt3.getText().toString();
                title.setText(name);
                viewPager.setAdapter(wearView3);
                closeDrawer();
            }
        });
        txt4 = (TextView)view.findViewById(R.id.textView4);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt4.getText().toString();
                title.setText(name);
                viewPager.setAdapter(wearView4);
                closeDrawer();
            }
        });
        txt5 = (TextView)view.findViewById(R.id.textView5);
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt5.getText().toString();
                title.setText(name);
                viewPager.setAdapter(wearView5);
                closeDrawer();
            }
        });

        return view;
    }

    public void closeDrawer() {
        drawerLayout.closeDrawers();
        drawerLayout.setVisibility(View.INVISIBLE);
    }

    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerStateChanged(int newState) {
            switch (newState) {
                case DrawerLayout.STATE_IDLE: // drawer open
                    break;
                case DrawerLayout.STATE_DRAGGING: // drawer drag
                    closeDrawer();
                    break;
                case DrawerLayout.STATE_SETTLING: // drawer close
                    break;
                default:
            }
        }
    };

}
