# Sistema-de-ventas

#### Contribuidor:
  * [César A.](https://github.com/hiromi00)
    
#### Sobre este proyecto:
Sistema de ventas desarrollado en Java usando el OpenJDK 12.0.1. Este sistema usando una interfaz sencilla, pero con todas las funcionalidades para un punto de ventas de un negocio el cual apenas está iniciando.   

Para el desarrollo del sistema se ha utilizado todos los fundamentos aprendidos sobre programación en Java y haciendo uso de algoritmos sencillos para poder crear una aplicación funcional bajo ciertos estandares.            

El sistema cuenta con las funcionalidad de poder cargar nuevos articulos al stock, poder agregar nuevos porveedores de 
articulos y nuevas categorias. Así mismo permite realizar busquedas dentro de una tabla usando la clave o el nombre del articulo; una vez teniendo la busqueda de producto, se puede o editar el articulo dentro del stock o eliminar.

El sistema trabaja con un motor de bases de datos en PostgreSQL, donde cuenta con todas las tablas necesarias para que el sistema trabaje por completo.

### Funcionamiento:
Al abrir el sistema, se mostrará toda la ventana principal donde se eligira si se realizará una venta o se mostrará el stock del sistema en sí.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/pantInicio.png "Inicio")


#### Ventana de Inventario:
En la ventana de inventario nos encontramos con el sistema central, donde se puede hacer toda la carga y descarga de stock a voluntad del dueño del negocio. Así tambien podrá buscar inventario por suclave y así poder verificar su stock, poder editar el producto o poder eliminarlo, ya siendo la voluntad del dueño.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/inventario.jpg)

#### Ventana de nuevo proveedor:
Aquí se podrá cargar un nuevo proveedor para poder comenzar a comprar nuevo stock de productos con el mismo o con otros más, pero la idea consiste en agregar todos los datos necesarios para cada proveedor diferente.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/proveedor.jpg)
En la imagen, se puede observar un proveedor que fue ingresado de prueba, donde se le han agregado todos sus contactos, incluyendo su dirección y un nombre de contacto (El negocio para el que trabaja).

#### Ventana de nueva categoria:
Aqui se cargan las categorias de los productos que existiran en el negocio. Esta ventana se llena en dependencia del tipo de proveedor que se tenga o bien de los productos que se desean vender en el negocio.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/categoria.jpg)

#### Ventana de nuevo producto:
Esta sin duda es la ventana mas importante para llenar el stock, ya que aqui se carga cada producto nuevo que va ingresando al negocio. Así haciendo uso de los proveedores que se hayan cargado anteriormente y las categorias.
En esta ventana se puede agregar una imagen del producto para poder tener una imagen más clara de lo que es y bien una descripcion, precio de venta y compra, el nombre del producto y la cantidad adquirida.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/productos.jpg)

#### Ventana de Inventario actualizada:
Al volver a esta ventana, de buejnas a primeras nos e mostrará ningun cambio, pero cuando se busca algun producto por su codigo o nombre, se mostrara en la tabla y este se podra seleccionar y poder llenar mas el stock, editar o eliminar del stock.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/actInventario.jpg)

#### Ventana de venta:
Esta ventana funciona en base al codigo, el cual es introducido y saldra el producto, este se podra pasar todas las veces que se haya vendido y al final se podra realizar dicha venta ingresando la cantidad necesaria para pagar.
![alt text](https://raw.githubusercontent.com/hiromi00/Sistema-de-ventas/master/images/ventaPrueba.jpg)

##### Version y detalles:
* Sistema de ventas 1.0

Ya que esta es la priemra versión del sistema, se puede decir que no esta totalmente pulido, por lo que se desea actualizar a futuro con:
+ ###### Sistema de login para empleados o el dueño
+ ###### Lógica para evitar el duplicado de proveedores y categorias
+ ###### Botón para dar de baja algun proveedor o categoria
+ ###### Mayor detalle en la carga de stock (cantidades)
+ ###### Funcionalidad en el botón del corte del día
+ ###### Ventas más precisas (En el sentido de que hay productos que se pueden vender en partes)

Parecen ser muchos cambios, pero se espera que con el paso del tiempo, cada actualización vaya surgiendo.
