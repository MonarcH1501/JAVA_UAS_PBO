-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2025 at 10:14 AM
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
-- Database: `uas_oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `passwords` varchar(50) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_user`, `username`, `passwords`, `full_name`) VALUES
(1, 'Admin', '123', 'Admin'),
(2, 'Steven', '123', 'Steven Edmund Pratama'),
(3, 'Steven', '123', 'steven Edmund Pratama');

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
  `sale_total_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_sale`, `sale_date`, `discount`, `tax`, `sale_total_price`) VALUES
(1, '2024-01-08', 20000.00, 5000.00, 0.00),
(2, '2024-01-08', 15000.00, 4000.00, 0.00),
(3, '2024-01-08', 25000.00, 5000.00, 0.00),
(4, '2025-01-19', 0.00, 0.00, 1350000.00),
(5, '2025-01-20', 0.00, 0.00, 125000.00),
(6, '2025-01-20', 0.00, 0.00, 220000.00),
(7, '2025-01-20', 0.00, 0.00, 29000.00),
(8, '2025-01-20', 0.00, 0.00, 125000.00),
(9, '2025-01-23', 0.00, 0.00, 0.00),
(10, '2025-01-23', 0.00, 0.00, 12500.00),
(11, '2025-01-23', 0.00, 0.00, 22500.00),
(12, '2025-01-23', 0.00, 0.00, 0.00),
(13, '2025-01-23', 0.00, 0.00, 150000.00),
(14, '2025-01-23', 0.00, 0.00, 125000.00),
(15, '2025-01-23', 0.00, 0.00, 600000.00),
(16, '2025-01-23', 0.00, 0.00, 240000.00),
(17, '2025-01-23', 0.00, 0.00, 2000000.00),
(18, '2025-01-23', 0.00, 0.00, 550000.00),
(19, '2025-01-23', 0.00, 0.00, 1250000.00),
(20, '2025-01-23', 0.00, 0.00, 220000.00),
(21, '2025-01-23', 0.00, 0.00, 216000.00);

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
(1, 4, 4, 54, 25000.00),
(2, 5, 4, 5, 25000.00),
(3, 6, 9, 5, 44000.00),
(4, 7, 10, 1, 29000.00),
(5, 8, 4, 5, 25000.00),
(6, 9, 4, 5, 0.00),
(7, 10, 6, 5, 2500.00),
(8, 11, 5, 5, 4500.00),
(9, 12, 5, 5, 0.00),
(10, 13, 4, 6, 25000.00),
(11, 14, 4, 5, 25000.00),
(12, 15, 5, 15, 40000.00),
(13, 16, 8, 6, 40000.00),
(14, 17, 5, 50, 40000.00),
(15, 18, 11, 10, 55000.00),
(16, 19, 4, 50, 25000.00),
(17, 20, 6, 5, 44000.00),
(18, 21, 7, 6, 36000.00);

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
  ADD PRIMARY KEY (`id_user`);

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
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id_purchase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_sale` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `sale_details`
--
ALTER TABLE `sale_details`
  MODIFY `id_sale_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

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
