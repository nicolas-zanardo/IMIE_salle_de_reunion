package imie.exercice.sdr;

import imie.exercice.sdr.service.RegisterSalleDeReunion;
import imie.exercice.sdr.model.Chef;
import imie.exercice.sdr.model.Employee;
import imie.exercice.sdr.model.SalleDeReunion;

public class Main {

    public static void main(String[] args) {
        // Salle de reunion
        SalleDeReunion salleSudOuest = new SalleDeReunion("sud-ouest", 64, 4);
        // Employee
        Employee mikael = new Employee("Mikael", "Cool, je vais bien.");
        Employee christophe = new Employee("Christophe", "Hey, impecable.");
        Employee luc = new Employee("Luc", "Bonjour, super.");
        Employee brayan = new Employee("Brayan", "Hi, there.");
        // Chef
        Chef rodolphe = new Chef("Rodolphe", "Merci, je vais bien.");

        /*
         * -- TEST --
         */
        System.out.println("\n##### ADD USER #####");
        RegisterSalleDeReunion.getInstance().registerEmployee(mikael, salleSudOuest);

        System.out.println("\n##### ADD THE SAME USER #####");
        RegisterSalleDeReunion.getInstance().registerEmployee(mikael, salleSudOuest);
        // Sleep zZZzZZz wait response
        Main.sleepToWaitResponse();

        System.out.println("\n##### TEST HELLO 1 user in room #####");
        mikael.sayHelloEveryOne();
        Main.sleepToWaitResponse();

        System.out.println("\n##### TEST Start Reunion with 1 participant in room #####");
        salleSudOuest.startReunion();
        Main.sleepToWaitResponse();

        System.out.println("\n##### ADD USER #####");
        RegisterSalleDeReunion.getInstance().registerEmployee(christophe, salleSudOuest);

        System.out.println("\n##### TEST HELLO 2 users in room #####");
        christophe.sayHelloEveryOne();

        System.out.println("\n##### ADD USER #####");
        RegisterSalleDeReunion.getInstance().registerChef(rodolphe, salleSudOuest);
        RegisterSalleDeReunion.getInstance().registerEmployee(luc, salleSudOuest);

        System.out.println("\n##### AFFECT CHEF in the same room twice #####");
        RegisterSalleDeReunion.getInstance().registerChef(rodolphe, salleSudOuest);
        Main.sleepToWaitResponse();

        System.out.println("\n##### TEST HELLO users in room #####");
        mikael.sayHelloEveryOne();

        System.out.println("\n##### TEST LEAVE Chef rodolphe #####");
        rodolphe.leaveRoom();

        System.out.println("\n##### USER LEAVE ROOM #####");
        christophe.leaveRoom();

        System.out.println("\n##### TEST Start Reunion without chef #####");
        salleSudOuest.startReunion();
        Main.sleepToWaitResponse();

        System.out.println("\n##### TEST Start Reunion with chef and 2 participants #####");
        RegisterSalleDeReunion.getInstance().registerChef(rodolphe, salleSudOuest);
        salleSudOuest.startReunion();

        System.out.println("\n##### ADD USER on capacity max #####");
        RegisterSalleDeReunion.getInstance().registerEmployee(christophe, salleSudOuest);
        RegisterSalleDeReunion.getInstance().registerEmployee(brayan, salleSudOuest);
    }

    private static void sleepToWaitResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
