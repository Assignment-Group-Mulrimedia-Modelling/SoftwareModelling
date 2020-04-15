-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 09:15 AM
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
-- Table structure for table `customer_details`
--

CREATE TABLE `customer_details` (
  `Surname` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone Number` int(50) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `D.O.B` date DEFAULT NULL,
  `Medical Issues` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_details`
--

INSERT INTO `customer_details` (`Surname`, `Name`, `Address`, `Phone Number`, `Sex`, `D.O.B`, `Medical Issues`) VALUES
('Jowa', 'Mouzammil', 'Rosehill', 1234567, 'male', '1999-03-02', 'wertywertyui'),
('Edoo', 'Wasimah', 'Vacoas', 234567, 'Female', '1999-05-12', 'Diabetes'),
('Babooa', 'Yash', 'TRIOLET', 23456567, 'male', '1999-07-12', 'Hypertention'),
('Edoo', 'Tausif', 'Vacoas', 211134567, 'male', '1999-09-11', 'qwertyuikjhgfd'),
('Edoo', 'Wass', 'phoenix', 2147483647, 'Female', '1999-06-12', 'asdfghjkl');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
