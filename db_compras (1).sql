-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-06-2019 a las 23:44:59
-- Versión del servidor: 10.1.39-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_compras`
--
CREATE DATABASE IF NOT EXISTS `db_compras` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_compras`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `articulo`;
CREATE TABLE `articulo` (
  `id_articulo` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `marca` int(11) DEFAULT NULL,
  `unidad_med` int(11) DEFAULT NULL,
  `existencia` int(11) DEFAULT NULL,
  `costo` decimal(7,2) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_depto` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `cedula` varchar(12) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id_marca`, `descripcion`, `estado`) VALUES
(1, 'Marca1', 'Disponible'),
(2, 'Marca2', 'Disponible'),
(3, 'Marca3', 'Agotado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `cedula_rnc` varchar(25) DEFAULT NULL,
  `nombre_com` varchar(50) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sol_det_articulo`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `sol_det_articulo`;
CREATE TABLE `sol_det_articulo` (
  `id_solicitud` int(11) NOT NULL,
  `articulo` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `unidad_med` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sol_det_orden`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `sol_det_orden`;
CREATE TABLE `sol_det_orden` (
  `id_orden` int(11) NOT NULL,
  `articulo` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `unidad_med` int(11) DEFAULT NULL,
  `marca` int(11) DEFAULT NULL,
  `costo_uni` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sol_enc_articulo`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `sol_enc_articulo`;
CREATE TABLE `sol_enc_articulo` (
  `id_solicitud` int(11) NOT NULL,
  `id_prov` int(11) DEFAULT NULL,
  `emp_sol` int(11) DEFAULT NULL,
  `fec_sol` datetime DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sol_enc_orden`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `sol_enc_orden`;
CREATE TABLE `sol_enc_orden` (
  `id_orden` int(11) NOT NULL,
  `id_sol` int(11) DEFAULT NULL,
  `fec_ord` datetime DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--
-- Creación: 11-06-2019 a las 22:29:43
--

DROP TABLE IF EXISTS `unidad_medida`;
CREATE TABLE `unidad_medida` (
  `id_unidades` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id_articulo`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_depto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD KEY `FK_EMP_DEP` (`departamento`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `sol_det_articulo`
--
ALTER TABLE `sol_det_articulo`
  ADD PRIMARY KEY (`id_solicitud`,`articulo`),
  ADD KEY `FK_SOL_ART_ART` (`articulo`);

--
-- Indices de la tabla `sol_det_orden`
--
ALTER TABLE `sol_det_orden`
  ADD PRIMARY KEY (`id_orden`,`articulo`),
  ADD KEY `FK_ORD_ARTICULO` (`articulo`),
  ADD KEY `FK_ORD_MARCA` (`marca`),
  ADD KEY `FK_sol_det_orden_unidad_medida` (`unidad_med`);

--
-- Indices de la tabla `sol_enc_articulo`
--
ALTER TABLE `sol_enc_articulo`
  ADD PRIMARY KEY (`id_solicitud`),
  ADD KEY `FK_SOL_ART_EMP` (`emp_sol`),
  ADD KEY `FK_sol_enc_articulo_proveedor` (`id_prov`);

--
-- Indices de la tabla `sol_enc_orden`
--
ALTER TABLE `sol_enc_orden`
  ADD PRIMARY KEY (`id_orden`),
  ADD KEY `FK_SOL_ORD` (`id_sol`);

--
-- Indices de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  ADD PRIMARY KEY (`id_unidades`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id_articulo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_depto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sol_enc_articulo`
--
ALTER TABLE `sol_enc_articulo`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sol_enc_orden`
--
ALTER TABLE `sol_enc_orden`
  MODIFY `id_orden` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id_unidades` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_empleado_departamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`id_depto`);

--
-- Filtros para la tabla `sol_det_articulo`
--
ALTER TABLE `sol_det_articulo`
  ADD CONSTRAINT `FK_sol_det_articulo_articulo` FOREIGN KEY (`articulo`) REFERENCES `articulo` (`id_articulo`),
  ADD CONSTRAINT `FK_sol_det_articulo_sol_enc_articulo` FOREIGN KEY (`id_solicitud`) REFERENCES `sol_enc_articulo` (`id_solicitud`);

--
-- Filtros para la tabla `sol_det_orden`
--
ALTER TABLE `sol_det_orden`
  ADD CONSTRAINT `FK_sol_det_orden_articulo` FOREIGN KEY (`articulo`) REFERENCES `articulo` (`id_articulo`),
  ADD CONSTRAINT `FK_sol_det_orden_marca` FOREIGN KEY (`marca`) REFERENCES `marca` (`id_marca`),
  ADD CONSTRAINT `FK_sol_det_orden_sol_enc_orden` FOREIGN KEY (`id_orden`) REFERENCES `sol_enc_orden` (`id_orden`),
  ADD CONSTRAINT `FK_sol_det_orden_unidad_medida` FOREIGN KEY (`unidad_med`) REFERENCES `unidad_medida` (`id_unidades`);

--
-- Filtros para la tabla `sol_enc_articulo`
--
ALTER TABLE `sol_enc_articulo`
  ADD CONSTRAINT `FK_sol_enc_articulo_empleado` FOREIGN KEY (`emp_sol`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `FK_sol_enc_articulo_proveedor` FOREIGN KEY (`id_prov`) REFERENCES `proveedor` (`id_proveedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
