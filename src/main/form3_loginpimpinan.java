package main;



import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class form3_loginpimpinan extends javax.swing.JFrame {

     private PreparedStatement stat;
    private ResultSet rs;
    private Statement st;
    koneksi k = new koneksi();
   
    public form3_loginpimpinan() {
        initComponents();
        k.connect();
        txtuser.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtpass.putClientProperty(FlatClientProperties.STYLE, "arc:10");
//        jmasuk.putClientProperty(FlatClientProperties.STYLE, "arc:100");
         panelcta.putClientProperty(FlatClientProperties.STYLE, "arc:20");
         open.setVisible(false);
         txtpass.setEchoChar('•');
         String pass = txtpass.getText();
         ingatpassword();
         place1.setVisible(false);
         jmasuk.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
         txtuser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Username");
         txtpass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Password");
    }

    private void ingatpassword(){
        try {
           this.stat = k.getCon().prepareStatement("SELECT * FROM pimpinan ORDER BY ingat ");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                 txtpass.setText(rs.getString("ingat"));
                
                if (txtpass.getText().equals("")) {
                    cek_ingat.setSelected(false);
                } else {
                    cek_ingat.setSelected(true);
                }
            }
        }catch (Exception e) {
            System.out.println("password tidak diingat");
            
        }
    }
    
    private void login() {
       String s = txtpass.getText();
        hash.setText(getMd5(s));
        user u = new user();
        
        try {
            this.stat = k.getCon().prepareStatement("select * from pimpinan where "
                + "username= '"+u.user+"' and password= '"+u.pass+"';");
            this.rs = this.stat.executeQuery();
            if (rs.next()) {
                 place1.setText(rs.getString("jabatan"));
                String jabatan =place1.getText();
                
                form5_menupimpinan d = new form5_menupimpinan();
                d.setUsername(u.user);
                d.setJabatan(jabatan);
                d.setVisible(true);
                this.setVisible(false);
                this.dispose();

            }else{
                JOptionPane.showMessageDialog(null, "akun tdidak ditemukan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
class user{
        String user, pass, foto="";
        public user(){
            user = txtuser.getText();
            pass = hash.getText();
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
				hashtext = "•" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jmasuk = new javax.swing.JButton();
        place1 = new javax.swing.JTextField();
        place2 = new javax.swing.JTextField();
        panelcta = new javax.swing.JPanel();
        forgot = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        open = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        hash = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cek_ingat = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign in");

        jPanel1.setBackground(new java.awt.Color(12, 16, 22));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 450));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtuser.setBackground(new Color(0,0,0,0));
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setCaretColor(new java.awt.Color(255, 255, 255));
        txtuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtuserFocusLost(evt);
            }
        });
        txtuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtuserMouseClicked(evt);
            }
        });
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtuserKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuserKeyTyped(evt);
            }
        });
        jPanel1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 230, 30));

        txtpass.setBackground(new Color(0,0,0,0));
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setCaretColor(new java.awt.Color(255, 255, 255));
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpassFocusLost(evt);
            }
        });
        txtpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpassMouseClicked(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpassKeyReleased(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 230, 30));

        jmasuk.setBackground(new java.awt.Color(50, 108, 254));
        jmasuk.setForeground(new java.awt.Color(255, 255, 255));
        jmasuk.setText(org.openide.util.NbBundle.getMessage(form3_loginpimpinan.class, "loginpimpinan.jmasuk.text_1_1")); // NOI18N
        jmasuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmasukActionPerformed(evt);
            }
        });
        jPanel1.add(jmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 230, 35));

        place1.setEditable(false);
        place1.setBackground(new Color(0,0,0,0));
        place1.setForeground(new java.awt.Color(153, 153, 153));
        place1.setText(org.openide.util.NbBundle.getMessage(form3_loginpimpinan.class, "loginpimpinan.place1.text_1")); // NOI18N
        place1.setBorder(null);
        place1.setCaretColor(new java.awt.Color(255, 255, 255));
        place1.setEnabled(false);
        place1.setOpaque(false);
        jPanel1.add(place1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 230, 30));

        place2.setEditable(false);
        place2.setBackground(new Color(0,0,0,0));
        place2.setForeground(new java.awt.Color(153, 153, 153));
        place2.setText(org.openide.util.NbBundle.getMessage(form3_loginpimpinan.class, "loginpimpinan.place2.text_1")); // NOI18N
        place2.setBorder(null);
        place2.setCaretColor(new java.awt.Color(255, 255, 255));
        place2.setEnabled(false);
        place2.setOpaque(false);
        jPanel1.add(place2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 230, 30));

        panelcta.setBackground(new java.awt.Color(22, 27, 34));
        panelcta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forgot.setForeground(new java.awt.Color(0, 153, 255));
        forgot.setText(org.openide.util.NbBundle.getMessage(form3_loginpimpinan.class, "loginpimpinan.forgot.text_1_1")); // NOI18N
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

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-closed-eye-20.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        panelcta.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 95, -1, -1));

        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-eye-20.png"))); // NOI18N
        open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMouseClicked(evt);
            }
        });
        panelcta.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 95, -1, -1));

        jPanel1.add(panelcta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 320, 210));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-30 (1).png"))); // NOI18N
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        hash.setEditable(false);
        hash.setBackground(new Color(0,0,0,0));
        hash.setForeground(new Color(0,0,0,0));
        hash.setBorder(null);
        hash.setCaretColor(new java.awt.Color(255, 255, 255));
        hash.setOpaque(false);
        jPanel1.add(hash, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 230, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pemda_100px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 100, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(org.openide.util.NbBundle.getMessage(form3_loginpimpinan.class, "loginpimpinan.jLabel3.text_1_1")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 200, -1));

        cek_ingat.setBackground(new Color(0,0,0,0));
        cek_ingat.setText("Ingat akun?");
        cek_ingat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_ingatActionPerformed(evt);
            }
        });
        jPanel1.add(cek_ingat, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 390, 220, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 210, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtuserFocusLost
        
    }//GEN-LAST:event_txtuserFocusLost

    private void txtuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtuserMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtuserMouseClicked

    private void txtuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtuserKeyTyped

    private void txtpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtpassFocusLost

    private void txtpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtpassMouseClicked

    private void txtpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyReleased
        
    }//GEN-LAST:event_txtpassKeyReleased

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        txtpass.setEchoChar((char)0);
        open.setVisible(true);
        close.setVisible(false);
    }//GEN-LAST:event_closeMouseClicked

    private void openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMouseClicked
        // TODO add your handling code here:
        txtpass.setEchoChar('•');
        open.setVisible(false);
        close.setVisible(true);
    }//GEN-LAST:event_openMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        form1_home lg= new form1_home();
        lg.setVisible(true);
                lg.timer.stop();

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        txtpass.isRequestFocusEnabled();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void forgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseExited
        // TODO add your handling code here:
        Font font = forgot.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.TRANSFORM);
        forgot.setFont(font.deriveFont(attribut));
    }//GEN-LAST:event_forgotMouseExited

    private void forgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseEntered
        // TODO add your handling code here:
        Font font = forgot.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        forgot.setFont(font.deriveFont(attribut));
    }//GEN-LAST:event_forgotMouseEntered

    private void forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotMouseClicked

    private void jmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmasukActionPerformed
        login();
   
        
    }//GEN-LAST:event_jmasukActionPerformed

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

    private void cek_ingatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_ingatActionPerformed
        String ingat = txtpass.getText();
        if (cek_ingat.isSelected()) {
             jLabel1.setText(ingat);
            try{
                      st=k.con.createStatement();
                  String sql = "update pimpinan set ingat= '"+jLabel1.getText()+"'"
                          +"where username= '"+txtuser.getText()+"'";               
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "ingat password");
                cek_ingat.setSelected(true);
            } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "ingat eror");
            }
        }else{
            jLabel1.setText("");
            try{
                      st=k.con.createStatement();
                  String sql = "update pimpinan set ingat= '"+jLabel1.getText()+"'"
                          +"where username= '"+txtuser.getText()+"'";               
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "tidak diingat password");
                cek_ingat.setSelected(false);
            } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "eror ingat eror");
            }
            
             }
        
    }//GEN-LAST:event_cek_ingatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form3_loginpimpinan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JCheckBox cek_ingat;
    private javax.swing.JLabel close;
    private javax.swing.JLabel forgot;
    private javax.swing.JTextField hash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jmasuk;
    private javax.swing.JLabel open;
    private javax.swing.JPanel panelcta;
    private javax.swing.JTextField place1;
    private javax.swing.JTextField place2;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
