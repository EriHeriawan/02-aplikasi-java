package main;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class panel7_importexcel extends javax.swing.JPanel {

     private PreparedStatement stat;
    private ResultSet rs;
    koneksi  k= new koneksi();
    private final int noColumnIndex = 0;
     private final int noColumnWidth= 50;
    int insertedRows=0;
    public panel7_importexcel() {
        initComponents();
        jPanel5.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel5.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        btnimport.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btnsave.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        lebarltabel();
        rp.setVisible(false);
    }
private void setColumnwidth() {
        
      TableColumnModel columnModel =tableimport.getColumnModel();
        
        columnModel.getColumn(noColumnIndex).setPreferredWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMaxWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMinWidth(noColumnWidth); 
        
    }
    public void lebarltabel(){ 
        TableColumn column;
        tableimport.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tableimport.getColumnModel().getColumn(0); //no sppt
        column.setPreferredWidth(200);
        column = tableimport.getColumnModel().getColumn(1); //sppt
        column.setPreferredWidth(80); 
        column = tableimport.getColumnModel().getColumn(2); //nop
        column.setPreferredWidth(80); 
        column = tableimport.getColumnModel().getColumn(3); //dusun
        column.setPreferredWidth(230); 
        column = tableimport.getColumnModel().getColumn(4); //noblok
        column.setPreferredWidth(100);
        column = tableimport.getColumnModel().getColumn(5); //nama
        column.setPreferredWidth(230);
        column = tableimport.getColumnModel().getColumn(6); //alamat
        column.setPreferredWidth(120);
        column = tableimport.getColumnModel().getColumn(7); //npwp
        column.setPreferredWidth(120);
        column = tableimport.getColumnModel().getColumn(8); //bayar
        column.setPreferredWidth(150);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        importexcel = new javax.swing.JPanel();
        panelShadow2 = new custom.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableimport = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnimport = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        rp = new javax.swing.JLabel();

        importexcel.setPreferredSize(new java.awt.Dimension(934, 661));

        panelShadow2.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow2.setPreferredSize(new java.awt.Dimension(934, 661));

        tableimport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nop", "Blok", "Dusun", "Nama", "Bayar", "Alamat", "NPWP", "NoSPPT", "Status"
            }
        ));
        jScrollPane1.setViewportView(tableimport);

        jPanel5.setBackground(new java.awt.Color(74, 145, 132));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(panel7_importexcel.class, "panel7_importexcel.jLabel6.text")); // NOI18N

        btnimport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/13.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnimport, org.openide.util.NbBundle.getMessage(panel7_importexcel.class, "panel7_importexcel.btnimport.text")); // NOI18N
        btnimport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportActionPerformed(evt);
            }
        });

        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-to-database-30 (1).png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnsave, org.openide.util.NbBundle.getMessage(panel7_importexcel.class, "panel7_importexcel.btnsave.text")); // NOI18N
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(rp, org.openide.util.NbBundle.getMessage(panel7_importexcel.class, "panel7_importexcel.rp.text")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(123, 123, 123)
                .addComponent(rp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnimport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rp)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnimport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout importexcelLayout = new javax.swing.GroupLayout(importexcel);
        importexcel.setLayout(importexcelLayout);
        importexcelLayout.setHorizontalGroup(
            importexcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importexcelLayout.createSequentialGroup()
                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        importexcelLayout.setVerticalGroup(
            importexcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importexcelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importexcel, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    DefaultTableModel importfromexcel;
    private void btnimportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportActionPerformed
        // TODO add your handling code here:
        importfromexcel = (DefaultTableModel) tableimport.getModel();
        importfromexcel.setRowCount(0);
        String Rp = rp.getText();
        
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelimportworkbook = null;

        String currentDirectoryPath = "C:\\Users\\Desktop";
        JFileChooser excelFileimport = new JFileChooser(currentDirectoryPath);

        int excelchooser = excelFileimport.showOpenDialog(null);

        if (excelchooser == JFileChooser.APPROVE_OPTION) {
            File excelfile = excelFileimport.getSelectedFile();
            try {
                excelFIS = new FileInputStream(excelfile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelimportworkbook = new XSSFWorkbook(excelBIS);
                XSSFSheet excelsheet = excelimportworkbook.getSheetAt(0);

                for (int i = 0; i < excelsheet.getLastRowNum(); i++){
                    XSSFRow excelrow = excelsheet.getRow(i);

                    //                    double excellImportedNop = excelrow.getCell(0).getNumericCellValue();
                    XSSFCell excellImportedNop = excelrow.getCell(0);
                    XSSFCell excellImportedBlok = excelrow.getCell(1);
                    XSSFCell excellImportedDusun = excelrow.getCell(2);
                    XSSFCell excellImportedNama = excelrow.getCell(3);
                    double excellImportedBayar = excelrow.getCell(4).getNumericCellValue();
                    XSSFCell excellImportedAlamat = excelrow.getCell(5);
                    XSSFCell excellImportedNPWP = excelrow.getCell(6);
                    XSSFCell excellImportedNoSPPT = excelrow.getCell(7);
                    XSSFCell excellImportedStatus = excelrow.getCell(8);

                    importfromexcel.addRow(new Object[] {
                        excellImportedNop,
                        excellImportedBlok,
                        excellImportedDusun,
                        excellImportedNama,
                        Rp+excellImportedBayar,
                        excellImportedAlamat,
                        excellImportedNPWP,
                        excellImportedNoSPPT,
                        excellImportedStatus,
                        
                    });
                }
                int jtabel = tableimport.getRowCount();
                JOptionPane.showMessageDialog(this, "Mengimpor "+jtabel+" Data");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            excelBIS = new BufferedInputStream(excelFIS);
        }

    }//GEN-LAST:event_btnimportActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        //        String Rp = rp.getText();
        int jtabel = tableimport.getRowCount();

        for (int i = 0; i < jtabel ; i++) {

            String Nop = importfromexcel.getValueAt(i, 0).toString();
            String Dusun = importfromexcel.getValueAt(i, 1).toString();
            String Blok = importfromexcel.getValueAt(i, 2).toString();
            String Nama = importfromexcel.getValueAt(i, 3).toString();
            String Bayar = importfromexcel.getValueAt(i, 4).toString();
            String Alamat= importfromexcel.getValueAt(i, 5).toString();
            String NPWP = importfromexcel.getValueAt(i, 6).toString();
            String NoSPPT = importfromexcel.getValueAt(i,7).toString();
            String Status = importfromexcel.getValueAt(i, 8).toString();
            try {
                this.stat = k.getCon().prepareStatement("INSERT INTO dhkp VALUES (?,?,?,?,?,?,?,?,?)");

                stat.setString(1,(Nop));
                stat.setString(2, Dusun);
                stat.setString(3, Blok);
                stat.setString(4, Nama);
                stat.setString(5, (Bayar));
                stat.setString(6, Alamat);
                stat.setDouble(7, Double.parseDouble(NPWP));
                stat.setDouble(8, Double.parseDouble(NoSPPT));
                stat.setString(9, Status);

                int insertResult = stat.executeUpdate();

                if(insertResult > 0){
                    insertedRows++;

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

        JOptionPane.showMessageDialog(null, jtabel+" data berhasil dimasukan");
    }//GEN-LAST:event_btnsaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimport;
    private javax.swing.JButton btnsave;
    private javax.swing.JPanel importexcel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private custom.PanelShadow panelShadow2;
    private javax.swing.JLabel rp;
    private javax.swing.JTable tableimport;
    // End of variables declaration//GEN-END:variables
}
