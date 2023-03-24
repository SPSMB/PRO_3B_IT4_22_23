-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Pát 24. bře 2023, 12:35
-- Verze serveru: 10.4.6-MariaDB
-- Verze PHP: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `bank`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `platebni_karta`
--

CREATE TABLE `platebni_karta` (
  `id` int(11) NOT NULL,
  `cislo_karty` int(11) NOT NULL,
  `kod_banky` int(11) NOT NULL,
  `cvv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Vypisuji data pro tabulku `platebni_karta`
--

INSERT INTO `platebni_karta` (`id`, `cislo_karty`, `kod_banky`, `cvv`) VALUES
(1, 123456789, 123, 789),
(2, 1542873, 4500, 998);

-- --------------------------------------------------------

--
-- Struktura tabulky `uzivatel`
--

CREATE TABLE `uzivatel` (
  `id` int(11) NOT NULL,
  `jmeno` varchar(64) COLLATE utf8_bin NOT NULL,
  `prijmeni` varchar(64) COLLATE utf8_bin NOT NULL,
  `prihlasovaci_jmeno` varchar(64) COLLATE utf8_bin NOT NULL,
  `heslo` varchar(64) COLLATE utf8_bin NOT NULL,
  `id_karty` int(11) NOT NULL,
  `cislo_uctu` int(11) NOT NULL,
  `zustatek` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Vypisuji data pro tabulku `uzivatel`
--

INSERT INTO `uzivatel` (`id`, `jmeno`, `prijmeni`, `prihlasovaci_jmeno`, `heslo`, `id_karty`, `cislo_uctu`, `zustatek`) VALUES
(2, 'Pavel', 'Tirpák', 'pawel', 'jednorozec', 1, 987654321, 153656),
(3, 'Petr', 'Tran', 'VietnamIsReal', 'heslo', 2, 154872, 1100);

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `platebni_karta`
--
ALTER TABLE `platebni_karta`
  ADD PRIMARY KEY (`id`);

--
-- Klíče pro tabulku `uzivatel`
--
ALTER TABLE `uzivatel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_karty` (`id_karty`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `platebni_karta`
--
ALTER TABLE `platebni_karta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pro tabulku `uzivatel`
--
ALTER TABLE `uzivatel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `uzivatel`
--
ALTER TABLE `uzivatel`
  ADD CONSTRAINT `uzivatel_ibfk_1` FOREIGN KEY (`id_karty`) REFERENCES `platebni_karta` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
