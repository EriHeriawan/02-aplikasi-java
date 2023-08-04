/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.*;
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

 
public class panel5_laporan extends javax.swing.JPanel {

    private PreparedStatement stat;
    private ResultSet rs;
    
    koneksi k = new koneksi();
     private final int noColumnIndex = 0;
     private final int noColumnWidth= 50;
    public panel5_laporan() {
        initComponents();
        jPanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        
        btntambah4.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btntambah5.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        rp.setVisible(false);
         k.connect();
        panellaporan.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        laporan();
        lebarlaporan();
        setColumnwidth();
    }

    private void setColumnwidth() {
        
      TableColumnModel columnModel =tblaporan.getColumnModel();
        
        columnModel.getColumn(noColumnIndex).setPreferredWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMaxWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMinWidth(noColumnWidth); 
        
    }
    
    public void laporan(){
        java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
        try {
            DefaultTableModel model = new DefaultTableModel();
            
            model.addColumn("No.");
            model.addColumn("NO SPPT");
            model.addColumn("Nop");
            model.addColumn("Dusun");
            model.addColumn("Nomor Blok-PBB"); 
            model.addColumn("Nama WP");
            model.addColumn("Alamat");
            model.addColumn("NPWP");
            model.addColumn("PBB yang dibayar "+thn);
            model.addColumn("Status");
            tblaporan.setModel(model);
        
            int no = 1;
            String Rp =rp.getText();
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp ");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nosppt"),
                    rs.getString("nop"),
                    rs.getString("dusun"),
                    rs.getString("nomor_blok"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("npwp"),
                    Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")
                    };
                model.addRow(data);
                tblaporan.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void lebarlaporan(){ 
        TableColumn column;
        tblaporan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tblaporan.getColumnModel().getColumn(0); //no
        column.setPreferredWidth(50);
        column = tblaporan.getColumnModel().getColumn(1); //sppt
        column.setPreferredWidth(100); 
        column = tblaporan.getColumnModel().getColumn(2); //nop
        column.setPreferredWidth(100); 
        column = tblaporan.getColumnModel().getColumn(3); //dusun
        column.setPreferredWidth(80); 
        column = tblaporan.getColumnModel().getColumn(4); //noblok
        column.setPreferredWidth(120);
        column = tblaporan.getColumnModel().getColumn(5); //nama
        column.setPreferredWidth(230);
        column = tblaporan.getColumnModel().getColumn(6); //alamat
        column.setPreferredWidth(230);
        column = tblaporan.getColumnModel().getColumn(7); //npwp
        column.setPreferredWidth(100);
        column = tblaporan.getColumnModel().getColumn(8); //bayar
        column.setPreferredWidth(150);
        column = tblaporan.getColumnModel().getColumn(9); //bayar
        column.setPreferredWidth(150);
        }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        panellaporan = new javax.swing.JPanel();
        panelShadow1 = new custom.PanelShadow();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblaporan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        rp = new javax.swing.JLabel();
        btntambah5 = new javax.swing.JButton();
        btntambah4 = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panellaporan.setBackground(new java.awt.Color(255, 255, 255));

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        tblaporan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nop", "Dusun", "Nomor Blok-PBB", "Nama", "Bayar", "Alamat", "NPWP", "NoSPPT", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblaporan);
        if (tblaporan.getColumnModel().getColumnCount() > 0) {
            tblaporan.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title0")); // NOI18N
            tblaporan.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title1")); // NOI18N
            tblaporan.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title2")); // NOI18N
            tblaporan.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title3")); // NOI18N
            tblaporan.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title4")); // NOI18N
            tblaporan.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title5")); // NOI18N
            tblaporan.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title6")); // NOI18N
            tblaporan.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title7")); // NOI18N
            tblaporan.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.tblaporan.columnModel.title8")); // NOI18N
        }

        jPanel4.setBackground(new java.awt.Color(74, 145, 132));
        jPanel4.setPreferredSize(new java.awt.Dimension(934, 56));

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel29.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel29, org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.jLabel29.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(rp, org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.rp.text")); // NOI18N

        btntambah5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btntambah5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-export-pdf-30.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btntambah5, org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.btntambah5.text")); // NOI18N
        btntambah5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntambah5.setIconTextGap(10);
        btntambah5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah5ActionPerformed(evt);
            }
        });

        btntambah4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btntambah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/14.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btntambah4, org.openide.util.NbBundle.getMessage(panel5_laporan.class, "panel5_laporan.btntambah4.text")); // NOI18N
        btntambah4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntambah4.setIconTextGap(10);
        btntambah4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntambah5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btntambah4)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rp)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btntambah4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntambah5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(11, Short.MAX_VALUE))))
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout panellaporanLayout = new javax.swing.GroupLayout(panellaporan);
        panellaporan.setLayout(panellaporanLayout);
        panellaporanLayout.setHorizontalGroup(
            panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panellaporanLayout.setVerticalGroup(
            panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panellaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panellaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btntambah4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah4ActionPerformed
        // TODO add your handling code here:
       try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/laporan/laporan.jasper"), null, k.getCon());
            JasperViewer viewer = new JasperViewer(jp,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btntambah4ActionPerformed

    private void btntambah5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah5ActionPerformed
        // TODO add your handling code here: try{
            try{
                tblaporan.print();
            }catch (Exception e){
            }

    }//GEN-LAST:event_btntambah5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntambah4;
    private javax.swing.JButton btntambah5;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private custom.PanelShadow panelShadow1;
    private javax.swing.JPanel panellaporan;
    private javax.swing.JLabel rp;
    private javax.swing.JTable tblaporan;
    // End of variables declaration//GEN-END:variables
}
