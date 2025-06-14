-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 14, 2025 at 06:32 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

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
  `id_user` int NOT NULL,
  `id_role` int NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `passwords` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `full_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL
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
  `id_purchase` int NOT NULL,
  `id_supplier` int NOT NULL,
  `id_product` int NOT NULL,
  `purchase_date` date NOT NULL,
  `purchase_qty` int NOT NULL,
  `total_price` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id_purchase`, `id_supplier`, `id_product`, `purchase_date`, `purchase_qty`, `total_price`) VALUES
(1, 1, 4, '2024-01-07', 50, 987000000),
(2, 1, 5, '2024-01-07', 10, 5000000000),
(3, 1, 6, '2024-01-07', 15, 25000000),
(4, 2, 7, '2024-01-08', 30, 17500000),
(5, 2, 7, '2024-01-10', 50, 1500000),
(6, 2, 4, '2024-01-10', 50, 2500000),
(7, 2, 4, '2024-01-10', 50, 1000000),
(8, 1, 11, '2025-01-23', 50, 50000),
(9, 1, 5, '2025-06-01', 70, 45000000000),
(11, 1, 8, '2025-05-19', 100, 7500000000),
(12, 2, 9, '2025-05-01', 150, 780000000),
(13, 2, 7, '2025-06-02', 45, 3000000),
(14, 1, 10, '2025-06-04', 55, 48000000);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id_sale` int NOT NULL,
  `sale_date` date NOT NULL,
  `discount` decimal(10,2) NOT NULL,
  `tax` decimal(10,2) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `total_bayar` decimal(10,2) NOT NULL,
  `kembalian` decimal(10,2) NOT NULL,
  `Total_Price_Produk` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_sale`, `sale_date`, `discount`, `tax`, `sale_total_price`, `total_bayar`, `kembalian`, `Total_Price_Produk`) VALUES
