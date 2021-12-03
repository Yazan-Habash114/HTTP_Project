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
            URL myUrl = new URL(url);
            InputStream is;

            HttpURLConnection httpUrlConnection = (HttpURLConnection) myUrl.openConnection();
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setRequestProperty("Content-Type", CONTENT_STR);
            httpUrlConnection.setUseCaches(false);
            String dataStr = URLEncoder.encode("DownloadImage", "UTF-8") + "=" + selectedImage;
            try (BufferedOutputStream out = new BufferedOutputStream(httpUrlConnection.getOutputStream())) {
                out.write(dataStr.getBytes());
            }

            if (httpUrlConnection.getResponseCode() == 404) {
                System.out.println("error!");
            }

            byte tmp[] = new byte[1024];
            is = httpUrlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int n = 0;
            FileOutputStream myWriter = new FileOutputStream("C:/Users/HP/" + selectedImage);
            if (httpUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()))) {
                    while ((n = is.read(tmp)) != -1) {
                        baos.write(tmp, 0, n);
                    }

                    byte[] r = baos.toByteArray();
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

            HttpURLConnection httpUrlConn = (HttpURLConnection) u.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestProperty("Content-Type", CONTENT_STR);
            httpUrlConn.setUseCaches(false);
            String dataStr = URLEncoder.encode("DownloadImage", "UTF-8") + "=" + selectedImage;
            try (BufferedOutputStream out = new BufferedOutputStream(httpUrlConn.getOutputStream())) {
                out.write(dataStr.getBytes());
            }

            if (httpUrlConn.getResponseCode() == 404) {
                System.out.println("Error!");
            }

            int b = -1;
            File file = new File("C:/Users/HP/" + selectedImage);
            FileOutputStream myWriter = new FileOutputStream(file);
            if (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()))) {
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
            File chosenFile = choose.getSelectedFile();
            String fileName = chosenFile.getAbsolutePath();
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
                url = new URL("http://localhost:8081/ServerSide/UploadImage");
                urlDescr = new URL("http://localhost:8081/ServerSide/UploadDescription");
            } else {
                url = new URL(ciw.getUrlTF().getText());
                urlDescr = new URL(ciw.getUrlTF().getText());
            }
            
            // Open a HTTP  connection (Send file)
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoInput(true);      // Allow Inputs
            httpConn.setDoOutput(true);     // Allow Outputs
            httpConn.setUseCaches(false);   // No caching
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("ENCTYPE", "multipart/form-data");
            httpConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            httpConn.setRequestProperty("UploadImage", fileName);

            DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());

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
            int serverResponseCode = httpConn.getResponseCode();
            String serverResponseMessage = httpConn.getResponseMessage();

            int b = -1;
            dos.close();
            if (httpConn.getResponseCode() == 404) {
                System.out.println("Error!");
            }

            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedImage image = ImageIO.read(new File(fileName));
                ImageIcon icon = new ImageIcon(image);
                int h = icon.getIconHeight();
                int w = icon.getIconWidth();
                if (h > 200) {
                    h = 200;
                }
                if (w > 300) {
                    w = 300;
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
            
            String catString = "";
            int readVar = -1;
            InputStream is = descConnection.getInputStream();
            while ((readVar = is.read()) != -1) {
                if ((char) readVar == '\r') {
                    catString += "\n";
                } else {
                    catString = catString + (char) b;
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
