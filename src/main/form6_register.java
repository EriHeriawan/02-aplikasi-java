package main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.AlphaComposite;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;

public class form6_register extends javax.swing.JFrame {

    private PreparedStatement stat;
    private ResultSet rs;
    private String filename;
    private Statement st;
    koneksi k = new koneksi();
    
    public form6_register() {
        initComponents();
        k.connect();
        
        txtnama.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama");
        txtuser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        password.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Passsword");
        idadmin();
        rounded();
        unhide.setVisible(false);
        idadmin.setEnabled(false);
    }

    
    class akun extends form6_register{
        String id="", nama="", user="", pass="", foto="";
        
        public akun(){            
            id = idadmin.getText();
            nama = txtnama.getText();
            user = txtuser.getText();
            pass = place2.getText();
          }
    }
        
    public void rounded(){
        idadmin.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtnama.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtuser.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        password.putClientProperty(FlatClientProperties.STYLE, "arc:10");
    } 
    
    public static String getMd5(String input)
	{
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

    
    public void idadmin(){

          try {
            st = k.con.createStatement();
            String sql = "SELECT * FROM admin ORDER BY id_admin DESC";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String kd_barang = rs.getString("id_admin").substring(1);
                String AN = "" + (Integer.parseInt(kd_barang) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idadmin.setText("B" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idadmin.setText("B0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       }
     public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
    int w = image.getWidth();
    int h = image.getHeight();
    BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2 = output.createGraphics();
    
    // This is what we want, but it only does hard-clipping, i.e. aliasing
    // g2.setClip(new RoundRectangle2D ...)

    // so instead fake soft-clipping by first drawing the desired clip shape
    // in fully opaque white with antialiasing enabled...
    g2.setComposite(AlphaComposite.Src);
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(Color.WHITE);
    g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
    
    // ... then compositing the image on top,
    // using the white shape from above as alpha source
    g2.setComposite(AlphaComposite.SrcAtop);
    g2.drawImage(image, 0, 0, null);
    
    g2.dispose();
    
    return output;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnama = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        idadmin = new javax.swing.JTextField();
        hide = new javax.swing.JLabel();
        unhide = new javax.swing.JLabel();
        labelfoto = new test.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        btnfoto1 = new javax.swing.JLabel();
        btntambah1 = new javax.swing.JLabel();
        btncancel1 = new javax.swing.JLabel();
        txtnama1 = new javax.swing.JLabel();
        place1 = new javax.swing.JLabel();
        place2 = new javax.swing.JLabel();
        bkg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnama.setBackground(new Color (0,0,0,0));
        txtnama.setForeground(java.awt.Color.white);
        txtnama.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnamaFocusLost(evt);
            }
        });
        txtnama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnamaMouseClicked(evt);
            }
        });
        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnamaKeyTyped(evt);
            }
        });
        jPanel1.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 195, 260, 30));

        txtuser.setBackground(new Color(0,0,0,0));
        txtuser.setForeground(java.awt.Color.white);
        txtuser.setCaretColor(new java.awt.Color(255, 255, 255));
        txtuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtuserFocusLost(evt);
            }
        });
        txtuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtuserMouseClicked(evt);
            }
        });
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuserKeyTyped(evt);
            }
        });
        jPanel1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 235, 260, 30));

        password.setBackground(new Color(0,0,0,0));
        password.setForeground(java.awt.Color.white);
        password.setCaretColor(new java.awt.Color(255, 255, 255));
        password.setFocusTraversalPolicyProvider(true);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 275, 260, 30));

        idadmin.setEditable(false);
        idadmin.setBackground(new java.awt.Color(51, 51, 51));
        idadmin.setForeground(java.awt.Color.white);
        idadmin.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(idadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 155, 260, 30));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-closed-eye-20.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        jPanel1.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        unhide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-eye-20.png"))); // NOI18N
        unhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unhideMouseClicked(evt);
            }
        });
        jPanel1.add(unhide, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        labelfoto.setBorderSize(1);
        labelfoto.setBorderSpace(2);
        labelfoto.setGradientColor1(new java.awt.Color(0, 51, 204));
        labelfoto.setGradientColor2(new java.awt.Color(153, 0, 153));
        jPanel1.add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 110, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-help-20.1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        btnfoto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Group 4.png"))); // NOI18N
        btnfoto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnfoto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfoto1MouseClicked(evt);
            }
        });
        jPanel1.add(btnfoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        btntambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Group 4 (1).png"))); // NOI18N
        btntambah1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntambah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambah1MouseClicked(evt);
            }
        });
        jPanel1.add(btntambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        btncancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Group 4 (2).png"))); // NOI18N
        btncancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancel1MouseClicked(evt);
            }
        });
        jPanel1.add(btncancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        txtnama1.setText("jLabel2");
        jPanel1.add(txtnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        place1.setText("jLabel3");
        jPanel1.add(place1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        place2.setText("jLabel4");
        jPanel1.add(place2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, -1, -1));

        bkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/sign up .png"))); // NOI18N
        jPanel1.add(bkg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnamaFocusLost
        // TODO add your handling code here:
        if (txtnama.getText().equals("")) {
            txtnama1.setVisible(true);
        } else {
            txtnama1.setVisible(false);
        }
    }//GEN-LAST:event_txtnamaFocusLost

    private void txtnamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnamaMouseClicked
        // TODO add your handling code here:
        txtnama1.setVisible(false);
    }//GEN-LAST:event_txtnamaMouseClicked

    private void txtnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyTyped
        // TODO add your handling code here:
        if (txtnama.getText().equals("")) {
            txtnama1.setVisible(true);
        } else  {
            txtnama1.setVisible(false);
        }
    }//GEN-LAST:event_txtnamaKeyTyped

    private void txtuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtuserFocusLost
        // TODO add your handling code here:
        if (txtuser.getText().equals("")) {
            place1.setVisible(true);

        } else {
            place1.setVisible(false);
        }
    }//GEN-LAST:event_txtuserFocusLost

    private void txtuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtuserMouseClicked
        // TODO add your handling code here:
        place1.setVisible(false);
    }//GEN-LAST:event_txtuserMouseClicked

    private void txtuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyTyped
        // TODO add your handling code here:
        if (txtuser.getText().equals("")) {
            place1.setVisible(true);

        } else {
            place1.setVisible(false);
        }
    }//GEN-LAST:event_txtuserKeyTyped

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            place2.setVisible(true);
        } else {
            place2.setVisible(false);
        }

    }//GEN-LAST:event_passwordFocusLost

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        // TODO add your handling code here:
        place2.setVisible(false);
    }//GEN-LAST:event_passwordMouseClicked

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            place2.setVisible(true);
        } else {
            place2.setVisible(false);
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void btnfoto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfoto1MouseClicked
        String s = password.getText();

        akun a = new akun();
        if (a.user.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "username dan password tidak boleh kosong");
        }else{
            try {
                JFileChooser chooser = new JFileChooser("C:\\Users\\Desktop\\Pictures\\foto");
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                ImageIcon icon = new ImageIcon(f.toString());
                
                Image img = icon.getImage().getScaledInstance(labelfoto.getWidth(),
                        labelfoto.getHeight(), Image.SCALE_DEFAULT);
                
                
                labelfoto.setImage(new javax.swing.ImageIcon((img)));
                this.filename = f.getAbsolutePath();
                place2.setText("" + getMd5(s));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnfoto1MouseClicked

    private void btntambah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambah1MouseClicked

        try {
            String newpath = "src/upload";
            File directory = new File(newpath);
            if (!directory.exists()) {
                directory.mkdirs();

            }
            File fileawal = null;
            File fileakhir = null;
            String ext = this.filename.substring(filename.lastIndexOf('.')+1);
            fileawal = new File(filename);
            fileakhir = new File(newpath+"/"+txtuser.getText()+"."+ext);
            System.out.println(fileakhir);
            akun a = new akun();
            this.stat = k.getCon().prepareStatement("insert into admin values(?,?,?,?,?)");
            stat.setString(1, a.id);
            stat.setString(2, a.nama);
            stat.setString(3, a.user);
            stat.setString(4, a.pass);
            stat.setString(5, fileakhir.toString());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "akun berhasil ditambahkan");
            Files.copy(fileawal.toPath(), fileakhir.toPath());

            form2_loginadmin log = new form2_loginadmin();
            log.setVisible(true);
            this.setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "id atau username tidak boleh kosong");
        }

    }//GEN-LAST:event_btntambah1MouseClicked

    private void btncancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancel1MouseClicked
        dispose();
        form2_loginadmin log = new form2_loginadmin();
        log.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btncancel1MouseClicked

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        password.setEchoChar((char)0);
        unhide.setVisible(true);
        hide.setVisible(false);
        
    }//GEN-LAST:event_hideMouseClicked

    private void unhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unhideMouseClicked
        password.setEchoChar('•');
        hide.setVisible(true);
        unhide.setVisible(false);
    }//GEN-LAST:event_unhideMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form6_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bkg;
    private javax.swing.JLabel btncancel1;
    private javax.swing.JLabel btnfoto1;
    private javax.swing.JLabel btntambah1;
    private javax.swing.JLabel hide;
    private javax.swing.JTextField idadmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private test.ImageAvatar labelfoto;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel place1;
    private javax.swing.JLabel place2;
    private javax.swing.JTextField txtnama;
    private javax.swing.JLabel txtnama1;
    private javax.swing.JTextField txtuser;
    private javax.swing.JLabel unhide;
    // End of variables declaration//GEN-END:variables
}
