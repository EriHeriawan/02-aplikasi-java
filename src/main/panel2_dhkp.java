
package main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatPasswordFieldUI;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

/**
 *
 * @author Administrator
 */
public class panel2_dhkp extends javax.swing.JPanel {
    
    private form4_menuutama mn;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    private Statement st;
    int insertedRows = 0;
    private final int noColumnIndex = 0;
    private final int noColumnWidth= 50;
    Color defaultColor,clickedColor;
   
    public panel2_dhkp() {
        initComponents();
        jPanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        k.connect();
        defaultColor = new Color(187, 187, 187);
        clickedColor = new Color(0, 51, 51) ;
        
        btnedit.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btnhapus.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btncetak.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btntambah.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);

        pencarian.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        cmbdusundhkp.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        sementara.setVisible(false);
        refreshTable();
                }

    private void setColumnwidth2() {
        TableColumnModel columnModel =tabelDHKP.getColumnModel();
        
        columnModel.getColumn(noColumnIndex).setPreferredWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMaxWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMinWidth(noColumnWidth);
                        
        }
        
    public void filterdhkp(){
        
        String dusun = (String) cmbdusundhkp.getSelectedItem();
        java.util.Date tglsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(tglsekarang);
        
        if(dusun == "satu"||dusun == "dua"||dusun == "tiga"){
            
        try {
              DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("No. SPPT");
            model.addColumn("Nop");
            model.addColumn("Dusun");
            model.addColumn("Nomor Blok-PBB");
            model.addColumn("Nama Wajib Pajak");
            model.addColumn("Alamat");
            model.addColumn("NPWP");
            model.addColumn("PBB yang dibayar tahun "+thn);
            
            tabelDHKP.setModel(model);
                        
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+dusun+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {  
                
                  String Rp=sementara.getText();
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
                };
                model.addRow(data);
                 tabelDHKP.setModel(model);
                 lebardhkp();

                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }else{
            refreshTable();
            
        }
    }
   
    public void refreshTable(){
        String Rp = sementara.getText();
        sementara.setText("Rp.");
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
            model.addColumn("PBB yang dibayar");
           
            tabelDHKP.setModel(model);
        
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp ORDER BY nop ASC ");
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
                    };
                model.addRow(data);
                
                tabelDHKP.setModel(model);
                setColumnwidth2();
                        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void lebardhkp(){ 
        TableColumn column;
        tabelDHKP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabelDHKP.getColumnModel().getColumn(0); //no
        column.setPreferredWidth(50);
        column = tabelDHKP.getColumnModel().getColumn(1); //sppt
        column.setPreferredWidth(100); 
        column = tabelDHKP.getColumnModel().getColumn(2); //nop
        column.setPreferredWidth(100); 
        column = tabelDHKP.getColumnModel().getColumn(3); //dusun
        column.setPreferredWidth(80); 
        column = tabelDHKP.getColumnModel().getColumn(4); //noblok
        column.setPreferredWidth(120);
        column = tabelDHKP.getColumnModel().getColumn(5); //nama
        column.setPreferredWidth(230);
        column = tabelDHKP.getColumnModel().getColumn(6); //alamat
        column.setPreferredWidth(230);
        column = tabelDHKP.getColumnModel().getColumn(7); //npwp
        column.setPreferredWidth(100);
        column = tabelDHKP.getColumnModel().getColumn(8); //bayar
        column.setPreferredWidth(150);
        }
    
    public void pencarian3(){
         java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
        
        String Rp = sementara.getText();
        int no =1;
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
            model.addColumn("PBB yang dibayar");
            
           tabelDHKP.setModel(model);
            
            String sql = "Select * from dhkp where nop like '%" + pencarian.getText() 
                    + "%'" +"or nama like '%" + pencarian.getText() + "%'"
                    +"or nosppt like '%" + pencarian.getText() + "%'";
            Statement stat = k.getCon().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                model.addRow(new Object[]{
                    no++,
                    rs.getString("nosppt"),
                    rs.getString("nop"),
                    rs.getString("dusun"),
                    rs.getString("nomor_blok"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("npwp"),
                    Rp+rs.getString("pbb_dibayar"),
                                    
                });
            }
            tabelDHKP.setModel(model);
            setColumnwidth2();
            } catch (Exception e) {
            }
    }
    
    public void jprint(){
        try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/laporan/lap_laporan.jasper"), null, k.getCon());
            JasperViewer viewer = new JasperViewer(jp,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        panelShadow1 = new custom.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDHKP = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btncetak = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbdusundhkp = new javax.swing.JComboBox<>();
        iconcari1 = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JLabel();
        sementara = new javax.swing.JLabel();
        panelShadow3 = new custom.PanelShadow();
        pencarian = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(934, 661));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.CardLayout());

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        tabelDHKP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabelDHKP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "NOP", "Dusun", "Nomor Blok-PBB", "Nama Wajib Pajak", "PBB yang dibayar tahun 2023"
            }
        ));
        tabelDHKP.setOpaque(false);
        tabelDHKP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDHKPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDHKP);

        jPanel4.setBackground(new java.awt.Color(74, 145, 132));
        jPanel4.setPreferredSize(new java.awt.Dimension(873, 56));

        jLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel, org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.jLabel.text")); // NOI18N

        btntambah.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/15.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btntambah, org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.btntambah.text")); // NOI18N
        btntambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/10.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnedit, org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.btnedit.text")); // NOI18N
        btnedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit.setIconTextGap(10);
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/11.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnhapus, org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.btnhapus.text")); // NOI18N
        btnhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus.setIconTextGap(10);
        btnhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapusMouseClicked(evt);
            }
        });
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btncetak.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btncetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/14.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btncetak, org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.btncetak.text")); // NOI18N
        btncetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncetak.setIconTextGap(10);
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));

        cmbdusundhkp.setBackground(new Color(0,0,0,0));
        cmbdusundhkp.setForeground(new java.awt.Color(0, 0, 0));
        cmbdusundhkp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SATU", "DUA", "TIGA" }));
        cmbdusundhkp.setSelectedIndex(-1);
        cmbdusundhkp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbdusundhkpMouseClicked(evt);
            }
        });
        cmbdusundhkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdusundhkpActionPerformed(evt);
            }
        });

        iconcari1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        iconcari1.setForeground(java.awt.Color.white);
        iconcari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-human-research-program-30 (1).png"))); // NOI18N
        iconcari1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconcari1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconcari1MouseClicked(evt);
            }
        });

        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-refresh-30.png"))); // NOI18N
        btnrefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrefreshMouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(sementara, org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.sementara.text")); // NOI18N

        panelShadow3.setShadowOpacity(0.3F);
        panelShadow3.setShadowSize(4);

        pencarian.setBackground(new Color(0,0,0,0));
        pencarian.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        pencarian.setText(org.openide.util.NbBundle.getMessage(panel2_dhkp.class, "panel2_dhkp.pencarian.text")); // NOI18N
        pencarian.setBorder(null);
        pencarian.setOpaque(false);
        pencarian.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pencarianFocusLost(evt);
            }
        });
        pencarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pencarianMouseClicked(evt);
            }
        });
        pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianActionPerformed(evt);
            }
        });
        pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pencarianKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pencarianKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(cmbdusundhkp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sementara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconcari1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrefresh)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sementara)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnrefresh)
                            .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconcari1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbdusundhkp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        content.add(panelShadow1, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelDHKPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDHKPMouseClicked
        // TODO add your handling code here:
        btnhapus.setEnabled(true);
        sementara.setVisible(true);
        sementara.setText(tabelDHKP.getValueAt(tabelDHKP.getSelectedRow(), 2).toString());
        tabelDHKP.getValueAt(tabelDHKP.getSelectedRow(), 2).toString();
    }//GEN-LAST:event_tabelDHKPMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
     panel6_tambah tambah = new panel6_tambah();
     content.removeAll();
     content.repaint();
     content.add(tambah);
     content.repaint();
     content.revalidate();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseClicked
        // TODO add your handling code here:
        if (pencarian.getText().equals("")||
            pencarian.getText().equals("Cari..")) {
            JOptionPane.showMessageDialog(this, "silahkan pilih data yang akan dihapus");

        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "data ini akan dihapus, lanjutkan?","konfirmasi",JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = k.con.createStatement();
                    String sql = "DELETE FROM dhkp WHERE nop = '"+pencarian.getText()+"'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                    sementara.setVisible(false);
                    refreshTable();
                    pencarian.setText("Cari...");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }
        }
    }//GEN-LAST:event_btnhapusMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        int jawab = JOptionPane.showConfirmDialog(null, "data ini akan dihapus, lanjutkan?","konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == 0) {
            String pilih=(String)tabelDHKP.getValueAt(tabelDHKP.getSelectedRow(), 2).toString();
            try {
                st = k.con.createStatement();
                String sql = "DELETE FROM dhkp WHERE nop = '"+pilih+"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                sementara.setVisible(false);
                refreshTable();
                pencarian.setText("Cari...");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/laporan/laporan_dhkp.jasper"), null, k.getCon());
            JasperViewer viewer = new JasperViewer(jp,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btncetakActionPerformed

    private void pencarianFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pencarianFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_pencarianFocusLost

    private void pencarianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pencarianMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pencarianMouseClicked

    private void pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pencarianActionPerformed

    private void pencarianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pencarianKeyPressed

    private void pencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyTyped
        // TODO add your handling code here:
        pencarian3();
    }//GEN-LAST:event_pencarianKeyTyped

    private void cmbdusundhkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdusundhkpActionPerformed
        // TODO add your handling code here:
        filterdhkp();
    }//GEN-LAST:event_cmbdusundhkpActionPerformed

    private void iconcari1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconcari1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_iconcari1MouseClicked

    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked
        // TODO add your handling code here:
        refreshTable();
        sementara.setVisible(false);
        pencarian.setText("Cari...");
    }//GEN-LAST:event_btnrefreshMouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // remove panel
        panel8_edit edit= new panel8_edit();
        content.removeAll();
        content.repaint();        
        //add panel
        content.add(edit);
        content.repaint();
        content.revalidate();
        
        StringSelection stringSelection = new StringSelection (sementara.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);               
    }//GEN-LAST:event_btneditActionPerformed

    private void cmbdusundhkpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbdusundhkpMouseClicked
        pencarian3();
    }//GEN-LAST:event_cmbdusundhkpMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncetak;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JLabel btnrefresh;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbdusundhkp;
    private javax.swing.JPanel content;
    private javax.swing.JLabel iconcari1;
    private javax.swing.JLabel jLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private custom.PanelShadow panelShadow1;
    private custom.PanelShadow panelShadow3;
    private javax.swing.JTextField pencarian;
    private javax.swing.JLabel sementara;
    private javax.swing.JTable tabelDHKP;
    // End of variables declaration//GEN-END:variables
}
