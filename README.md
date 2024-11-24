# Supermarket API

## Descripción

Este es un proyecto de **API RESTful** desarrollada con **Spring** que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre algunas tablas y registros en una base de datos de un supermercado. La API está conectada a una base de datos **PostgreSQL** en la nube a través de **Azure**, y el despliegue de la aplicación se realiza mediante **GitHub Actions** para lograr un proceso de integración y despliegue continuo (CI/CD).


## Funcionalidades

La API soporta las siguientes funcionalidades:

- **Obtener todos los productos**: Consulta todos los productos disponibles en el supermercado.
- **Filtrar productos**: Filtra los productos según la categoria.
- **Eliminar productos**: Elimina un producto de la base de datos.
- **Agregar productos**: Permite agregar nuevos productos a la base de datos.

## Tecnologías utilizadas

- **Spring**: Framework utilizado para desarrollar la API.
- **PostgreSQL**: Sistema de gestión de bases de datos utilizado para almacenar los productos.
- **Azure App Service**: Plataforma en la nube utilizada para desplegar y gestionar la aplicación.
- **GitHub Actions**: Herramienta de CI/CD para automatizar el proceso de despliegue y actualización de la aplicación.

## Versiones y porgramas utilizados

Para ejecutar este proyecto en tu máquina local, asegúrate de tener lo siguiente instalado:

- Java 17.
- Gradle.
- Postgres 17.

## Configuración

### Variables de entorno

Se utilizaran variables de entorno para el despliegue en azure aplicación en Azure:

- `SPRING_DATASOURCE_URL`: URL de la base de datos PostgreSQL.
- `SPRING_DATASOURCE_USERNAME`: Nombre de usuario para la base de datos.
- `SPRING_DATASOURCE_PASSWORD`: Contraseña para la base de datos.

Estas variables se utilizan para conectar la API con la base de datos PostgreSQL en Azure.

### Base de datos en Azure

Este proyecto utiliza **Azure PostgreSQL** como la base de datos en la nube. \

## Despliegue

El proyecto está configurado para ser desplegado automáticamente en **Azure App Service** utilizando **GitHub Actions**. Al hacer un `push` al repositorio, la aplicación se compilará, se ejecutarán las pruebas (si están configuradas) y se desplegará en Azure.

### Configuración de GitHub Actions

El flujo de trabajo de GitHub Actions se encuentra en el archivo `.github/workflows/master_apipruebarest.yml`. El flujo de trabajo realiza lo siguiente:

1. **Build**: Utiliza Gradle para construir el JAR de la aplicación.
2. **Deploy**: Despliega la aplicación en Azure App Service.

## Endpoints

### `GET https://apipruebarest-cxgjb0bcg5d2a6f9.mexicocentral-01.azurewebsites.net/mercado/api/products/all`

Obtiene todos los productos de la base de datos.

**Respuesta de ejemplo**:

```json
[
    {
        "productId": 1,
        "name": "Guayaba Feijoa",
        "categoryId": 1,
        "price": 300.0,
        "stock": 500,
        "active": true,
        "category": {
            "categoryId": 1,
            "category": "Frutas y verduras",
            "active": true
        }
    },
    {
        "productId": 2,
        "name": "Mango",
        "categoryId": 1,
        "price": 2100.0,
        "stock": 250,
        "active": true,
        "category": {
            "categoryId": 1,
            "category": "Frutas y verduras",
            "active": true
        }
    }
```

### `POST https://apipruebarest-cxgjb0bcg5d2a6f9.mexicocentral-01.azurewebsites.net/mercado/api/purchases/save`
Guarda un producto
**Envio de ejemplo**:

```json
 {
    "clientId": "4546221",
    "date": "1992-08-10T17:30:00",
    "paymentMethod": "E",
    "comment": "",
    "state": "P",
    "item": [
        {
            "productId": 1,
            "quantity": 10,
            "total": 3000,
            "active": true
        }
    ]
}
```
### `GET https://apipruebarest-cxgjb0bcg5d2a6f9.mexicocentral-01.azurewebsites.net/mercado/api/products/category/id`
Obtiene todos los porductos de una categoria
**Envio de ejemplo**:

```json
[
    {
        "productId": 20,
        "name": "Costilla de cerdo",
        "categoryId": 3,
        "price": 8600.0,
        "stock": 70,
        "active": true,
        "category": {
            "categoryId": 3,
            "category": "Carnes y pescados",
            "active": true
        }
    },
    {
        "productId": 22,
        "name": "Merluza",
        "categoryId": 3,
        "price": 23000.0,
        "stock": 45,
        "active": true,
        "category": {
            "categoryId": 3,
            "category": "Carnes y pescados",
            "active": true
        }
    },
    {
        "productId": 19,
        "name": "Posta",
        "categoryId": 3,
        "price": 7800.0,
        "stock": 40,
        "active": true,
        "category": {
            "categoryId": 3,
            "category": "Carnes y pescados",
            "active": true
        }
    },
    {
        "productId": 18,
        "name": "Punta de anca",
        "categoryId": 3,
        "price": 12000.0,
        "stock": 32,
        "active": true,
        "category": {
            "categoryId": 3,
            "category": "Carnes y pescados",
            "active": true
        }
    },
    {
        "productId": 17,
        "name": "Salmón",
        "categoryId": 3,
        "price": 28000.0,
        "stock": 55,
        "active": true,
        "category": {
            "categoryId": 3,
            "category": "Carnes y pescados",
            "active": true
        }
    },
    {
        "productId": 21,
        "name": "Tilapia",
        "categoryId": 3,
        "price": 17000.0,
        "stock": 60,
        "active": true,
        "category": {
            "categoryId": 3,
            "category": "Carnes y pescados",
            "active": true
        }
    }
]
```
Hay mas Endpoints y tambien ire actualizando mas hasta tener toda la base conectana con la api.

Por cuestiones de los precios de azure no siempre estara la api activa
La url de la documentacion
https://apipruebarest-cxgjb0bcg5d2a6f9.mexicocentral-01.azurewebsites.net/mercado/api/swagger-ui/index.html#/



