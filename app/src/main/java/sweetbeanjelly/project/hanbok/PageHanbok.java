package sweetbeanjelly.project.hanbok;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.relex.circleindicator.CircleIndicator;
import sweetbeanjelly.project.hanbok.pagerAdapter.PageHanbok_slider;

public class PageHanbok extends Fragment {

    Activity activity;
    Context context;
    PageHanbok_slider adapter;
    ViewPager viewPager;
    CircleIndicator indicator;

    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.page_hanbok,container,false);
        activity = getActivity();
        context = getContext();

        viewPager = view.findViewById(R.id.pager);
        adapter = new PageHanbok_slider(context);
        viewPager.setAdapter(adapter);
        indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        return view;
    }
}
