package mobileshop.model.FrontEnd.FormThemSua;

import mobileshop.model.BackEnd.QuanLyTaiKhoan.QuanLyTaiKhoanBUS;
import mobileshop.model.BackEnd.QuanLyTaiKhoan.TaiKhoan;
import mobileshop.model.FrontEnd.FormChon.ChonNhanVienForm;
import mobileshop.model.FrontEnd.FormChon.ChonQuyenForm;
import mobileshop.model.FrontEnd.MyButton.MoreButton;
import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mobileshop.model.FrontEnd.MyButton.FileButton;

public class ThemSuaTaiKhoanForm extends JFrame {

    String type;
    String filename2 = null;
    String filename = null;
    QuanLyTaiKhoanBUS qltkBUS = new QuanLyTaiKhoanBUS();
    TaiKhoan tkSua;
    JTextField txUsername = new JTextField(15);
    JTextField txPassword = new JTextField(15);
    JTextField txMaNV = new JTextField(15);
    JTextField txMaQuyen = new JTextField(15);
    JTextField txAvatar = new JTextField(15);

    MoreButton btnChonNhanVien = new MoreButton();
    MoreButton btnChonQuyen = new MoreButton();
    //FileButton btnChonAnh = new FileButton();

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    public ThemSuaTaiKhoanForm(String _type, String _username) {
        this.setLayout(new BorderLayout());
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.type = _type;

        // inputs
        txUsername.setBorder(BorderFactory.createTitledBorder("Tên tài khoản"));
        txPassword.setBorder(BorderFactory.createTitledBorder("Mật khẩu"));
        txMaNV.setBorder(BorderFactory.createTitledBorder(" "));
        txMaQuyen.setBorder(BorderFactory.createTitledBorder(" "));
        //txAvatar.setBorder(BorderFactory.createTitledBorder(" "));

        JPanel plChonNhanVien = new JPanel();
        plChonNhanVien.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        plChonNhanVien.add(txMaNV);
        plChonNhanVien.add(btnChonNhanVien);

        JPanel plChonQuyen = new JPanel();
        plChonQuyen.setBorder(BorderFactory.createTitledBorder("Mã quyền"));
        plChonQuyen.add(txMaQuyen);
        plChonQuyen.add(btnChonQuyen);

        //JPanel plChonAnh = new JPanel();
        //plChonAnh.setBorder(BorderFactory.createTitledBorder("Tên file ảnh"));
        //plChonAnh.add(txAvatar);
        //plChonAnh.add(btnChonAnh);
        
        JPanel plInput = new JPanel();
        plInput.add(txUsername);
        plInput.add(txPassword);
        plInput.add(plChonNhanVien);
        plInput.add(plChonQuyen);
        //plInput.add(plChonAnh);
        
        

        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm tài khoản");

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa tài khoản");
            for (TaiKhoan tk : qltkBUS.getDstk()) {
                if (tk.getUsername().equals(_username)) {
                    this.tkSua = tk;
                }
            }
            if (this.tkSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy tài khoản");
                this.dispose();
            }

            txUsername.setText(this.tkSua.getUsername());
            txUsername.setEditable(false);
            txPassword.setText(this.tkSua.getPassword());
            txMaNV.setText(this.tkSua.getMaNV());
            txMaQuyen.setText(this.tkSua.getMaQuyen());
            //txAvatar.setText(this.tkSua.getFileNameHinhAnh());

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/maintenance_30px.png")));
            plButton.add(btnSua);
        }
        
        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/icons8_cancel_30px_1.png")));
        plButton.add(btnHuy);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);

        // mouse listener
        btnThem.addActionListener((ae) -> {
            btnThemMouseClicked();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaMouseClicked();
        });
        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });
        btnChonNhanVien.addActionListener((ae) -> {
            ChonNhanVienForm cnv = new ChonNhanVienForm(txMaNV);
        });
        btnChonQuyen.addActionListener((ae) -> {
            ChonQuyenForm cq = new ChonQuyenForm(txMaQuyen, null);
        });
//        btnChonAnh.addActionListener((ae) -> {
//            btnChonAnhMouseClicked();
//        });

        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String username = txUsername.getText();
            String pass = txPassword.getText();
            String manv = txMaNV.getText();
            String maquyen = txMaQuyen.getText();
//            String url = txAvatar.getText();

            if (qltkBUS.add(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(this, "Thêm " + username + " thành công!");
                this.dispose();
            }
        }
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            String username = txUsername.getText();
            String pass = txPassword.getText();
            String manv = txMaNV.getText();
            String maquyen = txMaQuyen.getText();
            //String avatar = txAvatar.getText();
            if (qltkBUS.update(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(this, "Sửa " + username + " thành công!");
                this.dispose();
            }
        }
    }
    private void btnChonAnhMouseClicked() {
//            FileDialog fd = new FileDialog(this);
//            fd.setVisible(true);
//            String filename = fd.getFile();
//            if (filename != null) {
//                txAvatar.setText(filename);
//            }

            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename2 = f.getAbsolutePath();
            filename = f.getName();
            if (filename != null) {
                txAvatar.setText(filename);
            }
            String newPath = "D:/Project_java/MobileShop/src/mobileshop/profile";
            File directory = new File(newPath);
            if(!directory.exists())
            {
                directory.mkdirs();
            }
            File sourceFile = null;
            File destinationFile = null;
//            String extension = filename2.substring(filename2.lastIndexOf('.') + 1);
            sourceFile = new File(filename2);
            destinationFile = new File(newPath +"/"+ filename);
            
        try {
            Files.copy(sourceFile.toPath(),destinationFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ThemSuaTaiKhoanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         

    }


    private Boolean checkEmpty() {
        String username = txUsername.getText();
        String pass = txPassword.getText();
        String manv = txMaNV.getText();
        String maquyen = txMaQuyen.getText();
        //String url = txAvatar.getText();

        if (username.trim().equals("")) {
            return showErrorTx(txUsername, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(txPassword, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(txMaNV, "Mã nhân viên không được để trống");

        } else if (maquyen.trim().equals("")) {
            return showErrorTx(txMaQuyen, "Mã quyền không được để trống");
        }
//        else if (url.trim().equals("")) {
//            return showErrorTx(txAvatar, "Đường dẫn ảnh không được để trống");
//
//        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
