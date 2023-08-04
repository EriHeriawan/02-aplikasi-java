package main;


import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.AlphaComposite;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public class form2_loginadmin extends javax.swing.JFrame {

    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k =new koneksi();
    
    public form2_loginadmin() {
        initComponents();
        k.connect();
        txtuser.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtpass.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        jmasuk.putClientProperty(FlatClientProperties.STYLE, "arc:15");
         panelcta.putClientProperty(FlatClientProperties.STYLE, "arc:20");
         
         open.setVisible(false);
         txtuser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Username");         
         txtpass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Password");
         jmasuk.putClientProperty( "JButton.buttonType", "roundRect" );
         jmasuk.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS );
         place1.setVisible(false);
         place2.setVisible(false);
         hash.setVisible(false);
         }

  
    class user{
        String user, pass, foto="",nama;
        
        public user(){
            user = txtuser.getText();
            pass = txtpass.getText();
            nama = place1.getText();
        }
    }
   


    public static String getMd5(String input)
	{
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
   
    public void login(){
         String s = txtpass.getText();
         
         hash.setText(getMd5(s));
        user u = new user();
        try {
           
            this.stat = k.getCon().prepareStatement("select * from admin where "+ 
                    "Username= '"+u.user+"' and Password= '"+hash.getText()+"';");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
              u.foto = rs.getString("Foto");
              place1.setText(rs.getString("Nama_admin"));
              
            }
            if (u.user.equals("")){
               txtuser.putClientProperty(FlatClientProperties.OUTLINE,FlatClientProperties.OUTLINE_ERROR);
               return;
            }else if(u.pass.equals("")) {
              txtpass.putClientProperty(FlatClientProperties.OUTLINE,FlatClientProperties.OUTLINE_ERROR);
            }else if(u.foto.equals("")) {
               JOptionPane.showMessageDialog(null, "akun tidak ditemukan!");
            }
            else{
                place1.setVisible(false);
             String nama = place1.getText();
            form4_menuutama d= new form4_menuutama();
             d.setUsername(u.user);
             d.setFoto(u.foto);
             d.setNama(nama); 
             d.refreshFoto();
             dispose();
             d.setVisible(true);
             this.setVisible(false);
             
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jmasuk = new javax.swing.JButton();
        panelcta = new javax.swing.JPanel();
        forgot = new javax.swing.JLabel();
        open = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelregis = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        discord = new javax.swing.JLabel();
        instagram = new javax.swing.JLabel();
        whatsapp = new javax.swing.JLabel();
        hash = new javax.swing.JLabel();
        place1 = new javax.swing.JLabel();
        place2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign in");

        jPanel1.setBackground(new java.awt.Color(12, 16, 22));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 500));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtuser.setBackground(new Color(0,0,0,0));
        txtuser.setForeground(java.awt.Color.white);
        txtuser.setCaretColor(java.awt.Color.white);
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtuserKeyPressed(evt);
            }
        });
        jPanel1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 230, 30));

        txtpass.setBackground(new Color(0,0,0,0));
        txtpass.setForeground(java.awt.Color.white);
        txtpass.setCaretColor(java.awt.Color.white);
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 230, 30));

        jmasuk.setBackground(new java.awt.Color(50, 108, 254));
        jmasuk.setForeground(new java.awt.Color(255, 255, 255));
        jmasuk.setText("Masuk");
        jmasuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmasukActionPerformed(evt);
            }
        });
        jPanel1.add(jmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 230, 35));

        panelcta.setBackground(new java.awt.Color(22, 27, 34));
        panelcta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forgot.setForeground(new java.awt.Color(0, 153, 255));
        forgot.setText("lupa password?");
        forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotMouseExited(evt);
            }
        });
        panelcta.add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-eye-20.png"))); // NOI18N
        open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMouseClicked(evt);
            }
        });
        panelcta.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 95, -1, -1));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-closed-eye-20.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        panelcta.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 95, -1, -1));

        jPanel1.add(panelcta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 320, 210));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-30 (1).png"))); // NOI18N
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pemda_100px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 100, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Sign in to Aplikasi-PBB");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 200, -1));

        labelregis.setForeground(new java.awt.Color(0, 153, 255));
        labelregis.setText("Register");
        labelregis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelregis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelregisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelregisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelregisMouseExited(evt);
            }
        });
        jPanel1.add(labelregis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Belum punya akun?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-help-20.1.png"))); // NOI18N
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
        });
        jPanel1.add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, -1));

        discord.setForeground(new java.awt.Color(0, 153, 255));
        discord.setText("Discord .");
        discord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discordMouseClicked(evt);
            }
        });
        jPanel1.add(discord, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, -1, -1));

        instagram.setForeground(new java.awt.Color(0, 153, 255));
        instagram.setText("Instagram .");
        instagram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instagramMouseClicked(evt);
            }
        });
        jPanel1.add(instagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        whatsapp.setForeground(new java.awt.Color(0, 153, 255));
        whatsapp.setText("Whatsapp .");
        whatsapp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                whatsappMouseClicked(evt);
            }
        });
        jPanel1.add(whatsapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        hash.setText("hash code");
        jPanel1.add(hash, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        place1.setText("place1");
        jPanel1.add(place1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        place2.setText("place2");
        jPanel1.add(place2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmasukActionPerformed
        login();
    }//GEN-LAST:event_jmasukActionPerformed

    private void forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotMouseClicked

    private void forgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseEntered
        // TODO add your handling code here:
        Font font = forgot.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        forgot.setFont(font.deriveFont(attribut));
    }//GEN-LAST:event_forgotMouseEntered

    private void forgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseExited
        // TODO add your handling code here:
        Font font = forgot.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.TRANSFORM);
        forgot.setFont(font.deriveFont(attribut));
    }//GEN-LAST:event_forgotMouseExited

    private void openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseClicked
        // TODO add your handling code here:
        txtpass.setEchoChar('•');
        open.setVisible(false);
        close.setVisible(true);

    }//GEN-LAST:event_openMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        txtpass.setEchoChar((char)0);
        open.setVisible(true);
        close.setVisible(false);
    }//GEN-LAST:event_closeMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        form1_home lg = new form1_home();
        lg.setVisible(true);
        lg.timer.stop();

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void labelregisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelregisMouseClicked
        form6_register reg = new form6_register();
