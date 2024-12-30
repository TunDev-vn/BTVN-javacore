CREATE DATABASE quanlynhansu;
USE quanlynhansu;
CREATE TABLE departments
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location        VARCHAR(100) NOT NULL
);

INSERT INTO departments (department_id, department_name, location)
VALUES (1, 'IT', 'Hà Nội'),
       (2, 'HR', 'TP. Hồ Chí Minh'),
       (3, 'Finance', 'Đà Nẵng');

CREATE TABLE employees
(
    employee_id   INT PRIMARY KEY,
    name          VARCHAR(100)   NOT NULL,
    position      VARCHAR(50)    NOT NULL,
    salary        DECIMAL(10, 2) NOT NULL,
    department_id INT,
    hire_date     DATE           NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

INSERT INTO employees (employee_id, name, position, salary, department_id, hire_date)
VALUES (1, 'Nguyễn Văn A', 'Developer', 1500, 1, '2020-05-01'),
       (2, 'Trần Thị B', 'Tester', 1200, 1, '2021-03-15'),
       (3, 'Lê Văn C', 'Developer', 1500, 2, '2019-08-10'),
       (4, 'Nguyễn Thị D', 'Project Manager', 2500, 2, '2020-01-20'),
       (5, 'Phạm Văn E', 'Tester', 1300, 3, '2021-07-12'),
       (6, 'Hoàng Thị F', 'Developer', 1400, 3, '2022-09-01'),
       (7, 'Đặng Văn G', 'Developer', 1500, 1, '2022-05-20'),
       (8, 'Nguyễn Văn H', 'Developer', 2000, 2, '2018-12-15');

# 1.Tính tổng lương của mỗi phòng ban:
SELECT d.department_name, SUM(salary) AS tatol_salary
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
GROUP BY e.department_id;
# 2.Lọc các phòng ban có tổng lương lớn hơn 3000:
SELECT d.department_name, SUM(salary) AS tatol_salary
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
GROUP BY e.department_id
HAVING tatol_salary > 3000;
# 3.Lấy danh sách vị trí công việc duy nhất:
SELECT DISTINCT position
FROM employees;
# 4.Lấy 3 nhân viên đầu tiên, bỏ qua 2 nhân viên đầu tiên:
SELECT *
FROM employees
LIMIT 3;

SELECT *
FROM employees
LIMIT 3 OFFSET 2;

SELECT *
FROM employees
LIMIT 2, 3;
# 5.Tìm nhân viên có tên chứa “Nguyễn”:
SELECT *
FROM employees
WHERE name LIKE '%Nguyễn%';
# 6.Tính tổng và trung bình lương của toàn bộ nhân viên:
SELECT SUM(salary) AS total_salary
FROM employees;

SELECT AVG(salary) AS svg_salary
FROM employees;
# 7.Lấy danh sách nhân viên và tên phòng ban của họ:
SELECT *
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id;

# 8.Lấy danh sách tất cả phòng ban và nhân viên của phòng ban đó (nếu có):
SELECT *
FROM departments d
         LEFT JOIN employees e ON d.department_id = e.department_id;

# 9.Lấy danh sách tất cả nhân viên và thông tin phòng ban của họ (nếu có):
SELECT *
FROM employees e
         RIGHT JOIN departments d ON e.department_id = d.department_id;
# 10.Tìm các nhân viên có cùng mức lương
SELECT ec.name AS e1, ep.name AS e2, ec.salary AS salary
FROM employees ec
         INNER JOIN employees ep ON ec.salary = ep.salary AND ec.employee_id <> ep.employee_id;
# 11.Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
SELECT DISTINCT d.department_name, COUNT(e.name) AS quantity, SUM(salary) AS total_salary
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name
ORDER BY quantity DESC
LIMIT 1;

# 12.Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
SELECT d.department_name, e.name, e.salary AS largest_salary
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
WHERE e.salary = (SELECT MAX(e2.salary) FROM employees e2 WHERE e2.department_id = e.department_id);
# 13. Tính mức lương trung bình của từng vị trí công việc, chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
SELECT e.position, AVG(e.salary) AS average_salary
FROM employees e
GROUP BY e.position;