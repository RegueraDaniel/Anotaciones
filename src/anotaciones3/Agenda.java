package anotaciones3;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import anotaciones1.Empleado_Anotado;
import anotaciones1.Empresa;

@AgendaSemana(value = {
		
		@Tarea
		(titulo = "Aprobar asignatura",
		descripcion = "Realizar las tereas, estudiar e ir relajado al examen ",
		dia = "Lunes",
		hora = 8),
		
		@Tarea
		(titulo = "Descansar",
		descripcion = "Quitar despertador, hacer un poco de deporte y la compra",
		dia = "Martes",
		hora = 12),
		
		@Tarea
		(titulo = "Volver a ponerse las pilas",
		descripcion = "Poner despertador, dejar café hecho, llevarse la sonrisa puesta",
		dia = "Miercoles",
		hora = 8)
})

public class Agenda {

	private List <Tarea> agenda ;
	
	public Agenda () {
		this.agenda = new ArrayList<>();
	}
	
	static Agenda mostrarAgenda() {
		Agenda nuevaAgenda = new Agenda();
		
		Class agenda = Agenda.class;
		
		Annotation agenda_tareas = agenda.getAnnotation(AgendaSemana.class);
		
		if(agenda_tareas instanceof AgendaSemana) {
			AgendaSemana miAnotacion = (AgendaSemana) agenda_tareas;
			for(Tarea t: miAnotacion.value()) {
				nuevaAgenda.agenda.add(t);
			}
		}

		return nuevaAgenda;
	}
	public String toString() {
		String resul = "";
		for(Tarea t : this.agenda) {
			resul += t +"\n";
		}
		return resul;
	}
	
	public static void main(String[] args) {
		
		Agenda nuevaAgenda = Agenda.mostrarAgenda();
		System.out.println(nuevaAgenda);
	}

}
