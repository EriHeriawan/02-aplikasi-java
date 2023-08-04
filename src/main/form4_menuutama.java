package main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import test.MenuItem;
public class form4_menuutama extends javax.swing.JFrame {

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    private String user,foto,nama;
    private String tampil_tgl;
    public form4_menuutama() {
        initComponents();
        tampiltanggal();
                
//        header_1();
       
        pn_content.putClientProperty(FlatClientProperties.STYLE, "arc:20");
//        pn_navbar.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(151, 13, 0,30)));
        pn_content.repaint();
        pn_content.add(new panel1_menuutama());
        pn_content.revalidate();
        execute();
        
    }

     /**
     * @return the tampil_tgl
     */
    public String getTampil_tgl( ) {
        return tampil_tgl;
    }
    
    public void tampiltanggal(){
        Date tglsekarang =  new Date();
        SimpleDateFormat simpledate = new SimpleDateFormat("EEEE,dd MMMMMMMMM yyyy", Locale.getDefault());
        String tgl = simpledate.format(tglsekarang);
        
        tanggal.setText(" "+tgl);
        
    }
    
    void setUsername(String user) {
       
        this.setUser(user);
    }
    
    void setFoto(String foto) {
       
        this.foto = foto;
    }
    
    void setNama(String nama) {
        this.nama = nama;
//        
    }

    public void refreshFoto(){
        try {
            //konversi nama file
            File f = new File(this.foto);
            ImageIcon icon = new ImageIcon((f.toString()));
            
            //ukuranlabel
            int labelWidth  = 110;
            int labelHeight = 110;
            
            //ukuran aslli
            int imageWidth  = icon.getIconWidth();
            int imageHeight = icon.getIconHeight();
            
            //hitung skala
            double scaleX = (double) labelWidth/ (double) imageWidth;
            double scaleY = (double) labelHeight/ (double) imageHeight;
            double skala  = Math.min(scaleX, scaleY);
            //ubah ukurangambar
            Image img  = icon.getImage().getScaledInstance((int)(skala * imageWidth),(int) (skala * imageHeight), Image.SCALE_SMOOTH);
            
            //tampil foto
            imgfoto.setImage(new javax.swing.ImageIcon((img)));
            userName.setText(user);
            Nama.setText(nama);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    public void maksimal(KeyEvent evt) {                                   
        if(evt.getKeyCode() == KeyEvent.VK_F12){
                JFrame frame = new JFrame();
                frame.setExtendedState(MAXIMIZED_BOTH);
            }else{
            JOptionPane.showMessageDialog(null, evt);
        }
    } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbar = new custom.panel1();
        jLabel2 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        panelShadow3 = new custom.PanelShadow();
        tanggal = new javax.swing.JLabel();
        panelShadow2 = new custom.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_menu = new javax.swing.JPanel();
        pn_profil = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        userName = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        imgfoto = new test.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        pn_content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.title")); // NOI18N
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 750));

        navbar.setBackground(new java.awt.Color(17, 80, 76));
        navbar.setPreferredSize(new java.awt.Dimension(1222, 80));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.jLabel2.text")); // NOI18N

