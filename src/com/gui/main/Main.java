package com.gui.main;

import com.gui.component.Header;
import com.gui.component.Menu;
import com.gui.event.EventMenuSelected;
import com.gui.event.EventShowPopupMenu;
import com.gui.form.WelcomeForm;
import com.gui.form.Form_Home;
import com.gui.form.MainForm;
import com.gui.model.ModelMenu;
import com.gui.swing.MenuItem;
import com.gui.swing.PopupMenu;
import com.gui.swing.icon.GoogleMaterialDesignIcons;
import com.gui.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    public Main() {
        initComponents();
        init();
        
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        header.initMoving(this);
        header.loginuser(this);
        header.initEvent(this);
        header.avatar(this);
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(String menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
//                if (menuIndex == 0) {
//                    if (subMenuIndex == 0) {
//                        main.showForm(new Form_Home());
//                    } else if (subMenuIndex == 1) {
//                        main.showForm(new Form1());
//                    }
//
//                }
                switch(menuIndex){
                    case "Bán hàng":
                    {
                        main.showForm(new com.gui.form.BanHang());
                       break;
                    }
                    case "Nhập hàng":
                    {
                        main.showForm(new com.gui.form.NhapHang());
                       break;
                    }
                    case "Sản phẩm":
                    {
                        main.showForm(new com.gui.form.SanPhamForm());
                    
                       break;
                    }
                    case "Loại sản phẩm":
                    {
                       main.showForm(new com.gui.form.LoaiSanPhamForm());
                       break;
                    }
                    case "Hóa đơn":
                    {
                       main.showForm(new com.gui.form.HoaDonForm());
                       break;
                    }
                    case "Phiếu nhập":
                    {
                       main.showForm(new com.gui.form.PhieuNhapForm());
                       break;
                    }
                    case "Khuyến mãi":
                    {
                       main.showForm(new com.gui.form.KhuyenMaiForm());
                       break;
                    }
                    case "Nhân viên":
                    {
                       main.showForm(new com.gui.form.NhanVienForm());
                       break;
                    }
                    case "Khách hàng":
                    {
                       main.showForm(new com.gui.form.KhachHangForm());
                       break;
                    }
                    case "Nhà cung cấp":
                    {
                       main.showForm(new com.gui.form.NhaCungCapForm());
                       break;
                    }
                    case "Tài khoản":
                    {
                       main.showForm(new com.gui.form.AccountForm());
                       break;
                    }
                    case "Quyền":
                    {
                       main.showForm(new com.gui.form.QuyenForm());
                       break;
                    }
                    case "Thống kê":
                    {
                       main.showForm(new com.gui.form.ThongKe());
                       break;
                    }
                    case "About":
                    {
                       main.showForm(new com.gui.form.AboutUSForm());
                       break;
                    }
                }
                header.navbartitle(menuIndex);
                
//                if (menuIndex == 1 )
//                {
//                   main.showForm(new com.gui.form.BanHang());
//                }
//                if (menuIndex == 2 )
//                {
//                   main.showForm(new com.gui.form.NhapHang());
//                }
//                if (menuIndex == 3 )
//                {
//                   main.showForm(new com.gui.form.SanPhamForm());
//                }
//                if (menuIndex == 4 )
//                {
//                   main.showForm(new com.gui.form.LoaiSanPhamForm());
//                }
//                if (menuIndex == 5 )
//                {
//                   main.showForm(new com.gui.form.HoaDonForm());
//                }
//                if (menuIndex == 6 )
//                {
//                   main.showForm(new com.gui.form.PhieuNhapForm());
//                }
//                if (menuIndex == 7 )
//                {
//                   main.showForm(new com.gui.form.KhuyenMaiForm());
//                }
//                if (menuIndex == 8 )
//                {
//                   main.showForm(new com.gui.form.NhanVienForm());
//                }
//                if (menuIndex == 9 )
//                {
//                   main.showForm(new com.gui.form.KhachHangForm());
//                }
//                if (menuIndex == 10 )
//                {
//                   main.showForm(new com.gui.form.NhaCungCapForm());
//                }
//                if (menuIndex == 11 )
//                {
//                   main.showForm(new com.gui.form.AccountForm());
//                }
//                if (menuIndex == 12 )
//                {
//                   main.showForm(new com.gui.form.QuyenForm());
//                }
//                if (menuIndex == 13 )
//                {
//                   main.showForm(new com.gui.form.ThongKe());
//                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new WelcomeForm());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
