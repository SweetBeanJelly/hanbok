package sweetbeanjelly.project.hanbok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

public class PageHanbok_pagerAdapter extends PagerAdapter {
    private int[] images = {R.drawable.image_hanbok_1, R.drawable.image_hanbok_2, R.drawable.image_hanbok_3, R.drawable.image_hanbok_4,
            R.drawable.image_hanbok_5, R.drawable.image_hanbok_6, R.drawable.image_hanbok_7, R.drawable.image_hanbok_8, R.drawable.image_hanbok_9};
    private LayoutInflater inflater;
    private Context context;

    public PageHanbok_pagerAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.page_hanbok_slider, container, false);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(images[position]);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
