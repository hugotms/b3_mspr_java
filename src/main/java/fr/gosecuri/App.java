package fr.gosecuri;

import fr.gosecuri.items.HTML;
import fr.gosecuri.logic.Controller;

public class App {
    public static void main(String [] args) {
        System.out.println("Salut les nazes");

        //Pour appeler une méthode statique, pas besoin de créer d'objet
        HTML.DireBonjour();

        //Java considère un thread comme un objet
        Controller controller = new Controller();
        controller.start();
    }
}
