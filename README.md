# PRUEBA TÉCNICA FINAL - Sistema de Reserva de Vuelos

Este proyecto es una solución para la prueba técnica solicitada por INTOUCH CX Colombia (Versión 2024-2). El objetivo es desarrollar una aplicación web que permita a los usuarios consultar, reservar y simular la compra de boletos aéreos, con funcionalidades clave como autenticación, visualización de vuelos disponibles y gestión de reservas.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **Thymeleaf**
- **Bootstrap 5**
- **Maven**
- **H2 Database (en memoria para pruebas)**

### Requisitos Previos
Para ejecutar este proyecto, necesitarás tener instalado:

- Java JDK 8 o superior.
- Un IDE de Java como IntelliJ IDEA, Eclipse.
- Maven para manejar las dependencias 
- Un navegador web para interactuar con el servidor.

### Instalación 

1. Tener instalado Git en tu maquina local 
2. Elegir una carpeta en donde guardes tu proyecto
3. abrir la terminal de GIT --> mediante el clik derecho seleccionas Git bash here
4. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/andreec2/PruebaTecnica.git
   ```
5. Abre el proyecto con tu IDE favorito o navega hasta el directorio del proyecto 
6. Desde la terminal  para compilar el proyecto ejecuta:

   ```bash
   mvn clean install
   ```
7. compila el proyecto  

   ```bash
    mvn clean package
   ```
8. Corra el servidor en la clase httpServer "main" o ejecute el siguiente comando desde consola
   
      ```bash
    java -cp target/classes com.example.PruebaTecnicaApplication
   ```

9. Abre tu navegador y ve a:
   
      ```bash
    http://localhost:8080
   ```


## Resumen del Proyecto

###  Funcionales

Código	Descripción

R1	Consulta de vuelos disponibles

R2	Reserva de vuelos

R3	Simulación de compra de boletos (botón sin acción real)

R4	Autenticación de usuarios con credenciales en base de datos

R5	Consulta de tarifas por vuelo

R6	Información detallada de vuelos

R7	Registro de nuevos usuarios

### No funcionales

Cifrado de contraseñas con Spring Security

Arquitectura ligera y rápida

Responsive y accesible en múltiples dispositivos (gracias a Bootstrap)

### Datos de Prueba

Al iniciar por primera vez, se cargan automáticamente 10 vuelos de ejemplo si la base de datos está vacía. Puedes personalizarlos en el archivo PruebaTecnicaApplication.java.

![image](https://github.com/user-attachments/assets/66b82e3f-a86b-4a3b-b5da-e9cb67179662)

## Componentes principales

Formulario de Login

![image](https://github.com/user-attachments/assets/53338a94-0467-425a-bbb7-d2987d2de73e)

Usuario no autentificado intenta logearse

![image](https://github.com/user-attachments/assets/8992b4fa-f81c-4c15-ac1f-d5ce37e7b005)

Formulario de signup

![image](https://github.com/user-attachments/assets/fa23cf25-725a-4e06-b562-12f011b7f675)

Visualización de vuelos disponibles

![image](https://github.com/user-attachments/assets/e8fdac75-2606-4304-ae31-95e9fece8be3)

Panel de reservas del usuario

![image](https://github.com/user-attachments/assets/17d4e99f-ae86-412c-8d3e-3a7ed9a7baa4)

## Estado del Proyecto

Proyecto funcional con base en los requerimientos principales. Aún se pueden implementar:

Simulación completa de compra (R3)

Envío real de correos (R9)

Expiración automática por inactividad (R8)

Cancelación y edición de usuario

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Andres felipe montes ortiz** - 
* **@andreec2** - 

## Licencia

Este proyecto fue desarrollado con fines académicos/técnicos como parte de una prueba. El uso es libre y educativo.


