package fr.gosecuri;

import fr.gosecuri.items.Page;
import fr.gosecuri.items.User;
import fr.gosecuri.logic.Multi;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        // On crée une liste de pages à créer et on ajoute la page d'accueil
        ArrayList<Page> pages = new ArrayList<>();
        pages.add(new Page("accueil", new ArrayList<String>()));
        pages.add(new Page(new ArrayList<User>(), "htpasswd"));

        // Pour chaque utilisateur de la page d'acceuil
        try {
            Scanner s = new Scanner(new URL("https://raw.githubusercontent.com/hugotms/b3_mspr_sauvegarde/main/staff.txt").openStream());

            while (s.hasNext()) {
                String fiche = s.next();
                try {
                    Scanner agentInfos = new Scanner(new URL("https://raw.githubusercontent.com/hugotms/b3_mspr_sauvegarde/main/" + fiche + ".txt").openStream());
                    String nom = agentInfos.next();
                    String prenom = agentInfos.next();
                    String job = agentInfos.next();
                    String pwd = agentInfos.next();
                    ArrayList<String> items = new ArrayList<>();

                    while (agentInfos.hasNext()) {
                        String item = agentInfos.next();
                        if (item != "") {
                            items.add(item);
                        }
                    }

                    pages.get(0).getList().add(fiche);
                    pages.get(1).getListUser().add(new User(fiche, pwd));
                    pages.add(new Page("agent", fiche, nom, prenom, job, items));
                } catch (Exception e) {
                    System.out.println("Impossible de lire le fichier " + fiche + ".txt");
                }
            }
        } catch (Exception e) {
            System.out.println("Impossible de lire le fichier");
        }


        for (Page page: pages) {
            //Java considère un thread comme un objet
            new Multi(page).start();
        }
    }
}
