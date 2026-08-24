-- Exercise 1: Join 
USE Bai_thi;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
select *
from account;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 
 select *
 from account
 where createdate > '2010-12-20';
 
-- Question 3: Viết lệnh để lấy ra tất cả các developer  
select position_id
from position
where position_name like 'DEV';



-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
select *
from department
where department_id > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
select q.*, count(eq.ExamID) as SoLanSuDung
from Question q
join ExamQuestion eq ON q.QuestionID = eq.QuestionID
group by q.QuestionId
order by SoLanSuDung DESC
limit 1;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question 
select q.*, count(eq.ExamId) as SolanSuDung
from Question q
join Examquestion eq ON q.QuestionID = eq.QuestionID
group by q.questionID
order by SoLanSuDung DESC
limit 1;



-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam 
-- select Type_Name,CategoryName
-- from CategoryQuestion

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất 
Select q.*, count(a.AnswerID) as CauTraLoiNhieuNhat
from Question q
JOIN Answer a ON q.QuestionID = a.QuestionID
GROUP BY q.QuestionID
ORDER BY SoLuongCauTraLoi DESC
LIMIT 1; 


-- Question 9: Thống kê số lượng account trong mỗi group
  select*
  from `Group` g
  left join GroupAccount ga ON g.Group_id = ga.Group_id;
  
-- Question 10: Tìm chức vụ có ít người nhất 
select p.Position_id, p.Position_name,
	count(a.Account_id) as SoLuongAccount
from account `Position` p
left join Account a ON p.Position_id = a.Position_id
group by p.Position_id, p.Position_name
order by SoLuongAccount ASC
LIMIT 1;
 
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM   
SELECT 
    d.DepartmentID,
    d.DepartmentName,
    COUNT(CASE WHEN p.PositionName = 'Dev' THEN 1 END) AS SoLuongDev,
    COUNT(CASE WHEN p.PositionName = 'Test' THEN 1 END) AS SoLuongTest,
    COUNT(CASE WHEN p.PositionName = 'Scrum Master' THEN 1 END) AS SoLuongScrumMaster,
    COUNT(CASE WHEN p.PositionName = 'PM' THEN 1 END) AS SoLuongPM
FROM Department d
LEFT JOIN Account a ON d.DepartmentID = a.DepartmentID
LEFT JOIN Position p ON a.PositionID = p.PositionID
GROUP BY d.DepartmentID, d.DepartmentName;
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
SELECT 
    q.QuestionID,
    q.Content AS NoiDungCauHoi,
    t.TypeName AS LoaiCauHoi,
    a.FullName AS NguoiTao,
    ans.Content AS NoiDungCauTraLoi,
    ans.isCorrect AS LaDapAnDung
FROM Question q
LEFT JOIN TypeQuestion t ON q.TypeID = t.TypeID
LEFT JOIN Account a ON q.CreatorID = a.AccountID
LEFT JOIN Answer ans ON q.QuestionID = ans.QuestionID;
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
SELECT 
    t.TypeID,
    t.TypeName,
    COUNT(q.QuestionID) AS SoLuongCauHoi
FROM TypeQuestion t
LEFT JOIN Question q ON t.TypeID = q.TypeID
GROUP BY t.TypeID, t.TypeName;
-- Question 14:Lấy ra group không có account nào 
SELECT g.*
FROM `Group` g
LEFT JOIN GroupAccount ga ON g.GroupID = ga.GroupID
WHERE ga.AccountID IS NULL;
-- Question 15: Lấy ra group không có account nào 

-- Question 16: Lấy ra question không có answer nào 
SELECT q.*
FROM Question q
LEFT JOIN Answer a ON q.QuestionID = a.QuestionID
WHERE a.AnswerID IS NULL;

-- Exercise 2: Union Question 17:  
-- Lấy các account thuộc nhóm thứ 1 
SELECT a.* 
FROM Account a
JOIN GroupAccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID = 1;
-- Lấy các account thuộc nhóm thứ 2 
SELECT a.* 
FROM Account a
JOIN GroupAccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID = 2;
-- Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau 
 SELECT a.* 
FROM Account a
JOIN GroupAccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID = 1
UNION
SELECT a.* 
FROM Account a
JOIN GroupAccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID = 2;
-- Question 18:  
-- Lấy các group có lớn hơn 5 thành viên 
SELECT g.*, COUNT(ga.AccountID) AS SoThanhVien
FROM `Group` g
JOIN GroupAccount ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(ga.AccountID) > 5;
-- Lấy các group có nhỏ hơn 7 thành viên 
SELECT g.*, COUNT(ga.AccountID) AS SoThanhVien
FROM `Group` g
JOIN GroupAccount ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(ga.AccountID) < 7;
-- Ghép 2 kết quả từ câu a) và câu b) 
SELECT g.*, COUNT(ga.AccountID) AS SoThanhVien
FROM `Group` g
JOIN GroupAccount ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(ga.AccountID) > 5
UNION
FROM `Group` g
JOIN GroupAccount ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(ga.AccountID) < 7;
