package imie.exercice.sdr.model;


import java.util.ArrayList;

public class SalleDeReunion {
    private final String name;
    private final int numberRefSDR;
    private final int capacityMax;
    private Chef chef = null;

    private final ArrayList<Employee> arrayEmployees = new ArrayList<Employee>();

    public SalleDeReunion(String name, int numberRefSDR, int capacityMax) {
        this.name = name;
        this.numberRefSDR = numberRefSDR;
        this.capacityMax = capacityMax;
        // Trace log
        this.traceToString();
    }

    // Getter
    public String getName() {
        return name;
    }
    public int getCapacityMax() {
        return capacityMax;
    }
    public ArrayList<Employee> getArrayEmployees() {
        return arrayEmployees;
    }
    public Chef getChef() { return chef; }
    // Setter
    public void setChef(Chef chef) { this.chef = chef;    }

    // Methods
    public void startReunion() {
        if(this.getChef() != null && this.getArrayEmployees().size() >= 2) {
            System.out.println("## LA REUNION COMMENCE \n Liste des participants: ");
            for (Employee itemEmployee: this.getArrayEmployees()) {
                System.out.println("- " + itemEmployee.getName());
            }
        } else {
            System.err.println("=> Vous devez avoir un chef et un employé dans le salle pour commencer la reunion");
        }
    }

    private void traceToString() {
        System.out.println(""
                + "\n####### CREATION #######"
                + "\n SALLE DE REUNION :"
                + "\n- nom: " + this.name.toUpperCase()
                + "\n- Référence N°: " + this.numberRefSDR
                + "\n- Capacité d'accueil: " + this.capacityMax
                + "\n######### FIN ##########");
    }

}
