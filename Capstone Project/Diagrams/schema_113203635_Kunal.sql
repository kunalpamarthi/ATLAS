--schema for Employee HRMS Portal

CREATE TABLE Employees (
  emp_id VARCHAR(255) PRIMARY KEY,
  emp_name VARCHAR(255) NOT NULL,
  mobile_num VARCHAR(20) NOT NULL,
  email_id VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Departments (
  department_id INT AUTO_INCREMENT PRIMARY KEY,
  emp_id VARCHAR(255) NOT NULL,
  department VARCHAR(255) NOT NULL,
  designation VARCHAR(255) NOT NULL,
  day_wage DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES Employees(emp_id)
);

CREATE TABLE Attendance (
  emp_id VARCHAR(255) NOT NULL,
  date DATE NOT NULL,
  attendance_value DECIMAL(3, 1) NOT NULL,
  PRIMARY KEY (emp_id, date),
  FOREIGN KEY (emp_id) REFERENCES Employees(emp_id)
);

CREATE TABLE Salaries (
  salary_id INT AUTO_INCREMENT PRIMARY KEY,
  emp_id VARCHAR(255) NOT NULL,
  basic DECIMAL(10, 2) NOT NULL,
  pf_contribution DECIMAL(10, 2) NOT NULL,
  hra DECIMAL(10, 2) NOT NULL,
  net_pay DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES Employees(emp_id)
);

-- Leave table in DynamoDB
{
  "leave_id": {
    "S": "leave_id_value"
  },
  "emp_id": {
    "S": "emp_id_value"
  },
  "start_date": {
    "S": "start_date_value"
  },
  "end_date": {
    "S": "end_date_value"
  },
  "reason": {
    "S": "reason_value"
  }
}

