package com.eightbitlab.blurview_sample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

import butterknife.BindView;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class ImageFragment extends BaseFragment {

    private static int[] backgrounds = new int[5];
    static {
        backgrounds[0] = R.drawable.face;
        backgrounds[1] = R.drawable.fire;
        backgrounds[2] = R.drawable.lines;
        backgrounds[3] = R.drawable.marine;
        backgrounds[4] = R.drawable.trees;
    }

    @BindView(R.id.blurView)
    BlurView blurView;

    @BindView(R.id.ivThumb)
    ImageView ivThumb;

    @Override
    int getLayoutId() {
        return R.layout.fragment_image;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ivThumb.setImageResource(backgrounds[new Random().nextInt(backgrounds.length)]);

        blurView.setupWith((ViewGroup) getView())
                .setScaleFactor(12f)
                .setBlurAlgorithm(new RenderScriptBlur(getActivity()))
                .setBlurRadius(25f)
                .setHasFixedTransformationMatrix(true)
                .setBlurAutoUpdate(false);

        blurView.requestUpdate();
    }
}