//        reg.idadmin();
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_labelregisMouseClicked

    private void labelregisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelregisMouseEntered
        // TODO add your handling code here:
        Font font = labelregis.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labelregis.setFont(font.deriveFont(attribut));
    }//GEN-LAST:event_labelregisMouseEntered

    private void labelregisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelregisMouseExited
        // TODO add your handling code here:
        Font font = labelregis.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.TRANSFORM);
        labelregis.setFont(font.deriveFont(attribut));
    }//GEN-LAST:event_labelregisMouseExited

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_helpMouseClicked

    private void discordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discordMouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://discord.gg/VmscpSKCbJ").toURI());
        } catch (Exception e) {}
    }//GEN-LAST:event_discordMouseClicked

    private void instagramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instagramMouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://instagram.com/@elheriawan31").toURI());
        } catch (Exception e) {}
    }//GEN-LAST:event_instagramMouseClicked

    private void whatsappMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whatsappMouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://wa.me/+6285695665452").toURI());
        } catch (Exception e) {}
    }//GEN-LAST:event_whatsappMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        txtpass.isRequestFocusEnabled();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                login();
            }
    }//GEN-LAST:event_txtpassKeyPressed

    private void txtuserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                login();
            }
    }//GEN-LAST:event_txtuserKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new form2_loginadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel close;
    private javax.swing.JLabel discord;
    private javax.swing.JLabel forgot;
    private javax.swing.JLabel hash;
    private javax.swing.JLabel help;
    private javax.swing.JLabel instagram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jmasuk;
    private javax.swing.JLabel labelregis;
    private javax.swing.JLabel open;
    private javax.swing.JPanel panelcta;
    private javax.swing.JLabel place1;
    private javax.swing.JLabel place2;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    private javax.swing.JLabel whatsapp;
    // End of variables declaration//GEN-END:variables
}
