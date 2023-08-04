
package main;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class panel4_pembayaran extends javax.swing.JPanel {

    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    private DefaultTableModel model = null;
    private String username,  foto;
    private Statement st;
    int insertedRows = 0;
    private final int noColumnIndex = 0;
    private final int noColumnWidth= 50;
    public panel4_pembayaran() {
        
        initComponents();
        jPanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(0, 51, 51)));
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        
        btnbelum.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btnlunas.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        btncetakbayar.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
        
        tampiltanggal();
        tampiltahun();
        setColumnwidth();
        k.connect();
        pembayaran();
        panelpembayaran.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        pencarian.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        rp.setVisible(false);
        nop.setVisible(false);
    }

   public void filter(){
       
        String cmb_filter = (String) cmbdusunpemb.getSelectedItem();
        if (cmb_filter == "SATU") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun ");
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+cmb_filter+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tabelpembayaran.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        } else if (cmb_filter == "DUA") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun ");
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+cmb_filter+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tabelpembayaran.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }else if (cmb_filter == "TIGA") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun ");
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where dusun='"+cmb_filter+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tabelpembayaran.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         
        }else{
            pembayaran();
        }
    }
   
   public void pembayaran(){
        java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
               
        try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun "+thn);
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            String Rp =rp.getText();
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp ");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    Rp+rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tabelpembayaran.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
   
   private void setColumnwidth() {
        TableColumnModel columnModel =tabelpembayaran.getColumnModel();
        
        columnModel.getColumn(noColumnIndex).setPreferredWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMaxWidth(noColumnWidth);
        columnModel.getColumn(noColumnIndex).setMinWidth(noColumnWidth);
    }
   
    public void pencarianpembayaran(){
        java.util.Date thunsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(thunsekarang);
        
        int no =1;
        try {
            DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun "+thn);
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            String sql = "Select * from dhkp where nop like '%" + nop.getText() + "%'" +
                    "or nama like '%" + nop.getText() + "%'";
            Statement stat = k.getCon().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                model.addRow(new Object[]{
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    rs.getString("pbb_dibayar"),
                    rs.getString("status")                   
                });
            }
            tabelpembayaran.setModel(model);
            setColumnwidth();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }
    
    public void bayar(){
        
        if (bayar.getText().equals("LUNAS")) {
            nop.setText(tabelpembayaran.getValueAt(tabelpembayaran.getSelectedRow(), 1).toString());
            bayar.setText("BELUM BAYAR");
            
            try {
                    st = k.con.createStatement();
                    String sql = "update dhkp set status ='"+bayar.getText()+"'"+ "where nop= '"+nop.getText()+"'";
                   
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "Pembayaran berhasil");
                    
                    pembayaran();
                    
                    bayar.setVisible(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
        } else {bayar.getText().equals("BELUM BAYAR");
                nop.setText(tabelpembayaran.getValueAt(tabelpembayaran.getSelectedRow(), 1).toString());
                bayar.setText("LUNAS");
                try {
                    st = k.con.createStatement();
                    String sql = "update dhkp set status ='"+bayar.getText()+"'"+ "where nop= '"+nop.getText()+"'";
                   
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "Pembayaran berhasil");
                    
                    pembayaran();
                    
                    bayar.setVisible(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
        }
        
        
    }
  
    public void filterpembayaran(){
        String cmb_status = (String) cmbstatuspemb.getSelectedItem();
        String cmb_dusun = (String) cmbdusunpemb.getSelectedItem();
        if (cmb_status == "BELUM BAYAR") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun ");
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where status='"+cmb_status+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tabelpembayaran.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        } else if (cmb_status == "LUNAS") {
            
            try {
              DefaultTableModel model = new DefaultTableModel();
            
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun ");
            model.addColumn("Status Pembayaran"); 
            
            tabelpembayaran.setModel(model);
            
            
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp where status='"+cmb_status+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),                    
                    rs.getString("pbb_dibayar"),
                    rs.getString("status")
                   };
                model.addRow(data);
                tabelpembayaran.setModel(model);
                setColumnwidth();
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
            
        }else{
               pembayaran();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelpembayaran = new javax.swing.JPanel();
        panelShadow1 = new custom.PanelShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpembayaran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bayar = new javax.swing.JTextField();
        cmbstatuspemb = new javax.swing.JComboBox<>();
        cmbdusunpemb = new javax.swing.JComboBox<>();
        panelShadow3 = new custom.PanelShadow();
        pencarian = new javax.swing.JTextField();
        iconcari = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btncetakbayar = new javax.swing.JButton();
        btnbelum = new javax.swing.JButton();
        btnlunas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rp = new javax.swing.JLabel();
        nop = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(935, 661));

        panelpembayaran.setBackground(new java.awt.Color(255, 255, 255));
        panelpembayaran.setPreferredSize(new java.awt.Dimension(934, 661));

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        tabelpembayaran.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabelpembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Dusun", "Nomor Blok-PBB", "Nama Wajib Pajak", "PBB yang dibayar tahun 2023"
            }
        ));
        tabelpembayaran.setGridColor(new Color(0,0,0,0));
        tabelpembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpembayaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelpembayaran);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        bayar.setBackground(new Color(0,0,0,0));
        bayar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bayar.setBorder(null);
        bayar.setOpaque(false);

        cmbstatuspemb.setBackground(new java.awt.Color(255, 255, 255));
        cmbstatuspemb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BELUM BAYAR", "LUNAS", " " }));
        cmbstatuspemb.setSelectedIndex(-1);
        cmbstatuspemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstatuspembActionPerformed(evt);
            }
        });

        cmbdusunpemb.setBackground(new java.awt.Color(255, 255, 255));
        cmbdusunpemb.setForeground(new java.awt.Color(0, 0, 0));
        cmbdusunpemb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SATU", "DUA", "TIGA", " " }));
        cmbdusunpemb.setSelectedIndex(-1);
        cmbdusunpemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdusunpembActionPerformed(evt);
            }
        });

        panelShadow3.setShadowOpacity(0.3F);
        panelShadow3.setShadowSize(4);

        pencarian.setBackground(new Color(0,0,0,0));
        pencarian.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        pencarian.setText(org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.pencarian.text")); // NOI18N
        pencarian.setBorder(null);
        pencarian.setOpaque(false);
        pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianActionPerformed(evt);
            }
        });
        pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pencarianKeyTyped(evt);
            }
        });

        iconcari.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        iconcari.setForeground(java.awt.Color.white);
        iconcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-human-research-program-30 (1).png"))); // NOI18N
        iconcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbdusunpemb, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbstatuspemb, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbstatuspemb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbdusunpemb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(74, 145, 132));
        jPanel4.setPreferredSize(new java.awt.Dimension(345, 59));

        btncetakbayar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btncetakbayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/14.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btncetakbayar, org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.btncetakbayar.text")); // NOI18N
        btncetakbayar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncetakbayar.setIconTextGap(10);
        btncetakbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakbayarActionPerformed(evt);
            }
        });

        btnbelum.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnbelum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-cancel-30.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnbelum, org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.btnbelum.text")); // NOI18N
        btnbelum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbelum.setIconTextGap(10);
        btnbelum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbelumActionPerformed(evt);
            }
        });

        btnlunas.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnlunas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-ok-30.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnlunas, org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.btnlunas.text")); // NOI18N
        btnlunas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlunas.setIconTextGap(10);
        btnlunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlunasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(rp, org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.rp.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nop, org.openide.util.NbBundle.getMessage(panel4_pembayaran.class, "panel4_pembayaran.nop.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(nop, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(rp)
                .addGap(51, 51, 51)
                .addComponent(btnlunas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbelum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btncetakbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncetakbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbelum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnlunas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rp)))
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2)
                        .addGap(12, 12, 12))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelpembayaranLayout = new javax.swing.GroupLayout(panelpembayaran);
        panelpembayaran.setLayout(panelpembayaranLayout);
        panelpembayaranLayout.setHorizontalGroup(
            panelpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelpembayaranLayout.setVerticalGroup(
            panelpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpembayaranLayout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelpembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelpembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbdusunpembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdusunpembActionPerformed
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_cmbdusunpembActionPerformed

    private void tabelpembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpembayaranMouseClicked
        // TODO add your handling code here:

        nop.setText(tabelpembayaran.getValueAt(tabelpembayaran.getSelectedRow(), 1).toString());
        bayar.setText(tabelpembayaran.getValueAt(tabelpembayaran.getSelectedRow(), 5).toString());
        
    }//GEN-LAST:event_tabelpembayaranMouseClicked

    public void tampiltanggal(){
        Date tglsekarang =  new Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("EEEE,dd MMMMMMMMM yyyy", Locale.getDefault());
        String tgl = simpledate.format(tglsekarang);
        
//        tanggal.setText(tgl);
        
    }
    
    public void tampiltahun(){
        java.util.Date tglsekarang =  new java.util.Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy", Locale.getDefault());
        String thn = simpledate.format(tglsekarang);
//        tahun.setText(thn);
        
    }
    
    
    private void btnbelumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbelumActionPerformed
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_btnbelumActionPerformed

    private void btnlunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlunasActionPerformed
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_btnlunasActionPerformed

    private void btncetakbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakbayarActionPerformed
        // TODO add your handling code here:
        try{
            String file =("/laporan/laporan_pembayaran.jasper");
            
            JasperPrint jasv = JasperFillManager.fillReport(getClass().getResourceAsStream(file), null,k.getCon());
//            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/laporan/lap_laporan.jasper"), null, k.getCon());
            JasperViewer viewer = new JasperViewer(jasv,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btncetakbayarActionPerformed

    private void cmbstatuspembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstatuspembActionPerformed
        // TODO add your handling code here:
        filterpembayaran();
    }//GEN-LAST:event_cmbstatuspembActionPerformed

    private void pencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyTyped
        // TODO add your handling code here:
        pencarianpembayaran();
    }//GEN-LAST:event_pencarianKeyTyped

    private void pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianActionPerformed
        // TODO add your handling code here:
        pembayaran();
    }//GEN-LAST:event_pencarianActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if (cmbdusunpemb.getSelectedItem()=="SATU"
                ||cmbdusunpemb.getSelectedItem()=="DUA"
                ||cmbdusunpemb.getSelectedItem()=="TIGA"
                ||cmbstatuspemb.getSelectedItem()=="LUNAS"
                ||cmbstatuspemb.getSelectedItem()=="BELUM BAYAR") {
            cmbdusunpemb.setSelectedIndex(3);
            cmbstatuspemb.setSelectedIndex(2);
            pembayaran();
        } else {
            System.out.println("kosong");
        }
        
    }//GEN-LAST:event_jPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JButton btnbelum;
    private javax.swing.JButton btncetakbayar;
    private javax.swing.JButton btnlunas;
    private javax.swing.JComboBox<String> cmbdusunpemb;
    private javax.swing.JComboBox<String> cmbstatuspemb;
    private javax.swing.JLabel iconcari;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nop;
    private custom.PanelShadow panelShadow1;
    private custom.PanelShadow panelShadow3;
    private javax.swing.JPanel panelpembayaran;
    private javax.swing.JTextField pencarian;
    private javax.swing.JLabel rp;
    private javax.swing.JTable tabelpembayaran;
    // End of variables declaration//GEN-END:variables
}
