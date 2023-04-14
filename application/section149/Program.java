package application.section149;

import application.section149.entities.Department;
import application.section149.entities.HourContract;
import application.section149.entities.Worker;
import application.section149.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//serve para receber a data digitada pelo usuário

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        // workerLevel.valueOf(workerLevel) com isto eu crio uma instancia do meu  tipo enumerado WorkerLevel no valor equivalente ao que foi digitado
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour,hours); //instancio o contrato
            worker.addContract(contract); //passo esse contrato como argumento para o meu trabalhador
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");//vou pegar o MM, vou converter para inteiro e vou guardar em uma variável mês, e vou fazer o mesmo para o YYYY
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));//informo o inicio e o fim de onde quero recortar minha String (M e M, mas coloco o final em 2  pois sempre tenho que informar um posição a mais)
        int year =  Integer.parseInt(monthAndYear.substring(3));//corta da poosição 3 em diante Y...
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());//pego o objeto trabalhador, pego o outro objeto associado a ele (Department) e por último eu pego o nome
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year,month))); //chamo meu método passando o ano e o mês que eu cortei anteriormente

        sc.close();
    }
}
