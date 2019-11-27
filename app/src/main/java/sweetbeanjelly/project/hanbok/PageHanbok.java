package sweetbeanjelly.project.hanbok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class PageHanbok extends Fragment {

    Activity activity;
    Context context;
    PageHanbok_pagerAdapter adapter;
    ViewPager viewPager;
    CircleIndicator indicator;

    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.page_hanbok,container,false);
        activity = getActivity();
        context = getContext();

        viewPager = view.findViewById(R.id.pager);
        adapter = new PageHanbok_pagerAdapter(context);
        viewPager.setAdapter(adapter);
        indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        return view;
    }

    public void testShow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity,R.style.MyAlertDialogStyle);
        builder.setTitle("할룽");
        builder.setMessage("빨룽");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}
