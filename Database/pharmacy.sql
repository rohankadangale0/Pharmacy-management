-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jun 02, 2022 at 10:03 AM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

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
-- Table structure for table `agenttbl`
--

DROP TABLE IF EXISTS `agenttbl`;
CREATE TABLE IF NOT EXISTS `agenttbl` (
  `Agent_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Agent_Name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `Agent_Age` int(11) NOT NULL,
  `Agent_Phone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `Agent_Password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `Gender` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`Agent_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agenttbl`
--

INSERT INTO `agenttbl` (`Agent_Id`, `Agent_Name`, `Agent_Age`, `Agent_Phone`, `Agent_Password`, `Gender`) VALUES
(1, 'Anis', 23, '123', '1234', 'MALE'),
(2, 'Rohan', 23, '123', '12345', 'MALE'),
(3, 'Pushkar', 23, '1234', '123456', 'MALE'),
(4, 'Shivraj', 23, '2364789', '12345', 'MALE'),
(5, 'Yash', 23, '7845123265', '1234', 'MALE');

-- --------------------------------------------------------

--
-- Table structure for table `billno`
--

DROP TABLE IF EXISTS `billno`;
CREATE TABLE IF NOT EXISTS `billno` (
  `billno` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`billno`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `billno`
--

INSERT INTO `billno` (`billno`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Experience` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`Id`, `Name`, `Address`, `Experience`, `Phone`) VALUES
(1, 'dfsf', 'sgdfgdz', '4', 5635635),
(2, 'sdfsd', 'dsfgsdggf', '6', 434534),
(3, 'Xyz', 'abc', '10', 12345678);

-- --------------------------------------------------------

--
-- Table structure for table `medicinetbl`
--

DROP TABLE IF EXISTS `medicinetbl`;
CREATE TABLE IF NOT EXISTS `medicinetbl` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Price` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Manufacture` date NOT NULL,
  `Expiry` date NOT NULL,
  `Company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicinetbl`
--

INSERT INTO `medicinetbl` (`Id`, `Name`, `Price`, `Quantity`, `Manufacture`, `Expiry`, `Company`) VALUES
(1, 'dolo', 10, 60, '2022-06-02', '2023-06-03', 'dfsf'),
(2, 'Crocine', 12, 10, '2022-06-01', '2023-06-02', 'item2'),
(3, 'Ace500mg', 15, 50, '2022-05-30', '2023-05-31', 'item3'),
(4, 'Dicorate500', 250, 80, '2022-06-18', '2023-06-17', 'Xyz');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
