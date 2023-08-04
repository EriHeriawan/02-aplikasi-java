
package main;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class panel3_penundaan extends javax.swing.JPanel {

    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    int insertedRows = 0;
    private final int noColumnIndex = 0;
    private final int noColumnWidth= 50;
    
    public panel3_penundaan() {
        initComponents();
         k.connect();
         rp.setVisible(false);
//        panelShadow1.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        panelShadow1.putClientProperty(FlatClientProperties.STYLE, "arc:100");
        jPanel2.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel2.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        lebarpenundaan();
        pencarian.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        cmbpenundaan1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        
        btncetak.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
    }

    public void filterpenundaan(){
        java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
        String Rp= rp.getText();
        String cmb_filter = (String) cmbpenundaan1.getSelectedItem();
        
        if (cmb_filter == "SATU") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("No.SPPT");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun "+thn);
            model.addColumn("Status Pembayaran"); 
            
            tb_penundaan.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+cmb_filter+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nosppt"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tb_penundaan.setModel(model);
                lebarpenundaan();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        } else if (cmb_filter == "DUA") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("No.SPPT");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun "+thn);
            model.addColumn("Status Pembayaran"); 
            
            tb_penundaan.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+cmb_filter+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nosppt"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tb_penundaan.setModel(model);
                lebarpenundaan();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }else if (cmb_filter == "") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("No.SPPT");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun "+thn);
            model.addColumn("Status Pembayaran"); 
            
            tb_penundaan.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+cmb_filter+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nosppt"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                   Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tb_penundaan.setModel(model);
                 lebarpenundaan();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         
        }else{
            penundaan();
        }
    }
    
    public void lebarpenundaan(){ 
         TableColumn column;
       TableColumnModel columnModel1 =tb_penundaan.getColumnModel();
       
        columnModel1.getColumn(noColumnIndex).setPreferredWidth(noColumnWidth);
        columnModel1.getColumn(noColumnIndex).setMaxWidth(noColumnWidth);
        columnModel1.getColumn(noColumnIndex).setMinWidth(noColumnWidth);
        column = tb_penundaan.getColumnModel().getColumn(5); //bayar
        column.setPreferredWidth(150);
    }
    
    public void pencarian2(){
         java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
        cmbpenundaan1.setSelectedIndex(-1);
        String Rp = rp.getText();
        
        int no =1;
        try {
            DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("No.SPPT");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun "+thn);
            model.addColumn("Status Pembayaran");
            
            String sql = "Select * from dhkp where nop like '%" + pencarian.getText() + "%'" +
                    "or nama like '%" + pencarian.getText() + "%'";
            Statement stat = k.getCon().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                model.addRow(new Object[]{
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nosppt"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")                   
                });
            }
            tb_penundaan.setModel(model);
            lebarpenundaan();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data tidak ditemukan");
            }
        lebarpenundaan();
    }
    
     public void penundaan(){
        java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
              
        
        String Rp= rp.getText();
        try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("NO.SPPt");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun"+thn);
            model.addColumn("Status Pembayaran");
            
            tb_penundaan.setModel(model);
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM `dhkp` where status = 'BELUM BAYAR'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nosppt"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                
                tb_penundaan.setModel(model);
                 lebarpenundaan();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panelShadow1 = new custom.PanelShadow();
        jPanel1 = new javax.swing.JPanel();
        cmbpenundaan1 = new javax.swing.JComboBox<>();
        rp = new javax.swing.JLabel();
        panelShadow3 = new custom.PanelShadow();
        pencarian = new javax.swing.JTextField();
        iconcari = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btncetak = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_penundaan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        cmbpenundaan1.setBackground(new Color(0,0,0,0));
        cmbpenundaan1.setForeground(new java.awt.Color(0, 0, 0));
        cmbpenundaan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SATU", "DUA", "TIGA" }));
        cmbpenundaan1.setSelectedIndex(-1);
        cmbpenundaan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpenundaan1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(rp, org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.rp.text")); // NOI18N

        panelShadow3.setShadowOpacity(0.3F);
        panelShadow3.setShadowSize(4);

        pencarian.setBackground(new Color(0,0,0,0));
        pencarian.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        pencarian.setText(org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.pencarian.text")); // NOI18N
        pencarian.setBorder(null);
        pencarian.setOpaque(false);
        pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pencarianKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pencarianKeyTyped(evt);
            }
        });

        iconcari.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        iconcari.setForeground(java.awt.Color.white);
        iconcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-human-research-program-30 (1).png"))); // NOI18N
        iconcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconcariMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconcari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconcari)
                    .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cmbpenundaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(rp)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbpenundaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(74, 145, 132));

        btncetak.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btncetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/14.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btncetak, org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.btncetak.text")); // NOI18N
        btncetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncetak.setIconTextGap(10);
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel29.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel29, org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.jLabel29.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tb_penundaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tb_penundaan);
        if (tb_penundaan.getColumnModel().getColumnCount() > 0) {
            tb_penundaan.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.tb_penundaan.columnModel.title0")); // NOI18N
            tb_penundaan.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.tb_penundaan.columnModel.title1")); // NOI18N
            tb_penundaan.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.tb_penundaan.columnModel.title2")); // NOI18N
            tb_penundaan.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(panel3_penundaan.class, "panel3_penundaan.tb_penundaan.columnModel.title3")); // NOI18N
        }

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbpenundaan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpenundaan1ActionPerformed
        // TODO add your handling code here:
        filterpenundaan();
    }//GEN-LAST:event_cmbpenundaan1ActionPerformed

    private void iconcariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconcariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_iconcariMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        cmbpenundaan1.setSelectedIndex(-1);
        pencarian.setText("Cari..."); 
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        try{
            String file =("/laporan/laporan_penundaan.jasper");
            
            JasperPrint jasv = JasperFillManager.fillReport(getClass().getResourceAsStream(file), null,k.getCon());
//            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/laporan/lap_laporan.jasper"), null, k.getCon());
            JasperViewer viewer = new JasperViewer(jasv,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btncetakActionPerformed

    private void pencarianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pencarianKeyPressed

    private void pencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyTyped
        // TODO add your handling code here:
        pencarian2();
    }//GEN-LAST:event_pencarianKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncetak;
    private javax.swing.JComboBox<String> cmbpenundaan1;
    private javax.swing.JLabel iconcari;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private custom.PanelShadow panelShadow1;
    private custom.PanelShadow panelShadow3;
    private javax.swing.JTextField pencarian;
    private javax.swing.JLabel rp;
    private javax.swing.JTable tb_penundaan;
    // End of variables declaration//GEN-END:variables
}
