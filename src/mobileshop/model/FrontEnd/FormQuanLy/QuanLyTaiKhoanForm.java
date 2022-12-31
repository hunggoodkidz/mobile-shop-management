package mobileshop.model.FrontEnd.FormQuanLy;

import mobileshop.model.BackEnd.QuanLyTaiKhoan.QuanLyTaiKhoanBUS;
import mobileshop.model.BackEnd.WorkWithExcel.DocExcel;
import mobileshop.model.BackEnd.WorkWithExcel.XuatExcel;
import mobileshop.model.FrontEnd.FormHienThi.HienThiTaiKhoan;
import mobileshop.model.FrontEnd.FormThemSua.ThemSuaTaiKhoanForm;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;
import mobileshop.model.FrontEnd.MyButton.ExportExcelButton;
import mobileshop.model.FrontEnd.MyButton.ImportExcelButton;
import mobileshop.model.FrontEnd.MyButton.SuaButton;
import mobileshop.model.FrontEnd.MyButton.ThemButton;
import mobileshop.model.FrontEnd.MyButton.XoaButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuanLyTaiKhoanForm extends JPanel {

    HienThiTaiKhoan formHienThi = new HienThiTaiKhoan();

    ThemButton btnThem = new ThemButton();
    SuaButton btnSua = new SuaButton();
    XoaButton btnXoa = new XoaButton();
    
    ExportExcelButton btnXuatExcel = new ExportExcelButton();
    ImportExcelButton btnNhapExcel = new ImportExcelButton();

    public QuanLyTaiKhoanForm() {
        setLayout(new BorderLayout());

        // buttons
        if (!LoginForm.quyenLogin.getChiTietQuyen().contains("qlTaiKhoan")) {
            btnThem.setEnabled(false);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
            btnNhapExcel.setEnabled(false);
        }

        JPanel plBtn = new JPanel();
        plBtn.add(btnThem);
        plBtn.add(btnXoa);
        plBtn.add(btnSua);
        plBtn.add(btnXuatExcel);
        plBtn.add(btnNhapExcel);

        //=========== add all to this jpanel ===========
        this.add(formHienThi, BorderLayout.CENTER);
        this.add(plBtn, BorderLayout.NORTH);

        // actionlistener
        btnThem.addActionListener((ActionEvent ae) -> {
            btnThemMouseClicked();
        });
        btnXoa.addActionListener((ActionEvent ae) -> {
            btnXoaMouseClicked();
        });
        btnSua.addActionListener((ActionEvent ae) -> {
            btnSuaMouseClicked();
        });
        btnXuatExcel.addActionListener((ActionEvent ae) -> {
            new XuatExcel().xuatFileExcelTaiKhoan();
        });
        btnNhapExcel.addActionListener((ActionEvent ae) -> {
            new DocExcel().docFileExcelTaiKhoan();
        });
    }

    private void btnSuaMouseClicked() {
        String masp = formHienThi.getSelectedRow(1);
        if (masp != null) {
            ThemSuaTaiKhoanForm suatk = new ThemSuaTaiKhoanForm("Sửa", masp);

            // https://stackoverflow.com/questions/4154780/jframe-catch-dispose-event
            suatk.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    formHienThi.refresh();
                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn tài khoản nào để sửa");
        }
    }

    private void btnXoaMouseClicked() {
        String malsp = formHienThi.getSelectedRow(1);
        if (malsp != null) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tài khoản " + malsp + " ?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                new QuanLyTaiKhoanBUS().delete(malsp);
                formHienThi.refresh();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn tài khoản nào để xóa");
        }
    }

    private void btnThemMouseClicked() {
        ThemSuaTaiKhoanForm themtk = new ThemSuaTaiKhoanForm("Thêm", "");

        themtk.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                formHienThi.refresh();
            }
        });
    }
}
