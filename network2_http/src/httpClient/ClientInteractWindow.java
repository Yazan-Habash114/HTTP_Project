package httpClient;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Yazan Habash
 */
public class ClientInteractWindow extends javax.swing.JFrame {

    // Attributes
    public String dataStr;
    String[] strURLs = {
        "http://localhost:8080/my-site2/index.php", "Servlet"
    };
    
    
    // Methods
    private void addURLsToCombo() {
        this.urlCombo.removeAllItems();
        for (int i = 0; i < strURLs.length; ++i) {
            this.urlCombo.addItem(strURLs[i]);
        }
        this.urlCombo.setSelectedIndex(0);
    }

    public ClientInteractWindow() {
        initComponents();
        addURLsToCombo();
        imageCombo.removeAllItems();
        addImageName();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        urlCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        urlTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imageCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        imgTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        uploadImg = new javax.swing.JButton();
        downloadImg1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Window");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        urlCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        urlCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(urlCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 350, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Choose URL:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        urlTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(urlTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 350, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Choosen URL:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Select Images:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        imageCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(imageCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 350, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Selected Image:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        imgTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(imgTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 350, 30));

        statusTextArea.setColumns(20);
        statusTextArea.setRows(5);
        jScrollPane1.setViewportView(statusTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 506, 270, 50));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 310, 220));

        btnSelect.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        btnSelect.setText("Select URL");
        btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 120, 30));

        jLabel2.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HTTP Client Window");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 760, 30));

        uploadImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        uploadImg.setText("Upload");
        uploadImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImgActionPerformed(evt);
            }
        });
        getContentPane().add(uploadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 120, 30));

        downloadImg1.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        downloadImg1.setText("Download");
        downloadImg1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downloadImg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadImg1ActionPerformed(evt);
            }
        });
        getContentPane().add(downloadImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String contentStr = "application/x-www-form-urlencoded";

    private void addImageName() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/http_project", "root", "");
            Statement stmt = connection.createStatement();
            String query = "SELECT name FROM image";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                imageCombo.addItem(rs.getString("name"));
            }
            connection.close();     // Close connection with database
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientInteractWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientInteractWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        String str = (String) this.urlCombo.getSelectedItem();
        this.urlTF.setText(str);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void downloadImagePHP(String url) {
        String selectedImage = imageCombo.getSelectedItem().toString();
        new DownloadUploadImage(selectedImage).downloadPHP(url);
        putImage(selectedImage, true);
    }
    
    private void putImage(String selectedImage, boolean src) {
        try {
            //System.out.print(SS);
            File file = new File("C:/Users/HP/" + selectedImage);
            BufferedImage image = ImageIO.read(file);
            if(src)   // PHP
                ImageIO.write((BufferedImage) image, "jpg", file);
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
            jLabel6.setIcon(icon);
            Desktop.getDesktop().open(new java.io.File("C:/Users/HP/" + selectedImage));
        } catch (IOException ex) {
            Logger.getLogger(ClientInteractWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void downloadImageServlet(String url) {
        String selectedImage = imageCombo.getSelectedItem().toString();
        new DownloadUploadImage(selectedImage).downloadServlet(url);
        putImage(selectedImage, false);
    }

    private void uploadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImgActionPerformed
        try {
            OutputStream os;
            InputStream is;
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            String filename = f.getAbsolutePath();
            imgTF.setText(filename);
            HttpURLConnection conn = null;
            DataOutputStream dos = null;
            String lineEnd = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";
            int bytesRead, bytesAvailable, bufferSize;
            byte[] buffer;
            int maxBufferSize = 1 * 1024 * 1024;
            File sourceFile = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(sourceFile);

            URL url = null;
            if (urlTF.getText().compareTo("Servlet") == 0) {
                url = new URL("http://localhost:8081/network2_http_s/upload_image");
            } else {
                url = new URL(urlTF.getText());
            }

            // Open a HTTP  connection to  the URL
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true); // Allow Inputs
            conn.setDoOutput(true); // Allow Outputs
            conn.setUseCaches(false); // Don't use a Cached Copy
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("ENCTYPE", "multipart/form-data");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            conn.setRequestProperty("uploaded_image", filename);

            dos = new DataOutputStream(conn.getOutputStream());

            dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=uploaded_image;filename="
                    + filename + "" + lineEnd);

            dos.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();

            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // read file and write it into form...
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                dos.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            int serverResponseCode = 0;
            // Send multipart form data necesssary after file data...
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
            serverResponseCode = conn.getResponseCode();
            String serverResponseMessage = conn.getResponseMessage();

            int b = -1;
            dos.close();
            String SS = "";
            if (conn.getResponseCode() == 404) {
                System.out.println("error!");
            }

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    while ((b = bufferedReader.read()) != -1) {
                        SS = SS + (char) b;
                    }
                }
                BufferedImage image = ImageIO.read(new File(filename));
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
                jLabel6.setIcon(icon);
            }
            statusTextArea.setText(SS);
            imageCombo.removeAllItems();
            addImageName();

            //  Desktop.getDesktop().open(new java.io.File("text_file/rahaf.txt"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientInteractWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ClientInteractWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientInteractWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uploadImgActionPerformed

    private void downloadImg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadImg1ActionPerformed
        String url = "";
        if (urlTF.getText().compareTo("Servlet") == 0) {
            url = "http://localhost:8081/network2_http_s/download_image";
            downloadImageServlet(url);
        } else {
            url = urlTF.getText();
            downloadImagePHP(url);
        }
    }//GEN-LAST:event_downloadImg1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton downloadImg1;
    private javax.swing.JComboBox<String> imageCombo;
    private javax.swing.JTextField imgTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea statusTextArea;
    private javax.swing.JButton uploadImg;
    private javax.swing.JComboBox<String> urlCombo;
    private javax.swing.JTextField urlTF;
    // End of variables declaration//GEN-END:variables
}
