DROP TABLE IF EXISTS Bai_thi ;
CREATE DATABASE Bai_thi;
USE Bai_thi;

DROP TABLE IF EXISTS Department;
	CREATE TABLE Department (
    Department_id INT UNSIGNED PRIMARY KEY auto_increment,
    Department_name VARCHAR(100)
    );
 insert into Department (Department_Name) 
    values 	('Marketing'),
			('Sale'),
            ('Bảo vệ '),
            ('Nhân sự'),
            ('Kỹ thuật'),
            ('Tài chính'),
            ('Phó Giám Đốc'),
            ('Giám Đốc'),
            ('Thư Ký '),
            ('Trợ Lý');
-- lấy ra tất cả phòng ban          
SELECT * FROM Department;
-- lấy ả Id phòng sale
SELECT Department_id
FROM Department
WHERE Department_name ='Sale';
            
SET FOREIGN_KEY_CHECKS = 0; -- Tắt kiểm tra khóa ngoại để DROP thoải mái
DROP TABLE IF EXISTS position;
CREATE TABLE `position` (
	Position_id INT UNSIGNED PRIMARY KEY auto_increment,
    Position_name ENUM ( 'DEV', 'TEST', 'SCRUM_MASTER', 'PM')
);
insert into `position`(position_name)
values
	('DEV'),
	('TEST'),
    ('SCRUM_MASTER'),
    ('PM');
    
	
DROP TABLE IF EXISTS Account;
	CREATE TABLE Account (
    Account_id INT UNSIGNED PRIMARY KEY auto_increment,
    Email VARCHAR(150) UNIQUE NOT NULL,
    UserName VARCHAR(100) UNIQUE NOT NULL,
    FullName VARCHAR(100) NOT NULL,
    Department_id INT UNSIGNED,
    Position_id INT UNSIGNED,
    CreateDate datetime DEFAULT CURRENT_TIMESTAMP,
    constraint fk_acc_dep foreign key (department_id) references department(department_id),
    constraint fk_acc_pos foreign key (position_id) references `position` (position_id)
    );
insert into Account (Email, Username, Fullname)
Values
	('omaichuoi@gmaul.com', 'omaichuoi', 'LeVanMai'),
    ('Hoangngoc@gmaul.com', 'NgocHoang', 'HoangMinhNgoc'),
    ('Longchau@gmaul.com', 'Longchau', 'ChauVanLong'),
    ('Hoanhh@gmaul.com', 'Huanrose', 'BuiXuanHuan'),
    ('Khabanh@gmaul.com', 'KhaQuaNho', 'NgoBaKha'),
    ('Quat789@gmaul.com', 'VuaQuat', 'VuaVanQuat'),
    ('Khanh889@gmaul.com', 'KhanhSky', 'DaoQuocKhanh'),
    ('MinhHi@gmaul.com', 'MinhMongManh', 'NguyenNhatMinh'),
    ('Nhutdang@gmaul.com', 'NhutDang', 'DangMinhNhut'),
    ('ThuyMai@gmaul.com', 'MaiBe', 'NguyenThiMaiThuy');
    

DROP TABLE `Group` ;
CREATE TABLE `Group`(
	Group_id INT UNSIGNED PRIMARY KEY auto_increment ,
    Group_name VARCHAR(50) NOT NULL,
    Creator_id INT UNSIGNED, 						-- Creator_id để INT UNSIGNED để khớp kiểu Account_id ở bảng Account
	CreatorDate datetime DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_group_account FOREIGN KEY (Creator_id) REFERENCES Account(Account_id)
);

DROP TABLE GroupAccount;
CREATE TABLE GroupAccount(
	Group_id INT SIGNED NOT NULL,
    Account_id INT SIGNED NOT NULL,
    JoinDate datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Group_id, Account_id),
    CONSTRAINT fk_Group_Account FOREIGN KEY (Group_id) REFERENCES `Group` (Group_id)
);

DROP TABLE TypeQuestion;
CREATE TABLE TypeQuestion(
	Type_id INT SIGNED PRIMARY KEY auto_increment,
    Type_Name ENUM ('ESSAY', 'MULTIPLE-CHOICE')
);

DROP TABLE CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID INT SIGNED PRIMARY KEY auto_increment,
    CategoryName VARCHAR(50)
);

DROP TABLE Answer;
CREATE TABLE Answer(
	AnswerID INT SIGNED PRIMARY KEY auto_increment,
    Content VARCHAR(50),
    QuestionID INT NOT NULL,
    isCorret boolean
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID INT SIGNED PRIMARY KEY auto_increment,
    `Code` INT UNIQUE NOT NULL,
    Title VARCHAR (200),
    CategoryID INT UNIQUE NOT NULL,
    Duration INT UNSIGNED,
    CreatorID INT NOT NULL,
    CreateDate datetime DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID INT UNIQUE NOT NULL,
    QuestionID INT UNIQUE NOT NULL,
    PRIMARY KEY (ExamID, QuestionID)
);


