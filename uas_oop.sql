-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2025 at 06:58 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_oop2`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `passwords` varchar(50) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_user`, `id_role`, `username`, `passwords`, `full_name`) VALUES
(1, 1, 'Admin', '123', 'Admin'),
(2, 2, 'Steven', '123', 'Steven Edmund Pratama'),
(4, 2, 'Ryan', '123', 'Ryan F');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `id_purchase` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `purchase_date` date NOT NULL,
  `purchase_qty` int(11) NOT NULL,
  `total_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id_purchase`, `id_supplier`, `id_product`, `purchase_date`, `purchase_qty`, `total_price`) VALUES
(1, 1, 4, '2024-01-07', 50, 0.00),
(2, 1, 5, '2024-01-07', 10, 0.00),
(3, 1, 6, '2024-01-07', 15, 0.00),
(4, 2, 7, '2024-01-08', 30, 0.00),
(5, 2, 7, '2024-01-10', 50, 0.00),
(6, 2, 4, '2024-01-10', 50, 0.00),
(7, 2, 4, '2024-01-10', 50, 0.00),
(8, 1, 11, '2025-01-23', 50, 50000.00);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id_sale` int(11) NOT NULL,
  `sale_date` date NOT NULL,
  `discount` decimal(10,2) NOT NULL,
  `tax` decimal(10,2) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `total_bayar` decimal(10,2) NOT NULL,
  `kembalian` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_sale`, `sale_date`, `discount`, `tax`, `sale_total_price`, `total_bayar`, `kembalian`) VALUES
(1, '2024-12-18', 0.00, 11.00, 438450.00, 450000.00, 11550.00),
(2, '2024-12-18', 0.00, 11.00, 627150.00, 650000.00, 22850.00),
(3, '2024-12-19', 0.00, 11.00, 206460.00, 250000.00, 43540.00),
(4, '2024-12-20', 0.00, 11.00, 32190.00, 50000.00, 17810.00),
(5, '2025-06-11', 0.00, 11.00, 488400.00, 500000.00, 11600.00),
(6, '2025-06-11', 0.00, 11.00, 64380.00, 100000.00, 35620.00),
(7, '2025-06-11', 0.00, 11.00, 48840.00, 50000.00, 1160.00),
(8, '2025-06-11', 0.00, 10.00, 385000.00, 400000.00, 15000.00),
(9, '2025-06-11', 0.00, 10.00, 123200.00, 150000.00, 26800.00),
(10, '2025-06-11', 0.00, 10.00, 198000.00, 200000.00, 2000.00),
(11, '2024-12-12', 5.00, 10.00, 256500.00, 257000.00, 500.00),
(12, '2025-01-08', 7.00, 11.00, 299200.00, 300000.00, 800.00),
(13, '2025-02-21', 3.50, 12.00, 234800.00, 235000.00, 200.00),
(14, '2025-03-13', 4.00, 10.50, 273100.00, 274000.00, 900.00),
(15, '2025-04-25', 6.00, 11.50, 310400.00, 311000.00, 600.00),
(16, '2025-01-14', 6.00, 10.00, 270000.00, 270000.00, 0.00),
(17, '2025-01-28', 4.00, 11.00, 300400.00, 301000.00, 600.00),
(18, '2025-02-07', 7.00, 12.00, 235200.00, 236000.00, 800.00),
(19, '2025-02-25', 3.00, 10.00, 248600.00, 249000.00, 400.00),
(20, '2025-03-11', 8.00, 11.50, 292100.00, 293000.00, 900.00),
(21, '2025-03-25', 5.00, 10.50, 310300.00, 311000.00, 700.00),
(22, '2025-04-09', 3.50, 10.00, 277300.00, 278000.00, 700.00),
(23, '2025-04-24', 6.50, 11.00, 289500.00, 290000.00, 500.00),
(24, '2025-05-10', 5.00, 12.00, 265100.00, 266000.00, 900.00),
(25, '2025-05-29', 4.00, 10.00, 299200.00, 300000.00, 800.00),
(26, '2025-06-01', 4.00, 10.00, 250000.00, 250000.00, 0.00),
(27, '2025-06-02', 5.00, 11.00, 275000.00, 275000.00, 0.00),
(28, '2025-06-03', 3.00, 12.00, 300000.00, 300000.00, 0.00),
(29, '2025-06-04', 8.00, 10.00, 234000.00, 234000.00, 0.00),
(30, '2025-06-05', 6.00, 10.50, 260000.00, 260000.00, 0.00),
(31, '2025-06-06', 7.00, 11.00, 280000.00, 280000.00, 0.00),
(32, '2025-06-07', 4.50, 10.00, 295000.00, 295000.00, 0.00),
(33, '2025-06-08', 3.50, 12.00, 245000.00, 245000.00, 0.00),
(34, '2025-06-09', 5.00, 11.00, 265000.00, 265000.00, 0.00),
(35, '2025-06-10', 6.50, 10.00, 285000.00, 285000.00, 0.00),
(36, '2025-06-10', 5.00, 10.00, 250000.00, 260000.00, 10000.00),
(37, '2025-06-10', 6.00, 11.00, 260000.00, 272000.00, 12000.00),
(38, '2025-06-10', 7.00, 10.00, 270000.00, 282000.00, 12000.00),
(39, '2025-06-10', 3.00, 12.00, 285000.00, 295000.00, 10000.00),
(40, '2025-06-10', 4.00, 11.00, 240000.00, 250000.00, 10000.00),
(41, '2025-06-10', 8.00, 10.50, 275000.00, 288000.00, 13000.00),
(42, '2025-06-11', 3.50, 11.50, 265000.00, 275000.00, 10000.00),
(43, '2025-06-11', 4.00, 10.00, 295000.00, 308000.00, 13000.00),
(44, '2025-06-11', 7.00, 11.00, 230000.00, 242000.00, 12000.00),
(45, '2025-06-11', 5.50, 10.50, 245000.00, 258000.00, 13000.00),
(46, '2025-06-11', 6.00, 12.00, 255000.00, 266000.00, 11000.00),
(47, '2025-06-11', 3.00, 10.00, 310000.00, 320000.00, 10000.00),
(48, '2025-06-11', 4.50, 11.00, 290000.00, 305000.00, 15000.00),
(49, '2025-06-11', 5.00, 10.00, 300000.00, 315000.00, 15000.00),
(50, '2025-06-11', 6.50, 11.00, 280000.00, 292000.00, 12000.00);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `product_code` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `price_buy` decimal(10,2) NOT NULL,
  `price_sell` decimal(10,2) NOT NULL,
  `product_unit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id_product`, `id_supplier`, `product_code`, `product_name`, `price_buy`, `price_sell`, `product_unit`) VALUES
