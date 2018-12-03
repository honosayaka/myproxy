package cn.jiaju.honosayaka;

import android.util.Log;

import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class D {
    public void doit() throws Exception{
        ServerSocket ser = new ServerSocket(8899);
        Socket s =ser.accept();
        byte[] b = "htllowwf".getBytes();
        writeData(s,b);
    }

    public void writeData(Socket s, byte[] data) throws Exception {
        BufferedOutputStream outputStream = new BufferedOutputStream(s.getOutputStream());
        outputStream.write(data, 0, data.length);
        outputStream.flush();
        outputStream.close();
    }
}
