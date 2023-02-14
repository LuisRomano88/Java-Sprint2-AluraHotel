# Sprint 2 - AluraHotel
Alura Hotel es un sistema de reservas y registro de huespedes.

Consiga del trabajo.
El Hotel Alura conocido por su espectaculares instalaciones y paquetes promocionales para Desarrolladores de Software está teniendo problemas para llevar el control de las reservaciones hechas por sus clientes, por eso solicitan nuestra ayuda para desarrollar un sistema de reserva que contenga:

    1-Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema;
    2-Permitir crear, editar y eliminar una reserva para los clientes;
    3-Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas;
    4-Registrar, editar y eliminar datos de los huéspedes;
    5-Calcular el valor de la reserva en base a la cantidades de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país, por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra diaria son 20$ debemos multiplicar esos 3 dias por el valor de la diaria que serian 60$, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva;
    6-Base de datos para almacenar todos los datos pedidos anteriormente.
    

:computer: Tecnologias utilizadas :computer:

- Java.
- Eclipse.
- MySql.
- Libreria JCalendar.
- Libreria Swing.
- Plugin WindowBuilder.

Diagrama de entidad-relación

![imagen](https://user-images.githubusercontent.com/54158037/218822286-69925177-0f67-4450-83a7-c2ee26c421d2.png)

:arrow_forward: ¿Cómo funciona?

:heavy_check_mark: Al ejecutar el programa abre la pantalla inicial con un boton de login.

![imagen](https://user-images.githubusercontent.com/54158037/218826027-d1a832f9-f8dc-4154-8146-e5e680a0626c.png)

:heavy_check_mark: Al iniciar sesión el usuario debe hacer login para poder utilizar el sistema.

![imagen](https://user-images.githubusercontent.com/54158037/218826812-380ee06b-6e18-41fb-b776-f794e43c4097.png)
 
En el caso de no ingresar con usuario o contraseñas correctas, informa con un mensaje. También cuando no ingresa ningún dato.

![imagen](https://user-images.githubusercontent.com/54158037/218827082-88d12daa-a41c-40fc-a06e-c54ed3063b3a.png)

:heavy_check_mark: Una vez que se ingresa al sistema, muestra un menú de usuario donde podemos realizar el registro de una nueva reserva o buscar reservas.

![imagen](https://user-images.githubusercontent.com/54158037/218828530-8f1d16f5-bf5e-4175-bffb-c9cdd15afd13.png)

:heavy_check_mark: Registro de reservas: 
- Este formulario permite registrar la fecha de ingreso y egreso de los huéspedes, 
- Calcular automáticamente el valor total de los dias de alojamiento al igual que la cantidad de dias,
- Podemos seleccionar diferentes formas de pago, como pago en efectivo, tarjeta de débito y tarjeta de crédito.

![imagen](https://user-images.githubusercontent.com/54158037/218829439-06a07209-8367-45f3-a3e1-3b9154be77ef.png)

En caso de seleccionar mal las fechas, es decir, que la fecha de ingreso sea mayor a la fecha de egreso, el sistema avisa con un mensaje.

![imagen](https://user-images.githubusercontent.com/54158037/218830464-aa179ab9-143e-4c82-b1d0-b0a31757406f.png)

:heavy_check_mark: Registo de Huésped:
- Este formulario solicita al usuario datos personales del huésped. 
- Genera automáticamente un número de reserva.

![imagen](https://user-images.githubusercontent.com/54158037/218830941-bd365b4a-7291-4dd1-ab3a-bfab6c6052bc.png)

En caso de no completar algunos de los campos requeridos, informa con un mensaje.

![imagen](https://user-images.githubusercontent.com/54158037/218831129-a54a4c5c-cfcb-49ed-bb59-f36dc0c26ead.png)

Si todos los datos estan correctamente, informa con los siguiente mensajes que se guardaron correctamente.

![imagen](https://user-images.githubusercontent.com/54158037/218831430-2b354d5c-d9c3-455f-a834-238837088266.png)

![imagen](https://user-images.githubusercontent.com/54158037/218831712-2fc97dd2-4aaa-4434-9a97-f63da1b5029c.png)

:heavy_check_mark: Búsqueda:

Se pueden realizar dos tipo de búsquedas.

- La primera por reserva. Muestra un listado con todas las reservas guardadas en la base de datos. También se pueden editar y eliminar los datos que se muestan en las tablas. Permite filtrar por id de reserva.

![imagen](https://user-images.githubusercontent.com/54158037/218832660-728ab89f-e60e-453a-aebb-8380bf5f63a4.png)

Cuando se edita o elimina alguna reserva, muestra un mensaje confirmando los cambios. 

![imagen](https://user-images.githubusercontent.com/54158037/218832937-c8c8aa65-278b-4527-aaf2-2ca362788efd.png) ![imagen](https://user-images.githubusercontent.com/54158037/218833131-420b9088-4b88-4b0a-9478-35c676823a28.png)

- La segunda por huéspedes. Muestra un listado con todos los huéspedes registrados en la base de datos. Se pueden editar y eliminar los datos que se muestan en las tablas. Permite filtrar por apellido.

![imagen](https://user-images.githubusercontent.com/54158037/218833589-77f5ed06-68d3-45c3-8f3a-17a851223c8d.png)

Cuando se edita o elimina algun huésped, muestra un mensaje confirmando los cambios.

![imagen](https://user-images.githubusercontent.com/54158037/218833781-9e54ddc3-4841-416b-88ce-c6a912fa641d.png) ![imagen](https://user-images.githubusercontent.com/54158037/218833933-81702fd5-76aa-4958-ae14-63222b04a4a7.png)

Para salir de sistema presinar sobre la X y pregunta si desea salir.

![imagen](https://user-images.githubusercontent.com/54158037/218834176-4368971a-729a-4d39-a494-4801abdc1289.png)















