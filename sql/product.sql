-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 12:21 PM
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
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ItemNO` int(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Supplier` varchar(50) NOT NULL,
  `QtyBought` varchar(50) NOT NULL,
  `Bonus` varchar(50) NOT NULL,
  `BoxQty` varchar(50) NOT NULL,
  `WPrice` varchar(50) NOT NULL,
  `RPrice` varchar(50) NOT NULL,
  `Exp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ItemNO`, `Name`, `Supplier`, `QtyBought`, `Bonus`, `BoxQty`, `WPrice`, `RPrice`, `Exp`) VALUES
(1, 'Drontal Medium', 'Inicia', '2', '0', '20', '1340', '1608', '09/22'),
(2, 'Drontal Small', 'Inicia', '3', '1', '20', '900', '1200', '05/23'),
(21538, 'Doliprane', 'DST-Ltd', '45', '0', '8', '45', '57', '03/21'),
(38694, 'Panadol', 'Unicorn-Trading', '3', '0', '8', '3', '5', '10/20'),
(38695, 'Drontal Large', 'Inicia', '2', '0', '20', '3800', '4560', '08/22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ItemNO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ItemNO` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38696;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

