package fr.gosecuri.logic;

import fr.gosecuri.items.ApacheSecurite;
import fr.gosecuri.items.HTML;
import fr.gosecuri.items.Page;

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
                HTML.GenerateAccueil(page.getList());
                break;
            case "agent":
                HTML.GenerateAgent(page.getFiche(), page.getNom(), page.getPrenom(), page.getJob(), page.getList());
                break;
            case "htpasswd":
                ApacheSecurite.GenerateHTPaswd(page.getListUser());
                break;
            default:
                System.out.println("unknown file type");

        }
    }
}
