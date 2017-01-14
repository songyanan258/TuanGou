package syn.com.tuangou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import syn.com.tuangou.fragment.Fragment_Home;
import syn.com.tuangou.fragment.Fragment_More;
import syn.com.tuangou.fragment.Fragment_Wode;
import syn.com.tuangou.fragment.Fragment_Zhoubian;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    //存放碎片
    private Class[] fragmentRes = new Class[]{
            Fragment_Home.class,
            Fragment_Zhoubian.class,
            Fragment_Wode.class,
            Fragment_More.class
    };

    //存放Tab图片
    private int[] imgSelector = new int[]{
        R.drawable.ic_menu_deal_selector,
            R.drawable.ic_menu_nearby_selector,
            R.drawable.ic_menu_user_selector,
            R.drawable.ic_menu_more_selector
    };
    //存放Tab文本
    private String[] textRes = new String[]{
            "首页","周边","我的","更多"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);


        for (int i = 0; i <fragmentRes.length ; i++) {
            View view_tab = getLayoutInflater().inflate(R.layout.item_tab,null);
            ImageView iv_tab = (ImageView) view_tab.findViewById(R.id.iv_tab);
            TextView tv_tab = (TextView) view_tab.findViewById(R.id.tv_tab);
            iv_tab.setImageResource(imgSelector[i]);
            tv_tab.setText(textRes[i]);
            Class<Fragment> fragment = fragmentRes[i];
            tabHost.addTab(tabHost.newTabSpec(""+i).setIndicator(view_tab),fragment,null);

        }



    }

    private void initView() {
        tabHost = (FragmentTabHost) findViewById(R.id.tbHost);
    }
}
