package cn.jiaju.honosayaka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public final class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,MyService.class);

        //启动servicce服务

        startService(intent);
     //   new Thread(new T2()).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent name = new Intent(this,MyService.class);
        stopService(name);//name表示停止哪一个服务
    }
}
