
package main;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Administrator
 */
public class panel9_menulog extends javax.swing.JPanel {

    private PreparedStatement stat;
    private ResultSet rs;
    private ResultSet rs1;
    koneksi k = new koneksi();
    private Statement st;
    public panel9_menulog() {
        initComponents();
        k.connect();
        jPanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        txtuser1.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtpass1.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtpass2.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtpass3.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        submit.putClientProperty(FlatClientProperties.STYLE, "arc:100");
        submit.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JPasswordField getTxtpass2() {
        return txtpass2;
    }

    public JPasswordField getTxtpass3() {
        return txtpass3;
    }

    public JButton getSubmit() {
        return submit;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getLabelganti() {
        return labelganti;
    }

   
       
    private void subbmit() {                                          

        if (submit.getText().equals("Submit")) {
            String user = txtuser1.getText();
            String pass1 = txtpass1.getText();
            String pass2 = txtpass2.getText();
            String pass3 = txtpass3.getText();
            String u = null,p = null;
            String a =getMd5(pass1);
            String b =getMd5(pass2); 
            if(txtuser1.getText().equals("")||txtpass1.getText().equals("")
                ||txtpass2.getText().equals("")||txtpass3.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Silahkan isi dahulu");
            }
            else if (pass2 == null ? pass3 != null : !pass2.equals(pass3)) {
                 JOptionPane.showMessageDialog(null, "Password baru tidak sama");
                }else{
                        try {
                                //update password
                            st = k.con.createStatement();
                            String sql = "UPDATE admin SET id_admin='"+jLabel5.getText()+"',"
                                    +"Nama_admin='"+jLabel6.getText()+"',"
                                    +"Username = '"+user+"',"
                                    +"password = '"+b+"',"
                                    +"Foto='"+jLabel7.getText()+"'"
                                    +"where id_admin='"+jLabel5.getText()+"'";
                            st.execute(sql);
                            JOptionPane.showMessageDialog(null, "terubah ");
                        }
                        catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,e.getMessage());
                        }
            }  
        } else if(submit.getText().equals("Hapus")){
                if(txtuser1.getText().equals("")||txtpass1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "silahkan pilih akun yang akan dihapus");
            
                } else {
                    int jawab = JOptionPane.showConfirmDialog(null, "data ini akan dihapus, lanjutkan?","konfirmasi",JOptionPane.YES_NO_OPTION);
                    if (jawab == 0) {
                        try {
                            st = k.con.createStatement();
                            String sql = "DELETE FROM admin WHERE Username = '"+txtuser1.getText()+"'";
                            st.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }

                    }
                }
        }
    }  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new custom.PanelShadow();
        jPanel4 = new javax.swing.JPanel();
        labelganti = new javax.swing.JLabel();
        panelShadow2 = new custom.PanelShadow();
        submit = new javax.swing.JButton();
        lihat = new javax.swing.JRadioButton();
        txtpass3 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtpass2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtpass1 = new javax.swing.JPasswordField();
        txtuser1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(74, 145, 132));
        jPanel4.setPreferredSize(new java.awt.Dimension(164, 55));

        labelganti.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelganti.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(labelganti, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.labelganti.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelganti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelganti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        panelShadow2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submit.setBackground(new java.awt.Color(74, 145, 132));
        submit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(submit, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.submit.text")); // NOI18N
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        panelShadow2.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 260, 40));

        org.openide.awt.Mnemonics.setLocalizedText(lihat, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.lihat.text")); // NOI18N
        lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatActionPerformed(evt);
            }
        });
        panelShadow2.add(lihat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        txtpass3.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtpass3.setText(org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.txtpass3.text")); // NOI18N
        txtpass3.setPreferredSize(new java.awt.Dimension(10, 30));
        txtpass3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass3KeyTyped(evt);
            }
        });
        panelShadow2.add(txtpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 380, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel3.text")); // NOI18N
        panelShadow2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        txtpass2.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtpass2.setText(org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.txtpass2.text")); // NOI18N
        txtpass2.setPreferredSize(new java.awt.Dimension(10, 30));
        txtpass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass2KeyTyped(evt);
            }
        });
        panelShadow2.add(txtpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 380, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel2.text")); // NOI18N
        panelShadow2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel1.text")); // NOI18N
        panelShadow2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        txtpass1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtpass1.setText(org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.txtpass1.text")); // NOI18N
        txtpass1.setPreferredSize(new java.awt.Dimension(10, 30));
        txtpass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass1KeyTyped(evt);
            }
        });
        panelShadow2.add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 380, -1));

        txtuser1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtuser1.setText(org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.txtuser1.text")); // NOI18N
        txtuser1.setPreferredSize(new java.awt.Dimension(10, 30));
        panelShadow2.add(txtuser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 380, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel4.text")); // NOI18N
        panelShadow2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel7.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(panel9_menulog.class, "panel9_menulog.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtpass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass1KeyTyped
     String user = txtuser1.getText();
        String pass1 = txtpass1.getText();
        String pass2 = txtpass2.getText();
        String pass3 = txtpass3.getText();
        String u = null,p = null;
        String a =getMd5(pass1);
        String b =getMd5(pass2);     
        try {
            st=k.con.createStatement();
            String sql= "select * from admin where "+"Username= '"+user+"' and Password= '"+a+"';";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
              user = rs.getString("Username");
              a = rs.getString("Password");              
              System.out.println(user);
              
              jLabel5.setText(rs.getString("id_admin"));
              jLabel6.setText(rs.getString("Nama_admin"));
              jLabel7.setText(rs.getString("Foto"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txtpass1KeyTyped

    private void txtpass3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass3KeyTyped
        
    }//GEN-LAST:event_txtpass3KeyTyped

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        subbmit();
    }//GEN-LAST:event_submitActionPerformed

    private void txtpass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass2KeyTyped
       
    }//GEN-LAST:event_txtpass2KeyTyped

    private void lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatActionPerformed
        if(lihat.isSelected()) {
                txtpass1.setEchoChar((char)0);
                txtpass2.setEchoChar((char)0);
                txtpass3.setEchoChar((char)0);
            } else {
                txtpass1.setEchoChar('•');
                txtpass2.setEchoChar('•');
                txtpass3.setEchoChar('•');
            }
    }//GEN-LAST:event_lihatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelganti;
    private javax.swing.JRadioButton lihat;
    private custom.PanelShadow panelShadow1;
    private custom.PanelShadow panelShadow2;
    private javax.swing.JButton submit;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JPasswordField txtpass2;
    private javax.swing.JPasswordField txtpass3;
    private javax.swing.JTextField txtuser1;
    // End of variables declaration//GEN-END:variables
}
