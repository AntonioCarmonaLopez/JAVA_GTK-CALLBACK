-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 05, 2018 at 08:09 PM
-- Server version: 5.7.22
-- PHP Version: 7.2.7-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `T12p03`
--

-- --------------------------------------------------------

--
-- Table structure for table `Alumnos`
--

CREATE TABLE `Alumnos` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `mayorEdad` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Alumnos`
--

INSERT INTO `Alumnos` (`dni`, `nombre`, `mayorEdad`) VALUES
('1', '1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Cursos`
--

CREATE TABLE `Cursos` (
  `id` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `horas` decimal(6,2) NOT NULL,
  `dniProfesor` varchar(10) DEFAULT NULL,
  `fecIni` date DEFAULT NULL,
  `fecFin` date DEFAULT NULL,
  `modalidad` char(1) DEFAULT NULL,
  `estado` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cursos`
--

INSERT INTO `Cursos` (`id`, `titulo`, `horas`, `dniProfesor`, `fecIni`, `fecFin`, `modalidad`, `estado`) VALUES
(1, 'ttt', '1.00', '1', NULL, NULL, 'O', 'Realizándose'),
(2, '7', '2.00', '2', NULL, NULL, 'P', 'Programado'),
(5, '5', '5.00', NULL, NULL, NULL, 'P', 'Programado'),
(43, '43', '43.00', NULL, NULL, NULL, 'P', 'Programado');

-- --------------------------------------------------------

--
-- Table structure for table `Matriculas`
--

CREATE TABLE `Matriculas` (
  `idCurso` int(11) NOT NULL,
  `dniAlumno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Matriculas`
--

INSERT INTO `Matriculas` (`idCurso`, `dniAlumno`) VALUES
(1, '1'),
(2, '1'),
(43, '1');

-- --------------------------------------------------------

--
-- Table structure for table `Profesores`
--

CREATE TABLE `Profesores` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Profesores`
--

INSERT INTO `Profesores` (`dni`, `nombre`) VALUES
('1', '3'),
('2', '25'),
('3', '26'),
('32', '5'),
('42', '41'),
('44', 'sd'),
('45', 'ff');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Alumnos`
--
ALTER TABLE `Alumnos`
  ADD PRIMARY KEY (`dni`);

--
-- Indexes for table `Cursos`
--
ALTER TABLE `Cursos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Cursos_Profesores` (`dniProfesor`);

--
-- Indexes for table `Matriculas`
--
ALTER TABLE `Matriculas`
  ADD PRIMARY KEY (`idCurso`,`dniAlumno`),
  ADD KEY `fk_Matriculas_Alumnos` (`dniAlumno`);

--
-- Indexes for table `Profesores`
--
ALTER TABLE `Profesores`
  ADD PRIMARY KEY (`dni`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Cursos`
--
ALTER TABLE `Cursos`
  ADD CONSTRAINT `fk_Cursos_Profesores` FOREIGN KEY (`dniProfesor`) REFERENCES `Profesores` (`dni`) ON DELETE SET NULL;

--
-- Constraints for table `Matriculas`
--
ALTER TABLE `Matriculas`
  ADD CONSTRAINT `fk_Matriculas_Alumnos` FOREIGN KEY (`dniAlumno`) REFERENCES `Alumnos` (`dni`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_Matriculas_Cursos` FOREIGN KEY (`idCurso`) REFERENCES `Cursos` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
