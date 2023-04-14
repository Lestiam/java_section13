package application.section149.entities;

import application.section149.entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    //atributos básicos
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    //a partir daqui são as associações com base no desenho da UML.
    private Department department;
    private List<HourContract> contracts = new ArrayList<>(); //se instancia a lista dessa forma, no próprio atributo, para ela vir vazia

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {//não se instancia lista no construtor
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){ //toda vez que eu chamo o addContract, eu adiciono um contrato na lista
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for( HourContract c : contracts) {//vou testar se o contrato c é desse ano e desse mês, e cao seja, vou adicioná-lo a soma
            cal.setTime(c.getDate());//peguei a data do meu contrato e defini essa data como sendo a data do calendário
            int c_year = cal.get(Calendar.YEAR);//o ano do contrato c vai ser esse calendário.get e aí pega o ano
            int c_month = 1 + cal.get(Calendar.MONTH);//precisa do +1 pois o mesmo do Calendar em Java começa com 0
            if (year == c_year && month == c_month) {//se ano informado como argumento for igual ao ano do contrato que estou analisando && se o mês informado como parâmetro for igual ao mes deste contrato...
                sum += c.totalValue();  //...aí sim este contrato c vai ser um contrato deste mês e deste ano e aí o valor dele vai entrar na soma
            }
        }
        return sum;
    }

}
