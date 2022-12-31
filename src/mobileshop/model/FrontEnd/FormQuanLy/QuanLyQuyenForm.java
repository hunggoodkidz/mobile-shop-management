package mobileshop.model.FrontEnd.FormQuanLy;

import mobileshop.model.BackEnd.QuanLyQuyen.QuanLyQuyenBUS;
import mobileshop.model.BackEnd.WorkWithExcel.DocExcel;
import mobileshop.model.BackEnd.WorkWithExcel.XuatExcel;
import mobileshop.model.FrontEnd.FormHienThi.HienThiQuyen;
import mobileshop.model.FrontEnd.FormThemSua.ThemSuaQuyenForm;
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

public class QuanLyQuyenForm extends JPanel {

    HienThiQuyen formHienThi = new HienThiQuyen();

    ThemButton btnThem = new ThemButton();
    SuaButton btnSua = new SuaButton();
    XoaButton btnXoa = new XoaButton();
    
    ExportExcelButton btnXuatExcel = new ExportExcelButton();
    ImportExcelButton btnNhapExcel = new ImportExcelButton();

    public QuanLyQuyenForm() {
        setLayout(new BorderLayout());

        // buttons
        if (!LoginForm.quyenLogin.getChiTietQuyen().contains("qlQuyen")) {
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
            formHienThi.refresh();
        });
        btnXuatExcel.addActionListener((ActionEvent ae) -> {
            new XuatExcel().xuatFileExcelQuyen();
        });
        btnNhapExcel.addActionListener((ActionEvent ae) -> {
            new DocExcel().docFileExcelQuyen();
        });
    }

    private void btnSuaMouseClicked() {
        String maquyen = formHienThi.getSelectedRow(1);
        if (maquyen != null) {
            ThemSuaQuyenForm suaq = new ThemSuaQuyenForm("Sửa", maquyen);

            // https://stackoverflow.com/questions/4154780/jframe-catch-dispose-event
            suaq.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    formHienThi.refresh();
                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn quyền nào để sửa");
        }
    }

    private void btnXoaMouseClicked() {
        String maquyen = formHienThi.getSelectedRow(1);
        if (maquyen != null) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa quyền " + maquyen + " ?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                new QuanLyQuyenBUS().delete(maquyen);
                formHienThi.refresh();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn quyền nào để xóa");
        }
    }

    private void btnThemMouseClicked() {
        ThemSuaQuyenForm themq = new ThemSuaQuyenForm("Thêm", "");
        themq.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                formHienThi.refresh();
            }
        });
    }
}