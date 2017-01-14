package syn.com.tuangou.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import syn.com.tuangou.MainActivity;
import syn.com.tuangou.R;
/*引导界面*/

public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    //获取图片资源
    int[] imgRes = new int[]{
            R.mipmap.guid_1,
            R.mipmap.guid_2,
            R.mipmap.guid_3
    };

    //按钮
    private Button btn_tiyan;
    //存放view
    private List<View> list = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);


        initView();
        initData();
        initListener();
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(this);

        btn_tiyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initData() {


        for (int i = 0; i <imgRes.length ; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.item_guide,null);
            ImageView iv_guide = (ImageView) inflate.findViewById(R.id.iv_guide);


            if(i==imgRes.length-1){
                iv_guide.setBackgroundResource(imgRes[i]);
                //iv_guide_bg.setBackgroundResource(imgRes[i]);
                list.add(inflate);

            }else{
                iv_guide.setBackgroundResource(imgRes[i]);
                list.add(inflate);
            }

        }


    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter());
        btn_tiyan = (Button) findViewById(R.id.btn_tiyan);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if (position == list.size()-1){
            btn_tiyan.setVisibility(View.VISIBLE);
            Animation animation =  AnimationUtils.loadAnimation(GuideActivity.this,R.anim.btn_get_in);
            btn_tiyan.startAnimation(animation);
            Log.i("synnn","------>按钮出现");



        }else{
            btn_tiyan.setVisibility(View.GONE);
            Log.i("synnn","----》按钮消失");
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /*
    * 自定义适配器
    * */

    class MyAdapter extends PagerAdapter{


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));

            return list.get(position);
        }

        @Override
        public int getCount() {
            return imgRes.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }

    /**
     * 对ViewPager对象的监听事件
     */
    class myPagerChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //ViewPager滚动到第几张
        @Override
        public void onPageSelected(int position) {
            Log.i("synnn","-----》进入方法");

            if (position == list.size()){
                btn_tiyan.setVisibility(View.VISIBLE);
               Animation animation =  AnimationUtils.loadAnimation(GuideActivity.this,R.anim.btn_get_in);
               btn_tiyan.startAnimation(animation);
                Log.i("synnn","------>按钮出现");



            }else{
               btn_tiyan.setVisibility(View.GONE);
                Log.i("synnn","----》按钮消失");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
