package com.gui.component;

import com.gui.event.EventMenu;
import com.gui.event.EventMenuSelected;
import com.gui.event.EventShowPopupMenu;
import com.gui.model.ModelMenu;
import com.gui.swing.MenuAnimation;
import com.gui.swing.MenuItem;
import com.gui.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UnsupportedLookAndFeelException;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    String[] navItemInfo = {
            "Bán hàng", "/com/gui/icon/store_30px.png", "qlBanHang", "qlBanHang",
            "Nhập hàng", "/com/gui/icon/truck_30px.png", "qlNhapHang", "qlNhapHang",
            "Sản phẩm", "/com/gui/icon/mobile_30px.png", "xemSanPham", "qlSanPham",
            "Loại sản phẩm", "/com/gui/icon/list_30px.png", "xemLoaiSanPham", "qlLoaiSanPham",
            "Hóa đơn", "/com/gui/icon/hoadon_30px.png", "xemHoaDon", "qlHoaDon",
            "Phiếu nhập", "/com/gui/icon/phieunhap_30px.png", "xemPhieuNhap", "qlPhieuNhap",
            "Khuyến mãi", "/com/gui/icon/gift_30px.png", "xemKhuyenMai", "qlKhuyenMai",
            "Nhân viên", "/com/gui/icon/staff_30px.png", "xemNhanVien", "qlNhanVien",
            "Khách hàng", "/com/gui/icon/user_30px.png", "xemKhachHang", "qlKhachHang",
            "Nhà cung cấp", "/com/gui/icon/company_30px.png", "xemNCC", "qlNCC",
            "Tài khoản", "/com/gui/icon/key_30px.png", "xemTaiKhoan", "qlTaiKhoan",
            "Quyền", "/com/gui/icon/badge_30px.png", "xemQuyen", "qlQuyen",
            "Thống kê", "/com/gui/icon/chart_30px.png", "", "",
            "About", "/com/gui/icon/about_30px.png", "", "",
        };

    public Menu() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch 
        (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        menupanel.setLayout(layout);
        

    }

    public void initMenuItem() {
        String chitietquyen = LoginForm.quyenLogin.getChiTietQuyen();
        for (int i = 0; i < navItemInfo.length; i += 4)
        {
            if (chitietquyen.contains(navItemInfo[i + 2]) || chitietquyen.contains(navItemInfo[i + 3])){
                menupanel.add(new MenuItem(new ModelMenu(new ImageIcon(getClass().getResource(navItemInfo[i + 1])), navItemInfo[i]), getEventMenu(), event,navItemInfo[i] ), "h 40!");
            }
            
            //addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/2.png")), "Bán Hàng"));
        }
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/1.png")), "Dashboard", "Home", "Buttons", "Cards", "Tabs", "Accordions", "Modals"));
//        if (chitietquyen.contains("qlBanHang"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/2.png")), "Bán Hàng"));
//        }
//        if (chitietquyen.contains("qlNhapHang"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/3.png")), "Nhập Hàng"));
//        }
//        if (chitietquyen.contains("xemSanPham") || chitietquyen.contains("qlSanPham"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/4.png")), "Sản Phẩm"));
//        }
//        if (chitietquyen.contains("xemLoaiSanPham") || chitietquyen.contains("qlLoaiSanPham"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/5.png")), "Loại Sản Phẩm"));
//        }
//        if (chitietquyen.contains("xemHoaDon") || chitietquyen.contains("qlHoaDon"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/6.png")), "Hóa Đơn"));
//        }
//        if (chitietquyen.contains("xemPheuNhap") || chitietquyen.contains("qlHoaDon"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/7.png")), "Phiếu Nhập"));
//        }
//        if (chitietquyen.contains("xemKhuyenMai") || chitietquyen.contains("qlKhuyenMai"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/8.png")), "Khuyến Mãi"));
//        }
//        if (chitietquyen.contains("xemNhanVien") || chitietquyen.contains("qlNhanVien"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/9.png")), "Nhân Viên"));
//        }
//        if (chitietquyen.contains("xemKhachHang") || chitietquyen.contains("qlKhachHang"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/10.png")), "Khách Hàng"));
//        }
//        if (chitietquyen.contains("xemNCC") || chitietquyen.contains("qlNCC"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/11.png")), "Nhà Cung Cấp"));
//        }
//        if (chitietquyen.contains("xemTaiKhoan") || chitietquyen.contains("qlTaiKhoan"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/12.png")), "Tài Khoản"));
//        }
//        if (chitietquyen.contains("xemQuyen") || chitietquyen.contains("qlQuyen"))
//        {
//            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/13.png")), "Quyền"));
//        }
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gui/icon/14.png")), "Thống Kê"));
    }

//    private void addMenu(ModelMenu menu) {
//        
//    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : menupanel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }

        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menupanel = new javax.swing.JPanel();
        profile1 = new com.gui.component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menupanel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menupanel.setOpaque(false);

        javax.swing.GroupLayout menupanelLayout = new javax.swing.GroupLayout(menupanel);
        menupanel.setLayout(menupanelLayout);
        menupanelLayout.setHorizontalGroup(
            menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        menupanelLayout.setVerticalGroup(
            menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        sp.setViewportView(menupanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, Color.decode("#8E2DE2"), 0, getHeight(), Color.decode("#4A00E0"));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel menupanel;
    private com.gui.component.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
