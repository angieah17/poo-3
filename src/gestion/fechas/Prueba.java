package gestion.fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Prueba {

	public static void main(String[] args) {
		
		
		//LocalDateTime
		LocalDateTime ahoraMismo = LocalDateTime.now();
		System.out.println(ahoraMismo);
		
		LocalDateTime unPoquitoDespues = LocalDateTime.now();
		System.out.println(unPoquitoDespues);
		
		
		/*//Time
		LocalTime ahoraMismo = LocalTime.now();
		System.out.println(ahoraMismo);
		
		for (int i = 0; i < 10_000; i++) {
			int j = 0;
			j++;
		}
		
		LocalTime unPoquitoDespues = LocalTime.now();
		System.out.println(unPoquitoDespues);*/
		
				
		
		
		/*//Date
		LocalDate ahoraMismo = LocalDate.now();
		System.out.println(ahoraMismo);
		
		LocalDate unPoquitoDespues = LocalDate.now();
		System.out.println(unPoquitoDespues);*/
		
		//Métodos estáticos que permiten la construcción de instancias de estas fechas y horas
		
		LocalDate fechaFutura = LocalDate.of(2033, 3, 7);
		System.out.println(fechaFutura);
		
		LocalDate fechaFutura2 = LocalDate.of(2033, Month.MARCH, 7); //Se puede usar un Enum
		System.out.println(fechaFutura2);
		
		LocalTime horaFutura = LocalTime.of(10, 5);
		System.out.println(horaFutura);
		
		LocalDateTime fechaHoraFutura = LocalDateTime.of(fechaFutura, horaFutura);
		System.out.println(fechaHoraFutura);
		
		//Operar: 
		
		/*plus/minus
		 * Years, Months, Weeks, Days, Hours
		 * Minutes, Seconds, Nanos
		 * */
		
		horaFutura = horaFutura.plusHours(1); //se sustituye, no se modifica 
		
		System.out.println(horaFutura);
		System.out.println(horaFutura.minusMinutes(5));
		
		
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.now();
		LocalDate ld3 = ld1.plusDays(0); // Si no se suma, retorna this.
		
		System.out.println( ld1.minusWeeks(2));
		
		System.out.println(ld1.toEpochDay()); //Desde el 01/01/1970 
		//System.out.println(LocalDateTime.now().toEpochSecond());
		
		Period p = Period.ofDays(5);
		Period p2 = Period.of(3, 0, 4);
		
		System.out.println(p2);
		
		System.out.println(ld1.plus(p2).plusWeeks(33)); //Se pueden ir concatenando métodos del mismo tipo
		
		System.out.println(p2); //Como se puede ver NO se altera el p2
		
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.now();
		LocalTime lt = LocalTime.now();
		
		
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MM dd yy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MM dd yyyy");
		
		System.out.println(ldt.format(f2));
		System.out.println(f2.format(ldt));
		
		DateTimeFormatter f3 = DateTimeFormatter.ISO_DATE; //Hay Enum con formatos ya definidos.
		System.out.println(ldt.format(f3));
		
		
		
	}

}
