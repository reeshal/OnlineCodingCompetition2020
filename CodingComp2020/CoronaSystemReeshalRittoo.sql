-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 01, 2020 at 06:24 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CoronaSystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `dailyTimeslots`
--

CREATE TABLE `dailyTimeslots` (
  `shopId` int(11) NOT NULL,
  `slots` time NOT NULL,
  `servicecode` varchar(15) NOT NULL,
  `customername` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailyTimeslots`
--

INSERT INTO `dailyTimeslots` (`shopId`, `slots`, `servicecode`, `customername`) VALUES
(6, '08:30:00', '1AXBI6', ''),
(6, '09:00:00', 'UJ4A1X', ''),
(6, '09:30:00', '6HJYBN', ''),
(6, '10:00:00', 'DVWKIW', ''),
(6, '10:30:00', 'AFKHJA', ''),
(6, '11:00:00', 'PMVPHG', ''),
(6, '11:30:00', 'D44HRD', ''),
(6, '12:00:00', 'CNXD8I', ''),
(6, '12:30:00', 'T1YB3M', ''),
(6, '13:00:00', 'HF6DH0', ''),
(6, '13:30:00', 'P4OHON', ''),
(6, '14:00:00', 'PQFYN5', ''),
(6, '14:30:00', 'KZ1BQZ', ''),
(6, '15:00:00', 'N2DB45', ''),
(6, '15:30:00', 'E04NUN', 'Hitasha'),
(6, '16:00:00', 'ZE8W2M', 'Paupiah'),
(6, '16:30:00', '21VZZJ', 'Lavnish'),
(6, '17:00:00', '6X83SJ', ''),
(7, '09:25:00', 'ZQWREP', 'Vidushi'),
(7, '09:50:00', 'S7FRYY', ''),
(7, '10:15:00', 'UA0BRP', ''),
(7, '10:40:00', 'WB1V62', ''),
(7, '11:05:00', '013ERO', ''),
(7, '11:30:00', 'NHKMY6', ''),
(7, '11:55:00', 'BZ4MWS', ''),
(7, '12:20:00', 'JAU4V1', ''),
(7, '12:45:00', 'CUVOBP', 'Sadia'),
(7, '13:10:00', 'GB3WD5', ''),
(7, '13:35:00', 'I4O34H', ''),
(7, '14:00:00', 'RYQ2NI', ''),
(7, '14:25:00', 'TLLNZL', ''),
(7, '14:50:00', 'KQ7NWL', ''),
(7, '15:15:00', 'ZTY51H', ''),
(7, '15:40:00', 'PPZ5T2', 'Shakira'),
(7, '16:05:00', '53AS3W', ''),
(7, '16:30:00', 'S14XFB', 'Tashil'),
(7, '16:55:00', 'BBXIRL', 'Ria'),
(7, '17:20:00', '5PZO7A', ''),
(8, '09:45:00', 'VKRBUB', ''),
(8, '10:00:00', 'MM1QXV', ''),
(8, '10:15:00', 'VQ5X37', ''),
(8, '10:30:00', 'OXDCHV', ''),
(8, '10:45:00', 'G5EFKQ', 'Boosun'),
(8, '11:00:00', '3P01NB', ''),
(8, '11:15:00', 'H3G1QO', ''),
(8, '11:30:00', 'WWP2O5', ''),
(8, '11:45:00', 'GDUU0W', ''),
(8, '12:00:00', '876UNY', ''),
(8, '12:15:00', 'RJMHTX', ''),
(8, '12:30:00', 'M8AR05', ''),
(8, '12:45:00', 'H75B8W', ''),
(8, '13:00:00', 'QK3N81', ''),
(8, '13:15:00', '41X7DN', 'hena'),
(8, '13:30:00', '2TJY1C', 'YOYO'),
(8, '13:45:00', 'FKDQB8', ''),
(8, '14:00:00', '8TWA66', ''),
(8, '14:15:00', 'CEGF23', 'reeshal'),
(8, '14:30:00', '8PJ4VQ', ''),
(9, '06:35:00', 'GZ9S37', ''),
(9, '07:10:00', '07LI7M', ''),
(9, '07:45:00', 'OIGP81', ''),
(9, '08:20:00', '4G0BYX', ''),
(9, '08:55:00', 'QCBATB', ''),
(9, '09:30:00', 'E7NDA1', ''),
(9, '10:05:00', 'FKRG2O', ''),
(9, '10:40:00', '0XYQ1W', ''),
(9, '11:15:00', '5QIJY6', ''),
(9, '11:50:00', 'KU9NB9', ''),
(9, '12:25:00', 'DT1MLZ', ''),
(9, '13:00:00', 'DPLQPO', ''),
(9, '13:35:00', 'MLD5H7', ''),
(9, '14:10:00', '8KH8OK', ''),
(9, '14:45:00', '56OBNO', ''),
(9, '15:20:00', '205TWY', 'Yadhav'),
(9, '15:55:00', 'NBN8R5', ''),
(9, '16:30:00', 'ZHRIXD', ''),
(9, '17:05:00', '6SEAEK', ''),
(9, '17:40:00', 'IQ7K11', ''),
(10, '10:25:00', 'S11XM2', ''),
(10, '10:50:00', 'TUHG9O', ''),
(10, '11:15:00', 'Y089BB', ''),
(10, '11:40:00', 'OZ91T9', ''),
(10, '12:05:00', 'B4J4PH', ''),
(10, '12:30:00', 'NK2ZEZ', ''),
(10, '12:55:00', '1ID5NK', ''),
(10, '13:20:00', 'LYJF4C', ''),
(10, '13:45:00', '3LSBLA', ''),
(10, '14:10:00', '0F0GNP', ''),
(10, '14:35:00', 'KOY51N', ''),
(10, '15:00:00', 'YM101P', ''),
(10, '15:25:00', 'FYPX3U', ''),
(10, '15:50:00', 'P23XDX', ''),
(10, '16:15:00', '0A2E53', ''),
(10, '16:40:00', '7AXL1D', ''),
(10, '17:05:00', 'SBGBS7', ''),
(10, '17:30:00', 'Z9ZTNL', ''),
(10, '17:55:00', 'F4OMR4', ''),
(10, '18:20:00', '254PVV', ''),
(10, '18:45:00', 'D5N15Z', ''),
(11, '09:50:00', 'TDPW62', ''),
(11, '10:40:00', '9K56QL', ''),
(11, '11:30:00', '2KC6CB', ''),
(11, '12:20:00', '9SCB0T', ''),
(11, '13:10:00', 'K1PSEC', ''),
(11, '14:00:00', 'VPEFOF', ''),
(11, '14:50:00', 'OXK32S', ''),
(11, '15:40:00', 'SITHQS', ''),
(11, '16:30:00', 'A8BYJD', ''),
(11, '17:20:00', 'AVX4D9', '');

-- --------------------------------------------------------

--
-- Table structure for table `Supermarket`
--

CREATE TABLE `Supermarket` (
  `shopName` varchar(30) NOT NULL,
  `shopAddress` varchar(50) NOT NULL,
  `shopRSA` double NOT NULL,
  `opening` time NOT NULL,
  `closing` time NOT NULL,
  `serviceTime` int(11) NOT NULL,
  `shopId` int(11) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Supermarket`
--

INSERT INTO `Supermarket` (`shopName`, `shopAddress`, `shopRSA`, `opening`, `closing`, `serviceTime`, `shopId`, `password`) VALUES
('Dreamprice', 'Souillac', 9000, '08:00:00', '17:00:00', 30, 6, 'reeshal18'),
('Winners', 'Curepipe', 12000, '09:00:00', '17:30:00', 25, 7, 'reeshal18'),
('Intermart', 'Ebene', 12000, '09:30:00', '14:30:00', 15, 8, 'reeshal18'),
('Lolo', 'Morcellement Andre', 9800, '06:00:00', '18:00:00', 35, 9, 'reeshal18'),
('Shoprite', 'Trainon', 4560, '10:00:00', '19:00:00', 25, 10, 'reeshal18'),
('NewShop', 'Souillac', 450, '09:00:00', '18:00:00', 50, 11, 'reeshal17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Supermarket`
--
ALTER TABLE `Supermarket`
  ADD PRIMARY KEY (`shopId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Supermarket`
--
ALTER TABLE `Supermarket`
  MODIFY `shopId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
