package httpClient;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yazan Habash
 */
public class DownloadUploadImage implements DownloadUpload {

    private String selectedImage;

    public DownloadUploadImage(String selectedImage) {
        this.selectedImage = selectedImage;
    }

    @Override
    public void downloadPHP(String url) {
        try {
            URL u = new URL(url);
            OutputStream os;
            InputStream is;

            HttpURLConnection myConn = (HttpURLConnection) u.openConnection();
            myConn.setDoOutput(true);
            myConn.setRequestMethod("POST");
            myConn.setDoInput(true);
            myConn.setRequestProperty("Content-Type", contentStr);
            myConn.setUseCaches(false);
            String dataStr = URLEncoder.encode("download_image", "UTF-8") + "=" + selectedImage;
            try (BufferedOutputStream out = new BufferedOutputStream(myConn.getOutputStream())) {
                out.write(dataStr.getBytes());
            }
            String SS = "";

            if (myConn.getResponseCode() == 404) {
                System.out.println("error!");
            }

            byte tmp[] = new byte[1024];
            is = myConn.getInputStream();
            ByteArrayOutputStream O = new ByteArrayOutputStream();

            int n = 0;
            int b = -1;
            FileOutputStream myWriter = new FileOutputStream("C:/Users/HP/" + selectedImage);
            if (myConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myConn.getInputStream()))) {
                    while ((n = is.read(tmp)) != -1) {
                        O.write(tmp, 0, n);
                    }

                    byte[] r = O.toByteArray();
                    myWriter.write(r);
                    myWriter.close();
                    is.close();
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void downloadServlet(String url) {
        try {
            URL u = new URL(url);
            OutputStream os;
            InputStream is;

            HttpURLConnection myConn = (HttpURLConnection) u.openConnection();
            myConn.setDoOutput(true);
            myConn.setRequestMethod("POST");
            myConn.setDoInput(true);
            myConn.setRequestProperty("Content-Type", contentStr);
            myConn.setUseCaches(false);
            String dataStr = URLEncoder.encode("download_image", "UTF-8") + "=" + selectedImage;
            try (BufferedOutputStream out = new BufferedOutputStream(myConn.getOutputStream())) {
                out.write(dataStr.getBytes());
            }
            String SS = "";

            if (myConn.getResponseCode() == 404) {
                System.out.println("error!");
            }

            int b = -1;
            File file = new File("C:/Users/HP/" + selectedImage);
            FileOutputStream myWriter = new FileOutputStream(file);
            if (myConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myConn.getInputStream()))) {
                    while ((b = bufferedReader.read()) != -1) {
                        SS = SS + (char) b;
                        myWriter.write(b);
                    }
                    myWriter.close();
                }
                MainClient.statusTextArea.setText(SS);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
