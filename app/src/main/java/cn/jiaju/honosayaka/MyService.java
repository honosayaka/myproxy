package cn.jiaju.honosayaka;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new T()).start();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;	}
        //服务被关闭时调用
     @Override
     public void onDestroy() {
        super.onDestroy();
    }

    class T implements Runnable{
        @Override
        public void run() {
            new RemoteConnector().startX();
        }
    }

}