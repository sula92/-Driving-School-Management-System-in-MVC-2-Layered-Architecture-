-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2020 at 06:17 PM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `samadhi_learners`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `Branch_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Branch_Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Address` varchar(200) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Contact_Number` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Email` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Established_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`Branch_ID`, `Branch_Name`, `Address`, `Contact_Number`, `Email`, `Established_Date`) VALUES
('001', 'Gampaha', 'No 8A Kandy Road Gampaha', '0335647748', 'slns@gmail.com', '2019-08-14'),
('002', 'Yakkala', 'N0 19 samagi Road Yakkala', '033227748', 'slnsyak@gmail.com', '2000-08-14'),
('1111', 'xxxx', 'xxxx', '123', 'ddddd', '2019-10-09');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Course_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Course_Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Total_Fee` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Course_ID`, `Course_Name`, `Total_Fee`) VALUES
('001', 'light vehicle', '20000'),
('002', 'heavy vehicle', '30000'),
('003', 'full package', '40000');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Emp_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `NIC` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Position` varchar(60) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Monthly_Sal` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Branch` varchar(60) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Date_of_Recruited` date DEFAULT NULL,
  `Grade` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Emp_ID`, `NIC`, `Position`, `Monthly_Sal`, `Branch`, `Date_of_Recruited`, `Grade`) VALUES
('111122', '8383839', 's', '2', '001', '2019-10-22', 'a'),
('2', '321814399v', 'e', '4', 'Gampaha', '2019-10-16', 'a'),
('5367w', '377894214', 's', '3', 'Gampaha', '2019-10-31', 's'),
('66446', '887654899v', 'b', '87', 'Gampaha', '2019-10-23', 'a'),
('e001', '7474788v', 'Instructor', '50000', 'Gampaha', '2019-07-07', 'A'),
('e002', '921814396v', 'Manager', '55000', 'Gampaha', '2019-08-13', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `Exam_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Venue` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`Exam_ID`, `Date`, `Time`, `Venue`) VALUES
('001', '2019-08-20', '10:00:00', 'Gampaha'),
('002', '2019-08-27', '07:49:00', 'gampah'),
('003', '2019-08-07', '15:08:00', 'Yakkala'),
('234', '2019-10-09', '09:50:00', 'ccc');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `NIC` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Person_Type` varchar(40) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Image_Path` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inquiries`
--

