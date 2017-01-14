package syn.com.banner;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import syn.com.banner.fragment.BannerFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager banner_viewPager;
    //几张广告图片
    private static int IMG_NUM=3;

    private int[] img_res;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initListener() {
        autoScroll();
    }

    private void autoScroll() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = banner_viewPager.getCurrentItem();//获取当前的页面下表
                banner_viewPager.setCurrentItem(currentItem+1);
                handler.postDelayed(this,2000);

            }
        },2000);
    }

    private void initData() {
        banner_viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        img_res=new int[]{
            R.mipmap.banner_1,
            R.mipmap.banner_2,
            R.mipmap.banner_3
        };
    }

    private void initView() {
        banner_viewPager = (ViewPager) findViewById(R.id.banner_viewPager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            position %= img_res.length;
            BannerFragment fragment = new BannerFragment();
            fragment.setImg(img_res[position]);
            return fragment;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }
}
