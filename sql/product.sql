-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2020 at 09:41 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aid1`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ItemNO` varchar(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Supplier` varchar(50) NOT NULL,
  `QtyBought` varchar(50) NOT NULL,
  `Bouns` varchar(50) NOT NULL,
  `Box Qty` varchar(50) NOT NULL,
  `W.Price` varchar(50) NOT NULL,
  `R.Price` varchar(50) NOT NULL,
  `Exp Date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ItemNO`, `Name`, `Supplier`, `QtyBought`, `Bouns`, `Box Qty`, `W.Price`, `R.Price`, `Exp Date`) VALUES
('21538', 'Doliprane', 'DST-Ltd', '45', '0', '8', '45', '57', '03/21'),
('38694', 'Panadol', 'Unicorn-Trading', '3', '0', '8', '3', '5', '10/20');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
