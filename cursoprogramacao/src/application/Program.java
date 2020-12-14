package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Worker worker = new Worker();
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		worker.setDepartment(new Department(scan.next()));

		System.out.println("Enter worker data: ");

		System.out.print("Name: ");
		worker.setNome(scan.next());

		System.out.print("Level: ");
		worker.setLevel(WorkerLevel.valueOf(scan.next()));

		System.out.print("Base salary:");
		worker.setBaseSalary(scan.nextDouble());

		System.out.print("How many contracts to this worker? ");
		int quantidadeContratos = scan.nextInt();

		for (int i = 1; i <= quantidadeContratos; i++) {

			HourContract contract = new HourContract();

			System.out.println("Enter contracts #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			contract.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(scan.next()));
			System.out.print("Value per hour: ");
			contract.setValuePerHour(scan.nextDouble());
			System.out.print("Duration (hours): ");
			contract.setHours(scan.nextInt());

			worker.addContract(contract);

		}

		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat("MM/yyyy").parse(scan.next()));
		
		System.out.println("Name: " + worker.getNome());
		System.out.println("Department: " + worker.getDepartment().getNome());
		System.out.println("Income for " + 
		new SimpleDateFormat("MM/yyyy").format(calendar.getTime()) + ": " + 
		String.format("%.2f",worker.income(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH))));

	}

}
