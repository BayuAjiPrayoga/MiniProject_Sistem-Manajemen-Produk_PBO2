-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 26, 2025 at 04:00 PM
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
-- Database: `cashierapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `price` double NOT NULL,
  `stock` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`, `stock`, `created_at`) VALUES
(1, 'coffee arabica', 'dibuat di indonesia', 7000, 12, '2025-03-26 11:46:25'),
(2, 'Pensil', 'Pensil kayu berkualitas tinggi', 2000, 100, '2025-03-26 11:51:08'),
(3, 'Pulpen', 'Pulpen tinta hitam', 5000, 50, '2025-03-26 11:51:08'),
(4, 'Buku Tulis', 'Buku tulis 40 lembar', 10000, 200, '2025-03-26 11:51:08'),
(5, 'Penghapus', 'Penghapus karet putih', 1500, 300, '2025-03-26 11:51:08'),
(6, 'Penggaris', 'Penggaris plastik 30 cm', 3000, 150, '2025-03-26 11:51:08'),
(7, 'Spidol', 'Spidol permanen warna hitam', 8000, 75, '2025-03-26 11:51:08'),
(8, 'Stabilo', 'Stabilo warna kuning', 12000, 60, '2025-03-26 11:51:08'),
(9, 'Kertas A4', 'Kertas HVS ukuran A4 80 gsm', 50000, 20, '2025-03-26 11:51:08'),
(10, 'Binder', 'Binder ukuran A5 dengan 20 ring', 25000, 40, '2025-03-26 11:51:08'),
(11, 'Tas Sekolah', 'Tas sekolah anak dengan motif kartun', 150000, 7, '2025-03-26 11:51:08'),
(12, 'Kertas F4', 'Kertas HVS ukuran F4 45 gsm', 21000, 8, '2025-03-26 13:45:17'),
(13, 'Kipas Kertas', 'Kipas terbuat dari kertas 80gsm', 12000, 12, '2025-03-26 15:02:50');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `total_price` double NOT NULL,
  `transaction_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `product_id`, `quantity`, `total_price`, `transaction_date`) VALUES
(1, 11, 3, 450000, '2025-03-26 13:25:03'),
(2, 12, 2, 42000, '2025-03-26 13:45:51');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
