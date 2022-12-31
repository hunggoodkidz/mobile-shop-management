package com.gui.component;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import mobileshop.model.BackEnd.ReadWriteFile.WorkWithFile;
import mobileshop.model.FrontEnd.GiaoDienChuan.DoiMatKhauForm;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;


public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }
    
        public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }
            public void initEvent(JFrame fram) {
        winButton1.initEvent(fram);
    }
       private void logout(JFrame frame) {
        int reply = JOptionPane.showConfirmDialog(getRootPane(),
                "Bạn có chắc muốn đăng xuất khỏi " + LoginForm.nhanVienLogin.getTenNV() + "?", "Chú ý",
                JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            new WorkWithFile(LoginForm.saveFileName).write(""); // xóa dữ liệu đăng nhập
            new LoginForm().setVisible(true);
            frame.dispose();
        }
    }
       
    public void avatar(JFrame frame)
    {
        if(LoginForm.taiKhoanLogin != null)
        {
        String hinhanh = LoginForm.nhanVienLogin.getFileNameHinhAnh();
        ImageIcon img = new ImageIcon(getClass().getResource("/mobileshop/profile/" + hinhanh));
        pic.setIcon(img);
        }
    }
        
    public void navbartitle(String text)
    {
        jLabel1.setText(text);
    }
            
    public void loginuser(JFrame frame)
    {
        if(LoginForm.taiKhoanLogin != null)
        {
           String tenQuyen = LoginForm.quyenLogin.getTenQuyen();
           String tenNhanVien = LoginForm.nhanVienLogin.getTenNV();
           
           
           lbUserName.setText(tenNhanVien);
           lbRole.setText(tenQuyen);
           btnLogOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    logout(frame);
                }
            });
        }
        
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    x = me.getX();
                    y = me.getY();
                }
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new com.gui.swing.Button();
        pic = new com.gui.swing.ImageAvatar();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        winButton1 = new com.gui.swing.win_button.WinButton();
        btnLogOut = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMap = new javax.swing.JButton();
        btnQrcode = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gui/icon/menu.png"))); // NOI18N

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gui/icon/profile3.jpg"))); // NOI18N
        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                picMousePressed(evt);
            }
        });

        lbUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbUserName.setText("User Name");

        lbRole.setForeground(new java.awt.Color(255, 0, 51));
        lbRole.setText("Admin");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gui/icon/logout_20px.png"))); // NOI18N
        btnLogOut.setText("Đăng Xuất");
        btnLogOut.setContentAreaFilled(false);

        btnChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gui/icon/key_20px.png"))); // NOI18N
        btnChangePassword.setText("Đổi Mật Khẩu");
        btnChangePassword.setContentAreaFilled(false);
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Home");

        btnMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gui/icon/google_maps_20px.png"))); // NOI18N
        btnMap.setText("Xem vị trí");
        btnMap.setContentAreaFilled(false);
        btnMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapActionPerformed(evt);
            }
        });

        btnQrcode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gui/icon/qr_code_20px.png"))); // NOI18N
        btnQrcode.setText("Quét mã QR");
        btnQrcode.setContentAreaFilled(false);
        btnQrcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQrcodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnQrcode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChangePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(winButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(btnChangePassword)
                    .addComponent(jLabel1)
                    .addComponent(btnMap)
                    .addComponent(btnQrcode))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(winButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRole)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        new DoiMatKhauForm(LoginForm.taiKhoanLogin.getUsername()).setVisible(true);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void picMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMousePressed
        // TODO add your handling code
    }//GEN-LAST:event_picMousePressed

    private void btnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapActionPerformed
        new com.gui.form.MapForm().setVisible(true);
    }//GEN-LAST:event_btnMapActionPerformed

    private void btnQrcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQrcodeActionPerformed
        new com.gui.form.QrcodeForm().setVisible(true);
    }//GEN-LAST:event_btnQrcodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMap;
    private javax.swing.JButton btnQrcode;
    private com.gui.swing.Button cmdMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private com.gui.swing.ImageAvatar pic;
    private com.gui.swing.win_button.WinButton winButton1;
    // End of variables declaration//GEN-END:variables


}