(4, 1, '23110003', 'Susu Diarycrown', 21000.00, 25000.00, 'pcs'),
(5, 1, '23110004', 'Blue9 600ml', 35000.00, 40000.00, 'dus'),
(6, 1, '23110005', 'Nestle 600ml', 39000.00, 44000.00, 'dus'),
(7, 2, '23110006', 'Passy 600ml', 32000.00, 36000.00, 'dus'),
(8, 2, '23110007', 'Aqua 600ml', 35000.00, 40000.00, 'dus'),
(9, 1, '23110008', 'Mie Indomie Kaldu', 40000.00, 44000.00, 'dus'),
(10, 2, '23110009', 'Passy 300ml', 25000.00, 29000.00, 'dus'),
(11, 2, '23110010', 'Susu Dancow', 50000.00, 55000.00, 'pcs');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `role`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `sale_details`
--

CREATE TABLE `sale_details` (
  `id_sale_detail` int(11) NOT NULL,
  `id_sale` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `sale_qty` int(11) NOT NULL,
  `sale_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sale_details`
--

INSERT INTO `sale_details` (`id_sale_detail`, `id_sale`, `id_product`, `sale_qty`, `sale_price`) VALUES
(1, 1, 4, 5, 25000.00),
(2, 1, 11, 2, 55000.00),
(3, 1, 8, 4, 40000.00),
(4, 2, 8, 10, 40000.00),
(5, 2, 11, 3, 55000.00),
(6, 3, 7, 1, 36000.00),
(7, 3, 11, 2, 55000.00),
(8, 3, 5, 1, 40000.00),
(9, 4, 10, 1, 29000.00),
(10, 5, 9, 10, 44000.00),
(11, 6, 10, 2, 29000.00),
(12, 7, 6, 1, 44000.00),
(13, 8, 4, 3, 25000.00),
(14, 8, 11, 5, 55000.00),
(15, 9, 8, 1, 40000.00),
(16, 9, 7, 2, 36000.00),
(17, 10, 8, 2, 40000.00),
(18, 10, 4, 4, 25000.00),
(19, 11, 4, 5, 25000.00),
(20, 11, 6, 3, 44000.00),
(21, 12, 5, 2, 40000.00),
(22, 13, 11, 4, 55000.00),
(23, 14, 7, 3, 36000.00),
(24, 15, 8, 4, 40000.00),
(25, 16, 4, 6, 25000.00),
(26, 17, 6, 5, 44000.00),
(27, 18, 11, 4, 55000.00),
(28, 19, 7, 6, 36000.00),
(29, 20, 5, 7, 40000.00),
(30, 21, 8, 6, 40000.00),
(31, 22, 9, 5, 44000.00),
(32, 23, 10, 6, 29000.00),
(33, 24, 4, 4, 25000.00),
(34, 25, 6, 4, 44000.00),
(35, 25, 5, 2, 40000.00),
(36, 25, 11, 1, 55000.00),
(37, 25, 7, 1, 36000.00),
(38, 26, 4, 6, 25000.00),
(39, 27, 6, 5, 44000.00),
(40, 28, 11, 4, 55000.00),
(41, 29, 7, 6, 36000.00),
(42, 30, 5, 7, 40000.00),
(43, 31, 8, 6, 40000.00),
(44, 32, 9, 5, 44000.00),
(45, 33, 10, 6, 29000.00),
(46, 34, 4, 4, 25000.00),
(47, 35, 6, 4, 44000.00),
(48, 35, 5, 2, 40000.00),
(49, 35, 7, 1, 36000.00),
(50, 36, 4, 6, 25000.00),
(51, 37, 6, 5, 44000.00),
(52, 38, 11, 5, 55000.00),
(53, 39, 7, 8, 36000.00),
(54, 40, 8, 6, 40000.00),
(55, 41, 9, 6, 44000.00),
(56, 42, 10, 8, 29000.00),
(57, 43, 4, 5, 25000.00),
(58, 44, 6, 4, 44000.00),
(59, 45, 7, 6, 36000.00),
(60, 46, 11, 5, 55000.00),
(61, 47, 5, 7, 40000.00),
(62, 48, 6, 6, 44000.00),
(63, 49, 9, 7, 44000.00),
(64, 50, 10, 8, 29000.00);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `id_stock` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `stok_rusak` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`id_stock`, `id_product`, `stok_rusak`) VALUES
(1, 4, 0),
(2, 7, 0),
(4, 4, 0),
(5, 4, 0),
(6, 7, 0),
(7, 6, 0),
(8, 4, 0),
(9, 5, 0),
(10, 11, 0),
(11, 11, 0),
(12, 11, 0),
(13, 11, 0),
(14, 7, 0),
(15, 11, 0),
(16, 11, 0),
(17, 9, 0);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `supp_code` varchar(50) NOT NULL,
  `supp_name` varchar(100) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `supp_code`, `supp_name`, `contact`, `address`) VALUES
(1, '001', 'Hendri', '0895-9932-0983', 'Jl Gajahmada No 15'),
(2, '002', 'Pedro', '0895-9911-0363', 'Jl Tanjungpura No 20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_role` (`id_role`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id_purchase`),
  ADD KEY `id_supplier` (`id_supplier`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_sale`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`) USING BTREE;

--
-- Indexes for table `sale_details`
--
ALTER TABLE `sale_details`
  ADD PRIMARY KEY (`id_sale_detail`),
  ADD KEY `id_sale` (`id_sale`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id_stock`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id_purchase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_sale` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sale_details`
--
ALTER TABLE `sale_details`
  MODIFY `id_sale_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `id_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `FK_login_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`),
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`);

--
-- Constraints for table `sale_details`
--
ALTER TABLE `sale_details`
  ADD CONSTRAINT `sale_details_ibfk_1` FOREIGN KEY (`id_sale`) REFERENCES `penjualan` (`id_sale`),
  ADD CONSTRAINT `sale_details_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
