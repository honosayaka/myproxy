package cn.jiaju.honosayaka;


import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.net.*;

import static android.content.ContentValues.TAG;

public class MyPortResent {

    public void service() throws Exception{
        ServerSocket server = new ServerSocket(6677);
        while (true){
            Socket fromSocket = server.accept();
            Log.d("qwert", "service: get a client");
            Socket toSocket = new Socket("127.0.0.1", 8899);
            reSend(fromSocket,toSocket);//将请求转发出去
            reSend(toSocket,fromSocket);
            fromSocket.close();
            toSocket.close();
        }
    }

    public void reSend(Socket fromSocket,Socket toSocket) throws Exception{//读取的socket、、发送的socket
        byte[] data = readData(fromSocket);
        writeData(toSocket,data);
    }


    public byte[] readData(Socket s)throws Exception{
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(s.getInputStream());
        while ((len=inputStream.read(buffer)) != -1){
            data.write(buffer,0,len);
            data.flush();
        }
        byte[] da = data.toByteArray();
        data.close();
        inputStream.close();
        return da;
    }


    public void writeData(Socket s,byte[] data) throws Exception{
        BufferedOutputStream outputStream = new BufferedOutputStream(s.getOutputStream());
        outputStream.write(data,0,data.length);
        outputStream.flush();
        outputStream.close();
    }

}
