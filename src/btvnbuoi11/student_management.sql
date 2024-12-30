CREATE DATABASE studentmanagement;
USE studentmanagement;

# 1.Tạo bảng
CREATE TABLE Students
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    firstName NVARCHAR(50),
    lastName  NVARCHAR(50),
    birthDay  DATE,
    email     VARCHAR(100)
);

CREATE TABLE Courses
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    courseName        NVARCHAR(100),
    courseDescription TEXT
);

CREATE TABLE enrollments
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    studentId     INT,
    courseId      INT,
    enrolmentDate DATE,
    FOREIGN KEY (studentId) REFERENCES Students (id),
    FOREIGN KEY (courseId) REFERENCES Courses (id)
);

# 2.Chèn dl
INSERT INTO Students(firstName, lastName, birthDay, email)
VALUES ('Nguyễn', 'Văn Công', '2000-01-01', 'nguyenvana@example.com'),
       ('Trần', 'Thị Hà', '2001-02-02', 'tranthib@example.com'),
       ('Lê', 'Văn Nam', '2002-03-03', 'levanc@example.com'),
       ('Phạm', 'Thị Dung', '2003-04-04', 'phamthid@example.com'),
       ('Hoàng', 'Văn Tú', '2004-05-05', 'hoangvane@example.com');

INSERT INTO Courses (courseName, courseDescription)
VALUES ('Cơ sở dữ liệu', 'Khóa học giới thiệu về các khái niệm cơ bản của cơ sở dữ liệu và SQL.'),
       ('Lập trình Java', 'Khóa học tập trung vào lập trình Java từ cơ bản đến nâng cao.'),
       ('Phát triển web', 'Khóa học về phát triển ứng dụng web sử dụng HTML, CSS, và JavaScript.');

INSERT INTO Enrollments (studentId, courseId, enrolmentDate)
VALUES (1, 1, '2024-01-10'),
       (2, 2, '2024-02-15'),
       (3, 3, '2024-03-20'),
       (4, 1, '2024-04-25'),
       (5, 2, '2024-05-30');

# 3.Truy vấn
SELECT *
FROM Students;

SELECT *
FROM Courses;

SELECT *
FROM enrollments E
         JOIN Students S ON S.id = E.studentId
         JOIN Courses C ON E.courseId = C.id
WHERE C.courseName = 'Lập trình Java';

SELECT *
FROM Students
WHERE birthDay > '2000-01-01'
  AND email LIKE '%example%';

# 4.Cập nhật dl
UPDATE Students
SET email = 'new@example.com@'
WHERE id = 1;

UPDATE courses
SET courseDescription = 'Mô tả mới.'
WHERE courseName = 'Lập trình Java';

# 5.Xóa dl
DELETE s
FROM Students s
         LEFT JOIN enrollments e ON s.id = e.studentId
WHERE e.courseId IS NULL;

DELETE c
FROM courses c
         LEFT JOIN enrollments e ON c.id = e.courseId
WHERE e.studentId IS NULL;

# 6. Toán tử
SELECT *
FROM students
WHERE birthDay > '2000-01-01';

SELECT *
FROM students
WHERE firstName LIKE 'Nguyen';

SELECT *
FROM Students s
         INNER JOIN Enrollments e ON s.id = e.studentId
         INNER JOIN Courses C ON e.courseId = C.id
WHERE birthDay > '2000-01-01' AND C.courseName = 'Lập trình java';

SELECT *
FROM Students s
         INNER JOIN Enrollments e ON s.id = e.studentId
         INNER JOIN Courses C ON e.courseId = C.id
WHERE C.id IN (1,2);

SELECT *
FROM Students s
         INNER JOIN Enrollments e ON s.id = e.studentId
         INNER JOIN Courses C ON e.courseId = C.id
WHERE C.id BETWEEN 1 AND 3;