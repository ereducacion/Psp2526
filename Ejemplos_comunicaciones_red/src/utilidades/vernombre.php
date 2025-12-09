<?php
// Recibir los parámetros desde el formulario
$nombre = isset($_GET['nombre']) ? $_GET['nombre'] : '';
$apellido = isset($_GET['apellido']) ? $_GET['apellido'] : '';

// Devolver un saludo
echo "Hola, " . htmlspecialchars($nombre) . " " . htmlspecialchars($apellido) . "! Bienvenido.";
?>