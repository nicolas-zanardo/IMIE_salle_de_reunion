package imie.exercice.sdr.model;

import java.util.Objects;

public class Employee {
    /**
     * phrase
     * @implNote Les phrases sont unique a chaque employé
     * @// TODO: 3/13/2022  Rendre unique la phrase
     */
    private final String phrase;
    private final String name;
    private SalleDeReunion salleDeReunion = null;

    public Employee(String name, String phrase) {
        this.name = name;
        this.phrase = phrase;
    }

    //Getter
    public String getName() { return name; }
    public String getPhrase() {
        return phrase;
    }
    public SalleDeReunion getSalleDeReunion() {
        return salleDeReunion;
    }
    // Setter
    public void setSalleDeReunion(SalleDeReunion salleDeReunion) {
        this.salleDeReunion = salleDeReunion;
    }

    // Methods
    public void sayHelloEveryOne() {
        if(this.salleDeReunion.getArrayEmployees().size()>= 2) {
            System.out.println("=> " + getName().toUpperCase() + " dit bonjour aux gens dans la salle de reunion: " + this.salleDeReunion.getName().toUpperCase());
            int arrayEmployeesSize = this.getSalleDeReunion().getArrayEmployees().size() - 1;
            int count = 1;
            for (Employee employee:this.salleDeReunion.getArrayEmployees()) {
                if(!Objects.equals(employee.getPhrase(), getPhrase())) {
                    if ( count <  arrayEmployeesSize) {
                        System.out.println(employee.getName().toUpperCase() + ": " + employee.getPhrase());
                    } else {
                        System.out.println(employee.getName().toUpperCase() + ": " + employee.getPhrase() + " Et toi ?");
                    }
                }
                ++count;
            }
            System.out.println(getName().toUpperCase() + ": " + getPhrase());
        } else {
            System.err.println("Il faut 2 personnes dans la salle de réunion pour dire bonjour");
        }
    }

    public void leaveRoom() {
        boolean isFound = false;
        for (Employee itemEmployee:this.getSalleDeReunion().getArrayEmployees()){
            if(Objects.equals(itemEmployee.getPhrase(), this.getPhrase())) {
                this.getSalleDeReunion().getArrayEmployees().remove(itemEmployee);
                System.out.println("L'employé " +this.getName()+ " est sortie de la salle de réunion: " + this.salleDeReunion.getName().toUpperCase());
                this.setSalleDeReunion(null);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.err.println("Aucun employé " +this.getName()+ " n'a été trouvé dans la salle de réunion: " + this.salleDeReunion.getName().toUpperCase());
        }
    }

}
