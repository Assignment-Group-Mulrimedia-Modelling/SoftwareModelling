-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2020 at 10:07 PM
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
  `Exp` varchar(20) NOT NULL,
  `Stock` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ItemNO`, `Name`, `Supplier`, `QtyBought`, `Bonus`, `BoxQty`, `WPrice`, `RPrice`, `Exp`, `Stock`) VALUES
(1, 'DrontalM', 'Inicia', '2', '0', '10', '1340', '1608', '09/22', 20),
(2, 'DrontalS', 'Inicia', '3', '1', '20', '900', '1200', '15/23', 80),
(3, 'Fervex', 'Nouvelle', '25', '5', '8', '80', '105', '12/22', 240),
(4, 'HCQS', 'FTM', '20', '4', '30', '190', '250', '04/22', 720),
(5, 'Vasograin', 'Mauritius', '5', '1', '100', '750', '832', '10/20', 600),
(6, 'Panadol', 'Nouvelle', '25', '6', '100', '230', '290', '05/21', 3100),
(7, 'Frontline', 'Inicia', '10', '1', '1', '180', '230', '05/22', 11),
(8, 'Atacand', 'IBL', '4', '1', '28', '678', '805', '05/23', 140),
(9, 'Lempsip', 'Unicorn', '10', '3', '8', '95', '123', '08/20', 104),
(10, 'Uniflu', 'Socimed', '6', '1', '12', '145', '185', '05/21', 84),
(21538, 'Doliprane', 'IBL', '45', '7', '8', '39', '51', '03/21', 416),
(38695, 'DrontalL', 'Inicia', '3', '1', '20', '3800', '4560', '08/22', 80);

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
