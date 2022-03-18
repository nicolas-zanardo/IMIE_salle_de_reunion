package imie.exercice.sdr.model;

import java.util.Objects;

/**
 * Class Chef
 * @implNote Polymorphisme d'héritage
 */
public class Chef extends Employee {
    private final String phrase;

    public Chef(String name, String phrase) {
        super(name, phrase);
        this.phrase = phrase;
    }

    // Getter
    @Override
    public String getPhrase() {
        return phrase + " <| Et je suis le 'CHEF' |>";
    }


    // Methods
    @Override
    public void leaveRoom() {
        boolean isFound = false;
        for (Employee itemEmployee:this.getSalleDeReunion().getArrayEmployees()){
            if(Objects.equals(itemEmployee.getPhrase(), this.getPhrase())) {
                this.getSalleDeReunion().getArrayEmployees().remove(itemEmployee);
                System.out.println("L'employé " +this.getName()+ " est sortie de la salle de réunion: " + this.getSalleDeReunion().getName().toUpperCase());
                this.getSalleDeReunion().setChef(null);
                this.setSalleDeReunion(null);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.err.println("Aucun employé " +this.getName()+ " n'a été trouvé dans la salle de réunion: " + this.getSalleDeReunion().getName().toUpperCase());
        }
    }
}
