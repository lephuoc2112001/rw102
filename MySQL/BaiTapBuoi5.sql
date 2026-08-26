use bai_thi;
-- Exercise 1: Tiếp tục với Database Testing System (Sử dụng subquery hoặc CTE)
 
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
SELECT *
FROM account;

DROP VIEW IF EXISTS Ds_Nv_Sale;

CREATE VIEW Ds_Nv_Sale AS
SELECT acc.*, de.department_name
FROM account acc
left join department de ON dep.department_id = acc.Department_id
left join position po ON acc.position_id = po.position_id
where de.Department_name = 'Sale';

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
SELECT *
FROM account;

SELECT *
FROM `Group`;

CREATE OR REPLACE VIEW vw_TopAccountInGroups AS
WITH GroupCount AS (
    SELECT 
        AccountID, 
        COUNT(GroupID) AS TotalGroups
    FROM GroupAccount
    GROUP BY AccountID
)
SELECT 
    a.AccountID,
    a.Email,
    a.Username,
    a.FullName,
    gc.TotalGroups
FROM Account a
JOIN GroupCount gc ON a.AccountID = gc.AccountID
WHERE gc.TotalGroups = (
    SELECT MAX(TotalGroups) 
    FROM GroupCount
);

-- Xem dữ liệu từ view
SELECT * FROM vw_TopAccountInGroups;
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
-- Step 1: Tạo View chứa các câu hỏi dài hơn 300 từ
CREATE OR REPLACE VIEW vw_LongQuestions AS
SELECT QuestionID, Content, CreatorID, CreateDate
FROM Question
WHERE (LENGTH(Content) - LENGTH(REPLACE(Content, ' ', '')) + 1) > 300;

-- Xem danh sách câu hỏi quá dài trước khi xóa
SELECT * FROM vw_LongQuestions;

-- Step 2: Xóa các câu hỏi này khỏi bảng chính thông qua View (hoặc xóa qua Subquery từ View)
DELETE FROM Question 
WHERE QuestionID IN (SELECT QuestionID FROM vw_LongQuestions);
-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW vw_MaxEmployeeDepartments AS
WITH DeptEmpCount AS (
    SELECT 
        d.DepartmentID,
        d.DepartmentName,
        COUNT(a.AccountID) AS TotalEmployees
    FROM Department d
    LEFT JOIN Account a ON d.DepartmentID = a.DepartmentID
    GROUP BY d.DepartmentID, d.DepartmentName
)
SELECT 
    DepartmentID,
    DepartmentName,
    TotalEmployees
FROM DeptEmpCount
WHERE TotalEmployees = (
    SELECT MAX(TotalEmployees) 
    FROM DeptEmpCount
);

-- Xem dữ liệu từ view
SELECT * FROM vw_MaxEmployeeDepartments;
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW vw_QuestionsCreatedByNguyen AS
SELECT 
    q.QuestionID,
    q.Content,
    q.CategoryID,
    q.TypeID,
    a.FullName AS CreatorName,
    q.CreateDate
FROM Question q
JOIN Account a ON q.CreatorID = a.AccountID
WHERE a.FullName LIKE 'Nguyen %' 
   OR a.FullName LIKE 'Nguyễn %';

-- Xem dữ liệu từ view
SELECT * FROM vw_QuestionsCreatedByNguyen;
