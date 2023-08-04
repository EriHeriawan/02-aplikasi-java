package main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class form1_home extends javax.swing.JFrame {

    Timer timer;
    int detik;
    
    public form1_home() {
        initComponents();
        detik = 10;
        mundur();
        tungguan.setVisible(false); 
        jPanel2.setBackground(new Color(0,0,0,0));
        btn_admin.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        btn_pimpinan.putClientProperty(FlatClientProperties.STYLE,"arc:999");
        btn_admin.putClientProperty(FlatClientProperties.BUTTON_TYPE,FlatClientProperties.BUTTON_TYPE_BORDERLESS);
        btn_pimpinan.putClientProperty(FlatClientProperties.BUTTON_TYPE,FlatClientProperties.BUTTON_TYPE_BORDERLESS);
    }

    public void mundur(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtmundur.setText(""+detik);
                detik--;
//                jika waktu habis
                if (detik==0) {
                        timer.stop();
                        txtmundur.setText("terhubung ke Server");
                        tungguan.setVisible(false);
                        btn_admin.setEnabled(true);
                        btn_pimpinan.setEnabled(true);
                        btn_admin.setEnabled(true);
                        btn_pimpinan.setEnabled(true);
                    }else{
                    btn_admin.setEnabled(false);
                    btn_pimpinan.setEnabled(false);
                    btn_admin.setEnabled(false);
                    btn_pimpinan.setEnabled(false);
                    tungguan.setVisible(true);
                }
            }
        }
        );
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tungguan = new javax.swing.JLabel();
        txtmundur = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_pimpinan = new javax.swing.JButton();
        btn_admin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wellcome!");

        jPanel1.setBackground(new java.awt.Color(12, 16, 22));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 490));
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 490));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tungguan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tungguan.setForeground(new java.awt.Color(255, 255, 255));
        tungguan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tungguan.setText("please wait 10 second...");
        jPanel1.add(tungguan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 178, 30));

        txtmundur.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtmundur.setForeground(new java.awt.Color(153, 153, 153));
        txtmundur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtmundur, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 190, 30));

        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_pimpinan.setBackground(new java.awt.Color(0, 51, 204));
        btn_pimpinan.setForeground(new java.awt.Color(255, 255, 255));
        btn_pimpinan.setText("Pimpinan");
        btn_pimpinan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pimpinanActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pimpinan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 110, 30));

        btn_admin.setBackground(new java.awt.Color(0, 51, 204));
        btn_admin.setForeground(new java.awt.Color(255, 255, 255));
        btn_admin.setText("Admin");
        btn_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminActionPerformed(evt);
            }
        });
        jPanel2.add(btn_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pemda_100px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 100, 90));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Masuk sebagai :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Leelawadee", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Selamat datang");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 40));

        jLabel6.setFont(new java.awt.Font("Leelawadee", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("di Aplikasi-PBB");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 230, 50));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 250, 10));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("selamat datang dan selamat");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 220, 30));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(" atas aplikasi baru Anda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 220, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Intersect.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 292, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Rectangle 33 (1).png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 550, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminActionPerformed
        form2_loginadmin log = new form2_loginadmin();
        log.setVisible(true);
        this.dispose();
        dispose();
    }//GEN-LAST:event_btn_adminActionPerformed

    private void btn_pimpinanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pimpinanActionPerformed
        form3_loginpimpinan log = new form3_loginpimpinan();
        log.setVisible(true);
        this.dispose();
        dispose();
    }//GEN-LAST:event_btn_pimpinanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatLightLaf.setup();

//        try {
////            membuka server
//        Runtime r = Runtime.getRuntime();
//        r.exec("c:\\wamp64\\wampmanager.exe");
//           System.out.println("menghubungkan ke server");
//               
//    } catch (IOException e) {
////        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, e.getMessage());
//    } 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form1_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_admin;
    private javax.swing.JButton btn_pimpinan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tungguan;
    private javax.swing.JLabel txtmundur;
    // End of variables declaration//GEN-END:variables
}
