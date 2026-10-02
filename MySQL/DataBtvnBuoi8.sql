CREATE DATABASE IF NOT EXISTS btvn_buoi8;
USE btvn_buoi8;

-- 1. Bảng Department
CREATE TABLE Department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- 2. Bảng Position
CREATE TABLE Position (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- 3. Bảng Account
CREATE TABLE Account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    department_id INT,
    position_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(id),
    FOREIGN KEY (position_id) REFERENCES `Position` (id)
);

-- Thêm dữ liệu mẫu
INSERT INTO Department (name) VALUES (N'Phòng Kỹ Thuật'), (N'Phòng Nhân Sự'), (N'Phòng Marketing');
INSERT INTO `Position` (name) VALUES ('Dev'), ('Test'), ('HR'), ('Manager');

INSERT INTO Account (username, full_name, department_id, position_id) 
VALUES 
('nhanvien1', N'Lê Văn A', 1, 1),
('nhanvien2', N'Nguyễn Văn B', 2, 3),
('nhanvien3', N'Trần Thị C', 1, 2);