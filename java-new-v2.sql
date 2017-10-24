-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2017 at 02:16 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java-new-v2`
--

-- --------------------------------------------------------

--
-- Table structure for table `alatlap`
--

CREATE TABLE `alatlap` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `jenis` varchar(45) DEFAULT NULL,
  `hargaperjam` double DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `kategori` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `alatlap`
--

INSERT INTO `alatlap` (`id`, `nama`, `jenis`, `hargaperjam`, `stok`, `kategori`) VALUES
(9, 'lap studio 1', 'Lapangan Rumput', 100000, 1, 'Lapangan'),
(10, 'lap studio 2', 'Lapangan interlock', 110000, 1, 'Lapangan'),
(11, 'lap studio 3', 'Lapangan Rumput', 100000, 1, 'Lapangan'),
(12, 'Good Defend Hand Nike', 'Sarung Tangan', 2000, 5, 'Alat'),
(13, 'Nike Defend foot', 'Pelindung/Dekker', 2000, 5, 'Alat'),
(14, 'Nike Ronaldo ', 'Sepatu', 5000, 5, 'Alat');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `username` varchar(12) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`id`, `nama`, `username`, `password`) VALUES
(2, 'Ali baba', 'ali', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `pelunasan1`
--

CREATE TABLE `pelunasan1` (
  `id` int(11) NOT NULL,
  `norental` varchar(45) DEFAULT NULL,
  `tglbayar` date DEFAULT NULL,
  `uangpelunasan` double DEFAULT NULL,
  `uangkembali` double DEFAULT NULL,
  `penyewaan_id` int(11) NOT NULL,
  `kasir_id` int(11) NOT NULL,
  `alatlap_id` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pelunasan1`
--

INSERT INTO `pelunasan1` (`id`, `norental`, `tglbayar`, `uangpelunasan`, `uangkembali`, `penyewaan_id`, `kasir_id`, `alatlap_id`, `qty`) VALUES
(32, 'BR401', '2017-07-11', 100000, 60000, 23, 2, 9, 1),
(33, 'BR411', '2017-07-11', 50000, 1000, 25, 2, 10, 1),
(34, 'BR421', '2017-07-11', 50000, 0, 24, 2, 9, 1),
(35, 'BR431', '2017-07-12', 100000, 46000, 26, 2, 9, 1),
(36, 'BR431', '2017-07-12', 100000, 46000, 26, 2, 12, 2),
(37, 'BR441', '2017-07-12', 200000, 61000, 27, 2, 9, 1),
(38, 'BR441', '2017-07-12', 200000, 61000, 27, 2, 10, 1),
(39, 'BR451', '2017-07-12', 100000, 46000, 28, 2, 9, 1),
(40, 'BR451', '2017-07-12', 100000, 46000, 28, 2, 12, 2),
(41, 'BR461', '2017-07-15', 100000, 35000, 29, 2, 10, 1),
(42, 'BR461', '2017-07-15', 100000, 35000, 29, 2, 14, 1);

--
-- Triggers `pelunasan1`
--
DELIMITER $$
CREATE TRIGGER `pelunasan1_AFTER_INSERT` AFTER INSERT ON `pelunasan1` FOR EACH ROW BEGIN
update penyewaan set sisabayar = 0
	where id = new.penyewaan_id;
    
    update alatlap set stok = stok + new.qty
	where id = new.alatlap_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `penyewa`
--

