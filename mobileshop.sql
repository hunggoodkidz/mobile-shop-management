-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2022 at 04:07 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mobileshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('HD2', 'SP6', 10, 20),
('HD2', 'SP1', 2, 20),
('HD1', 'SP1', 1, 20),
('HD3', 'SP4', 1, 15),
('HD3', 'SP6', 1, 20),
('HD1', 'SP2', 10, 8.2),
('HD1', 'SP3', 11, 15),
('HD4', 'SP1', 3, 20),
('HD5', 'SP23', 1, 19.9),
('HD5', 'SP4', 3, 3.9),
('HD6', 'SP4', 1, 3.9),
('HD6', 'SP3', 1, 7.9),
('HD6', 'SP8', 5, 23),
('HD6', 'SP10', 2, 23.9),
('HD7', 'SP10', 1, 23.9),
('HD7', 'SP12', 2, 7.9),
('HD7', 'SP16', 3, 11.9),
('HD7', 'SP17', 1, 5.6),
('HD8', 'SP15', 1, 5.5),
('HD8', 'SP16', 1, 11.9),
('HD9', 'SP10', 1, 23.9),
('HD9', 'SP1', 1, 20),
('HD10', 'SP13', 1, 7.9),
('HD10', 'SP5', 10, 25.7),
('HD10', 'SP6', 10, 6.5),
('HD11', 'SP1', 1, 20),
('HD11', 'SP10', 1, 23.9),
('HD11', 'SP11', 2, 15.9),
('HD12', 'SP15', 2, 5.5),
('HD12', 'SP17', 1, 5.6),
('HD12', 'SP12', 1, 7.9),
('HD12', 'SP16', 5, 11.9),
('HD13', 'SP5', 1, 25.7),
('HD13', 'SP6', 1, 6.5),
('HD13', 'SP8', 3, 23),
('HD14', 'SP23', 49, 19.9),
('HD15', 'SP10', 1, 23.9),
('HD15', 'SP1', 2, 20),
('HD15', 'SP18', 1, 24),
('HD15', 'SP19', 1, 13),
('HD16', 'SP1', 20, 20),
('HD17', 'SP14', 1, 5.5),
('HD18', 'SP12', 1, 7.9),
('HD19', 'SP10', 2, 23.9),
('HD20', 'SP15', 3, 5.5),
('HD20', 'SP16', 1, 11.9),
('HD20', 'SP12', 1, 7.9),
('HD20', 'SP19', 2, 13),
('HD20', 'SP18', 1, 24),
('HD20', 'SP20', 1, 5),
('HD20', 'SP21', 1, 8),
('HD20', 'SP24', 1, 25),
('HD20', 'SP25', 1, 42.5),
('HD20', 'SP4', 1, 2),
('HD20', 'SP6', 1, 6.5),
('HD21', 'SP17', 1, 5.6),
('HD22', 'SP16', 2, 11.9),
('HD22', 'SP19', 1, 13),
('HD23', 'SP17', 2, 5.6),
('HD23', 'SP14', 1, 5.5),
('HD24', 'SP14', 1, 5.5);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL,
  `DonGia` float UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('PN1', 'SP8', 2, 23),
('PN1', 'SP24', 10, 25),
('PN2', 'SP3', 35, 7.9),
('PN3', 'SP1', 5, 20),
('PN4', 'SP14', 1, 5.5),
('PN4', 'SP12', 1, 7.9),
('PN4', 'SP1', 1, 20),
('PN4', 'SP7', 1, 15.4),
('PN5', 'SP15', 1, 5.5),
('PN5', 'SP14', 1, 5.5),
('PN5', 'SP11', 1, 15.9),
('PN5', 'SP1', 1, 20),
('PN6', 'SP10', 1, 23.9),
('PN6', 'SP15', 10, 5.5),
('PN6', 'SP17', 5, 5.6),
('PN7', 'SP21', 100, 8),
('PN7', 'SP22', 10, 39),
('PN8', 'SP16', 10, 11.9),
('PN9', 'SP1', 10, 20),
('PN10', 'SP16', 1, 11.9),
('PN10', 'SP22', 1, 39);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKM` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` date NOT NULL,
  `GioLap` time NOT NULL,
  `TongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaNV`, `MaKH`, `MaKM`, `NgayLap`, `GioLap`, `TongTien`) VALUES
