package fr.gosecuri;

import fr.gosecuri.items.Page;
import fr.gosecuri.logic.Multi;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        ArrayList<Page> pages = new ArrayList<>();
        pages.add(new Page("accueil", new ArrayList<String>()));

        try {
            Scanner s = new Scanner(new URL("https://raw.githubusercontent.com/hugotms/b3_mspr_sauvegarde/main/staff.txt").openStream());
            while (s.hasNext()) {
                String fiche = s.next();

                pages.get(0).getList().add(fiche);
                pages.add(new Page("agent", fiche, null));
            }
        } catch (Exception e) {
            System.out.println("error");
        }

        for (Page page: pages) {
            //Java considère un thread comme un objet
            new Multi(page).start();
        }
    }
}
