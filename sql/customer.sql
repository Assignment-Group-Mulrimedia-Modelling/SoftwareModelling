-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2020 at 04:40 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` varchar(50) NOT NULL,
  `Surname` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone Number` varchar(50) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `D.O.B` date DEFAULT NULL,
  `Medical Issues` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Surname`, `Name`, `Address`, `Phone Number`, `Sex`, `D.O.B`, `Medical Issues`) VALUES
('1', 'Edoo', 'Wasimah', 'Vacoas', '23454567', 'Female', '1999-05-12', 'Diabetes'),
('2', 'Babooa', 'Yash', 'Triolet', '124511567', 'male', '1999-06-08', 'Hypertension'),
('3', 'Edoo', 'Tausif', 'Vacoas', '1123454567', 'male', '1999-06-02', 'asdfghjk'),
('4', 'Jowa', 'Muzam', 'RHILL', '29934545967', 'male', '1999-09-11', 'asdfghjk'),
('5', 'edoo', 'wass', 'vvv', '234567', 'male', '1999-04-04', 'dfnhfbfyffrfnh'),
('6', 'mmm', 'msm', 'nmsnsm', '23432111', 'male', '2001-03-02', 'udrufhu5'),
('7', 'mickey', 'mousee', 'disneyland', '98765432', 'male', '2005-01-08', 'hufhu4fnnr5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
