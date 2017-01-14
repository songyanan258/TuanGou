package syn.com.banner.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import syn.com.banner.R;

/**
 * Created by YN on 2017/1/12.
 */

public class BannerFragment extends Fragment {
    private int drawableRes;
    public BannerFragment() {
    }

    public void setImg(int drawableRes){
        this.drawableRes = drawableRes;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view_banner = inflater.inflate(R.layout.fragment_banner,null);
        ImageView iv_banner = (ImageView) view_banner.findViewById(R.id.iv_banner);
        iv_banner.setImageResource(drawableRes);
        return view_banner;
    }
}
