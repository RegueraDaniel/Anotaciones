package anotaciones1;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Empleados(value = { 
		@Empleado_Anotado
		(nombre = "Amancio",
		apellidos = "Ortega",
		dni = "66554433F",
		direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
		telefono = "981185596f",
		clase = "Directivo"), 
		
		@Empleado_Anotado
		(nombre="josema", 
		  apellidos = "martin tejero",
		  dni = "10010100v",
		  direccion = "calle falsa 123, Andorra",
		  telefono = "666666666",
		  clase = "oficial"),
		
		@Empleado_Anotado
		(nombre="daniel", 
		  apellidos = "reguera",
		  dni = "31629979b",
		  direccion = "calle pacharan 61b benalmadena, malaga",
		  telefono = "555555555",
		  clase = "tecnico")
})

public class Empresa {
	
	private String nombre;
	private List<Empleado> plantillaEmpleados;
	
	public Empresa(String nombreEmpresa) {
		this.nombre = nombreEmpresa;
		this.plantillaEmpleados = new ArrayList<>();
	}
	

	public static Empresa cargadorDeContexto() {
		Empresa empresaNueva = new Empresa("Gruas Reauto S.L.");
	
		Class empresa = Empresa.class;
		Annotation plantilla = empresa.getAnnotation(Empleados.class);   
		
		if(plantilla instanceof Empleados ) {
			
			Empleados miAnotacion = (Empleados) plantilla;
			
			for(Empleado_Anotado e: miAnotacion.value()) {
				
				Empleado empleadoNuevo = new Empleado();
				empleadoNuevo.setApellidos(e.apellidos());
				empleadoNuevo.setNombre(e.nombre());
				empleadoNuevo.setDireccion(e.direccion());
				empleadoNuevo.setDni(e.dni());
				empleadoNuevo.setTelefono(e.telefono());
				empleadoNuevo.setClase(e.clase());
				empresaNueva.plantillaEmpleados.add(empleadoNuevo);
			}
		}

		return empresaNueva;
	}
	
	public String toString() {
		String resul = "";
		for(Empleado e : this.plantillaEmpleados) {
			resul += e.getClase() +"\t" + e.getNombre() +"\t" + e.getApellidos() +"\t" + e.getDireccion() +"\t" + e.getDni() +"\t" + e.getTelefono() + "\n" ;
		}
		return resul;
	}
}