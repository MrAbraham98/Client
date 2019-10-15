/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author mrabraham
 */
public class Client {
    public static void main(String[] args) throws IOException {
        
        Socket socket = null;
        String host = "192.168.1.20";
      try {
        socket = new Socket(host, 300);
          System.out.println("Bağlantı başarılı");
      } catch (Exception e) {
             System.out.println("Bağlantı başarısız");
        }
      
        try {
        File file = new File("/Users/mrabraham/Desktop/Mikroislemciler-DersNotu-02-2019.ppt");
        //Users/mrabraham/Desktop/isim-soyisim.txt
        // Get the size of the file
        long length = file.length();
        
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
            System.out.println("Dosya gönderme Başlarılı");
        out.close();
        in.close();
        socket.close(); 
        } catch (Exception e) {
            System.out.println("Dosya gönderme başarısız");
        }
        
    }
}