(1, '2024-12-13', '0.00', '11.00', '275280.00', '300000.00', '24720.00', '248000.00'),
(2, '2024-12-13', '5.00', '11.00', '279442.50', '300000.00', '5850.00', '265000.00'),
(3, '2024-12-13', '5.00', '11.00', '590520.00', '600000.00', '9480.00', '560000.00'),
(4, '2024-12-14', '5.00', '11.00', '371184.00', '400000.00', '28816.00', '352000.00'),
(5, '2024-12-14', '10.00', '11.00', '239760.00', '300000.00', '46920.00', '240000.00'),
(6, '2024-12-15', '10.00', '11.00', '219780.00', '250000.00', '30220.00', '220000.00'),
(7, '2024-12-16', '3.00', '11.00', '343467.30', '350000.00', '6532.70', '319000.00'),
(8, '2024-12-20', '0.00', '11.00', '149850.00', '150000.00', '150.00', '135000.00'),
(9, '2024-12-18', '0.00', '11.00', '175380.00', '200000.00', '24620.00', '158000.00'),
(10, '2024-12-25', '0.00', '11.00', '387390.00', '400000.00', '12610.00', '349000.00'),
(11, '2025-01-02', '0.00', '11.00', '183150.00', '200000.00', '16850.00', '165000.00'),
(12, '2025-01-03', '0.00', '11.00', '324120.00', '350000.00', '25880.00', '292000.00'),
(13, '2025-01-03', '0.00', '11.00', '172050.00', '200000.00', '27950.00', '155000.00'),
(14, '2025-01-04', '0.00', '11.00', '500610.00', '510000.00', '9390.00', '451000.00'),
(15, '2025-01-05', '0.00', '11.00', '93240.00', '100000.00', '6760.00', '84000.00'),
(16, '2025-02-10', '0.00', '11.00', '135420.00', '150000.00', '14580.00', '122000.00'),
(17, '2025-02-15', '5.00', '11.00', '42180.00', '50000.00', '5600.00', '40000.00'),
(18, '2025-02-16', '3.00', '11.00', '166888.50', '200000.00', '33111.50', '155000.00'),
(19, '2025-02-20', '3.00', '11.00', '38761.20', '50000.00', '11238.80', '36000.00'),
(20, '2025-02-25', '5.00', '11.00', '99123.00', '100000.00', '877.00', '94000.00'),
(21, '2025-03-10', '0.00', '11.00', '105450.00', '110000.00', '4550.00', '95000.00'),
(22, '2025-03-12', '0.00', '11.00', '79920.00', '100000.00', '20080.00', '72000.00'),
(23, '2025-03-15', '3.00', '11.00', '220723.50', '250000.00', '29276.50', '205000.00'),
(24, '2025-03-21', '3.00', '11.00', '177655.50', '200000.00', '22344.50', '165000.00'),
(25, '2025-03-30', '3.00', '11.00', '62448.60', '70000.00', '7551.40', '58000.00'),
(26, '2025-04-01', '3.00', '11.00', '94749.60', '100000.00', '5250.40', '88000.00'),
(27, '2025-04-05', '3.00', '11.00', '38761.20', '50000.00', '11238.80', '36000.00'),
(28, '2025-04-10', '3.00', '11.00', '215340.00', '250000.00', '34660.00', '200000.00'),
(29, '2025-04-15', '3.00', '11.00', '142124.40', '150000.00', '7875.60', '132000.00'),
(30, '2025-04-29', '0.00', '11.00', '286380.00', '300000.00', '13620.00', '258000.00'),
(31, '2025-05-11', '0.00', '11.00', '97680.00', '100000.00', '2320.00', '88000.00'),
(32, '2025-05-15', '3.00', '11.00', '215340.00', '250000.00', '28000.00', '200000.00'),
(33, '2025-05-18', '3.00', '11.00', '172272.00', '200000.00', '27728.00', '160000.00'),
(34, '2025-05-21', '3.00', '11.00', '284248.80', '300000.00', '15751.20', '264000.00'),
(35, '2025-05-30', '3.00', '11.00', '217493.40', '250000.00', '32506.60', '202000.00'),
(36, '2025-06-05', '3.00', '11.00', '255177.90', '300000.00', '44822.10', '237000.00'),
(37, '2025-06-10', '5.00', '11.00', '37962.00', '50000.00', '11238.80', '36000.00'),
(38, '2025-06-12', '5.00', '11.00', '173992.50', '200000.00', '26007.50', '165000.00'),
(39, '2025-06-14', '5.00', '11.00', '84360.00', '100000.00', '15640.00', '80000.00'),
(40, '2025-06-14', '5.00', '11.00', '319513.50', '400000.00', '80486.50', '303000.00');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id_product` int NOT NULL,
  `id_supplier` int NOT NULL,
  `product_code` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `price_buy` decimal(10,2) NOT NULL,
  `price_sell` decimal(10,2) NOT NULL,
  `product_unit` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id_product`, `id_supplier`, `product_code`, `product_name`, `price_buy`, `price_sell`, `product_unit`) VALUES
(4, 1, '23110003', 'Susu Diarycrown', '21000.00', '25000.00', 'pcs'),
(5, 1, '23110004', 'Blue9 600ml', '35000.00', '40000.00', 'dus'),
(6, 1, '23110005', 'Nestle 600ml', '39000.00', '44000.00', 'dus'),
(7, 2, '23110006', 'Passy 600ml', '32000.00', '36000.00', 'dus'),
(8, 2, '23110007', 'Aqua 600ml', '35000.00', '40000.00', 'dus'),
(9, 1, '23110008', 'Mie Indomie Kaldu', '40000.00', '44000.00', 'dus'),
(10, 2, '23110009', 'Passy 300ml', '25000.00', '29000.00', 'dus'),
(11, 2, '23110010', 'Susu Dancow', '50000.00', '55000.00', 'pcs');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL
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
  `id_sale_detail` int NOT NULL,
  `id_sale` int NOT NULL,
  `id_product` int NOT NULL,
  `sale_qty` int NOT NULL,
  `sale_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sale_details`
--

