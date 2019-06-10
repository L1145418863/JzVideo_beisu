package com.lzg.video;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedHashMap;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * 饺子视频倍速demo  饺子视频版本   6.2.12
 * 包括 视频倍速 视频清晰度切换
 * 视频 结束 监听
 */
public class MainActivity extends AppCompatActivity {

    private JZVideoPlayerStandard jzvideoplayerstandard;
    private String[] mediaName = {"普通", "高清", "原画"};//可以做选集

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        jzvideoplayerstandard = (JZVideoPlayerStandard) findViewById(R.id.jzvideoplayerstandard);

        Object[] objects = new Object[3];
        LinkedHashMap map = new LinkedHashMap();
        for (int i = 0; i < 3; i++) {
            map.put(mediaName[i], "http://ssb-video.oss-cn-qingdao.aliyuncs.com/Video_1003_20161027140007.mp4");
        }
        objects[0] = map;
        objects[1] = false;
        objects[2] = new HashMap<>();
        ((HashMap) objects[2]).put("key", "value");

        jzvideoplayerstandard.setUp(objects, 0
                , JZVideoPlayerStandard.SCROLL_AXIS_HORIZONTAL, "可选集 可倍速");

        jzvideoplayerstandard.setonVideoEndLinstener(new JZVideoPlayerStandard.onVideoEndLinstener() {
            @Override
            public void videoEndListener() {
                Toast.makeText(MainActivity.this,"视频播放结束",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
