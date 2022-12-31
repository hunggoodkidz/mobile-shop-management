package com.gui.form;

import mobileshop.model.FrontEnd.FormQuanLy.BeginForm;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class WelcomeForm extends JPanel {

    public WelcomeForm() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch 
        (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
        initComponents();
        setOpaque(false);
//        plContent.setLayout(new BorderLayout());
          lbTitle.setText(LoginForm.nhanVienLogin.getTenNV() + " - " + LoginForm.nhanVienLogin.getMaNV());
          lbTitle1.setText(LoginForm.quyenLogin.getTenQuyen());
          lbTitle1.setForeground(Color.red);
//        add(plContent, BorderLayout.CENTER);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTitle1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileshop/images/cute.gif"))); // NOI18N
        add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 340, 300));

        lbTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 65)); // NOI18N
        lbTitle.setText("jLabel2");
        add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 830, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileshop/images/welcome.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileshop/images/icon-4s-334px.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 260, 220, 300));

        lbTitle1.setFont(new java.awt.Font("Segoe UI Black", 0, 65)); // NOI18N
        lbTitle1.setForeground(new java.awt.Color(204, 0, 0));
        lbTitle1.setText("jLabel2");
        add(lbTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 820, 120));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    // End of variables declaration//GEN-END:variables
}
