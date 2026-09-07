
USE bai_thi;
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước 
DELIMITER $$
CREATE TRIGGER ckeck_group_create_date
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN
    IF NEW.CreateDate < DATE_SUB(NOW(), INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể tạo Group có ngày tạo trước 1 năm trước!';
    END IF;
END $$
DELIMITER ;
 
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user" 
DELIMITER $$
CREATE TRIGGER prevent_add_user_to_sale
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
    DECLARE v_department_id INT;
    
    SELECT DepartmentID INTO v_department_id
    FROM Department 
    WHERE DepartmentName = 'Sale' LIMIT 1;
    
    IF NEW.DepartmentID = v_department_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMITER ;
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
DELIMITER $$
CREATE TRIGGER prevent_add_user_to_sale
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
    DECLARE v_department_id INT;
    
    SELECT DepartmentID INTO v_department_id
    FROM Department 
    WHERE DepartmentName = 'Sale' LIMIT 1;
    
    IF NEW.DepartmentID = v_department_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMITER ;
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
select *
from question;
select *
from examquestion ;

DELIMITER $$
CREATE TRIGGER max_10_questions_per_exam
BEFORE INSERT ON ExamQuestion
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    
    SELECT COUNT(*) INTO v_count 
    FROM ExamQuestion 
    WHERE ExamID = NEW.ExamID;
    
    IF v_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Bài thi có nhiều nhất 10 câu hỏi!';
    END IF;
END $$
DELIMITER ;
-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là          admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó 
select *
from account;

DELIMITER $$
CREATE TRIGGER protect_admin_account
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
    IF OLD.Email = 'admin@gmail.com' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Đây là tài khoản admin, không cho phép xóa!';
    ELSE
        -- Xóa dữ liệu liên quan ở các bảng con nếu chưa cài ON DELETE CASCADE
        DELETE FROM GroupAccount WHERE AccountID = OLD.AccountID;
    END IF;
END $$
DELIMITER ;
-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"   
select *
from department ;

DELIMITER $$
CREATE TRIGGER default_waiting_department
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
    DECLARE v_waiting_dept_id INT;
    
    IF NEW.DepartmentID IS NULL THEN
        SELECT DepartmentID INTO v_waiting_dept_id
        FROM Department 
        WHERE DepartmentName = 'waiting Department' LIMIT 1;
        
        SET NEW.DepartmentID = v_waiting_dept_id;
    END IF;
END $$
DELIMITER ;
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng. 
select *
from answer ;

DELIMITER $$
CREATE TRIGGER limit_answers_per_question
BEFORE INSERT ON Answer
FOR EACH ROW
BEGIN
    DECLARE v_total_answers INT;
    DECLARE v_correct_answers INT;
    
    SELECT COUNT(*), SUM(isCorrect) 
    INTO v_total_answers, v_correct_answers
    FROM Answer 
    WHERE QuestionID = NEW.QuestionID;
    
    IF v_total_answers >= 4 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mỗi câu hỏi chỉ được phép có tối đa 4 đáp án!';
    END IF;
    
    IF NEW.isCorrect = 1 AND v_correct_answers >= 2 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mỗi câu hỏi chỉ được phép có tối đa 2 đáp án đúng!';
    END IF;
END $$
DELIMITER ;
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database 
DELIMITER $$
CREATE TRIGGER format_gender_before_insert
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
    IF LOWER(NEW.Gender) = 'nam' THEN
        SET NEW.Gender = 'M';
    ELSEIF LOWER(NEW.Gender) = 'nữ' OR LOWER(NEW.Gender) = 'nu' THEN
        SET NEW.Gender = 'F';
    ELSEIF LOWER(NEW.Gender) = 'chưa xác định' OR LOWER(NEW.Gender) = 'chua xac dinh' THEN
        SET NEW.Gender = 'U';
    END IF;
END $$
DELIMITER ;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
DELIMITER $$
CREATE TRIGGER prevent_delete_recent_exam
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
    IF OLD.CreateDate >= DATE_SUB(NOW(), INTERVAL 2 DAY) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể xóa bài thi vừa được tạo trong vòng 2 ngày qua!';
    END IF;
END $$
DELIMITER ;
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
-- Trigger chặn Update
DELIMITER $$
CREATE TRIGGER restrict_update_question
BEFORE UPDATE ON Question
FOR EACH ROW
BEGIN
    DECLARE v_in_exam INT;
    
    SELECT COUNT(*) INTO v_in_exam 
    FROM ExamQuestion 
    WHERE QuestionID = OLD.QuestionID;
    
    IF v_in_exam > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Câu hỏi đã có trong bài thi, không được cập nhật!';
    END IF;
END $$
DELIMITER ;

-- Trigger chặn Delete
DELIMITER $$
CREATE TRIGGER restrict_delete_question
BEFORE DELETE ON Question
FOR EACH ROW
BEGIN
    DECLARE v_in_exam INT;
    
    SELECT COUNT(*) INTO v_in_exam 
    FROM ExamQuestion 
    WHERE QuestionID = OLD.QuestionID;
    
    IF v_in_exam > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Câu hỏi đã có trong bài thi, không được phép xóa!';
    END IF;
END $$
DELIMITER ;
-- Question 12: Lấy ra thông tin exam trong đó: Duration <= 30 thì sẽ đổi thành giá trị "Short time" 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time" Duration > 60 thì sẽ đổi thành giá trị "Long time" 
SELECT 
    ExamID,
    Code,
    Title,
    Duration,
    CASE 
        WHEN Duration <= 30 THEN 'Short time'
        WHEN Duration > 30 AND Duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS DurationType
FROM Exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few 
-- Nếu số lượng user trong group <= 20 và > 5  thì sẽ có giá trị là normal 
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher 
SELECT 
    g.GroupID,
    g.GroupName,
    COUNT(ga.AccountID) AS user_count,
    CASE 
        WHEN COUNT(ga.AccountID) <= 5 THEN 'few'
        WHEN COUNT(ga.AccountID) <= 20 THEN 'normal'
        ELSE 'higher'
    END AS the_number_user_amount
FROM `Group` g
LEFT JOIN GroupAccount ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID, g.GroupName;
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User" 
SELECT 
    d.DepartmentID,
    d.DepartmentName,
    CASE 
        WHEN COUNT(a.AccountID) = 0 THEN 'Không có User'
        ELSE CAST(COUNT(a.AccountID) AS CHAR)
    END AS user_amount
FROM Department d
LEFT JOIN `Account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID, d.DepartmentName;
