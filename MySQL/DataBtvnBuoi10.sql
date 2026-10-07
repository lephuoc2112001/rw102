
-- 1. Tạo Database (nếu chưa có) và sử dụng
CREATE DATABASE IF NOT EXISTS qlcb_buoi10;
USE qlcb_buoi10;

-- 2. Tạo bảng can_bo
CREATE TABLE IF NOT EXISTS can_bo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(255) NOT NULL,
    tuoi INT NOT NULL,
    gioi_tinh VARCHAR(20) NOT NULL, -- NAM, NU, KHAC
    dia_chi VARCHAR(255),
    loai VARCHAR(10) NOT NULL,       -- CN (Công nhân), KS (Kỹ sư), NV (Nhân viên)
    bac INT DEFAULT NULL,            -- Dành cho Công nhân (1 - 10)
    nganh VARCHAR(255) DEFAULT NULL, -- Dành cho Kỹ sư
    cong_viec VARCHAR(255) DEFAULT NULL -- Dành cho Nhân viên
);

-- 3. Thêm dữ liệu mẫu vào bảng
INSERT INTO can_bo (ho_ten, tuoi, gioi_tinh, dia_chi, loai, bac, nganh, cong_viec) VALUES
('Nguyen Van A', 30, 'NAM', 'Ha Noi', 'CN', 3, NULL, NULL),
('Tran Thi B', 28, 'NU', 'Da Nang', 'KS', NULL, 'Cong nghe thong tin', NULL),
('Le Van C', 35, 'NAM', 'TP HCM', 'NV', NULL, NULL, 'Kiem thu phan mem'),
('Pham Van D', 25, 'NAM', 'Binh Duong', 'CN', 5, NULL, NULL);