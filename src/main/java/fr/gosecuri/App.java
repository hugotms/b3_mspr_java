package fr.gosecuri;

import fr.gosecuri.items.Page;
import fr.gosecuri.logic.Multi;

import java.util.ArrayList;

public class App {
    public static void main(String [] args) {
        ArrayList<Page> pages = new ArrayList<>();
        pages.add(new Page("accueil", null));

        // Pour l'instant fait en dur, il faudra implementer une fonction qui prend toutes les fiches agent
        pages.add(new Page("agent", "jpepe"));

        for (Page page: pages) {
            //Java considère un thread comme un objet
            new Multi(page).start();
        }
    }
}
