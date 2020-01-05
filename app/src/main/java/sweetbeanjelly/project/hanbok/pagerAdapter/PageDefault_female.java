package sweetbeanjelly.project.hanbok.pagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import sweetbeanjelly.project.hanbok.R;

public class PageDefault_female extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;

    public PageDefault_female(Context context) {
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
        View view = inflater.inflate(R.layout.page_default_female, container, false);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
