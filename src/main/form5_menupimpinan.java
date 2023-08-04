package main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Point;
import test.MenuLogout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class form5_menupimpinan extends javax.swing.JFrame {
    private String user,jabatan;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public form5_menupimpinan() {
        initComponents();
        jsp6.setVisible(false);
        k.connect();
        refreshTable();
        btnberanda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255,10)));
        btnlaporan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255,10)));
        jPanel2.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        jPanel3.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        jmap.putClientProperty(FlatClientProperties.STYLE, "arc:20");
    }
// void setUsername(String user) {       
//        this.user = user;
//    }
// void setJabatan(String jabatan) {       
//        this.jabatan = jabatan;
//    }
    
    public void refreshTable(){
        
        try {
            DefaultTableModel model = new DefaultTableModel();
            
            model.addColumn("No.");
            model.addColumn("Nop");
            model.addColumn("Nama WP");
            model.addColumn("Dusun");            
            model.addColumn("PBB yang dibayar tahun ");
            model.addColumn("Status Pembayaran"); 
           
            tabelpembayaran1.setModel(model);
        
            int no = 1;
            
            this.stat = k.getCon().prepareStatement("SELECT * FROM dhkp ORDER BY nop ASC ");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                    no ++,
                    rs.getString("nop"),
                    rs.getString("nama"),
                    rs.getString("dusun"),
                    rs.getString("pbb_dibayar"),
                    rs.getString("status"),
                    };
                model.addRow(data);
                getsum();
                tabelpembayaran1.setModel(model);
                                       }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
     public void getsum(){
        DefaultTableModel dataModel = (DefaultTableModel) tabelpembayaran1.getModel();
        int jumlah = dataModel.getRowCount();
        double total =0;
      
        
        for (int i = 0; i < jumlah; i++) {
            double dataBerat = Double.valueOf(dataModel.getValueAt(i, 4).toString());
            
            total += dataBerat;
            
        }
        
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

formatRp.setCurrencySymbol("Rp. ");
formatRp.setMonetaryDecimalSeparator(',');
formatRp.setGroupingSeparator('.');

kursIndonesia.setDecimalFormatSymbols(formatRp);

        jljumlah.setText(Integer.toString(jumlah));
        jltotal.setText(kursIndonesia.format(total));
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_sidebar = new javax.swing.JPanel();
        pn_profil = new javax.swing.JPanel();
        tJabatan = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        imgfoto = new test.ImageAvatar();
        jLabel3 = new javax.swing.JLabel();
        btnlaporan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnberanda = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pn_content = new javax.swing.JPanel();
        pn_navbar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelberanda = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlpen = new javax.swing.JLabel();
        jltotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jldhkp = new javax.swing.JLabel();
        jljumlah = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jmap = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        linkgmap = new javax.swing.JLabel();
        jsp6 = new javax.swing.JScrollPane();
        tabelpembayaran1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi PBB");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/pbb.png")).getImage());

        pn_sidebar.setBackground(new java.awt.Color(42, 122, 111));
        pn_sidebar.setPreferredSize(new java.awt.Dimension(160, 490));

        pn_profil.setBackground(new java.awt.Color(42, 122, 111));
        pn_profil.setPreferredSize(new java.awt.Dimension(0, 237));
        pn_profil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tJabatan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tJabatan.setForeground(java.awt.Color.lightGray);
        tJabatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tJabatan.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "myheader.nama.text_1")); // NOI18N
        tJabatan.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pn_profil.add(tJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 227, -1));

        userName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userName.setText("Pimpinan");
        pn_profil.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 156, 230, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        pn_profil.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 232, 230, 10));

        imgfoto.setBorderSize(1);
        imgfoto.setBorderSpace(1);
        imgfoto.setGradientColor1(new java.awt.Color(0, 255, 255));
        imgfoto.setGradientColor2(new java.awt.Color(255, 0, 51));
        imgfoto.setImage(new javax.swing.ImageIcon(getClass().getResource("/upload/Admin.jpeg"))); // NOI18N
        pn_profil.add(imgfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btn3.png"))); // NOI18N
        pn_profil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, 150));

        btnlaporan.setBackground(new java.awt.Color(42, 122, 111));
        btnlaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlaporanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnlaporanMousePressed(evt);
            }
        });
        btnlaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Laporan");
        btnlaporan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 50, 45));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/5.png"))); // NOI18N
        btnlaporan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 45, 45));

        btnberanda.setBackground(new java.awt.Color(42, 122, 111));
        btnberanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnberandaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnberandaMousePressed(evt);
            }
        });
        btnberanda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Beranda");
        btnberanda.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 50, 45));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1.png"))); // NOI18N
        btnberanda.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 45, 45));

        javax.swing.GroupLayout pn_sidebarLayout = new javax.swing.GroupLayout(pn_sidebar);
        pn_sidebar.setLayout(pn_sidebarLayout);
        pn_sidebarLayout.setHorizontalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnberanda, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pn_sidebarLayout.setVerticalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addComponent(pn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnberanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_sidebarLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_content.setBackground(new java.awt.Color(153, 153, 153));
        pn_content.setLayout(new java.awt.CardLayout());

        pn_navbar.setBackground(new java.awt.Color(42, 122, 111));
        pn_navbar.setPreferredSize(new java.awt.Dimension(0, 60));

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-logout-30.png"))); // NOI18N
        jLabel1.setText("Logout");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setIconTextGap(8);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_navbarLayout = new javax.swing.GroupLayout(pn_navbar);
        pn_navbar.setLayout(pn_navbarLayout);
        pn_navbarLayout.setHorizontalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_navbarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        pn_navbarLayout.setVerticalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelberanda.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel1.text")); // NOI18N

        jPanel2.setBackground(new java.awt.Color(42, 122, 111));

        jlpen.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jlpen.setForeground(new java.awt.Color(255, 255, 255));
        jlpen.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jlpen.text")); // NOI18N

        jltotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jltotal.setForeground(new java.awt.Color(255, 255, 255));
        jltotal.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jltotal.text")); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-salary-40.png"))); // NOI18N
        jLabel12.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel12.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57)))
                .addGap(71, 71, 71)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addGap(16, 16, 16))
        );

        jPanel3.setBackground(new java.awt.Color(42, 122, 111));

        jldhkp.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jldhkp.setForeground(new java.awt.Color(255, 255, 255));
        jldhkp.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jldhkp.text")); // NOI18N

        jljumlah.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jljumlah.setForeground(new java.awt.Color(255, 255, 255));
        jljumlah.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jljumlah.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel2.text")); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-crowd-40.png"))); // NOI18N
        jLabel11.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel11.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jldhkp, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jljumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jldhkp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jljumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGap(21, 21, 21))
        );

        jmap.setBackground(new java.awt.Color(42, 122, 111));
        jmap.setForeground(new Color (255,255,255,100));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group 24.png"))); // NOI18N
        jLabel7.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel7.text")); // NOI18N

        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel6.text")); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.jLabel10.text")); // NOI18N

        linkgmap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        linkgmap.setText(org.openide.util.NbBundle.getMessage(form5_menupimpinan.class, "panel1_menuutama.linkgmap.text")); // NOI18N
        linkgmap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkgmapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                linkgmapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                linkgmapMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jmapLayout = new javax.swing.GroupLayout(jmap);
        jmap.setLayout(jmapLayout);
        jmapLayout.setHorizontalGroup(
            jmapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jmapLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(linkgmap, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jmapLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(jmapLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jmapLayout.setVerticalGroup(
            jmapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jmapLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jmapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(linkgmap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabelpembayaran1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabelpembayaran1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpembayaran1.setGridColor(new Color(0,0,0,0));
        jsp6.setViewportView(tabelpembayaran1);

        javax.swing.GroupLayout panelberandaLayout = new javax.swing.GroupLayout(panelberanda);
        panelberanda.setLayout(panelberandaLayout);
        panelberandaLayout.setHorizontalGroup(
            panelberandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelberandaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelberandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelberandaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(736, 736, 736))
                    .addGroup(panelberandaLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(panelberandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelberandaLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jmap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jsp6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(176, 176, 176))))
        );
        panelberandaLayout.setVerticalGroup(
            panelberandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelberandaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelberandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jsp6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jmap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelberanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_navbar, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(pn_content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pn_navbar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panelberanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pn_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        MenuLogout menu = new MenuLogout(this, true,null);
        Point p = jLabel1.getLocationOnScreen();
        
        int x = p.x + jLabel1.getWidth()-menu.getWidth();
        int y = p.y + jLabel1.getHeight();
        menu.setLocation(x, y);
        menu.setVisible(true);
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void linkgmapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkgmapMouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://goo.gl/maps/ti8fTJ4xgf65PVnN7").toURI());
        } catch (Exception e) {}
    }//GEN-LAST:event_linkgmapMouseClicked

    private void linkgmapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkgmapMouseEntered
        // TODO add your handling code here:
        Font font = linkgmap.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        linkgmap.setFont(font.deriveFont(attribut));
        linkgmap.setForeground(Color.blue);
    }//GEN-LAST:event_linkgmapMouseEntered

    private void linkgmapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkgmapMouseExited
        // TODO add your handling code here:
        Font font = linkgmap.getFont();
        Map attribut = font.getAttributes();
        attribut.put(TextAttribute.UNDERLINE, TextAttribute.TRANSFORM);
        linkgmap.setFont(font.deriveFont(attribut));
        linkgmap.setForeground(new Color (187,187,187));
    }//GEN-LAST:event_linkgmapMouseExited

    private void btnberandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnberandaMouseClicked
        btnberanda.setBackground(Color.orange);
        pn_content.removeAll();
        pn_content.repaint();
        pn_content.add(panelberanda);
        pn_content.repaint();
        pn_content.revalidate();
    }//GEN-LAST:event_btnberandaMouseClicked

    private void btnberandaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnberandaMousePressed
        btnberanda.setBackground(new Color(56, 56, 56));
    }//GEN-LAST:event_btnberandaMousePressed

    private void btnlaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlaporanMouseClicked
        btnlaporan.setBackground(Color.orange);
         pn_content.removeAll();
        pn_content.repaint();
        panel5_laporan nn = new panel5_laporan();
        pn_content.add(nn);
        pn_content.repaint();
        pn_content.revalidate();
    }//GEN-LAST:event_btnlaporanMouseClicked

    private void btnlaporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlaporanMousePressed
        btnlaporan.setBackground(new Color(56, 56, 56));
    }//GEN-LAST:event_btnlaporanMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form5_menupimpinan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnberanda;
    private javax.swing.JPanel btnlaporan;
    private test.ImageAvatar imgfoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jldhkp;
    private javax.swing.JLabel jljumlah;
    private javax.swing.JLabel jlpen;
    private javax.swing.JLabel jltotal;
    private javax.swing.JPanel jmap;
    private javax.swing.JScrollPane jsp6;
    private javax.swing.JLabel linkgmap;
    private javax.swing.JPanel panelberanda;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_navbar;
    private javax.swing.JPanel pn_profil;
    private javax.swing.JPanel pn_sidebar;
    private javax.swing.JLabel tJabatan;
    private javax.swing.JTable tabelpembayaran1;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables

    void setUsername(String user) {
        this.user = user;
    }

    void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
