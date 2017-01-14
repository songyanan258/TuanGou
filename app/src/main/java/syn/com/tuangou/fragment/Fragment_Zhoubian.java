package syn.com.tuangou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import syn.com.tuangou.R;

/**
 * Created by YN on 2017/1/13.
 */

public class Fragment_Zhoubian extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_zhoubian,null);
        return view;
    }
}
