package test;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Frame;
import javax.swing.JFrame;
import main.form3_loginpimpinan;
import main.form4_menuutama;
import main.form5_menupimpinan;

public class MenuLogout extends javax.swing.JDialog {

   
    private form4_menuutama menuutama;
            
    public MenuLogout(Frame parent, boolean modal,form4_menuutama menuutama) {
        super(parent, modal);
        initComponents();
       this.menuutama = menuutama;
       
    }

      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlogout = new javax.swing.JLabel();
        jganti = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);
        setResizable(false);

        jlogout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlogout, org.openide.util.NbBundle.getMessage(MenuLogout.class, "MenuLogout.jlogout.text")); // NOI18N
        jlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlogoutMouseClicked(evt);
            }
        });

        jganti.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jganti, org.openide.util.NbBundle.getMessage(MenuLogout.class, "MenuLogout.jganti.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jganti, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jlogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jganti, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlogoutMouseClicked
        dispose();
//        menupim.dispose();
       
//        new form3_loginpimpinan().setVisible(true);
    }//GEN-LAST:event_jlogoutMouseClicked

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuLogout dialog = new MenuLogout(new javax.swing.JFrame(), true,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jganti;
    private javax.swing.JLabel jlogout;
    // End of variables declaration//GEN-END:variables
}