CREATE TABLE `penyewa` (
  `id` int(11) NOT NULL,
  `team` varchar(45) DEFAULT NULL,
  `manager` varchar(45) DEFAULT NULL,
  `nohp` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penyewa`
--

INSERT INTO `penyewa` (`id`, `team`, `manager`, `nohp`, `status`) VALUES
(12, 'KBL fc Bumigora', 'Husnul Wardi', '083129978394', 'Member'),
(13, 'KAMIL FC Bumigora', 'Rahman Hakim', '083129978394', 'Umum'),
(14, 'BEM Bumigora', 'Gusti Arsyad', '085123000111', 'Member'),
(15, 'PC Bumigora', 'Roby Huzwandar', '083129978394', 'Umum');

-- --------------------------------------------------------

--
-- Table structure for table `penyewaan`
--

CREATE TABLE `penyewaan` (
  `id` int(11) NOT NULL,
  `tglrental` date DEFAULT NULL,
  `tglmain` varchar(100) DEFAULT NULL,
  `jammasuk` varchar(45) DEFAULT NULL,
  `jamkeluar` varchar(45) DEFAULT NULL,
  `totalbayar` double DEFAULT NULL,
  `uangmuka` double DEFAULT NULL,
  `sisabayar` double DEFAULT NULL,
  `kasir_id` int(11) NOT NULL,
  `noboking` varchar(45) DEFAULT NULL,
  `penyewa_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penyewaan`
--

INSERT INTO `penyewaan` (`id`, `tglrental`, `tglmain`, `jammasuk`, `jamkeluar`, `totalbayar`, `uangmuka`, `sisabayar`, `kasir_id`, `noboking`, `penyewa_id`) VALUES
(23, '2017-07-11', '2017-07-12', '16:0:0', '17:0:0', 100000, 50000, 0, 2, 'BO-01', 12),
(24, '2017-07-11', '2017-07-13', '16:0:0', '17:0:0', 100000, 50000, 0, 2, 'BO-11', 13),
(25, '2017-07-11', '2017-07-12', '16:0:0', '17:0:0', 110000, 50000, 0, 2, 'BO-21', 14),
(26, '2017-07-12', '2017-07-13', '16:0:0', '17:0:0', 104000, 50000, 0, 2, 'BO-31', 13),
(27, '2017-07-12', '2017-07-13', '16:0:0', '17:0:0', 210000, 50000, 0, 2, 'BO-41', 14),
(28, '2017-07-12', '2017-07-13', '16:0:0', '17:0:0', 104000, 50000, 0, 2, 'BO-51', 13),
(29, '2017-07-15', '2017-07-16', '16:0:0', '17:0:0', 115000, 50000, 0, 2, 'BO-61', 15);

-- --------------------------------------------------------

--
-- Table structure for table `penyewaan_item`
--

CREATE TABLE `penyewaan_item` (
  `id` int(11) NOT NULL,
  `jumlahjam` int(11) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `penyewaan_id` int(11) NOT NULL,
  `subtotal` double DEFAULT NULL,
  `alatlap_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penyewaan_item`
--

INSERT INTO `penyewaan_item` (`id`, `jumlahjam`, `qty`, `penyewaan_id`, `subtotal`, `alatlap_id`) VALUES
(25, 1, 1, 23, 100000, 9),
(26, 1, 1, 24, 100000, 9),
(27, 1, 1, 25, 110000, 10),
(28, 1, 1, 26, 100000, 9),
(29, 1, 2, 26, 4000, 12),
(30, 1, 1, 27, 100000, 9),
(31, 1, 1, 27, 110000, 10),
(32, 1, 1, 28, 100000, 9),
(33, 1, 2, 28, 4000, 12),
(34, 1, 1, 29, 110000, 10),
(35, 1, 1, 29, 5000, 14);

--
-- Triggers `penyewaan_item`
--
DELIMITER $$
CREATE TRIGGER `penyewaan_item_AFTER_INSERT` AFTER INSERT ON `penyewaan_item` FOR EACH ROW BEGIN
update alatlap set stok = stok - new.qty
	where id = new.alatlap_id;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alatlap`
--
ALTER TABLE `alatlap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pelunasan1`
--
ALTER TABLE `pelunasan1`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pelunasan1_penyewaan1_idx` (`penyewaan_id`),
  ADD KEY `fk_pelunasan1_kasir1_idx` (`kasir_id`),
  ADD KEY `fk_pelunasan1_alatlap1_idx` (`alatlap_id`);

--
-- Indexes for table `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penyewaan`
--
ALTER TABLE `penyewaan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `noboking_UNIQUE` (`noboking`),
  ADD KEY `fk_penyewaan_kasir_idx` (`kasir_id`),
  ADD KEY `fk_penyewaan_penyewa1_idx` (`penyewa_id`);

--
-- Indexes for table `penyewaan_item`
--
ALTER TABLE `penyewaan_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_penyewaan_item_penyewaan1_idx` (`penyewaan_id`),
  ADD KEY `fk_penyewaan_item_alatlap1_idx` (`alatlap_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alatlap`
--
ALTER TABLE `alatlap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pelunasan1`
--
ALTER TABLE `pelunasan1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `penyewa`
--
ALTER TABLE `penyewa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `penyewaan`
--
ALTER TABLE `penyewaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `penyewaan_item`
--
ALTER TABLE `penyewaan_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `pelunasan1`
--
ALTER TABLE `pelunasan1`
  ADD CONSTRAINT `fk_pelunasan1_alatlap1` FOREIGN KEY (`alatlap_id`) REFERENCES `alatlap` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pelunasan1_kasir1` FOREIGN KEY (`kasir_id`) REFERENCES `kasir` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pelunasan1_penyewaan1` FOREIGN KEY (`penyewaan_id`) REFERENCES `penyewaan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penyewaan`
--
ALTER TABLE `penyewaan`
  ADD CONSTRAINT `fk_penyewaan_kasir` FOREIGN KEY (`kasir_id`) REFERENCES `kasir` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_penyewaan_penyewa1` FOREIGN KEY (`penyewa_id`) REFERENCES `penyewa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penyewaan_item`
--
ALTER TABLE `penyewaan_item`
  ADD CONSTRAINT `fk_penyewaan_item_alatlap1` FOREIGN KEY (`alatlap_id`) REFERENCES `alatlap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_penyewaan_item_penyewaan1` FOREIGN KEY (`penyewaan_id`) REFERENCES `penyewaan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
