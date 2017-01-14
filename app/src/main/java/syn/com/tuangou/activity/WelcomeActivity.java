package syn.com.tuangou.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import syn.com.tuangou.MainActivity;
import syn.com.tuangou.R;
/*
* 欢迎界面
* */
public class WelcomeActivity extends Activity {

    Handler mHandler = new Handler();
    private boolean isFirst = true;//判断用户是否为第一次
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        initView();
    }

    private void initView() {


        delay();
    }


    //延迟时间
    public void delay(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                //利用首选项存储是否为用户第一次进入
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                isFirst = sp.getBoolean("isFirst",true);
                if (isFirst){
                    //修改分享首选项中的isFirst
                    sp.edit().putBoolean("isFirst",false).commit();
                    //如果为第一次则进入引导界面
                    intent.setClass(WelcomeActivity.this, GuideActivity.class);

                }else{
                    //不是第一次则进入主界面
                   intent.setClass(WelcomeActivity.this, MainActivity.class);
                }

                startActivity(intent);
                //设置界面之间的切换动画
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },500);//延迟三秒进入

    }
}
