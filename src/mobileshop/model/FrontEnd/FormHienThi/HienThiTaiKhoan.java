package mobileshop.model.FrontEnd.FormHienThi;

import mobileshop.model.BackEnd.QuanLyTaiKhoan.QuanLyTaiKhoanBUS;
import mobileshop.model.BackEnd.QuanLyTaiKhoan.TaiKhoan;
import mobileshop.model.FrontEnd.GiaoDienChuan.MyTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import mobileshop.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;

public class HienThiTaiKhoan extends FormHienThi {

    QuanLyTaiKhoanBUS qltk = new QuanLyTaiKhoanBUS();
    QuanLyNhanVienBUS qlnv = new QuanLyNhanVienBUS();

    
    JLabel lbImage = new JLabel();
    
    JTextField txTaiKhoan = new JTextField(12);
    JTextField txMatKhau = new JTextField(12);
    JTextField txMaNV = new JTextField(12);
    JTextField txMaQuyen = new JTextField(12);
    JTextField txTenNV = new JTextField(15);

    
    JTextField txTim = new JTextField(15);
    JComboBox<String> cbTypeSearch;
    JButton btnRefresh = new JButton("Refresh");

    // index
    final int USERNAME_I = 1, PASSWORD_I = 2, MANV_I = 3, MAQUYEN_I = 4;

    public HienThiTaiKhoan() {
        setLayout(new BorderLayout());
        
        mtb = new MyTable();
        mtb.setPreferredSize(new Dimension(1200 - 250, 600));
        mtb.setHeaders(new String[]{"STT", "Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Mã quyền"});
        mtb.setColumnsWidth(new double[]{.5, 2, 2, 3, 2,2});
        mtb.setAlignment(0, JLabel.CENTER);
        mtb.setupSort();
        setDataToTable(qltk.getDstk(), mtb);

        // ======== search panel ===========
        cbTypeSearch = new JComboBox<>(new String[]{"Tất cả", "Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Mã quyền"});

        JPanel plHeader = new JPanel();
        JPanel plTim = new JPanel();
        plTim.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTim.setBorder(BorderFactory.createTitledBorder(" ")); // tạo border rỗng
        plTim.add(cbTypeSearch);
        plTim.add(txTim);
        plHeader.add(plTim);

        btnRefresh.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/refresh_30px.png")));
        plHeader.add(btnRefresh);

        cbTypeSearch.addActionListener((ActionEvent e) -> {
            txTim.requestFocus();
            if (!txTim.getText().equals("")) {
                txSearchOnChange();
            }
        });

        btnRefresh.addActionListener((ae) -> {
            refresh();
        });

        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
        txTim.getDocument().addDocumentListener(new DocumentListener() {
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
        
        mtb.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                String masp = getSelectedRow(1);
                showInfo(masp);
            }
        });
        
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
        txTaiKhoan.setBorder(BorderFactory.createTitledBorder("Tài khoản"));
        txMatKhau.setBorder(BorderFactory.createTitledBorder("Mật khẩu"));
        txMaNV.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        txTenNV.setBorder(BorderFactory.createTitledBorder("Họ & tên nhân viên"));
        txMaQuyen.setBorder(BorderFactory.createTitledBorder("Mã quyền"));
        
        // font
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        txTaiKhoan.setFont(f);
        txMatKhau.setFont(f);
        txTenNV.setFont(f);
        txMaNV.setFont(f);
        txMaQuyen.setFont(f);
        
        // add to panel
        plTextField.add(txTaiKhoan);
        plTextField.add(txMatKhau);
        plTextField.add(txMaNV);
        plTextField.add(txTenNV);
        plTextField.add(txMaQuyen);
        

        plImage.add(plTextField);

        //=========== add all to this jpanel ===========
        this.add(plHeader, BorderLayout.NORTH);
        this.add(mtb, BorderLayout.CENTER);
        this.add(plImage, BorderLayout.SOUTH);
        
        

        
        
    }

    public void refresh() {
        qltk.readDB();
        setDataToTable(qltk.getDstk(), mtb);
    }

    private void txSearchOnChange() {
        setDataToTable(qltk.search(txTim.getText(), cbTypeSearch.getSelectedItem().toString()), mtb);
    }

    private void setDataToTable(ArrayList<TaiKhoan> data, MyTable table) {
        table.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (TaiKhoan tk : data) {
            //ImageIcon img = new ImageIcon(getClass().getResource("/mobileshop/profile/" + tk.getFileNameHinhAnh()));
            table.addRow(new String[]{String.valueOf(stt), tk.getUsername(), tk.getPassword(), tk.getMaNV(), tk.getMaQuyen()});
            stt++;
        }
    }
    
    public void showInfo(String matk) { // copy from BanHangForm
        // https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
        if (matk != null) {
            // show hình
            for (TaiKhoan tk : qltk.getDstk()) {
                if (tk.getUsername().equals(matk)) {
                    int w = lbImage.getWidth();
                    int h = lbImage.getHeight();
                    String hinhanh = qlnv.getNhanVien(tk.getMaNV()).getFileNameHinhAnh();
                    ImageIcon img = new ImageIcon(getClass().getResource("/mobileshop/profile/" + hinhanh));
                    Image imgScaled = img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
                    lbImage.setIcon(new ImageIcon(imgScaled));

                    // show info
                    
                      String tennv = qlnv.getNhanVien(tk.getMaNV()).getTenNV();   //qltk.getLoaiSanPham(sp.getMaLSP()).getTenLSP();
                      txTaiKhoan.setText(tk.getUsername());
                      txMatKhau.setText(tk.getPassword());
                      txTenNV.setText(tennv);
                      txMaNV.setText(tk.getMaNV());
                      txMaQuyen.setText(tk.getMaQuyen());
//                    txLoaiSP.setText(loai + " - " + sp.getMaLSP());
//                    txDonGia.setText(PriceFormatter.format(sp.getDonGia()));
//                    txSoLuong.setText(String.valueOf(sp.getSoLuong()));
                    return;
                }
            }
        }
    }
}
