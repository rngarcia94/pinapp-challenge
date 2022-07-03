# Pinapp Challenge

Aplicacion creada para el desafio tecnico de Pinapp.

Esta desplegada en GCP

Se puede correr localmente, utiliza el puerto 8080

## Uso 

La aplicacion se puede probrar completamente usando Swagger desde GCP


[Swagger](http://pinapp-challenge-rng.rj.r.appspot.com/swagger-ui/index.html#/client-controller/getKpi)

## Healthcheck

Podemos probar que la app esta funcionando usando

[Ping](http://pinapp-challenge-rng.rj.r.appspot.com/ping)

Nos deberia devolver: **pong**

## Endpoints

### **POST:** /creacliente 

Crea un cliente usando el siguiente body:

```
{
  "nombre": "string",
  "apellido": "string",
  "edad": int,
  "fechaDeNacimiento": "yyyy-MM-dd"
}
```
Al crear un cliente verifica que la edad y la fecha de nacimiento concuerden.

### **GET:** /listclientes

Nos retorna la lista de cliente y la fecha probable de cada uno.

### **GET:** /kpideclientes

Nos retorna el promedio de edad de los clientes y la Desviacion Estandar de la muetra.

**Extra**

### **POST:** /creacliente

Crea una lista de clientes usando el siguiente body:

```
[
    {
      "nombre": "string",
      "apellido": "string",
      "edad": int,
      "fechaDeNacimiento": "yyyy-MM-dd"
    },
    {
      "nombre": "string",
      "apellido": "string",
      "edad": int,
      "fechaDeNacimiento": "yyyy-MM-dd"
    }
]
```
Al crear un cliente verifica que la edad y la fecha de nacimiento concuerden.

### **GET:** /ping

Se utiliza para checkear el estado de la aplicacion.

Devuelve "pong".

## Links

**GCP:** http://pinapp-challenge-rng.rj.r.appspot.com/
