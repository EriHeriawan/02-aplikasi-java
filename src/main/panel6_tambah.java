
package main;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class panel6_tambah extends javax.swing.JPanel {

    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    private Statement st;
    int insertedRows = 0;
    private final int noColumnIndex = 0;
    private final int noColumnWidth= 50;
    Color defaultColor,clickedColor;
    
    public panel6_tambah() {
        initComponents();
        jPanel5.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel5.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        
        lblsppt.setEnabled(false);
        spptlama.setEnabled(false);
        
        place();
        
        btnSimpan.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btnKembali.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btnImport.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        peringatan.setVisible(false);
        peringatan2.setVisible(false);
        peringatan3.setVisible(false);
        peringatan1.setVisible(false);
        peringatan5.setVisible(false);
        
        txtdusun.setVisible(false);
        txtstatus.setVisible(false);
    }
    
    private void place(){
        spptbaru.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"No. SPPT");
        txtnop.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Nomor objek Pajak");
        txtcari.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Status Pembayaran");
        txtblok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Blok");
        txtnama.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Nama wajib Pajak");
        txtalamat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Alamat Wajib Pajak");
        txtnpwp.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"No.NPWP ");
        txtpbb.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Nominal pembayaran");
//        spptlama.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, );
    }
    
    public void cari(){
        if (txtcari.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "silahkan masukan NO.SPPT");
            
        } else {
             try {
            String sql = "Select * from dhkp where nosppt like '%" + txtcari.getText() + "%'" +
                    "or nama like '%" + txtcari.getText() + "%'";
            st = k.con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                txtnop.setText(rs.getString("nop"));
                txtnama.setText(rs.getString("nama"));
                txtblok.setText(rs.getString("nomor_blok"));
                cmbdusuntam.setSelectedItem(rs.getString("dusun"));
                txtnpwp.setText(rs.getString("npwp"));
                spptlama.setText(rs.getString("nosppt"));
                spptbaru.setText(rs.getString("nosppt"));
                txtpbb.setText(rs.getString("pbb_dibayar"));
                txtalamat.setText(rs.getString("alamat"));
                cmbstatustam.setSelectedItem(rs.getString("status"));
                
                JOptionPane.showMessageDialog(null, "Data Ditemukan");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
        }
       
    }
    
    public void pencarian4(){        
        try {
            String sql = "Select * from dhkp where nop like '%" + txtcari.getText() + "%'" +
                    "or nama like '%" + txtcari.getText() + "%'";
            Statement stat = k.getCon().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                    txtnop.setText(rs.getString("nop"));
                    cmbdusuntam.setSelectedItem(rs.getString("dusun"));
                    txtdusun.setText(rs.getString("dusun"));
                    txtblok.setText(rs.getString("nomor_blok"));
                    txtnama.setText(rs.getString("nama"));
                    txtpbb.setText(rs.getString("pbb_dibayar"));
                    txtalamat.setText(rs.getString("alamat"));
                    txtnpwp.setText(rs.getString("npwp"));
                    spptlama.setText(rs.getString("nosppt"));   
                    txtstatus.setText(rs.getString("status"));
                    cmbstatustam.setSelectedItem(rs.getString("status"));
                    }
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }
       
    public void bersih(){
            txtcari.setText("");
            cmbdusuntam.setSelectedIndex(-1);
            txtblok.setText("");
            txtnama.setText("");
            cmbstatustam.setSelectedIndex(-1);
            txtalamat.setText("");
            txtnpwp.setText("");
            spptlama.setText("");
            spptbaru.setText("");
            txtnop.setText("");
            txtpbb.setText("");
            txtstatus.setText("");
            txtdusun.setText("");
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelShadow2 = new custom.PanelShadow();
        sementara1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        iconcari = new javax.swing.JLabel();
        panelShadow4 = new custom.PanelShadow();
        txtcari = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnImport = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtpbb = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtnpwp = new javax.swing.JTextField();
        peringatan3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbstatustam = new javax.swing.JComboBox();
        txtstatus = new javax.swing.JTextField();
        peringatan1 = new javax.swing.JLabel();
        peringatan5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblsppt = new javax.swing.JLabel();
        spptlama = new javax.swing.JTextField();
        lblspptbaru = new javax.swing.JLabel();
        spptbaru = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtnop = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cmbdusuntam = new javax.swing.JComboBox();
        txtdusun = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtblok = new javax.swing.JTextField();
        peringatan = new javax.swing.JLabel();
        peringatan2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        panelShadow2.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow2.setPreferredSize(new java.awt.Dimension(934, 661));

        org.openide.awt.Mnemonics.setLocalizedText(sementara1, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.sementara1.text")); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconcari.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        iconcari.setForeground(java.awt.Color.white);
        iconcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-human-research-program-30 (1).png"))); // NOI18N
        iconcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconcariMouseClicked(evt);
            }
        });
        jPanel3.add(iconcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 40));

        txtcari.setBackground(new Color(0,0,0,0));
        txtcari.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtcari.setForeground(new java.awt.Color(51, 51, 51));
        txtcari.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtcari.text")); // NOI18N
        txtcari.setBorder(null);
        txtcari.setCaretColor(new java.awt.Color(51, 51, 51));
        txtcari.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtcari.setOpaque(false);
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtcari, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(panelShadow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 19, 200, 45));

        jPanel5.setBackground(new java.awt.Color(74, 145, 132));

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/13.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnImport, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.btnImport.text")); // NOI18N
        btnImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/12.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnKembali, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.btnKembali.text")); // NOI18N
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/15.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnSimpan, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.btnSimpan.text")); // NOI18N
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel22, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel22.text")); // NOI18N

        txtnama.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtnama.text")); // NOI18N
        txtnama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnamaFocusLost(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel27, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel27.text")); // NOI18N

        txtpbb.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtpbb.text")); // NOI18N
        txtpbb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpbbFocusLost(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel26, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel26.text")); // NOI18N

        txtalamat.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtalamat.text")); // NOI18N
        txtalamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtalamatFocusLost(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel21, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel21.text")); // NOI18N

        txtnpwp.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtnpwp.text")); // NOI18N
        txtnpwp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnpwpFocusLost(evt);
            }
        });
        txtnpwp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnpwpKeyTyped(evt);
            }
        });

        peringatan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warning-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(peringatan3, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.peringatan3.text")); // NOI18N

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel20, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel20.text")); // NOI18N

        cmbstatustam.setBackground(new Color(0,0,0,0));
        cmbstatustam.setForeground(new java.awt.Color(51, 51, 51));
        cmbstatustam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BELUM BAYAR", "LUNAS" }));
        cmbstatustam.setSelectedIndex(-1);
        cmbstatustam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstatustamActionPerformed(evt);
            }
        });

        txtstatus.setFont(new java.awt.Font("Artifakt Element", 1, 12)); // NOI18N
        txtstatus.setForeground(new java.awt.Color(51, 51, 51));
        txtstatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtstatus.setCaretColor(java.awt.Color.black);
        txtstatus.setOpaque(false);
        txtstatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtstatusMouseClicked(evt);
            }
        });

        peringatan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warning-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(peringatan1, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.peringatan1.text")); // NOI18N

        peringatan5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warning-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(peringatan5, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.peringatan5.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpbb, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbstatustam, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtnama))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peringatan1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peringatan5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtnpwp)
                            .addComponent(txtalamat))
                        .addGap(1, 1, 1)
                        .addComponent(peringatan3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpbb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(peringatan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(peringatan5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel26)
                .addGap(10, 10, 10)
                .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnpwp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peringatan3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbstatustam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblsppt.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblsppt.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(lblsppt, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.lblsppt.text")); // NOI18N

        spptlama.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.spptlama.text")); // NOI18N
        spptlama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spptlamaFocusLost(evt);
            }
        });
        spptlama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spptlamaKeyTyped(evt);
            }
        });

        lblspptbaru.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblspptbaru.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(lblspptbaru, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.lblspptbaru.text")); // NOI18N

        spptbaru.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.spptbaru.text")); // NOI18N
        spptbaru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spptbaruFocusLost(evt);
            }
        });
        spptbaru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spptbaruKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel34, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel34.text")); // NOI18N

        txtnop.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtnop.text")); // NOI18N
        txtnop.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnopFocusLost(evt);
            }
        });
        txtnop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnopKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel18, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel18.text")); // NOI18N

        cmbdusuntam.setBackground(new Color(0,0,0,0));
        cmbdusuntam.setForeground(new java.awt.Color(51, 51, 51));
        cmbdusuntam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SATU", "DUA", "TIGA" }));
        cmbdusuntam.setSelectedIndex(-1);
        cmbdusuntam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdusuntamActionPerformed(evt);
            }
        });

        txtdusun.setFont(new java.awt.Font("Artifakt Element", 1, 12)); // NOI18N
        txtdusun.setForeground(new java.awt.Color(51, 51, 51));
        txtdusun.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtdusun.setCaretColor(java.awt.Color.black);
        txtdusun.setOpaque(false);
        txtdusun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdusunMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel19, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.jLabel19.text")); // NOI18N

        txtblok.setText(org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.txtblok.text")); // NOI18N
        txtblok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtblokFocusLost(evt);
            }
        });

        peringatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warning-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(peringatan, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.peringatan.text")); // NOI18N

        peringatan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warning-20.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(peringatan2, org.openide.util.NbBundle.getMessage(panel6_tambah.class, "panel6_tambah.peringatan2.text")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblsppt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(spptlama, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(peringatan)
                .addGap(4, 4, 4))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cmbdusuntam, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(txtdusun, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtblok)
                .addGap(34, 34, 34))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblspptbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spptbaru)
                            .addComponent(txtnop))
                        .addGap(14, 14, 14)
                        .addComponent(peringatan2))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblsppt)
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spptlama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(peringatan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(lblspptbaru)
                .addGap(10, 10, 10)
                .addComponent(spptbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel34)
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peringatan2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbdusuntam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdusun, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(10, 10, 10)
                .addComponent(txtblok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(sementara1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62)))
                        .addContainerGap())))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(sementara1))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(93, Short.MAX_VALUE))))
        );

        jPanel1.add(panelShadow2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iconcariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconcariMouseClicked
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_iconcariMouseClicked

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            pencarian4();
        }
        else {
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
     panel7_importexcel impor = new panel7_importexcel();
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.add(impor);
        jPanel1.repaint();
        jPanel1.revalidate();   
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
     panel2_dhkp dhkp = new panel2_dhkp();
     jPanel1.removeAll();
     jPanel1.repaint();
     jPanel1.add(dhkp);
     jPanel1.repaint();
     jPanel1.revalidate();
     
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed

        try {
            st=k.con.createStatement();

            if ("Simpan".equals(btnSimpan.getText())) {
                String cek = "SELECT * FROM dhkp WHERE nop = '" + spptlama.getText()+"'";
                rs = st.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "data sudah ada");
                    return;
                }
                else {
                    this.stat = k.con.prepareStatement( "INSERT INTO dhkp VALUES(?,?,?,?,?,?,?,?,?)");
                    stat.setString(1, txtnop.getText());
                    stat.setString(2, txtdusun.getText());
                    stat.setString(3, txtblok.getText());
                    stat.setString(4, txtnama.getText());
                    stat.setString(5, txtpbb.getText());
                    stat.setString(6, txtalamat.getText());
                    stat.setString(7, txtnpwp.getText());
                    stat.setString(8, spptlama.getText());
                    stat.setString(9, txtstatus.getText());

                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Berhasil menambahkan data");

                }
            } else {
            }
        }catch(Exception e) {
            if (
                txtdusun.getText().equals("") ||
                txtblok.getText().equals("") ||
                txtpbb.getText().equals("") ||
                txtalamat.getText().equals("") ||
                txtnpwp.getText().equals("") ||
                spptlama.getText().equals("") ||
                txtstatus.getText().equals("")||
                txtnama.getText().equals("")||
                txtnop.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } return;
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnamaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaFocusLost

    private void txtpbbFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpbbFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpbbFocusLost

    private void txtalamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtalamatFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatFocusLost

    private void txtnpwpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnpwpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnpwpFocusLost

    private void txtnpwpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnpwpKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))) {
            txtnpwp.putClientProperty(FlatClientProperties.OUTLINE, FlatClientProperties.OUTLINE_ERROR);
            peringatan3.setVisible(true);
            evt.consume();
        }else{
            txtnpwp.putClientProperty(FlatClientProperties.OUTLINE, FlatClientProperties.OUTLINE);
            peringatan3.setVisible(false);
        }
    }//GEN-LAST:event_txtnpwpKeyTyped

    private void cmbstatustamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstatustamActionPerformed
        // TODO add your handling code here:
        String Status = (String) cmbstatustam.getSelectedItem();
        if (Status=="BELUM BAYAR" || Status =="LUNAS") {
            txtstatus.setText(Status);
        } else {
            //            System.out.println("eror");
        }
    }//GEN-LAST:event_cmbstatustamActionPerformed

    private void txtstatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtstatusMouseClicked
        // TODO add your handling code here:
        txtnama.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtstatus.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 51), 1, true));
        txtnop.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtdusun.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtblok.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtpbb.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtalamat.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtnpwp.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        spptlama.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        spptbaru.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
    }//GEN-LAST:event_txtstatusMouseClicked

    private void spptlamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spptlamaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_spptlamaFocusLost

    private void spptlamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spptlamaKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))) {
            spptlama.putClientProperty(FlatClientProperties.OUTLINE, FlatClientProperties.OUTLINE_ERROR);
            peringatan.setVisible(true);
            evt.consume();
        }else{
            spptlama.putClientProperty(FlatClientProperties.OUTLINE, FlatClientProperties.OUTLINE);
            peringatan.setVisible(false);
        }
    }//GEN-LAST:event_spptlamaKeyTyped

    private void spptbaruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spptbaruFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_spptbaruFocusLost

    private void spptbaruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spptbaruKeyTyped
        
    }//GEN-LAST:event_spptbaruKeyTyped

    private void txtnopFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnopFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnopFocusLost

    private void txtnopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnopKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE))) {
            txtnop.putClientProperty(FlatClientProperties.OUTLINE, FlatClientProperties.OUTLINE_ERROR);
            peringatan2.setVisible(true);
            evt.consume();
        }else{
            txtnop.putClientProperty(FlatClientProperties.OUTLINE, FlatClientProperties.OUTLINE);
            peringatan2.setVisible(false);
        }
    }//GEN-LAST:event_txtnopKeyTyped

    private void cmbdusuntamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdusuntamActionPerformed
        // TODO add your handling code here:
        String dusun = (String) cmbdusuntam.getSelectedItem();
        if (dusun=="SATU" || dusun =="DUA"||dusun=="TIGA") {
            txtdusun.setText(dusun);
        } else {
            //            System.out.println("eror");
        }
    }//GEN-LAST:event_cmbdusuntamActionPerformed

    private void txtdusunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdusunMouseClicked
        // TODO add your handling code here:
        txtnama.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtdusun.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 51), 1, true));
        txtnop.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtstatus.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtblok.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtpbb.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtalamat.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        txtnpwp.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        spptlama.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
        spptbaru.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187), 1, true));
    }//GEN-LAST:event_txtdusunMouseClicked

    private void txtblokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtblokFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtblokFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbdusuntam;
    private javax.swing.JComboBox cmbstatustam;
    private javax.swing.JLabel iconcari;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblsppt;
    private javax.swing.JLabel lblspptbaru;
    private custom.PanelShadow panelShadow2;
    private custom.PanelShadow panelShadow4;
    private javax.swing.JLabel peringatan;
    private javax.swing.JLabel peringatan1;
    private javax.swing.JLabel peringatan2;
    private javax.swing.JLabel peringatan3;
    private javax.swing.JLabel peringatan5;
    private javax.swing.JLabel sementara1;
    private javax.swing.JTextField spptbaru;
    private javax.swing.JTextField spptlama;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtblok;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtdusun;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnop;
    private javax.swing.JTextField txtnpwp;
    private javax.swing.JTextField txtpbb;
    private javax.swing.JTextField txtstatus;
    // End of variables declaration//GEN-END:variables
}