        btnlogout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setting-30.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnlogout, org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.btnlogout.text")); // NOI18N
        btnlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });

        panelShadow3.setBackground(new Color(255,255,255,80));

        tanggal.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(tanggal, org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.tanggal.text")); // NOI18N

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addContainerGap(933, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogout)
                .addGap(21, 21, 21))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnlogout))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(navbar, java.awt.BorderLayout.PAGE_START);

        panelShadow2.setBackground(new java.awt.Color(42, 122, 111));
        panelShadow2.setPreferredSize(new java.awt.Dimension(230, 900));

        jScrollPane1.setBorder(null);

        pn_menu.setBackground(new java.awt.Color(42, 122, 111));
        pn_menu.setLayout(new javax.swing.BoxLayout(pn_menu, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(pn_menu);

        pn_profil.setBackground(new Color(0,0,0,0));
        pn_profil.setOpaque(false);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        userName.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(userName, org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.userName.text")); // NOI18N

        Nama.setForeground(new java.awt.Color(204, 204, 204));
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(Nama, org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.Nama.text")); // NOI18N

        imgfoto.setBorderSize(2);
        imgfoto.setBorderSpace(1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/verified-badge-30.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(form4_menuutama.class, "form4_menuutama.jLabel1.text")); // NOI18N
        imgfoto.add(jLabel1);
        jLabel1.setBounds(90, 90, 30, 30);

        javax.swing.GroupLayout pn_profilLayout = new javax.swing.GroupLayout(pn_profil);
        pn_profil.setLayout(pn_profilLayout);
        pn_profilLayout.setHorizontalGroup(
            pn_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pn_profilLayout.createSequentialGroup()
                .addGroup(pn_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addGroup(pn_profilLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(imgfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_profilLayout.setVerticalGroup(
            pn_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_profilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nama)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_profil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(panelShadow2, java.awt.BorderLayout.LINE_START);

        content.setBackground(new Color (0,0,0,0));
        content.setPreferredSize(new java.awt.Dimension(1000, 983));

        pn_content.setPreferredSize(new java.awt.Dimension(934, 661));
        pn_content.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pn_content, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_content, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        dialog1_menulogout menu = new dialog1_menulogout(this, true,this);
          
        Point p =btnlogout.getLocationOnScreen();
        int x = p.x + btnlogout.getWidth() - menu.getWidth();
        int y = p.y + btnlogout.getHeight();
        menu.setLocation(x, y);
        menu.setVisible(true);
        
//        int dialogbtn = JOptionPane.YES_NO_OPTION;
//        int dialgResult = JOptionPane.showConfirmDialog(this,"Anda yakin ingin Logout?","Logout", dialogbtn);
//        if (dialgResult==0) {
//                dispose();
//                new form2_loginadmin().setVisible(true);
//        }else{
//            
//        }
    }//GEN-LAST:event_btnlogoutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form4_menuutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JPanel content;
    private test.ImageAvatar imgfoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private custom.panel1 navbar;
    private custom.PanelShadow panelShadow2;
    private custom.PanelShadow panelShadow3;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_profil;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
    private void execute() {
        //icon set
        ImageIcon iconBeranda       = new ImageIcon(getClass().getResource("/icon/1.png"));
        ImageIcon iconDHKP          = new ImageIcon(getClass().getResource("/icon/2.png"));
        ImageIcon iconpenundaan     = new ImageIcon(getClass().getResource("/icon/3.png"));
        ImageIcon iconPembayaran    = new ImageIcon(getClass().getResource("/icon/4.png"));
        ImageIcon iconLaporan       = new ImageIcon(getClass().getResource("/icon/5.png"));
        
        ImageIcon icontambah        = new ImageIcon(getClass().getResource("/icon/16.png"));
        ImageIcon iconedit          = new ImageIcon(getClass().getResource("/icon/17.png"));        
        ImageIcon iconimport        = new ImageIcon(getClass().getResource("/icon/18.png"));        
        
                    
        //submenu item
        MenuItem tambahdhkp       = new MenuItem(null,true,icontambah, "Tambah", new ActionListener(){ // submenu tambah dhkp

            @Override
            public void actionPerformed(ActionEvent ae) {
                pn_content.removeAll();
                pn_content.add(new panel6_tambah());
                pn_content.repaint();
                pn_content.revalidate();
            }
        }
        );
        MenuItem editdhkp       = new MenuItem(null,true,iconedit, "Edit", new ActionListener() { // submenu edit dhkp

            @Override
            public void actionPerformed(ActionEvent ae) {
              pn_content.removeAll();
                pn_content.add(new panel8_edit());
                pn_content.repaint();
                pn_content.revalidate();  
            }
        }
        );
         MenuItem importexcel       = new MenuItem(null,true,iconimport, "Import Excel", new ActionListener(){ // import data

            @Override
            public void actionPerformed(ActionEvent ae) {
                pn_content.removeAll();
                pn_content.add(new panel7_importexcel());
                pn_content.repaint();
                pn_content.revalidate();  
            }
        }
         );
         
         //menu item
        
        MenuItem menuBeranda    = new MenuItem(iconBeranda  , false, null, "Beranda", new ActionListener() { // menuitem beranda

            @Override
            public void actionPerformed(ActionEvent ae) {
                pn_content.removeAll();
                pn_content.add(new panel1_menuutama());
                pn_content.repaint();
                pn_content.revalidate();
               
            }
        });
        
        
        MenuItem menuDHKP       = new MenuItem(iconDHKP     , false, null,"DHKP", new ActionListener() { // menuitem Dhkp

            @Override
            public void actionPerformed(ActionEvent ae) {
                pn_content.removeAll();
                panel2_dhkp pn= new panel2_dhkp();
                pn.refreshTable();
                pn_content.add(pn);
                pn_content.repaint();
                pn_content.revalidate();
            }

        }
                ,tambahdhkp,editdhkp,importexcel);
        MenuItem menuPenundaan  = new MenuItem(iconpenundaan, false, null, "Penundaan", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pn_content.removeAll();
                panel3_penundaan pnd =new panel3_penundaan();
                pnd.penundaan();
                pn_content.add(pnd);
                pn_content.repaint();
                pn_content.revalidate();
            }
        });
        MenuItem menuPembayaran = new MenuItem(iconPembayaran, false, null,"pembayaran", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pn_content.removeAll();
                pn_content.add(new panel4_pembayaran());
                pn_content.repaint();
                pn_content.revalidate();
            }
        } );
        MenuItem menuLaporan    = new MenuItem(iconLaporan  , false, null,"Laporan", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               pn_content.removeAll();
                pn_content.add(new panel5_laporan());
                pn_content.repaint();
                pn_content.revalidate();
            }
        } );
        
        addmenu(
                menuBeranda,menuDHKP,menuPenundaan,menuPembayaran,menuLaporan);
        
        
    }

    public JPanel getPn_content() {
        return pn_content;
    }
    
    private void execute1() {
        //icon set
        ImageIcon iconBeranda       = new ImageIcon(getClass().getResource("/icon/1.png"));
        ImageIcon iconDHKP          = new ImageIcon(getClass().getResource("/icon/2.png"));
        ImageIcon iconpenundaan     = new ImageIcon(getClass().getResource("/icon/3.png"));
        ImageIcon iconPembayaran    = new ImageIcon(getClass().getResource("/icon/4.png"));
        ImageIcon iconLaporan       = new ImageIcon(getClass().getResource("/icon/5.png"));
        
        ImageIcon icontambah        = new ImageIcon(getClass().getResource("/icon/6.png"));
        ImageIcon iconedit          = new ImageIcon(getClass().getResource("/icon/7.png"));        
        ImageIcon iconimport        = new ImageIcon(getClass().getResource("/icon/8.png"));        
        
                    
        //submenu item
        MenuItem tambahdhkp       = new MenuItem(null,true,icontambah, "Tambah", null);
        MenuItem editdhkp       = new MenuItem(null,true,iconedit, "Edit", null);
        MenuItem importexcel       = new MenuItem(null,true,iconimport, "Edit", null);
         
         //menu item
        MenuItem menuBeranda    = new MenuItem(iconBeranda  , false, null, "Beranda",null);
        MenuItem menuDHKP       = new MenuItem(iconDHKP     , false, null,"DHKP", null,tambahdhkp,editdhkp,importexcel);
        MenuItem menuPenundaan  = new MenuItem(iconpenundaan, false, null, "Penundaan",null);
        MenuItem menuPembayaran = new MenuItem(iconPembayaran, false, null,"pembayaran",null);
        MenuItem menuLaporan    = new MenuItem(iconLaporan  , false, null,"Laporan",null);
        
        addmenu(menuBeranda,menuDHKP,menuPenundaan,menuPembayaran,menuLaporan);
        
        
    }
    
    private void addmenu(MenuItem... menu){
        for (int i = 0; i < menu.length; i++) {
            pn_menu.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addmenu(m);
            }
            
            
        }
        pn_menu.revalidate();
    }

   

}
