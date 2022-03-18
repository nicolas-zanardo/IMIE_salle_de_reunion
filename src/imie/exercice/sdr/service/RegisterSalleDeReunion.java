package imie.exercice.sdr.service;

import imie.exercice.sdr.model.Chef;
import imie.exercice.sdr.model.Employee;
import imie.exercice.sdr.model.SalleDeReunion;


public class RegisterSalleDeReunion {
    private static RegisterSalleDeReunion instance = null;

    private RegisterSalleDeReunion() {}

    public static RegisterSalleDeReunion getInstance() {
        if(instance == null) {
            instance = new RegisterSalleDeReunion();
        }
        return instance;
    }

    public void registerEmployee(Employee employee, SalleDeReunion salleDeReunion) {
        if (salleDeReunion.getArrayEmployees().size() <= salleDeReunion.getCapacityMax() - 1 ) {
            if (employee.getSalleDeReunion() == null) {
                salleDeReunion.getArrayEmployees().add(employee);
                employee.setSalleDeReunion(salleDeReunion);
                System.out.println("L'employé " +employee.getName()+ " est entré dans la salle de réunion "+ salleDeReunion.getName().toUpperCase() +".");
            } else {
                System.err.println("L'employé est déjà affecté a une salle de reunion" );
            }
        } else {
            System.err.println("Message => Impossible d'ajouter l'employé " + employee.getName() + ", la salle est pleine");
        }
    }

    public void registerChef(Chef chef, SalleDeReunion salleDeReunion) {
        if(salleDeReunion.getChef() == null && chef.getSalleDeReunion() == null) {
            salleDeReunion.setChef(chef);
            salleDeReunion.getArrayEmployees().add(chef);
            chef.setSalleDeReunion(salleDeReunion);
            System.out.println("Le chef " +chef.getName()+ " est entré dans la salle de réunion "+ salleDeReunion.getName().toUpperCase() +".");
        } else {
            System.err.println("Le chef " +chef.getName()+ " est déjà affecté à une salle de réunion "+ salleDeReunion.getName().toUpperCase() +".");
        }

    }


}
