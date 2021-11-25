package httpClient;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    public String dataStr;
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

    public ClientInterfaceWindow() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Window");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        urlCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        urlCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(urlCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 370, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Choose URL:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        urlTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(urlTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 370, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Choosen URL:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Select Images:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        imageCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(imageCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 370, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Status:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 100, 30));

        imgTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(imgTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 370, 30));
        getContentPane().add(iconImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 280, 190));

        btnSelect.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        btnSelect.setText("Select URL");
        btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 120, 30));

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
        getContentPane().add(uploadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, 30));

        downloadImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        downloadImg.setText("Download");
        downloadImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downloadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadImgActionPerformed(evt);
            }
        });
        getContentPane().add(downloadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 100, 30));

        statusTextArea.setColumns(20);
        statusTextArea.setRows(5);
        jScrollPane2.setViewportView(statusTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 370, 90));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Selected Image:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 30));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane3.setViewportView(description);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 370, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Description:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        updateImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        updateImg.setText("Update");
        updateImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImgActionPerformed(evt);
            }
        });
        getContentPane().add(updateImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 80, 30));

        deleteImg.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        deleteImg.setText("Delete");
        deleteImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImgActionPerformed(evt);
            }
        });
        getContentPane().add(deleteImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String contentStr = "application/x-www-form-urlencoded";

    public void addImageName() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/http_project", "root", "");
            Statement stmt = connection.createStatement();
            String query = "SELECT name FROM images";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                getImageCombo().addItem(rs.getString("name"));
            }
            connection.close();     // Close connection with database
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
            //System.out.print(SS);
            File file = new File("C:/Users/HP/" + selectedImage);
            BufferedImage image = ImageIO.read(file);
            if (src) // PHP
            {
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
            Desktop.getDesktop().open(new java.io.File("C:/Users/HP/" + selectedImage));
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
        if (getImageCombo().getItemCount() + 1 <= 12 && description.getText().length() <= 500) {
            new DownloadUploadImage(this).uploadImage();
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

    }//GEN-LAST:event_updateImgActionPerformed

    private void deleteImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImgActionPerformed

    }//GEN-LAST:event_deleteImgActionPerformed


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
}
