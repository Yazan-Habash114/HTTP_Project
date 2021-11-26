package httpClient;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Yazan Habash
 */
public class DownloadUploadImage implements DownloadUpload {

    private String selectedImage;
    private ClientInterfaceWindow ciw;
    
    public DownloadUploadImage(ClientInterfaceWindow ciw) {
        this.ciw = ciw;
    }

    public DownloadUploadImage(ClientInterfaceWindow ciw, String selectedImage) {
        this.selectedImage = selectedImage;
        this.ciw = ciw;
    }

    @Override
    public void downloadPHP(String url) {
        try {
            URL u = new URL(url);
            InputStream is;

            HttpURLConnection myConn = (HttpURLConnection) u.openConnection();
            myConn.setDoOutput(true);
            myConn.setRequestMethod("POST");
            myConn.setDoInput(true);
            myConn.setRequestProperty("Content-Type", CONTENT_STR);
            myConn.setUseCaches(false);
            String dataStr = URLEncoder.encode("DownloadImage", "UTF-8") + "=" + selectedImage;
            try (BufferedOutputStream out = new BufferedOutputStream(myConn.getOutputStream())) {
                out.write(dataStr.getBytes());
            }

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
            ciw.getStatusTextArea().setText("Your image has been download from server successfully");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void downloadServlet(String url) {
        try {
            URL u = new URL(url);

            HttpURLConnection myConn = (HttpURLConnection) u.openConnection();
            myConn.setDoOutput(true);
            myConn.setRequestMethod("POST");
            myConn.setDoInput(true);
            myConn.setRequestProperty("Content-Type", CONTENT_STR);
            myConn.setUseCaches(false);
            String dataStr = URLEncoder.encode("DownloadImage", "UTF-8") + "=" + selectedImage;
            try (BufferedOutputStream out = new BufferedOutputStream(myConn.getOutputStream())) {
                out.write(dataStr.getBytes());
            }

            if (myConn.getResponseCode() == 404) {
                System.out.println("Error!");
            }

            int b = -1;
            File file = new File("C:/Users/HP/" + selectedImage);
            FileOutputStream myWriter = new FileOutputStream(file);
            if (myConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myConn.getInputStream()))) {
                    while ((b = bufferedReader.read()) != -1) {
                        myWriter.write(b);
                    }
                    myWriter.close();
                }
            }
            ciw.getStatusTextArea().setText("Your image has been download from server successfully");

        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void uploadImage() {
        try {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            String fileName = f.getAbsolutePath();
            ciw.getImgTF().setText(fileName);
            String endLine = "\r\n";
            String hyphenSeparators = "--";
            String boundary = "$$$";        // Random Text
            int bytesRead, bytesAvailable, bufferSize;
            byte[] buffer;
            int maxBufferSize = 1 * 1024 * 1024;
            File sourceFile = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(sourceFile);

            URL url = null, urlDescr = null;
            if (ciw.getUrlTF().getText().compareTo("Servlet Server") == 0) {
                url = new URL("http://localhost:8081/network2_http_s/UploadImage");
                urlDescr = new URL("http://localhost:8081/network2_http_s/UploadDescription");
            } else {
                url = new URL(ciw.getUrlTF().getText());
                urlDescr = new URL(ciw.getUrlTF().getText());
            }
            
            // Open a HTTP  connection (Send file)
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);      // Allow Inputs
            conn.setDoOutput(true);     // Allow Outputs
            conn.setUseCaches(false);   // No caching
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("ENCTYPE", "multipart/form-data");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            conn.setRequestProperty("UploadImage", fileName);

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

            dos.writeBytes(hyphenSeparators + boundary + endLine);
            dos.writeBytes("Content-Disposition: form-data; name=UploadImage;filename="
                    + fileName + "" + endLine);

            dos.writeBytes(endLine);    // Another endLine

            bytesAvailable = fileInputStream.available();

            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // Read the file and write it into the form
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                dos.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            
            // Send multipart form data necesssary after file data
            dos.writeBytes(endLine);
            dos.writeBytes(hyphenSeparators + boundary + hyphenSeparators + endLine);
            int serverResponseCode = conn.getResponseCode();
            String serverResponseMessage = conn.getResponseMessage();

            int b = -1;
            dos.close();
            if (conn.getResponseCode() == 404) {
                System.out.println("Error!");
            }

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedImage image = ImageIO.read(new File(fileName));
                ImageIcon icon = new ImageIcon(image);
                int h = icon.getIconHeight();
                int w = icon.getIconWidth();
                if (h > 220) {
                    h = 220;
                }
                if (w > 310) {
                    w = 310;
                }
                icon = new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                ciw.getIconImg().setIcon(icon);
            }
            ciw.getImageCombo().removeAllItems();
            ciw.addImageName(false);
            
            // Open a HTTP connection (Send description)
            HttpURLConnection descConnection = (HttpURLConnection) urlDescr.openConnection();
            descConnection.setDoInput(true);
            descConnection.setDoOutput(true);
            descConnection.setUseCaches(false);
            descConnection.setRequestMethod("POST");
            descConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            String imgName = new File(fileName).getName();
            DataOutputStream descDOS = new DataOutputStream(descConnection.getOutputStream());
            descDOS.writeBytes("desc=" + ciw.getDescription().getText() + "&" + "imgName=" + imgName);
            descDOS.flush();
            descDOS.close();
            
            String SS = "";
            int bb = -1;
            InputStream is = descConnection.getInputStream();
            while ((bb = is.read()) != -1) {
                if ((char) bb == '\r') {
                    SS += "\n";
                } else {
                    SS = SS + (char) b;
                }
            }
            
            ciw.getStatusTextArea().setText("Your image has been uploaded to server successfully");
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
