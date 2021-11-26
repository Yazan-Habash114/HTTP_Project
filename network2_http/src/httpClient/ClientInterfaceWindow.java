package httpClient;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Yazan Habash
 */
public class ClientInterfaceWindow extends javax.swing.JFrame {

    // Attributes
    private ImageWindow iw;
    String[] strURLs = {
        "http://localhost:8080/phpServer/index.php", "Servlet Server"
    };

    // Methods
    private void addURLsToCombo() {
        this.urlCombo.removeAllItems();
        for (int i = 0; i < strURLs.length; ++i) {
            this.urlCombo.addItem(strURLs[i]);
        }
        this.urlCombo.setSelectedIndex(0);
    }

    public ClientInterfaceWindow() throws IOException {
        initComponents();
        addURLsToCombo();
        imageCombo.removeAllItems();
        iw = new ImageWindow();
        addImageName(true);
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
        iconImage = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        uploadImg = new javax.swing.JButton();
        downloadImg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        updateImg = new javax.swing.JButton();
        deleteImg = new javax.swing.JButton();
        showWindow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Window");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        urlCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        urlCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(urlCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 390, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Choose URL:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        urlTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(urlTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 390, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Choosen URL:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Select Images:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        imageCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(imageCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 390, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Status:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 100, 30));

        imgTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imgTF.setToolTipText("Your selected image");
        getContentPane().add(imgTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 390, 30));
        getContentPane().add(iconImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 260, 190));

        btnSelect.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        btnSelect.setText("Select URL");
        btnSelect.setToolTipText("Select an URL to deal with");
        btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 30));

        jLabel2.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HTTP Client Window");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 760, 30));

        uploadImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        uploadImg.setText("Upload");
        uploadImg.setToolTipText("Upload an image to server");
        uploadImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImgActionPerformed(evt);
            }
        });
        getContentPane().add(uploadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 90, 30));

        downloadImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        downloadImg.setText("Download");
        downloadImg.setToolTipText("Download an image from server");
        downloadImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downloadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadImgActionPerformed(evt);
            }
        });
        getContentPane().add(downloadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 100, 30));

        jScrollPane2.setEnabled(false);

        statusTextArea.setEditable(false);
        statusTextArea.setColumns(20);
        statusTextArea.setRows(5);
        statusTextArea.setToolTipText("Status of an operation");
        jScrollPane2.setViewportView(statusTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 390, 90));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Selected Image:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 30));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane3.setViewportView(description);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 390, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Description:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        updateImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        updateImg.setText("Update");
        updateImg.setToolTipText("Update the description of an image");
        updateImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImgActionPerformed(evt);
            }
        });
        getContentPane().add(updateImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 90, 30));

        deleteImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        deleteImg.setText("Delete");
        deleteImg.setToolTipText("Delete an image from server");
        deleteImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImgActionPerformed(evt);
            }
        });
        getContentPane().add(deleteImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, 30));

        showWindow.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        showWindow.setText("Show all images window");
        showWindow.setToolTipText("Show images window");
        showWindow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showWindowActionPerformed(evt);
            }
        });
        getContentPane().add(showWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 220, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String contentStr = "application/x-www-form-urlencoded";
    
    public void addImageName(boolean fromShowWindowBtn) throws IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/http_project", "root", "");
            Statement stmt = connection.createStatement();
            String query = "SELECT name, description FROM images";
            ResultSet rs = stmt.executeQuery(query);
            iw.clearWindow();   // Clear images window
            while (rs.next()) {
                getImageCombo().addItem(rs.getString("name"));
                iw.addImg(rs.getString("name"), rs.getString("description"));
            }
            connection.close();     // Close connection with database
            if(fromShowWindowBtn)
                iw.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        String str = (String) this.urlCombo.getSelectedItem();
        this.getUrlTF().setText(str);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void downloadImagePHP(String url) {
        String selectedImage = getImageCombo().getSelectedItem().toString();
        new DownloadUploadImage(this, selectedImage).downloadPHP(url);
        putImage(selectedImage, true);
    }

    private void putImage(String selectedImage, boolean src) {
        try {
            File file = new File("C:/Users/HP/" + selectedImage);
            BufferedImage image = ImageIO.read(file);
            if (src) {   // PHP
                ImageIO.write((BufferedImage) image, "jpg", file);
            }
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
            iconImage.setIcon(icon);
            //Desktop.getDesktop().open(new java.io.File("C:/Users/HP/" + selectedImage));
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void downloadImageServlet(String url) {
        String selectedImage = getImageCombo().getSelectedItem().toString();
        new DownloadUploadImage(this, selectedImage).downloadServlet(url);
        putImage(selectedImage, false);
    }

    private void uploadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImgActionPerformed
        if (getImageCombo().getItemCount() + 1 <= 12 && getDescription().getText().length() <= 500) {
            new DownloadUploadImage(this).uploadImage();
            this.description.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Max number of images has beed exceeded "
                    + "or description has more than 500 characters",
                    "Cannot upload image due to this error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_uploadImgActionPerformed

    private void downloadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadImgActionPerformed
        String url = "";
        if (getUrlTF().getText().compareTo("Servlet Server") == 0) {
            url = "http://localhost:8081/network2_http_s/DownloadImage";
            downloadImageServlet(url);
        } else {
            url = getUrlTF().getText();
            downloadImagePHP(url);
        }
    }//GEN-LAST:event_downloadImgActionPerformed

    private void updateImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateImgActionPerformed
        try {
            // Open a HTTP connection (Update image's description)
            URL urlDescr;
            if (urlTF.getText().compareTo("Servlet Server") == 0) {
                urlDescr = new URL("http://localhost:8081/network2_http_s/UploadDescription");
            } else {
                urlDescr = new URL(urlTF.getText());
            }
            HttpURLConnection descConnection = (HttpURLConnection) urlDescr.openConnection();
            descConnection.setDoInput(true);
            descConnection.setDoOutput(true);
            descConnection.setUseCaches(false);
            descConnection.setRequestMethod("POST");
            descConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            DataOutputStream descDOS = new DataOutputStream(descConnection.getOutputStream());
            descDOS.writeBytes("desc=" + this.description.getText() + "&" + "imgName=" + (String) this.imageCombo.getSelectedItem());
            descDOS.flush();
            descDOS.close();
            
            String responseMessage = "";
            int bb = -1;
            InputStream is = descConnection.getInputStream();
            while ((bb = is.read()) != -1) {
                if ((char) bb == '\r') {
                    responseMessage += "\n";
                } else {
                    responseMessage = responseMessage + (char) bb;
                }
            }
            
            statusTextArea.setText("The description of this image has been updated sucessfully :)");
        } catch (ProtocolException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateImgActionPerformed

    private void deleteImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImgActionPerformed
        try {
            // Open a HTTP connection (Delete an image)
            URL urlDescr;
            if (urlTF.getText().compareTo("Servlet Server") == 0) {
                urlDescr = new URL("http://localhost:8081/network2_http_s/DeleteImage");
            } else {
                urlDescr = new URL(urlTF.getText());
            }
            HttpURLConnection descConnection = (HttpURLConnection) urlDescr.openConnection();
            descConnection.setDoInput(true);
            descConnection.setDoOutput(true);
            descConnection.setUseCaches(false);
            descConnection.setRequestMethod("POST");
            descConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            DataOutputStream descDOS = new DataOutputStream(descConnection.getOutputStream());
            descDOS.writeBytes("imageName=" + (String) this.imageCombo.getSelectedItem());
            descDOS.flush();
            descDOS.close();
            
            String responseMessage = "";
            int bb = -1;
            InputStream is = descConnection.getInputStream();
            while ((bb = is.read()) != -1) {
                if ((char) bb == '\r') {
                    responseMessage += "\n";
                } else {
                    responseMessage = responseMessage + (char) bb;
                }
            }
            
            // Delete the image file from hard disk (Server side)
            File image = new File("C:/Users/Hp/images/" + (String) imageCombo.getSelectedItem());
            image.delete();
            
            iconImage.setIcon(null);
            imgTF.setText("");
            description.setText("");
            imageCombo.removeAllItems();
            try {
                addImageName(false);
            } catch (IOException ex) {
                Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            statusTextArea.setText("The selected image has been delete successfully :)");
        } catch (ProtocolException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteImgActionPerformed

    private void showWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showWindowActionPerformed
        imageCombo.removeAllItems();
        try {
            addImageName(true);
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showWindowActionPerformed

    public static void main(String [] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {     // Lambda Expression
            try {
                new ClientInterfaceWindow().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ClientInterfaceWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton deleteImg;
    private javax.swing.JTextArea description;
    private javax.swing.JButton downloadImg;
    private javax.swing.JLabel iconImage;
    private javax.swing.JComboBox<String> imageCombo;
    private javax.swing.JTextField imgTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton showWindow;
    private javax.swing.JTextArea statusTextArea;
    private javax.swing.JButton updateImg;
    private javax.swing.JButton uploadImg;
    private javax.swing.JComboBox<String> urlCombo;
    private javax.swing.JTextField urlTF;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextArea getStatusTextArea() {
        return statusTextArea;
    }

    public javax.swing.JLabel getIconImg() {
        return iconImage;
    }

    public javax.swing.JComboBox<String> getImageCombo() {
        return imageCombo;
    }

    public javax.swing.JTextField getImgTF() {
        return imgTF;
    }

    public javax.swing.JTextField getUrlTF() {
        return urlTF;
    }

    public javax.swing.JTextArea getDescription() {
        return description;
    }
}
