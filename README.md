# Salmontt-Sistema-S8

# Sistema de Gestión Empresarial Salmontt (Java)





## Descripción general

Este proyecto corresponde a un **Sistema de gestión empresarial**, desarrollado en **Java**, que modela distintas entidades operativas de la empresa *Salmontt*, como empleados, proveedores y unidades productivas.

El sistema fue diseñado aplicando estructuras dinámicas y una **interfaz gráfica básica**, permitiendo la interacción por parte de usuarios no técnicos (personal administrativo u operadores internos).



---

## Objetivos del sistema

- Unificar la gestión de distintas entidades de la empresa bajo un **comportamiento común**.
- Aplicar **herencia, polimorfismo e interfaces**.
- Gestionar los objetos mediante **colecciones dinámicas**.
- Validar el tipo de objeto en tiempo de ejecución utilizando `instanceof`.
- Facilitar el uso del sistema mediante una **interfaz gráfica Swing**, sin depender de consola.



---

## Arquitectura y diseño

### Interfaz común

Se define una interfaz llamada `Registrable`, que actúa como **contrato de comportamiento** para todas las entidades gestionables del sistema.

```java
interface Registrable {
    String mostrarResumen();
}