('HD1', 'NV2', 'KH2', 'KM2', '2022-04-18', '22:45:52', 267),
('HD10', 'NV9', 'KH16', 'KM1', '2022-04-24', '22:16:58', 329.9),
('HD11', 'NV7', 'KH22', 'KM1', '2022-04-25', '13:20:37', 75.7),
('HD12', 'NV7', 'KH19', 'KM3', '2022-04-26', '17:59:11', 84),
('HD13', 'NV7', 'KH14', 'KM1', '2022-04-26', '18:58:06', 101.2),
('HD14', 'NV7', 'KH19', 'KM3', '2022-05-01', '14:14:27', 975.1),
('HD15', 'NV7', 'KH15', 'KM5', '2022-05-05', '15:12:27', 100.9),
('HD16', 'NV7', 'KH1', 'KM4', '2022-05-10', '11:21:12', 400),
('HD17', 'NV2', 'KH1', 'KM1', '2022-05-07', '00:57:55', 5.5),
('HD18', 'NV2', 'KH19', 'KM1', '2022-05-07', '00:58:07', 7.9),
('HD19', 'NV1', 'KH23', 'KM4', '2022-05-08', '16:56:00', 47.8),
('HD2', 'NV1', 'KH1', 'KM1', '2022-04-18', '23:15:36', 240),
('HD20', 'NV1', 'KH20', 'KM1', '2022-05-09', '05:23:58', 175.3),
('HD21', 'NV1', 'KH5', 'KM4', '2022-05-19', '17:52:27', 5.6),
('HD22', 'NV1', 'KH2', 'KM4', '2022-05-19', '17:53:20', 36.8),
('HD23', 'NV1', 'KH19', 'KM1', '2022-05-19', '21:37:25', 16.7),
('HD24', 'NV1', 'KH12', 'KM1', '2022-05-19', '22:17:58', 5.5),
('HD3', 'NV1', 'KH1', 'KM1', '2022-04-19', '18:44:34', 35),
('HD4', 'NV1', 'KH1', 'KM1', '2022-04-21', '12:13:48', 60),
('HD5', 'NV8', 'KH1', 'KM1', '2022-04-24', '03:18:01', 31.6),
('HD6', 'NV8', 'KH7', 'KM1', '2022-04-24', '03:21:35', 174.6),
('HD7', 'NV8', 'KH13', 'KM1', '2022-04-24', '03:22:30', 81),
('HD8', 'NV8', 'KH3', 'KM1', '2022-04-24', '11:29:50', 17.4),
('HD9', 'NV8', 'KH12', 'KM1', '2022-04-24', '21:43:30', 43.9);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `TenKH`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('KH1', 'Trần Văn Hoàng', 'TP HCM', '0123456789', 0),
('KH10', 'Trần Ngọc Hải', 'Kiên Giang', '0905271941', 0),
('KH11', 'Nguyễn Xuân Diệu', 'TP HCM', '0301279552', 0),
('KH12', 'Trần Thanh Thiện', 'Hà Nội', '0123617389', 1),
('KH13', 'Huỳnh Minh Mẫn', 'An Giang', '0389230581', 0),
('KH14', 'Trần Xuân An', 'Long An', '0972136531', 0),
('KH15', 'Nguyễn Thị Xuân', 'TP HCM', '0702571936', 0),
('KH16', 'Huỳnh Anh Thư', 'Bến Tre', '0892383623', 0),
('KH17', 'Trần Thanh Nhã', 'TP HCM', '0702397442', 0),
('KH18', 'Huỳnh Nhựt Trường', 'TP HCM', '0120982736', 0),
('KH19', 'Trần Ngọc Hà', 'TP HCM', '0702843627', 0),
('KH2', 'Nguyễn Thiên Hữu', 'Huế', '0126461589', 1),
('KH20', 'Trần Thị Hoài Anh', 'TP HCM', '0126729137', 0),
('KH21', 'Nguyễn Văn Thắng', 'Kiên Giang', '0723812935', 0),
('KH22', 'Huỳnh Lê Diệu Hân', 'Hà Nội', '0306279178', 1),
('KH23', 'Khách Hàng Minh Đức', 'TPHCM', '1231464343', 0),
('KH3', 'Phan Thanh Tùng', 'Hà Nội', '0952612771', 0),
('KH4', 'Trần Thanh Sơn', 'Hải Phòng', '0120617231', 0),
('KH5', 'Trần Thanh Thái', 'Bến Tre', '0912385524', 1),
('KH6', 'Nguyễn Hồng Nhung', 'Huế', '0967263941', 0),
('KH7', 'Từ Ngọc Cảnh', 'Sóc Trăng', '0306172915', 0),
('KH8', 'Nguyễn Thiên Phụng', 'Vũng Tàu', '0703167293', 0),
('KH9', 'Nguyễn Diệu Ái', 'TP HCM', '0805178293', 0);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKM` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DieuKienKM` float NOT NULL,
  `PhanTramKM` float NOT NULL,
  `NgayBD` date DEFAULT NULL,
  `NgayKT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `DieuKienKM`, `PhanTramKM`, `NgayBD`, `NgayKT`) VALUES
('KM1', 'Không khuyến mãi', 0, 0, '2022-01-05', '2025-04-04'),
('KM2', 'Giảm giá nhân ngày 30/4', 5, 5, '2022-04-28', '2022-05-02'),
('KM3', 'Giảm giá 1/5', 20, 7.5, '2022-04-25', '2022-05-20'),
('KM4', 'Giảm giá tết', 15, 5, '2022-04-24', '2022-05-20'),
('KM5', 'Khuyến mãi xả hàng', 100, 96.69, '2022-05-05', '2022-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenLSP` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `Mota` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLSP`, `TenLSP`, `Mota`) VALUES
('LSP1', 'Apple', 'Apple Inc. là một tập đoàn công nghệ đa quốc gia của Mỹ có nhà đồng sáng lập là Steve Jobs'),
('LSP2', 'Oppo', 'Oppo là nhà sản xuất thiết bị điện tử, điện thoại di động Android Trung Quốc, có trụ sở đặt tại Đông Hoản, Quảng Đông, công ty con của tập đoàn điện tử BBK Electronics.'),
('LSP3', 'SamSung', 'SamSung là một tập đoàn đa quốc gia của Hàn Quốc có tổng hành dinh đặt tại Samsung Town, Seoul.'),
('LSP4', 'Redmi', 'Redmi là một thương hiệu con sản xuất điện thoại di động thông minh, thuộc sở hữu của công ty điện tử Trung Quốc Xiaomi.'),
('LSP5', 'Nokia', 'Nokia là nhà sản xuất điện thoại di động lớn nhất thế giới với thị phần toàn cầu sản phẩm này chiếm khoảng 40%'),
('LSP6', 'Blackbery', 'BlackBerry là một tập đoàn điện tử của Canada chuyên sản xuất, buôn bán các thiết bị di động và giải pháp di động'),
('LSP7', 'Huawei', 'Huawei là một tập đoàn đa quốc gia về thiết bị mạng và viễn thông, có trụ sở chính tại Thâm Quyến, Quảng Đông, Trung Quốc.'),
('LSP8', 'Vivo', 'Vivo là một công ty Trung Quốc chuyên thiết kế, phát triển và sản xuất điện thoại thông minh Android, phụ kiện điện thoại thông minh, phần mềm và dịch vụ trực tuyến.'),
('LSP9', 'Xiaomi', 'Xiaomi là một thương hiệu phổ biến tại thị trường Việt Nam và thế giới bên cạnh các hãng lớn như iPhone, Samsung, Huawei, Oppo');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNCC` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Fax` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SDT`, `Fax`) VALUES
('NCC1', 'Cty Samsung', 'TP HCM', '0123456789', '4598-8789-8789-7897'),
('NCC2', 'Cty Thương Mại Công Nghệ', 'Hà Nội', '0120728815', '3672-1782-3923-6091'),
('NCC3', 'Cty Di Động Trường Sơn', 'TP HCM', '0703192738', '2364-2974-2384-2394'),
('NCC4', 'Cty Viễn Thông Thành Đạt', 'TP HCM', '0501239237', '9823-6738-6739-6766'),
('NCC5', 'Thế Giới Công Nghệ', 'Bình Dương', '0801729329', '1830-7288-8900-7712'),
('NCC6', 'Cty TNHH Hoàng Bá', 'Long An', '0303676818', '7623-9812-3876-2834'),
('NCC7', 'Cty Di Động Thành Tiến', 'Hà Nội', '0989140736', '1873-1738-8736-4761'),
('NCC8', 'Cty Toàn Thắng', 'TP HCM', '0120628918', '8127-9382-1974-2983');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNV` text COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `HinhAnh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NgaySinh`, `DiaChi`, `Email`, `SDT`, `HinhAnh`, `TrangThai`) VALUES
('NV1', 'Trần Chấn Hưng', '2001-03-01', 'TP.HCM', 'ninbook0708@gmail.com', '0979810953', 'profile3.jpg', 0),
('NV2', 'Võ Minh Phi', '2001-05-16', 'TP HCM', 'gos.vanoss@gmail.com', '0123456489', 'phi.jpg', 0),
('NV3', 'Phạm Minh Đức', '2001-03-19', 'TP HCM', 'ducphamlbt@gmail.com', '0128456786', 'minhduc.png', 0),
('NV4', 'Trần Văn Hoàng', '1999-11-12', 'TP HCM', 'tranvanhoang@gmail.com', '01207764668', 'profilegojo.jpg', 1),
('NV5', 'Ngô Nguyễn Ngọc Thành', '2000-08-16', 'TP.HCM', 'nnnt10122000@gmail.com', '0903836827', 'thanh.jpg', 0),
('NV6', 'Lê Hoàng Minh Tuấn', '2001-09-12', 'TP.HCM', 'minhtuan241001@gmail.com', '0795027697', 'tuan.jpg', 1),
('NV7', 'Đỗ Anh Dũng', '1999-06-10', 'TP.HCM', 'whoami@gmail.com', '0981578293', 'hinhthe1.jpg', 0),
('NV8', 'Nguyễn Thị My', '1997-12-18', 'Hà Nội', 'asdasdasd@gmail.com', '0703689147', 'hinhthe2.jpg', 1),
('NV9', 'Phan Yến Hân', '1996-03-14', 'Bến Tre', 'yenhan@gmail.com', '0123671823', 'hinhthe3.jpg', 0);

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenQuyen` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ChiTietQuyen` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`MaQuyen`, `TenQuyen`, `ChiTietQuyen`) VALUES
('Q1', 'Admin', 'qlBanHang qlNhapHang qlSanPham qlLoaiSanPham qlHoaDon qlKhuyenMai qlNhanVien qlKhachHang qlPhieuNhap qlNCC qlTaiKhoan qlQuyen'),
('Q2', 'Nhân viên Bán hàng', 'qlBanHang xemSanPham xemLoaiSanPham xemHoaDon xemNhanVien xemKhachHang'),
('Q3', 'Nhân viên Nhập hàng', 'qlNhapHang xemSanPham xemLoaiSanPham xemNhanVien qlPhieuNhap qlNCC');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhap` date NOT NULL,
  `GioNhap` time NOT NULL,
  `TongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `GioNhap`, `TongTien`) VALUES
('PN1', 'NCC2', 'NV1', '2022-04-24', '01:25:08', 296),
('PN10', 'NCC5', 'NV1', '2022-05-19', '23:12:57', 50.9),
('PN2', 'NCC3', 'NV1', '2022-04-24', '01:25:23', 276.5),
('PN3', 'NCC5', 'NV7', '2022-04-25', '17:06:52', 100),
('PN4', 'NCC4', 'NV7', '2022-04-26', '02:51:18', 48.8),
('PN5', 'NCC5', 'NV7', '2022-04-26', '17:54:01', 46.9),
('PN6', 'NCC8', 'NV7', '2022-04-26', '17:58:26', 106.9),
('PN7', 'NCC6', 'NV7', '2022-05-01', '14:15:27', 1190),
('PN8', 'NCC1', 'NV7', '2022-05-10', '11:19:10', 119),
('PN9', 'NCC2', 'NV7', '2022-05-10', '11:19:53', 200);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaLSP` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TenSP` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` float NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL DEFAULT 1,
  `HinhAnh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `MaLSP`, `TenSP`, `DonGia`, `SoLuong`, `HinhAnh`, `TrangThai`) VALUES
('SP1', 'LSP1', 'IPhone X', 20, 90, 'iphone-xr-128gb-red-400x400.jpg', 1),
('SP10', 'LSP1', 'iPhone Xr 256GB', 23.9, 73, 'iphone-xr-256gb-white-400x400.jpg', 0),
('SP11', 'LSP2', 'OPPO R17 Pro', 15.9, 99, 'oppo-r17-pro-2-400x460.jpg', 0),
('SP12', 'LSP8', 'Vivo V15', 7.9, 255, 'vivo-v15-quanghai-400x460.jpg', 0),
('SP13', 'LSP6', 'Blackberry Evolve', 7.9, 46, 'blackberry-evolve6xvk3-640.jpg', 0),
('SP14', 'LSP7', 'Huawei Y9 (2019)', 5.5, 34, 'huawei-y9-2019-blue-400x460.jpg', 0),
('SP15', 'LSP2', 'OPPO F7', 5.5, 358, 'oppo-f7-red-mtp-400x460.jpg', 0),
('SP16', 'LSP9', 'Xiaomi Mi 8', 11.9, 49, 'xiaomi-mi-8-1-400x460-400x460.jpg', 0),
('SP17', 'LSP9', 'Xiaomi Redmi Note 6 Pro 64GB', 5.6, 65, 'xiaomi-redmi-note-6-pro-black-1-400x460.jpg', 0),
('SP18', 'LSP3', 'Samsung Galaxy Note 9 512GB', 24, 58, 'samsung-galaxy-note-9-512gb-blue-400x460.jpg', 0),
('SP19', 'LSP7', 'Huawei Mate 20', 13, 41, 'huawei-mate-20-black-400x460.jpg', 0),
('SP2', 'LSP2', 'Oppo A7', 8.2, 70, 'oppo-a7-400x460.jpg', 0),
('SP20', 'LSP8', 'Vivo Y85', 5, 35, 'vivo-y85-red-docquyen-400x460.jpg', 0),
('SP21', 'LSP8', 'Vivo V11', 8, 129, 'vivo-v11-400x460.jpg', 0),
('SP22', 'LSP1', 'iPhone Xs Max 512GB', 39, 56, 'iphone-xs-max-512gb-gold-400x460.jpg', 0),
('SP23', 'LSP2', 'OPPO Fid X', 19.9, 0, 'oppo-find-x-1-400x460-400x460.jpg', 0),
('SP24', 'LSP1', 'Iphone abc', 25, 19, 'iphone-xr-256gb-white-400x400.jpg', 0),
('SP25', 'LSP1', 'Apple 4566', 42.5, 44, 'huawei-mate-20-black-400x460.jpg', 0),
('SP3', 'LSP5', 'Nokia 8.1', 7.9, 69, 'nokia-81-silver-400x460.jpg', 0),
('SP4', 'LSP4', 'Redmi Note 8 Blue', 2, 55, 'xiaomi-redmi-note-8-blue-1-400x460.png', 0),
('SP5', 'LSP1', 'iPhone 8 Plus 256GB', 25.7, 167, 'iphone-8-plus-256gb-gold-400x460.jpg', 0),
('SP6', 'LSP5', 'Nokia 6.1 Plus', 6.5, 43, 'nokia-61-plus-3-400x460.jpg', 0),
('SP7', 'LSP2', 'Oppo NEO 3', 15.4, 101, 'oppo-a7-32gb-gold-400x400.jpg', 1),
('SP8', 'LSP7', 'Huawei P30 Pro', 23, 69, 'huawei-p30-pro-1-400x460.jpg', 0),
('SP9', 'LSP3', 'Samsung Galaxy S10+ (512GB)', 29, 57, 'samsung-galaxy-s10-plus-512gb-ceramic-black-400x460.jpg', 0);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TenTaiKhoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`TenTaiKhoan`, `MatKhau`, `MaNV`, `MaQuyen`) VALUES
('admin', 'admin', 'NV1', 'Q1'),
('anhdung123', 'dungpro123', 'NV7', 'Q3'),
('ducphamlbt', '123456', 'NV3', 'Q3'),
('minhphi001', '123456', 'NV2', 'Q2'),
('mysociu', '123456', 'NV8', 'Q2'),
('nhanvien', 'nv', 'NV2', 'Q2'),
('thanhcorn', '123456', 'NV5', 'Q3'),
('tuanbadboi', '123456', 'NV6', 'Q3'),
('yenhan', '123456', 'NV9', 'Q2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaHD` (`MaHD`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaPN` (`MaPN`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaKM` (`MaKM`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLSP`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`MaQuyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `LoaiSP` (`MaLSP`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenTaiKhoan`),
  ADD KEY `MaQuyen` (`MaQuyen`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_3` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`) ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `khuyenmai_ibfk_3` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`) ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLSP`) REFERENCES `loaisanpham` (`MaLSP`) ON UPDATE CASCADE;

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_3` FOREIGN KEY (`MaQuyen`) REFERENCES `phanquyen` (`MaQuyen`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
