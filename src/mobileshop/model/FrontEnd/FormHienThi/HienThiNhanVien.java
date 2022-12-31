package mobileshop.model.FrontEnd.FormHienThi;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import mobileshop.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import mobileshop.model.BackEnd.QuanLyNhanVien.NhanVien;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;
import mobileshop.model.FrontEnd.GiaoDienChuan.MyTable;
import mobileshop.model.FrontEnd.MyButton.DateButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HienThiNhanVien extends FormHienThi {

    QuanLyNhanVienBUS qlnv = new QuanLyNhanVienBUS();
    
    JLabel lbImage = new JLabel();

    JTextField txTim = new JTextField(15);
    JComboBox<String> cbTypeSearch;
    JButton btnRefresh = new JButton("Refresh");
    
    //JTextField txTaiKhoan = new JTextField(12);
    JTextField txDiaChi = new JTextField(15);
    JTextField txMaNV = new JTextField(12);
    JTextField txNgaySinh = new JTextField(12);
    JTextField txTenNV = new JTextField(15);
    JTextField txEmail = new JTextField(25);
    JTextField txSDT = new JTextField(15);

    JTextField txKhoangNgay1 = new JTextField(8);
    JTextField txKhoangNgay2 = new JTextField(8);
    DatePicker dPicker1;
    DatePicker dPicker2;

    // index
    final int MANV_I = 1, TENNV_I = 2, NGAYSINH_I = 3, DIACHI_I = 4, SDT_I = 5;

    public HienThiNhanVien() {
        setLayout(new BorderLayout());

        // khoang ngay
        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(pickerSettings);
        dPicker2 = new DatePicker(pickerSettings.copySettings());
        dPicker1.setDateToToday();
        dPicker2.setDateToToday();

        // calendar icon
        DateButton db = new DateButton(dPicker1);
        DateButton db2 = new DateButton(dPicker2);

        txKhoangNgay1.setBorder(BorderFactory.createTitledBorder("Từ:"));
        txKhoangNgay2.setBorder(BorderFactory.createTitledBorder("Đến:"));

        mtb = new MyTable();
        mtb.setPreferredSize(new Dimension(1200 - 250, 600));
        mtb.setHeaders(new String[]{"STT", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ","Email", "Số điện thoại","Hình ảnh", "Trạng thái"});
        mtb.setColumnsWidth(new double[]{.5, 1.5, 2.5, 1.3,2, 3, 1.5,1.5, 1});
        mtb.setAlignment(0, JLabel.CENTER);
        mtb.setupSort();
        setDataToTable(qlnv.getDsnv(), mtb);

        // ======== search panel ===========
        cbTypeSearch = new JComboBox<>(new String[]{"Tất cả", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ","Email", "Số điện thoại", "Trạng thái"});

        JPanel plHeader = new JPanel();
        JPanel plTim = new JPanel();
        plTim.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTim.setBorder(BorderFactory.createTitledBorder("Tất cả")); // tạo border rỗng
        plTim.add(cbTypeSearch);
        plTim.add(txTim);
        plHeader.add(plTim);

        // pl tim khoang ngay
        JPanel plTimKiemKhoangNgay = new JPanel();
        plTimKiemKhoangNgay.setBorder(BorderFactory.createTitledBorder("Ngày sinh:"));
        plTimKiemKhoangNgay.add(txKhoangNgay1);
        plTimKiemKhoangNgay.add(dPicker1);
        plTimKiemKhoangNgay.add(txKhoangNgay2);
        plTimKiemKhoangNgay.add(dPicker2);
        plHeader.add(plTimKiemKhoangNgay);

        btnRefresh.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/refresh_30px.png")));
        plHeader.add(btnRefresh);

        cbTypeSearch.addActionListener((ActionEvent e) -> {
            txTim.setBorder(BorderFactory.createTitledBorder(cbTypeSearch.getSelectedItem().toString()));
            txTim.requestFocus();
            if (!txTim.getText().equals("")) {
                txSearchOnChange();
            }
        });

        btnRefresh.addActionListener((ae) -> {
            refresh();
        });

        dPicker1.addDateChangeListener((dce) -> {
            txKhoangNgay1.setText(dPicker1.getDateStringOrEmptyString());
        });
        dPicker2.addDateChangeListener((dce) -> {
            txKhoangNgay2.setText(dPicker2.getDateStringOrEmptyString());
        });
        
        mtb.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                String masp = getSelectedRow(1);
                showInfo(masp);
            }
        });

        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
        addDocumentListener(txTim);
        addDocumentListener(txKhoangNgay1);
        addDocumentListener(txKhoangNgay2);
        
                      // panel image ----------- Copy From BanHangForm
        JPanel plImage = new JPanel();
        lbImage.setPreferredSize(new Dimension(250, 250));
        lbImage.setBorder(BorderFactory.createLineBorder(Color.black));
        plImage.add(lbImage);

        JPanel plTextField = new JPanel();
        plTextField.setPreferredSize(new Dimension(400, 250));
        plTextField.setLayout(new FlowLayout());
        plTextField.setBackground(new Color(240, 240, 240));
        // border
        txTenNV.setBorder(BorderFactory.createTitledBorder("Họ & tên nhân viên"));
        txMaNV.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        txNgaySinh.setBorder(BorderFactory.createTitledBorder("Ngày sinh"));
        txDiaChi.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));
        txEmail.setBorder(BorderFactory.createTitledBorder("Email"));
        txSDT.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
        
        // font
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        txTenNV.setFont(f);
        txNgaySinh.setFont(f);
        txMaNV.setFont(f);
        txDiaChi.setFont(f);
        txEmail.setFont(f);
        txSDT.setFont(f);
        
        // add to panel
        plTextField.add(txTenNV);
        plTextField.add(txMaNV);
        plTextField.add(txNgaySinh);
        plTextField.add(txDiaChi);
        plTextField.add(txEmail);
        plTextField.add(txSDT);
        

        plImage.add(plTextField);

        //=========== add all to this jpanel ===========
        this.add(plHeader, BorderLayout.NORTH);
        this.add(mtb, BorderLayout.CENTER);
        this.add(plImage, BorderLayout.SOUTH);
        
    }

    public void refresh() {
        qlnv.readDB();
        setDataToTable(qlnv.getDsnv(), mtb);
        txTim.setText("");
        txKhoangNgay1.setText("");
        txKhoangNgay2.setText("");
    }

    private void addDocumentListener(JTextField txField) {
        txField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                txSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                txSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                txSearchOnChange();
            }
        });
    }

    private void txSearchOnChange() {
        LocalDate ngay1 = null, ngay2 = null;
        try {
            ngay1 = java.time.LocalDate.parse(txKhoangNgay1.getText());
            txKhoangNgay1.setForeground(Color.black);
        } catch (DateTimeParseException e) {
            txKhoangNgay1.setForeground(Color.red);
        }
        try {
            ngay2 = java.time.LocalDate.parse(txKhoangNgay2.getText());
            txKhoangNgay2.setForeground(Color.black);
        } catch (DateTimeParseException e) {
            txKhoangNgay2.setForeground(Color.red);
        }
        setDataToTable(qlnv.search(txTim.getText(), cbTypeSearch.getSelectedItem().toString(), ngay1, ngay2), mtb);
    }

    private void setDataToTable(ArrayList<NhanVien> data, MyTable table) {
        table.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
        Boolean hienNhanVienAn = LoginForm.quyenLogin.getChiTietQuyen().contains("qlNhanVien");
        for (NhanVien nv : data) {
            if (hienNhanVienAn || nv.getTrangThai() == 0) {
                table.addRow(new String[]{
                    String.valueOf(stt),
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getNgaySinh().toString(),
                    nv.getDiaChi(),
                    nv.getEmail(),
                    nv.getSDT(),
                    nv.getFileNameHinhAnh(),
                    (nv.getTrangThai() == 0 ? "Hiện" : "Ẩn")
                });
                stt++;
            }

        }
    }
    
        public void showInfo(String manv) { // copy from BanHangForm
        // https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
        if (manv != null) {
            // show hình
            for (NhanVien nv : qlnv.getDsnv()) {
                if (nv.getMaNV().equals(manv)) {
                    int w = lbImage.getWidth();
                    int h = lbImage.getHeight();
                    ImageIcon img = new ImageIcon(getClass().getResource("/mobileshop/profile/" + nv.getFileNameHinhAnh()));
                    Image imgScaled = img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
                    lbImage.setIcon(new ImageIcon(imgScaled));

                    // show info
                    
                      //String tennv = qlnv.getNhanVien(nv.getMaNV()).getTenNV();   //qltk.getLoaiSanPham(sp.getMaLSP()).getTenLSP();
                      txTenNV.setText(nv.getTenNV());
                      txMaNV.setText(nv.getMaNV());
                      txDiaChi.setText(nv.getDiaChi());
                      txEmail.setText(nv.getEmail());
                      txSDT.setText(nv.getSDT());
                      txNgaySinh.setText(nv.getNgaySinh().toString());
                      
//                          JTextField txDiaChi = new JTextField(15);
//    JTextField txMaNV = new JTextField(12);
//    JTextField txNgaySinh = new JTextField(12);
//    JTextField txTenNV = new JTextField(15);
//    JTextField txEmail = new JTextField(25);
//    JTextField txSDT = new JTextField(15);
//                    txLoaiSP.setText(loai + " - " + sp.getMaLSP());
//                    txDonGia.setText(PriceFormatter.format(sp.getDonGia()));
//                    txSoLuong.setText(String.valueOf(sp.getSoLuong()));
                    return;
                }
            }
        }
    }
}
