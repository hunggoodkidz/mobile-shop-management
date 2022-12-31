package mobileshop.model.FrontEnd.FormThemSua;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import mobileshop.model.BackEnd.QuanLyNhanVien.NhanVien;
import mobileshop.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import mobileshop.model.FrontEnd.MyButton.DateButton;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mobileshop.model.FrontEnd.MyButton.FileButton;

public class ThemSuaNhanVienForm extends JFrame {

    String type;
    QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
    NhanVien nvSua;
    
    String filename2 = null;
    String filename = null;

    JTextField txManv = new JTextField(12);
    JTextField txTennv = new JTextField(15);
    JTextField txNgaysinh = new JTextField(12);
    JTextField txDiachi = new JTextField(15);
    JTextField txEmail = new JTextField(12);
    JTextField txSDT = new JTextField(12);
    JTextField txAvatar = new JTextField(12);
    JComboBox<String> cbChonTrangThai;

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");
    
    FileButton btnChonAnh = new FileButton();

    DatePicker dPickerNgaySinh;

    public ThemSuaNhanVienForm(String _type, String _manv) {
        this.setLayout(new BorderLayout());
        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.type = _type;

        // date picker
        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dPickerNgaySinh = new DatePicker(pickerSettings);
        dPickerNgaySinh.setDateToToday();
        DateButton db = new DateButton(dPickerNgaySinh);

        JPanel plNgaysinh = new JPanel();
        plNgaysinh.setBorder(BorderFactory.createTitledBorder("Ngày sinh"));
        plNgaysinh.add(txNgaysinh);
        plNgaysinh.add(dPickerNgaySinh);

        // inputs
        txManv.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        txTennv.setBorder(BorderFactory.createTitledBorder("Tên nhân viên"));
        txNgaysinh.setBorder(BorderFactory.createTitledBorder(" "));
        txDiachi.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));
        txEmail.setBorder(BorderFactory.createTitledBorder("Email"));
        txSDT.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
        txAvatar.setBorder(BorderFactory.createTitledBorder(""));
        cbChonTrangThai = new JComboBox<>(new String[]{"Ẩn", "Hiện"});

        // chon trang thai
        JPanel plChonTT = new JPanel();
        plChonTT.setBorder(BorderFactory.createTitledBorder("Trạng thái"));
        JLabel lbChonTT = new JLabel("Trạng thái: ");
        plChonTT.add(lbChonTT);
        plChonTT.add(cbChonTrangThai);
        
        JPanel plChonAnh = new JPanel();
        plChonAnh.setBorder(BorderFactory.createTitledBorder("Tên file ảnh"));
        plChonAnh.add(txAvatar);
        plChonAnh.add(btnChonAnh);

        JPanel plInput = new JPanel();
        plInput.add(txManv);
        plInput.add(txTennv);
        plInput.add(plNgaysinh);
        plInput.add(txDiachi);
        plInput.add(txEmail);
        plInput.add(txSDT);
        plInput.add(plChonAnh);
        plInput.add(plChonTT);


        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm nhân viên");
            txManv.setText(qlnvBUS.getNextID());

            cbChonTrangThai.setSelectedItem("Hiện");

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa nhân viên");
            for (NhanVien nv : qlnvBUS.getDsnv()) {
                if (nv.getMaNV().equals(_manv)) {
                    this.nvSua = nv;
                }
            }
            if (this.nvSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy nhân viên");
                this.dispose();
            }

            cbChonTrangThai.setSelectedItem(this.nvSua.getTrangThai() == 0 ? "Hiện" : "Ẩn");
            txManv.setText(this.nvSua.getMaNV());
            txTennv.setText(this.nvSua.getTenNV());
            txNgaysinh.setText(this.nvSua.getNgaySinh().toString());
            dPickerNgaySinh.setDate(this.nvSua.getNgaySinh());
            txDiachi.setText(this.nvSua.getDiaChi());
            txEmail.setText(this.nvSua.getEmail());
            txSDT.setText(this.nvSua.getSDT());
            txAvatar.setText(this.nvSua.getFileNameHinhAnh());

            txManv.setEditable(false);

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/icons8_support_30px.png")));
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
        dPickerNgaySinh.addDateChangeListener((dce) -> {
            txNgaysinh.setText(dPickerNgaySinh.getDateStringOrEmptyString());
        });
        btnChonAnh.addActionListener((ae) -> {
            btnChonAnhMouseClicked();
        });


        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String manv = txManv.getText();
            String tennv = txTennv.getText();
            LocalDate ngaysinh = LocalDate.parse(txNgaysinh.getText());
            String diachi = txDiachi.getText();
            String email = txEmail.getText();
            String sdt = txSDT.getText();
            String url = txAvatar.getText();
            int trangthai = (cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlnvBUS.add(manv, tennv, ngaysinh, diachi,email, sdt,url, trangthai)) {
                JOptionPane.showMessageDialog(this, "Thêm " + tennv + " thành công!");
                this.dispose();
            }
        }
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            String manv = txManv.getText();
            String tennv = txTennv.getText();
            LocalDate ngaysinh = LocalDate.parse(txNgaysinh.getText());
            String diachi = txDiachi.getText();
            String email = txEmail.getText();
            String sdt = txSDT.getText();
            String url = txAvatar.getText();
            int trangthai = (cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlnvBUS.update(manv, tennv, ngaysinh, diachi,email, sdt,url, trangthai)) {
                JOptionPane.showMessageDialog(this, "Sửa " + manv + " thành công!");
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
        String manv = txManv.getText();
        String tennv = txTennv.getText();
        String ngaysinh = txNgaysinh.getText();
        String diachi = txDiachi.getText();
        String email = txEmail.getText();
        String sdt = txSDT.getText();
        String url = txAvatar.getText();

        if (manv.trim().equals("")) {
            return showErrorTx(txManv, "Mã nhân viên không được để trống");

        } else if (tennv.trim().equals("")) {
            return showErrorTx(txTennv, "Tên nhân viên không được để trống");

        } else if (ngaysinh.trim().equals("")) {
            return showErrorTx(txTennv, "Ngày sinh không được để trống");

        } else if (diachi.trim().equals("")) {
            return showErrorTx(txTennv, "Địa chỉ không được để trống");

        }else if (email.trim().equals("")) {
            return showErrorTx(txTennv, "Email không được để trống");

        } else if (sdt.trim().equals("")) {
            return showErrorTx(txTennv, "Số điện thoại không được để trống");

        }
                else if (url.trim().equals("")) {
            return showErrorTx(txAvatar, "Đường dẫn ảnh không được để trống");

        }
        else {
            try {
                LocalDate.parse(ngaysinh);
            } catch (Exception e) {
                return showErrorTx(txTennv, "Ngày sinh không hợp lệ");
            }
        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
