package com.feidian.ek.hzaumooc.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.feidian.ek.hzaumooc.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SLIDER = 5;
    public static final int GIRD = 6;
    Activity activity;
    LayoutInflater layoutInflater;

    class GirdViewHolder extends RecyclerView.ViewHolder {

        //@Bind(R.id.item_girdview_title) TextView title;
        //@Bind(R.id.item_girdview) GridView gridView;
        NoScrollGridView gridView;
        TextView title;

        public GirdViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            gridView = (NoScrollGridView) itemView.findViewById(R.id.item_girdview);
            title = (TextView) itemView.findViewById(R.id.item_girdview_title);
        }
    }

    public MainAdapter(Activity activity) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
    }

    /**
     * 滚动条
     */
    class ViewHolderSlider extends RecyclerView.ViewHolder {

        @Bind(R.id.item_slider_banner)
        public SliderLayout sliderLayout;
        @Bind(R.id.item_slider_indicator)
        public PagerIndicator indicator;

        public ViewHolderSlider(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            Context context = itemView.getContext();

            ViewGroup.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.sliderLayout.getLayoutParams();
            if (layoutParams == null || layoutParams.width <= 0) {
                //可用高度小于100dp
                Point point = new Point();
                ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
                int d = point.x;
                layoutParams = new FrameLayout.LayoutParams(d, (int) (((float) d) / 2.333333f));

            } else {
                Log.d("layoutParams before", layoutParams.height + "");
                layoutParams.height = (int) (((float) layoutParams.width) / 2.333333f);
                Log.d("layoutParams after", layoutParams.height + "");
            }
            sliderLayout.setLayoutParams(layoutParams);
            sliderLayout.setCustomIndicator(indicator);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SLIDER:
                return new ViewHolderSlider(layoutInflater.inflate(R.layout.item_slider_banner, parent, false));
            case GIRD:
                return new GirdViewHolder(layoutInflater.inflate(R.layout.item_girdview, parent, false));
            default:
                return new GirdViewHolder(layoutInflater.inflate(R.layout.item_girdview, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderSlider) {
            ((ViewHolderSlider) holder).sliderLayout.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Visible);
            ((ViewHolderSlider) holder).sliderLayout.startAutoCycle();
            ((ViewHolderSlider) holder).sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
            BaseSliderView sliderView = new DefaultSliderView(activity);
            sliderView.image("http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg").setScaleType(BaseSliderView.ScaleType.CenterCrop);
            for (int i = 0; i < 3; i++) {
                ((ViewHolderSlider) holder).sliderLayout.addSlider(sliderView);
            }
        } else if (holder instanceof GirdViewHolder) {
            ((GirdViewHolder) holder).title.setText("热门收藏");
            ((GirdViewHolder) holder).gridView.setAdapter(new GridAdapter(activity));
        }


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return SLIDER;
        if (position == 1) return GIRD;
        return super.getItemViewType(position);
    }
}
