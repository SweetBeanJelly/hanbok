package sweetbeanjelly.project.hanbok.pagerAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sweetbeanjelly.project.hanbok.R;

public class PageWear_View5 extends PagerAdapter {

    private LayoutInflater inflater;
    private Context context;

    public PageWear_View5(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return 1;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.page_wear_view5, container, false);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}