CREATE TABLE `inquiries` (
  `Inquiry_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Senders_NIC` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Senders_Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Senders_Email` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Message` varchar(500) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `inquiries`
--

INSERT INTO `inquiries` (`Inquiry_ID`, `Senders_NIC`, `Senders_Name`, `Senders_Email`, `Message`) VALUES
('1', '69949408v', 'Kusuma Silva', 'Sususil@gmail.com', 'Can We arrange individual classes?');

-- --------------------------------------------------------

--
-- Table structure for table `lecture`
--

CREATE TABLE `lecture` (
  `Lecture_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Lecture_Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Venue` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `lecture`
--

INSERT INTO `lecture` (`Lecture_ID`, `Lecture_Name`, `Date`, `Time`, `Venue`) VALUES
('001', 'Road Rules', '2019-08-20', '10:00:00', 'Gampaha'),
('002', 'Signals', '2019-08-14', '14:00:00', 'Kandy'),
('003', 'Vehicle Parts', '2019-08-11', '06:42:00', 'Gampaha'),
('004', 'Signals', '2016-08-11', '06:44:00', 'Nuwara'),
('007', 'Road Rules-2', '2019-08-08', '10:06:00', 'Yakkala');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `NIC` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Type_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Age` varchar(20) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Gender` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`NIC`, `Type_ID`, `Name`, `DOB`, `Age`, `Gender`) VALUES
('321814399v', '002', 's', '2019-10-10', '9', 'male'),
('33633', '002', 'd', '2019-10-04', '5', 'male'),
('377894214', '002', 'd', '2019-10-03', '5', 'male'),
('7474788v', '003', 'MMA Sisira', '2019-08-26', '45', 'male'),
('8383839', '002', 'sdd', '2019-10-03', '2', 'male'),
('887654899v', '002', 'f', '2019-10-10', '8', 'male'),
('921814396v', '002', 'kumara', '2019-08-14', '54', 'male'),
('921814398v', '001', 'Kamal Perera', '2019-08-19', '23', 'male'),
('921814399v', '001', 'Sulakkhana Dissanayake', '2019-08-14', '27', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `person_contact`
--

CREATE TABLE `person_contact` (
  `NIC` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Type_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Address` varchar(150) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Mobile` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Phone` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Email` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `person_contact`
--

INSERT INTO `person_contact` (`NIC`, `Type_ID`, `Address`, `Mobile`, `Phone`, `Email`) VALUES
('8383839', '002', 's', '2', '2', '2'),
('887654899v', '002', 'ghnn', '8', '8', 'h'),
('921814396v', '001', 'No 05 Sri Dharmapala MW, Gampaha', '07599499', '033229599', 'sulaid@gmail.com'),
('921814398v', '002', 'no 7A, samagi road yakkala', '07385959', '033459599', 'test1@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `person_type`
--

CREATE TABLE `person_type` (
  `Type_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Person_Type` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `person_type`
--

INSERT INTO `person_type` (`Type_ID`, `Person_Type`) VALUES
('001', 'student'),
('002', 'employee'),
('003', 'supplier');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Std_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `NIC` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Branch_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Course_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Date_of_Joined` date DEFAULT NULL,
  `Exam_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Trial_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Next_Training_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Next_Lecture_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Std_ID`, `NIC`, `Branch_ID`, `Course_ID`, `Date_of_Joined`, `Exam_ID`, `Trial_ID`, `Next_Training_ID`, `Next_Lecture_ID`) VALUES
('001', '921814399v', '001', '001', '2019-08-15', '001', '001', '001', '001'),
('002', '921814398v', '002', '003', '2019-08-13', '002', '001', '001', '007'),
('005', '7474788v', '001', '002', '2019-10-09', '003', '001', '002', '003');

-- --------------------------------------------------------

--
-- Table structure for table `student_payments`
--

CREATE TABLE `student_payments` (
  `Std_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Registration_Fee` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Total_Amount` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Installment_Paid_Last` varchar(50) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Invoice_Number` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Amount` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `student_payments`
--

INSERT INTO `student_payments` (`Std_ID`, `Registration_Fee`, `Total_Amount`, `Installment_Paid_Last`, `Date`, `Invoice_Number`, `Amount`) VALUES
('001', '5000', '20000', '1st Installment', '2019-08-14', '00123', '10000'),
('002', '5000', '20000', '1st Installment', '2019-08-27', '123', '10000');

-- --------------------------------------------------------

--
-- Table structure for table `student_status`
--

CREATE TABLE `student_status` (
  `Std_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Exam_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Exam_Status` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Trial_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Trial_Status` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `License_Status` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `student_status`
--

INSERT INTO `student_status` (`Std_ID`, `Exam_ID`, `Exam_Status`, `Trial_ID`, `Trial_Status`, `License_Status`) VALUES
('002', '001', 'failed', '001', 'failed', 'issued'),
('003', '001', 'absent', '001', 'passed', 'pending'),
('004', '001', 'passed', '001', 'passed', 'issued'),
('005', '001', 'passed', '001', 'passed', 'issued'),
('006', '002', 'failed', '002', 'passed', 'pending'),
('007', '003', 'passed', '002', 'failed', 'issued');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Sup_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `NIC` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Sup_ID`, `NIC`, `Name`) VALUES
('001', '7474788', 'K Perera'),
('002', '9928282v', 'S.S.A Nimal');

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `Training_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Venue` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `training`
--

INSERT INTO `training` (`Training_ID`, `Date`, `Time`, `Venue`) VALUES
('001', '2019-08-20', '10:00:00', 'Gampaha'),
('002', '2019-08-14', '14:00:00', 'Kandy');

-- --------------------------------------------------------

--
-- Table structure for table `trial`
--

CREATE TABLE `trial` (
  `Trial_ID` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Venue` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `trial`
--

INSERT INTO `trial` (`Trial_ID`, `Date`, `Time`, `Venue`) VALUES
('001', '2019-08-20', '10:00:00', 'Gampaha'),
('002', '2019-08-14', '14:00:00', 'Kandy'),
('333', '2019-10-11', '15:59:00', 'fff'),
('444', '2019-10-10', '12:05:00', 'Yakkala');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `NIC` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Type_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Email` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `User_Name` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Password` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Privilege` varchar(60) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`NIC`, `Type_ID`, `Email`, `User_Name`, `Password`, `Privilege`) VALUES
('921814399v', '001', 'sulakkanaid@gmail.com', 'sula', 'abcd', 'std');

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `Vehicle_Number` varchar(30) COLLATE utf8_sinhala_ci NOT NULL,
  `Brand_&_Type` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Color` varchar(50) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Condition_` varchar(50) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Branch_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Supplier_ID` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Date_of_Enlisted` date DEFAULT NULL,
  `Monthly_Rent` varchar(30) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `Due_Date` date DEFAULT NULL,
  `Settled_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`Vehicle_Number`, `Brand_&_Type`, `Color`, `Condition_`, `Branch_ID`, `Supplier_ID`, `Date_of_Enlisted`, `Monthly_Rent`, `Due_Date`, `Settled_Date`) VALUES
('123456', 'car-alto', 'blue', 'good', '001', '001', '2019-08-07', '20000', '2019-08-21', '2019-08-14'),
('48893948', 'car-maruti', 'red', 'good', '002', '001', '2019-08-07', '15000', '2019-08-07', '2019-08-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`Branch_ID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Course_ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Emp_ID`),
  ADD KEY `NIC` (`NIC`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`Exam_ID`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`NIC`);

--
-- Indexes for table `inquiries`
--
ALTER TABLE `inquiries`
  ADD PRIMARY KEY (`Inquiry_ID`);

--
-- Indexes for table `lecture`
--
ALTER TABLE `lecture`
  ADD PRIMARY KEY (`Lecture_ID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`NIC`),
  ADD KEY `Type_ID` (`Type_ID`);

--
-- Indexes for table `person_contact`
--
ALTER TABLE `person_contact`
  ADD PRIMARY KEY (`NIC`);

--
-- Indexes for table `person_type`
--
ALTER TABLE `person_type`
  ADD PRIMARY KEY (`Type_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD KEY `Std_ID` (`Std_ID`),
  ADD KEY `Exam_ID` (`Exam_ID`),
  ADD KEY `Trial_ID` (`Trial_ID`),
  ADD KEY `Next_Lecture_ID` (`Next_Lecture_ID`),
  ADD KEY `Next_Training_ID` (`Next_Training_ID`),
  ADD KEY `NIC` (`NIC`),
  ADD KEY `Branch_ID` (`Branch_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `student_payments`
--
ALTER TABLE `student_payments`
  ADD PRIMARY KEY (`Std_ID`);

--
-- Indexes for table `student_status`
--
ALTER TABLE `student_status`
  ADD PRIMARY KEY (`Std_ID`),
  ADD KEY `Exam_ID` (`Exam_ID`),
  ADD KEY `Trial_ID` (`Trial_ID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Sup_ID`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`Training_ID`);

--
-- Indexes for table `trial`
--
ALTER TABLE `trial`
  ADD PRIMARY KEY (`Trial_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`NIC`),
  ADD KEY `Type_ID` (`Type_ID`);

--
-- Indexes for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`Vehicle_Number`),
  ADD KEY `Branch_ID` (`Branch_ID`),
  ADD KEY `Supplier_ID` (`Supplier_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`NIC`) REFERENCES `person` (`NIC`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`NIC`) REFERENCES `student` (`NIC`),
  ADD CONSTRAINT `images_ibfk_2` FOREIGN KEY (`NIC`) REFERENCES `employee` (`NIC`);

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`Type_ID`) REFERENCES `person_type` (`Type_ID`);

--
-- Constraints for table `person_contact`
--
ALTER TABLE `person_contact`
  ADD CONSTRAINT `person_contact_ibfk_1` FOREIGN KEY (`NIC`) REFERENCES `person` (`NIC`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Exam_ID`) REFERENCES `exam` (`Exam_ID`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`Trial_ID`) REFERENCES `trial` (`Trial_ID`),
  ADD CONSTRAINT `student_ibfk_3` FOREIGN KEY (`Next_Lecture_ID`) REFERENCES `lecture` (`Lecture_ID`),
  ADD CONSTRAINT `student_ibfk_4` FOREIGN KEY (`Next_Training_ID`) REFERENCES `training` (`Training_ID`),
  ADD CONSTRAINT `student_ibfk_5` FOREIGN KEY (`NIC`) REFERENCES `person` (`NIC`),
  ADD CONSTRAINT `student_ibfk_6` FOREIGN KEY (`Branch_ID`) REFERENCES `branch` (`Branch_ID`),
  ADD CONSTRAINT `student_ibfk_7` FOREIGN KEY (`Course_ID`) REFERENCES `course` (`Course_ID`);

--
-- Constraints for table `student_payments`
--
ALTER TABLE `student_payments`
  ADD CONSTRAINT `student_payments_ibfk_1` FOREIGN KEY (`Std_ID`) REFERENCES `student` (`Std_ID`);

--
-- Constraints for table `student_status`
--
ALTER TABLE `student_status`
  ADD CONSTRAINT `student_status_ibfk_1` FOREIGN KEY (`Exam_ID`) REFERENCES `exam` (`Exam_ID`),
  ADD CONSTRAINT `student_status_ibfk_2` FOREIGN KEY (`Trial_ID`) REFERENCES `trial` (`Trial_ID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`Type_ID`) REFERENCES `person_type` (`Type_ID`);

--
-- Constraints for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`Branch_ID`) REFERENCES `branch` (`Branch_ID`),
  ADD CONSTRAINT `vehicles_ibfk_2` FOREIGN KEY (`Supplier_ID`) REFERENCES `supplier` (`Sup_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
