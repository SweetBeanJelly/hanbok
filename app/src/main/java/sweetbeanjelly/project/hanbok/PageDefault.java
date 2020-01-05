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
import android.widget.Button;

import sweetbeanjelly.project.hanbok.pagerAdapter.PageDefault_female;
import sweetbeanjelly.project.hanbok.pagerAdapter.PageDefault_male;

public class PageDefault extends Fragment {

    Boolean btnFCheck = true , btnMCheck = false; // true = gray , false = white
    Activity activity;
    Context context;
    PageDefault_female adapter_female;
    PageDefault_male adapter_male;
    ViewPager viewPager;
    Button btnF, btnM;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.page_default,container,false);
        activity = getActivity();
        context = getContext();
        viewPager = view.findViewById(R.id.pager);
        adapter_female = new PageDefault_female(context);
        adapter_male  = new PageDefault_male(context);
        viewPager.setAdapter(adapter_female);

        btnF = (Button)view.findViewById(R.id.btnF);
        btnM = (Button)view.findViewById(R.id.btnM);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFCheck = true;
                btnMCheck = false;
                if((btnFCheck==true)&&(btnMCheck==false)) {
                    btnF.setBackgroundColor(getResources().getColor(R.color.Gray));
                    btnM.setBackgroundColor(getResources().getColor(R.color.white));
                    btnF.setTextColor(getResources().getColor(R.color.white));
                    btnM.setTextColor(getResources().getColor(R.color.DarkGray));
                    viewPager.setAdapter(adapter_female);
                }
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFCheck = false;
                btnMCheck = true;
                if((btnFCheck==false)&&(btnMCheck==true)) {
                    btnF.setBackgroundColor(getResources().getColor(R.color.white));
                    btnM.setBackgroundColor(getResources().getColor(R.color.Gray));
                    btnF.setTextColor(getResources().getColor(R.color.DarkGray));
                    btnM.setTextColor(getResources().getColor(R.color.white));
                    viewPager.setAdapter(adapter_male);
                }
            }
        });

        return view;
    }
}
