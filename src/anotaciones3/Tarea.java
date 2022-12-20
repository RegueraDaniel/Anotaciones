package anotaciones3;

import java.lang.annotation.*;

import anotaciones1.Empleados;

@Repeatable(AgendaSemana.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tarea {
	String titulo();
	String descripcion();
	String dia();
	int hora();
}