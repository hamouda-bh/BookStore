-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 17, 2020 at 08:23 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_store_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prenom` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tel` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adresse` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `id_annonce` int NOT NULL AUTO_INCREMENT,
  `date_publication` date NOT NULL,
  `id_client` int NOT NULL,
  `id_livre` int NOT NULL,
  `prix` float NOT NULL,
  `etat_de_livre` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `date_achat` date NOT NULL,
  PRIMARY KEY (`id_annonce`),
  KEY `id_Client` (`id_client`),
  KEY `annonce_ibfk_2` (`id_livre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `annonce_livre`
--

DROP TABLE IF EXISTS `annonce_livre`;
CREATE TABLE IF NOT EXISTS `annonce_livre` (
  `id_livre` int NOT NULL,
  `id_annonce` int NOT NULL,
  KEY `id_annonce` (`id_annonce`),
  KEY `id_livre` (`id_livre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `id_blog` int NOT NULL AUTO_INCREMENT,
  `id_client` int NOT NULL,
  `categorie_blog` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_blog`),
  KEY `id_client` (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int NOT NULL AUTO_INCREMENT,
  `Label` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `Label`) VALUES
(1, 'azertty');

-- --------------------------------------------------------

--
-- Table structure for table `categoriekids`
--

DROP TABLE IF EXISTS `categoriekids`;
CREATE TABLE IF NOT EXISTS `categoriekids` (
  `id_categorie_kids` int NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_categorie_kids`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categoriekids`
--

INSERT INTO `categoriekids` (`id_categorie_kids`, `nom_categorie`, `description`) VALUES
(1, 'Coloration', 'C\'est la categorie de coloration pour les enfants'),
(2, 'Avant Sommeil', 'salem maakom khoukom abdessalem '),
(3, 'horror', 'salut les livre d\'horror'),
(4, 'painting ', 'livre pour peinture'),
(5, 'Cartoons', 'c\'est la categorie des dessins animées');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prenom` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tel` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adresse` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `nom`, `prenom`, `username`, `email`, `tel`, `password`, `adresse`) VALUES
(1, 'sssss', 'ssss', 'aaaaaa', 'aaasssss', 'aaaaaaa', 'aa', 'a'),
(6, 'azaz', 'zazaza', 'zazza', 'azazz@gmail.com', '25061610', '$2a$10$TM1ZC3dCsDIrsrvKg6hVXe5j.lNi4bCFnEzboBvNtEK6iBsr3YIJa', 'lzdkzd@gmail.com'),
(7, 'maliiik', 'malek', 'malek@gmail.com', 'malek75', '25061610', '$2a$10$4P.tb9jLXGPuz9McXcFqXOdk0S8.k5ZYOtc6yy7XWS0mRghycP9Vq', 'malekekelel'),
(8, 'ygyg', 'jjhj', 'hih75', 'malek@gmail.com', '25061610', '$2a$10$.YJbkQosZGB1SZUrbJtU8ONwplwnKzgOkOXpfMcdT9R2z2Z132zLC', 'huhuh'),
(9, 'nour', 'bhy', 'nour', 'nour.benhadjyahia@esprit.tn', '96177179', '$2a$10$v6Fzq.d.qmZQNaQxGqhK2eTB0TOP2dPkbuaYyDirXAIb8jB.ydCoS', 'tunis');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int NOT NULL AUTO_INCREMENT,
  `date_commande` date NOT NULL,
  `id_client` int NOT NULL,
  `prix_Totale` float NOT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `id_Client` (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id_commande`, `date_commande`, `id_client`, `prix_Totale`) VALUES
(1, '2020-12-10', 1, 10),
(11, '2020-12-10', 1, 10),
(12, '2020-12-10', 1, 10),
(13, '2020-12-10', 1, 10),
(14, '2020-12-10', 1, 10),
(15, '2020-12-10', 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id_facture` int NOT NULL AUTO_INCREMENT,
  `id_commande` int NOT NULL,
  `id_client` int NOT NULL,
  `date_facturation` date NOT NULL,
  `prix_totale` float NOT NULL,
  PRIMARY KEY (`id_facture`),
  KEY `facture_ibfk_1` (`id_client`),
  KEY `facture_ibfk_2` (`id_commande`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`id_facture`, `id_commande`, `id_client`, `date_facturation`, `prix_totale`) VALUES
(1, 5, 5, '2020-12-10', 15),
(2, 5, 5, '2020-12-10', 15),
(3, 5, 5, '2020-12-10', 15);

-- --------------------------------------------------------

--
-- Table structure for table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id_livre` int NOT NULL AUTO_INCREMENT,
  `id_categorie` int NOT NULL,
  `titre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `auteur` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `genre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prix` float NOT NULL,
  `image` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_livre`),
  KEY `id_Categorie` (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `livre`
--

INSERT INTO `livre` (`id_livre`, `id_categorie`, `titre`, `auteur`, `genre`, `prix`, `image`) VALUES
(1, 1, 'azert', 'aze', 'ghj', 88, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `livrekids`
--

DROP TABLE IF EXISTS `livrekids`;
CREATE TABLE IF NOT EXISTS `livrekids` (
  `id_livre_kids` int NOT NULL AUTO_INCREMENT,
  `id_categorie_kids` int DEFAULT NULL,
  `titre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_livre_kids`),
  KEY `id_categorie_kids` (`id_categorie_kids`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `livrekids`
--

INSERT INTO `livrekids` (`id_livre_kids`, `id_categorie_kids`, `titre`, `description`, `image`) VALUES
(1, 2, 'Bonjour Bonsoir', 'kteb arbi', 'C:\\BookStore\\src\\bookstore\\images\\icons8_Open_Envelope_32px.png'),
(2, 2, 'bonjour bonsoir', 'habibi', 'C:\\BookStore\\src\\bookstore\\images\\plus-square-regular.png'),
(4, 2, 'salem', 'hifive', 'C:\\Users\\PC-Hamouda\\Desktop\\download.jpg'),
(5, 2, 'qsfqsfqsf', 'haslema', 'C:\\BookStore\\src\\bookstore\\images\\child-solid.png'),
(6, 2, 'sqdqsd', 'qsdqsdqsd', 'C:\\Users\\PC-Hamouda\\Desktop\\download.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `livre_commande`
--

DROP TABLE IF EXISTS `livre_commande`;
CREATE TABLE IF NOT EXISTS `livre_commande` (
  `id_commande` int NOT NULL,
  `id_livre` int NOT NULL,
  KEY `id_commande` (`id_commande`),
  KEY `id_livre` (`id_livre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `panier_livre`
--

DROP TABLE IF EXISTS `panier_livre`;
CREATE TABLE IF NOT EXISTS `panier_livre` (
  `id_panier` int NOT NULL AUTO_INCREMENT,
  `id_client` int NOT NULL,
  `id_livre` int NOT NULL,
  `somme_ajouter` float NOT NULL,
  `quantite_ajouter` int NOT NULL,
  PRIMARY KEY (`id_panier`),
  KEY `panier_livre_ibfk_1` (`id_client`),
  KEY `panier_livre_ibfk_2` (`id_livre`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `panier_livre`
--

INSERT INTO `panier_livre` (`id_panier`, `id_client`, `id_livre`, `somme_ajouter`, `quantite_ajouter`) VALUES
(16, 1, 1, 10, 20),
(2, 1, 1, 10, 20),
(15, 1, 1, 10, 20),
(14, 1, 1, 10, 20),
(9, 1, 1, 10, 20),
(13, 1, 1, 10, 20),
(10, 1, 1, 10, 20),
(8, 1, 1, 10, 20);

-- --------------------------------------------------------

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
CREATE TABLE IF NOT EXISTS `publication` (
  `id_publication` int NOT NULL AUTO_INCREMENT,
  `id_blog` int NOT NULL,
  `id_client` int NOT NULL,
  `contenue` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `commentaire` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_publication`),
  KEY `id_blog` (`id_blog`),
  KEY `id_client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE,
  ADD CONSTRAINT `annonce_ibfk_2` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`) ON DELETE CASCADE;

--
-- Constraints for table `annonce_livre`
--
ALTER TABLE `annonce_livre`
  ADD CONSTRAINT `annonce_livre_ibfk_1` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id_annonce`),
  ADD CONSTRAINT `annonce_livre_ibfk_2` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`);

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Constraints for table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Constraints for table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `livre_ibfk_1` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`) ON UPDATE CASCADE;

--
-- Constraints for table `livre_commande`
--
ALTER TABLE `livre_commande`
  ADD CONSTRAINT `livre_commande_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`),
  ADD CONSTRAINT `livre_commande_ibfk_2` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`);

--
-- Constraints for table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`id_blog`) REFERENCES `blog` (`id_blog`),
  ADD CONSTRAINT `publication_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