INSERT INTO `sale_details` (`id_sale_detail`, `id_sale`, `id_product`, `sale_qty`, `sale_price`) VALUES
(1, 1, 8, 4, '40000.00'),
(2, 1, 9, 2, '44000.00'),
(3, 2, 8, 3, '40000.00'),
(4, 2, 10, 5, '29000.00'),
(5, 3, 11, 7, '55000.00'),
(6, 3, 4, 7, '25000.00'),
(7, 4, 11, 4, '55000.00'),
(8, 4, 9, 3, '44000.00'),
(9, 5, 5, 6, '40000.00'),
(10, 6, 11, 4, '55000.00'),
(11, 7, 11, 5, '55000.00'),
(12, 7, 9, 1, '44000.00'),
(13, 8, 11, 1, '55000.00'),
(14, 8, 5, 2, '40000.00'),
(15, 9, 10, 2, '29000.00'),
(16, 9, 4, 3, '25000.00'),
(17, 9, 4, 1, '25000.00'),
(18, 10, 10, 6, '29000.00'),
(19, 10, 4, 7, '25000.00'),
(20, 11, 11, 3, '55000.00'),
(21, 12, 7, 2, '36000.00'),
(22, 12, 11, 4, '55000.00'),
(23, 13, 5, 2, '40000.00'),
(24, 13, 4, 3, '25000.00'),
(25, 14, 6, 4, '44000.00'),
(26, 14, 11, 5, '55000.00'),
(27, 15, 11, 1, '55000.00'),
(28, 15, 10, 1, '29000.00'),
(29, 16, 4, 2, '25000.00'),
(30, 16, 7, 2, '36000.00'),
(31, 17, 5, 1, '40000.00'),
(32, 18, 4, 4, '25000.00'),
(33, 18, 11, 1, '55000.00'),
(34, 19, 7, 1, '36000.00'),
(35, 20, 9, 1, '44000.00'),
(36, 20, 4, 2, '25000.00'),
(37, 21, 5, 1, '40000.00'),
(38, 21, 11, 1, '55000.00'),
(39, 22, 7, 2, '36000.00'),
(40, 23, 4, 1, '25000.00'),
(41, 23, 7, 5, '36000.00'),
(42, 24, 4, 5, '25000.00'),
(43, 24, 8, 1, '40000.00'),
(44, 25, 10, 2, '29000.00'),
(45, 26, 6, 2, '44000.00'),
(46, 27, 7, 1, '36000.00'),
(47, 28, 8, 5, '40000.00'),
(48, 29, 9, 3, '44000.00'),
(49, 30, 5, 5, '40000.00'),
(50, 30, 10, 2, '29000.00'),
(51, 31, 9, 2, '44000.00'),
(52, 32, 8, 5, '40000.00'),
(53, 33, 7, 2, '36000.00'),
(54, 33, 6, 2, '44000.00'),
(55, 34, 9, 6, '44000.00'),
(56, 35, 7, 2, '36000.00'),
(57, 35, 4, 2, '25000.00'),
(58, 35, 8, 2, '40000.00'),
(59, 36, 7, 2, '36000.00'),
(60, 36, 11, 3, '55000.00'),
(61, 37, 7, 1, '36000.00'),
(62, 38, 11, 3, '55000.00'),
(63, 39, 5, 2, '40000.00'),
(64, 40, 6, 2, '44000.00'),
(65, 40, 11, 3, '55000.00'),
(66, 40, 4, 2, '25000.00');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `id_stock` int NOT NULL,
  `id_product` int NOT NULL,
  `tanggal` date DEFAULT NULL,
  `stok_rusak` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`id_stock`, `id_product`, `tanggal`, `stok_rusak`) VALUES
(1, 4, '2025-06-02', 12),
(2, 11, '2025-06-04', 2);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int NOT NULL,
  `supp_code` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `supp_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `contact` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `address` text COLLATE utf8mb4_general_ci NOT NULL
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
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id_purchase` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_sale` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sale_details`
--
ALTER TABLE `sale_details`
  MODIFY `id_sale_detail` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `id_stock` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
