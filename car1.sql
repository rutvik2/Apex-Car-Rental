-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.17 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for carrental_db
CREATE DATABASE IF NOT EXISTS `carrental_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carrental_db`;

-- Dumping structure for table carrental_db.company
CREATE TABLE IF NOT EXISTS `company` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(50) DEFAULT NULL,
  KEY `sno` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table carrental_db.company: ~12 rows (approximately)
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`sno`, `company`) VALUES
	(1, 'Toyota'),
	(2, 'Audi'),
	(3, 'BMW'),
	(4, 'Mercedes'),
	(5, 'Hyundai'),
	(6, 'Chevrolet'),
	(7, 'Bugatti'),
	(8, 'Maruti'),
	(9, 'Ford'),
	(10, 'Lamborghini'),
	(11, 'Tata'),
	(12, 'Mahindra');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

-- Dumping structure for table carrental_db.customerdetails
CREATE TABLE IF NOT EXISTS `customerdetails` (
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `driverid` varchar(50) DEFAULT NULL,
  `carnumber` varchar(50) DEFAULT NULL,
  `rentingdays` int(11) DEFAULT NULL,
  `bill` int(11) DEFAULT NULL,
  `bdate` date DEFAULT NULL,
  `rdate` date DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table carrental_db.customerdetails: ~2 rows (approximately)
/*!40000 ALTER TABLE `customerdetails` DISABLE KEYS */;
INSERT INTO `customerdetails` (`name`, `gender`, `address`, `phoneno`, `company`, `customerid`, `driverid`, `carnumber`, `rentingdays`, `bill`, `bdate`, `rdate`) VALUES
	('Rekha Shah', 'female', '12,B Block, Jamna Appt, Nagpur', '7392649256', 'Toyota', 8, '', 'B1636FKK', 5, 7500, '2020-01-07', '2020-01-12'),
	('Papiha Chavan', 'Female', 'Sindi', '1111111112', 'Select', 9, '25', 'PB1495JE', 7, 35000, '2020-10-17', '2020-10-24');
/*!40000 ALTER TABLE `customerdetails` ENABLE KEYS */;

-- Dumping structure for table carrental_db.driverdetails
CREATE TABLE IF NOT EXISTS `driverdetails` (
  `driverid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `experience` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `dateofjoin` date DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `carnumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`driverid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table carrental_db.driverdetails: ~1 rows (approximately)
/*!40000 ALTER TABLE `driverdetails` DISABLE KEYS */;
INSERT INTO `driverdetails` (`driverid`, `name`, `gender`, `address`, `phoneno`, `experience`, `dob`, `dateofjoin`, `path`, `carnumber`) VALUES
	(25, 'Krish Chavan', 'male', 'Sindi', '8888888888', 'No Experience', '2004-09-24', '2020-10-17', 'C:\\Users\\Lenovo\\OneDrive\\Desktop\\Imp Docs\\Pspt photo.jpg', 'PB1495JE');
/*!40000 ALTER TABLE `driverdetails` ENABLE KEYS */;

-- Dumping structure for table carrental_db.empdetails
CREATE TABLE IF NOT EXISTS `empdetails` (
  `name` varchar(50) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `dateofjoin` date DEFAULT NULL,
  `qualification` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table carrental_db.empdetails: ~3 rows (approximately)
/*!40000 ALTER TABLE `empdetails` DISABLE KEYS */;
INSERT INTO `empdetails` (`name`, `phoneno`, `address`, `username`, `dob`, `dateofjoin`, `qualification`, `gender`) VALUES
	('Rahul Sharma', '6465363643', 'India, Sindi', 'emp1', '1990-01-16', '2020-01-13', 'Graduate', 'male'),
	('Rutuja Chavan', '1234567891', 'Sindi', 'wonderwoman', '1998-01-19', '2020-10-17', 'Graduate', 'female'),
	('Abc Def', '76543256', 'XYZJEFD', 'abc123', '1999-10-22', '2020-10-24', '10+2', 'male');
/*!40000 ALTER TABLE `empdetails` ENABLE KEYS */;

-- Dumping structure for table carrental_db.emplist
CREATE TABLE IF NOT EXISTS `emplist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `usertype` varchar(50) NOT NULL DEFAULT 'employee',
  PRIMARY KEY (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table carrental_db.emplist: ~4 rows (approximately)
/*!40000 ALTER TABLE `emplist` DISABLE KEYS */;
INSERT INTO `emplist` (`id`, `username`, `password`, `usertype`) VALUES
	(13, 'abc123', 'abc123', 'employee'),
	(1, 'admin', 'admin', 'admin'),
	(11, 'emp1', 'emp1', 'employee'),
	(12, 'wonderwoman', 'wonderman', 'employee');
/*!40000 ALTER TABLE `emplist` ENABLE KEYS */;

-- Dumping structure for table carrental_db.servicecars
CREATE TABLE IF NOT EXISTS `servicecars` (
  `model` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `carnumber` varchar(50) DEFAULT NULL,
  `makeyear` varchar(50) DEFAULT NULL,
  `useas` varchar(50) DEFAULT NULL,
  `seat_cap` varchar(50) DEFAULT NULL,
  `engine_cap` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `varient` varchar(50) DEFAULT NULL,
  `rent` varchar(50) DEFAULT NULL,
  `driverid` varchar(50) DEFAULT '',
  `driver` varchar(50) DEFAULT 'No',
  `status` varchar(50) DEFAULT 'Not Rented'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table carrental_db.servicecars: ~7 rows (approximately)
/*!40000 ALTER TABLE `servicecars` DISABLE KEYS */;
INSERT INTO `servicecars` (`model`, `company`, `carnumber`, `makeyear`, `useas`, `seat_cap`, `engine_cap`, `type`, `varient`, `rent`, `driverid`, `driver`, `status`) VALUES
	('Avanza', 'Toyota', 'B1636FKK', '2013', 'Individual Rent', '7 Seater', '1000', 'AC', 'Economic Model', '1500', '', 'no', 'Not Rented'),
	('Chiron', 'Bugatti', 'PB1495JE', '2018', 'With Driver', '2 Seater', '2500', 'AC', 'Top Model', '5000', '25', 'Yes', 'Not Rented'),
	('EcoSport', 'Ford', 'MH7623KS', '2018', 'With Driver', '5 Seater', '1498 cc', 'AC', 'Top Model', '2500', '', 'no', 'Not Rented'),
	('R8', 'Audi', 'UP8462KS', '2018', 'Individual Rent', '2 Seater', '5204 cc', 'AC', 'Top Model', '5000', '', 'no', 'Not Rented'),
	('Innova', 'Toyota', 'CR3524V', '2019', 'With Driver', '7 Seater', '1400', 'AC', 'Economic Model', '1700', ' ', 'no', 'Not Rented'),
	('Aventador', 'Lamborghini', 'AA8823KI', '2020', 'Individual Rent', '2 Seater', '2400', 'AC', 'Top Model', '6500', '', 'no', 'Not Rented'),
	('PQR300', 'Mahindra', '7263WE', '2018', 'Individual Rent', '7 Seater', '700 ', 'AC', 'Top Model', '1000', '', 'No', 'Not Rented');
/*!40000 ALTER TABLE `servicecars` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
