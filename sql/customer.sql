-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2020 at 02:44 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `ID` int(4) NOT NULL,
  `Surname` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Number` varchar(50) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `DOB` varchar(15) DEFAULT NULL,
  `MedicalIssues` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Surname`, `Name`, `Address`, `Number`, `Sex`, `DOB`, `MedicalIssues`) VALUES
(1, 'Edoo', 'Wasimah', 'Vacoas', '23454567', 'Female', '1999-05-12', 'Diabetes'),
(2, 'Babooa', 'Yash', 'Triolet', '124511567', 'male', '1999-06-08', 'Hypertension'),
(3, 'Edoo', 'Tausif', 'Vacoas', '1123454567', 'male', '1999-06-02', 'asdfghjk'),
(4, 'Jowa', 'Mouzammil', 'Quatre Bornes', '56969696', 'Male', '22/06/99', 'Nothing'),
(5, 'Bacsou', 'Zaynab', '31/03/98', '69696969', 'F', '31/03/98', 'Mental');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
