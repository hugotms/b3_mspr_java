package fr.gosecuri.logic;

import fr.gosecuri.items.HTML;
import fr.gosecuri.items.Page;

import java.util.ArrayList;
import java.util.Arrays;

public class Multi extends Thread {
    private Page page;

    public Multi(Page page) {
        this.page = page;
    }

    //Lorsque un thread est démarré avec la méthode start, c'est la méthode run qui prend le relais
    @Override
    public void run() {
        switch (page.getType()) {
            case "accueil":
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("hugo");
                HTML.GenerateAccueil(arrayList);
                break;
            case "agent":
                HTML.GenerateAgent(page.getArgs().toString());
                break;
            default:
                System.out.println("unknown file type");

        }
    }
}