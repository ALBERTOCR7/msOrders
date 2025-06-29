# Sistema E-Commerce Distribuido: Microservicios `ms-products` y `ms-orders`

Este proyecto implementa dos microservicios independientes que se comunican entre sí a través de HTTP para resolver el flujo de gestión de productos y órdenes en un entorno distribuido.

---

## Tecnologías Utilizadas

* Java 17
* Spring Boot 3.x
* Spring Web
* Spring Data JPA
* Spring Validation
* REST Template
* MySQL 8
* Maven
* Lombok
* Postman
* GitHub (repositorio con ramas y versiones)

---

## Estructura del Repositorio (Rama `Dev`)

```
parcial/
├── ms-products/           # Microservicio de productos
├── ms-orders/             # Microservicio de órdenes
├── Ecommerce-Postman-Collection.json  # Colección Postman exportada
└── README.md              # Documentación general del sistema
```

Repositorio: [https://github.com/ALBERTOCR7/parcial/tree/Dev](https://github.com/ALBERTOCR7/parcial/tree/Dev)

---

## Cómo correr el proyecto

### Paso 1: Crear las bases de datos en MySQL

```sql
CREATE DATABASE productsdb;
CREATE DATABASE ordersdb;
```

### Paso 2: Configurar `application.properties`

#### `ms-products/src/main/resources/application.properties`

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/productsdb
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

#### `ms-orders/src/main/resources/application.properties`

```properties
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/ordersdb
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### Paso 3: Ejecutar los proyectos

1. Inicia primero el microservicio `ms-products`.
2. Luego inicia el microservicio `ms-orders`.

Puedes usar Spring Boot desde VSCode o terminal:

```bash
cd ms-products
mvn spring-boot:run

cd ../ms-orders
mvn spring-boot:run
```

---



### Captura 1: Consultar stock desde `ms-orders`

**Método:** `GET`
**URL:** `http://localhost:8082/orders/stock-check/1`
**Resultado esperado:**

```json
{
  "stock": 10
}
```

### Captura 2: Crear una orden

**Método:** `POST`
**URL:** `http://localhost:8082/orders`
**Body:**

```json
{
  "client": "Juan",
  "status": "PENDING",
  "productId": 1
}
```

### Captura 3: Buscar órdenes por cliente

**Método:** `GET`
**URL:** `http://localhost:8082/orders/client?name=Juan`

---

## Colección Postman

Puedes descargar y usar esta colección para probar los endpoints:

👉 [Descargar Ecommerce Postman Collection](./Ecommerce-Postman-Collection.json)

---

## Explicación de patrones aplicados

### Patrón de Cliente REST + Circuit Breaker (Fallback)

**Ubicación:** `ms-orders/src/main/java/com/parcial/msorders/client/ProductClient.java`

* Se implementó un cliente REST manual usando `RestTemplate` para llamar al microservicio de productos.
* Se simula un `Circuit Breaker` mediante try-catch devolviendo un valor por defecto con `fallbackStock()` en caso de fallo de conexión.

### Validaciones y Buenas Prácticas

* Se usaron anotaciones como `@NotNull`, `@NotBlank` y `@Valid` en entidades.
* Se agregó un manejador global de excepciones con `@ControllerAdvice` y `@ExceptionHandler` para retornar respuestas HTTP claras.
* Cada método devuelve `ResponseEntity` con códigos HTTP adecuados (`200`, `201`, `400`, `404`, etc).

---

## Estado final del repositorio Git

Repositorio GitHub: [parcial](https://github.com/ALBERTOCR7/parcial/tree/Dev)

### Rama utilizada: `Dev`

Se creó la rama `Dev` y se subieron los siguientes archivos:

```
Dev branch:
├── ms-products/
├── ms-orders/
├── Ecommerce-Postman-Collection.json
└── README.md
```

### Comandos Git utilizados:

```bash
# 1. Clonar el repositorio y cambiar de rama
 git clone https://github.com/ALBERTOCR7/parcial.git
 cd parcial
 git checkout Dev

# 2. Copiar las carpetas y crear el README
 move ../ms-products ./ms-products
 move ../ms-orders ./ms-orders
 mkdir capturas
 notepad README.md  # y pegar contenido

# 3. Subir los cambios
 git add .
 git commit -m "Subida inicial de microservicios ms-products y ms-orders con README y colección Postman"
 git push origin Dev
```
