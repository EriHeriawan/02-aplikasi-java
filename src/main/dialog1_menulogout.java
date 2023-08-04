package main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.netbeans.api.actions.Closable;


public class dialog1_menulogout extends java.awt.Dialog {

    private form4_menuutama menuUtama;
    private panel9_menulog menulog;
    
    public dialog1_menulogout(java.awt.Frame parent, boolean modal,form4_menuutama menuUtama) {
        super(parent, modal);
        initComponents();
        this.menuUtama= menuUtama;
        
        setBackground(new Color(0,0,0,0));;
         }
    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {                                     
        
    }                                    

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {                                    
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new custom.PanelShadow();
        closeDialog = new javax.swing.JLabel();
        Logout = new javax.swing.JPanel();
        jlogout = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        Ganti = new javax.swing.JPanel();
        jganti = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        Hapus = new javax.swing.JPanel();
        jhapus = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();

        setIconImage(null);
        setIconImages(null);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setShadowSize(10);
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeDialog.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        closeDialog.setForeground(new java.awt.Color(204, 0, 0));
        closeDialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close-25.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(closeDialog, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.closeDialog.text")); // NOI18N
        closeDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeDialogMouseClicked(evt);
            }
        });
        panelShadow1.add(closeDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 20, 20));

        Logout.setBackground(new java.awt.Color(255, 255, 255));
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutMouseExited(evt);
            }
        });

        jlogout.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jlogout.setForeground(new java.awt.Color(0, 0, 0));
        jlogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        org.openide.awt.Mnemonics.setLocalizedText(jlogout, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.jlogout.text")); // NOI18N

        icon1.setForeground(new java.awt.Color(0, 0, 153));
        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(icon1, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.icon1.text")); // NOI18N

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(icon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jlogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelShadow1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, -1));

        Ganti.setBackground(new java.awt.Color(255, 255, 255));
        Ganti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GantiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GantiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GantiMouseExited(evt);
            }
        });

        jganti.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jganti.setForeground(new java.awt.Color(0, 0, 0));
        jganti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        org.openide.awt.Mnemonics.setLocalizedText(jganti, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.jganti.text")); // NOI18N

        icon2.setForeground(new java.awt.Color(0, 0, 153));
        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/password-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(icon2, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.icon2.text")); // NOI18N

        javax.swing.GroupLayout GantiLayout = new javax.swing.GroupLayout(Ganti);
        Ganti.setLayout(GantiLayout);
        GantiLayout.setHorizontalGroup(
            GantiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GantiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jganti, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        GantiLayout.setVerticalGroup(
            GantiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jganti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(icon2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelShadow1.add(Ganti, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, -1));

        Hapus.setBackground(new java.awt.Color(255, 255, 255));
        Hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HapusMouseExited(evt);
            }
        });

        jhapus.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jhapus.setForeground(new java.awt.Color(0, 0, 0));
        jhapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        org.openide.awt.Mnemonics.setLocalizedText(jhapus, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.jhapus.text")); // NOI18N

        icon3.setForeground(new java.awt.Color(0, 0, 102));
        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(icon3, org.openide.util.NbBundle.getMessage(dialog1_menulogout.class, "dialog1_menulogout.icon3.text")); // NOI18N

        javax.swing.GroupLayout HapusLayout = new javax.swing.GroupLayout(Hapus);
        Hapus.setLayout(HapusLayout);
        HapusLayout.setHorizontalGroup(
            HapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HapusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HapusLayout.setVerticalGroup(
            HapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(icon3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelShadow1.add(Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
       dispose();
    }//GEN-LAST:event_closeDialog

    private void closeDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeDialogMouseClicked
      dispose();
        
    }//GEN-LAST:event_closeDialogMouseClicked

    private void LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseEntered
        Logout.setBackground(new Color(42,122,111));
        jlogout.setForeground(Color.white);
        Logout.putClientProperty(FlatClientProperties.STYLE,"arc:100");
        icon1.setIcon(new ImageIcon(getClass().getResource("/icon/wahite-logout-20.png")));
    }//GEN-LAST:event_LogoutMouseEntered

    private void LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseExited
       Logout.setBackground(Color.white);
       jlogout.setForeground(Color.black);
       icon1.setIcon(new ImageIcon(getClass().getResource("/icon/logout-20.png")));
    }//GEN-LAST:event_LogoutMouseExited

    private void GantiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GantiMouseEntered
        Ganti.setBackground(new Color(42,122,111));
        jganti.setForeground(Color.white);
        Ganti.putClientProperty(FlatClientProperties.STYLE,"arc:100");
        icon2.setIcon(new ImageIcon(getClass().getResource("/icon/white-password-20.png")));
    }//GEN-LAST:event_GantiMouseEntered

    private void GantiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GantiMouseExited
        Ganti.setBackground(Color.white);
        jganti.setForeground(Color.black);
        icon2.setIcon(new ImageIcon(getClass().getResource("/icon/password-20.png")));
    }//GEN-LAST:event_GantiMouseExited

    private void HapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseEntered
        Hapus.setBackground(new Color(42,122,111));
        jhapus.setForeground(Color.white);
        Hapus.putClientProperty(FlatClientProperties.STYLE,"arc:100");
        icon3.setIcon(new ImageIcon(getClass().getResource("/icon/white-remove-20.png")));
    }//GEN-LAST:event_HapusMouseEntered

    private void HapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseExited
       Hapus.setBackground(Color.white);
       jhapus.setForeground(Color.black);
       icon3.setIcon(new ImageIcon(getClass().getResource("/icon/remove-20.png")));
    }//GEN-LAST:event_HapusMouseExited

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        dispose();
        menuUtama.dispose();
        new form2_loginadmin().setVisible(true);
    }//GEN-LAST:event_LogoutMouseClicked

    private void GantiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GantiMouseClicked
        dispose();
        
        panel9_menulog menu = new panel9_menulog();
        JPanel pn_content = menuUtama.getPn_content();
        pn_content.removeAll();
        pn_content.repaint();
        pn_content.add(menu);
        pn_content.repaint();
        pn_content.revalidate();
    }//GEN-LAST:event_GantiMouseClicked

    private void HapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseClicked
        dispose();
        
        panel9_menulog menu = new panel9_menulog();
        JPanel pn_content = menuUtama.getPn_content();
        pn_content.removeAll();
        pn_content.repaint();
        pn_content.add(menu);
        menu.getjLabel2().setVisible(false);
        menu.getjLabel3().setVisible(false);
        menu.getjLabel1().setText("Password");
        menu.getLabelganti().setText("Hapus Akun");
        menu.getTxtpass2().setVisible(false);
        menu.getTxtpass3().setVisible(false);
        menu.getSubmit().setText("Hapus");
        pn_content.repaint();
        pn_content.revalidate();
    }//GEN-LAST:event_HapusMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
//FlatDarculaLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                dialog1_menulogout dialog = new dialog1_menulogout(new java.awt.Frame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Ganti;
    private javax.swing.JPanel Hapus;
    private javax.swing.JPanel Logout;
    private javax.swing.JLabel closeDialog;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel jganti;
    private javax.swing.JLabel jhapus;
    private javax.swing.JLabel jlogout;
    private custom.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
