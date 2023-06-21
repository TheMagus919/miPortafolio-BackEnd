-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2023 a las 20:25:10
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portafolio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educacion`
--

CREATE TABLE `educacion` (
  `universidad` varchar(60) NOT NULL,
  `carrera` varchar(60) NOT NULL,
  `fecha` varchar(60) NOT NULL,
  `imagen` mediumtext NOT NULL,
  `id_educacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `educacion`
--

INSERT INTO `educacion` (`universidad`, `carrera`, `fecha`, `imagen`, `id_educacion`) VALUES
('Universidad De La Punta', 'Tecnicatura Universitaria en Desarrollo De Software', '2021 - Actualidad', './assets/imagenes/logo.png', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencias`
--

CREATE TABLE `experiencias` (
  `puesto` varchar(60) NOT NULL,
  `local` varchar(60) NOT NULL,
  `jornada` varchar(30) NOT NULL,
  `fecha` varchar(60) NOT NULL,
  `ciudad` varchar(60) NOT NULL,
  `imagen` mediumtext NOT NULL,
  `id_experiencias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experiencias`
--

INSERT INTO `experiencias` (`puesto`, `local`, `jornada`, `fecha`, `ciudad`, `imagen`, `id_experiencias`) VALUES
('Atencion al Cliente y Cocinero.', 'La Clandestina', 'Jornada Completa', 'Julio 2022 - Actualidad', 'Luján, San Luis, Argentina.', './assets/imagenes/clande.png', 1),
('Atencion al Cliente.', 'La Previa', 'Jornada Completa', 'Julio 2020 - Agosto 2020', 'Luján, San Luis, Argentina.', './assets/imagenes/clande.png', 2),
('Mecanico de Motos', 'Lavalle Motos', 'Jornada Parcial', 'Febrero 2018 - Marzo 2018', 'San Luis, Argentina', './assets/imagenes/exp1.jpeg', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidades`
--

CREATE TABLE `habilidades` (
  `nombre` varchar(30) NOT NULL,
  `porcentaje` int(11) NOT NULL,
  `width` varchar(6) NOT NULL,
  `id_habilidades` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habilidades`
--

INSERT INTO `habilidades` (`nombre`, `porcentaje`, `width`, `id_habilidades`) VALUES
('JAVA', 75, '75%', 1),
('EXPRESS.JS', 50, '50%', 2),
('JAVASCRIPT', 75, '75%', 3),
('HTML', 100, '100%', 4),
('CSS', 100, '100%', 5),
('NODE.JS', 50, '50%', 6),
('C++', 75, '75%', 7),
('MYSQL', 75, '75%', 8),
('BOOTSTRAP', 50, '50%', 9),
('ANGULAR', 50, '50%', 10),
('SEQUELIZE', 25, '25%', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE `perfil` (
  `nombre` varchar(60) NOT NULL,
  `profesion` varchar(60) NOT NULL,
  `ciudad` varchar(60) NOT NULL,
  `universidad` varchar(60) NOT NULL,
  `info` text NOT NULL,
  `fotouniversidad` varchar(40) NOT NULL,
  `foto` mediumtext NOT NULL,
  `id_perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`nombre`, `profesion`, `ciudad`, `universidad`, `info`, `fotouniversidad`, `foto`, `id_perfil`) VALUES
('Jorge Agustin Barroso', 'Full Stack Developer Jr', 'San Luis (Argentina)', 'Universidad De La Punta', 'Soy un Desarrollador de Software Jr y busco introducirme al mercado laboral IT. Tengo 23 años, aprendo rapido y tengo muchas ganas de trabajar. Me encuentro actualmente estudiando Desarrollo de Software en la ULP de manera Virtual. Realice varias paginas web y aplicaciones para las tareas de la carrera, y algunas paginas para uso personal.', './assets/imagenes/logo.png', './assets/imagenes/fotoPerfil.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `titulo` varchar(60) NOT NULL,
  `descripcion` mediumtext NOT NULL,
  `url` varchar(60) NOT NULL,
  `pagina` varchar(60) DEFAULT NULL,
  `id_proyectos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`titulo`, `descripcion`, `url`, `pagina`, `id_proyectos`) VALUES
('Pagina Web Estatica para Negocio', 'Es una pagina web estatica de un negocio de bebidas que muestra el listado de productos y sus respectivos precios, diseño responsive y tiene un carrusel para mostrar ofertas, se puede visitar en linea gracias al uso de github-pages.', 'https://github.com/TheMagus919/LaClandestina', 'https://themagus919.github.io/LaClandestina/', 1),
('Maqueta de Pagina Web para Negocio', 'Diseñe una pagina web estatica para un lavadero de autos con html, css y javascript, uso carrusel para mostrar imagenes y servicios, tambien uso de formulario para tomar turnos.', 'https://github.com/TheMagus919/BarrosoLV', NULL, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `user` varchar(60) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`user`, `password`, `id_usuario`) VALUES
('admin', '$argon2id$v=19$m=1024,t=1,p=1$pJhy+g+T5YL5QSauHVnuhA$JgXCBBPEGrh0mvFhanyl/JlHMwAj+0Na+HSD7TTpNQs', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id_educacion`);

--
-- Indices de la tabla `experiencias`
--
ALTER TABLE `experiencias`
  ADD PRIMARY KEY (`id_experiencias`);

--
-- Indices de la tabla `habilidades`
--
ALTER TABLE `habilidades`
  ADD PRIMARY KEY (`id_habilidades`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id_perfil`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`id_proyectos`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `user` (`user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `educacion`
--
ALTER TABLE `educacion`
  MODIFY `id_educacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `experiencias`
--
ALTER TABLE `experiencias`
  MODIFY `id_experiencias` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `habilidades`
--
ALTER TABLE `habilidades`
  MODIFY `id_habilidades` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id_perfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `id_proyectos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
