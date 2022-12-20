package anotaciones1;

import java.lang.annotation.*;

@Repeatable(Empleados.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Empleado_Anotado {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    String telefono();
    String clase();
   
}