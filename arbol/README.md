# Árbol Binario de Documentos

Este proyecto consiste en una aplicación de gestión de documentos utilizando un árbol binario. Permite agregar documentos, visualizar los documentos en orden, y buscar documentos según ciertos criterios. La aplicación está dividida en varias clases para una mejor organización y mantenimiento del código.

## Estructura del Proyecto

El proyecto se compone de las siguientes clases:

- Documento: Representa un documento con atributos como nombre, apellido1, apellido2 y número de documento.
- Nodo: Representa un nodo en el árbol binario, que contiene un documento y referencias a nodos hijo izquierdo y derecho.
- ArbolBinario: Implementa las operaciones del árbol binario, como agregar documentos y obtener la lista de documentos en orden.
- FrmOrdenamiento: Interfaz gráfica de usuario (GUI) que permite a los usuarios interactuar con el árbol binario y realizar operaciones sobre los documentos.

## Requisitos

- JDK 11 o superior
- IDE como Eclipse o IntelliJ IDEA para la ejecución del proyecto

## Instalación

1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>


### Explicación de Búsqueda y Ordenación

Búsqueda de Documentos:

1. Campo de Búsqueda: La interfaz tiene un campo donde el usuario puede ingresar un término de búsqueda.
2. Botón de Búsqueda: Al hacer clic en el botón "Buscar", se invoca un método que recorre el árbol binario y encuentra los documentos que contienen el término ingresado.
3. Resultados: Los documentos que coincidan se mostrarán en una tabla en la interfaz.

Ordenación de Documentos:

1. Encabezados de Columnas: Cada columna de la tabla tiene un encabezado que el usuario puede hacer clic y desplazar.
2. Método de Ordenación: Al hacer clic en un encabezado y desplazarlo a la primera columna, se activa un método que ordena los documentos en base a la columna seleccionada. Se puede alternar entre orden ascendente y descendente cuando se selecciona A-Z o Z-A, y luego en el botón "Ordenar".
3. Visualización: Los documentos ordenados se actualizan automáticamente en la tabla de la interfaz.
