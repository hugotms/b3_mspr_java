package fr.gosecuri.items;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

public class HTML {

    public static void GenerateAccueil(ArrayList<String> users) {
        String body = "";

        for (String user: users) {
            body += "<a href='./" + user + ".html'>" + user + "</a>" +
                    "<br>";
        }

        try {
            FileUtils.writeStringToFile(
                    new File("C:/Users/hugo.tomasi/Desktop/b3_mspr_java/src/main/resources/index.html"),
                    GetBase("Accueil").replace("$body", body)
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier");
        }
    }

    public static void GenerateAgent(String fiche, ArrayList<String> items) {
        String listItems = "";

        for (String item: items) {
            listItems += "<p>" + item + "</p>" +
                    "<br>";
        }

        File bodyHtmlTemplateFile = new File("C:/Users/hugo.tomasi/Desktop/b3_mspr_java/src/main/resources/agentBody.html");

        try {
            String bodyString = FileUtils.readFileToString(bodyHtmlTemplateFile);
            bodyString = bodyString.replace("$identification", fiche);
            bodyString = bodyString.replace("$link", "https://raw.githubusercontent.com/hugotms/b3_mspr_sauvegarde/main/jpepe.jpg");
            bodyString = bodyString.replace("$items", listItems);

            FileUtils.writeStringToFile(
                    new File("C:/Users/hugo.tomasi/Desktop/b3_mspr_java/src/main/resources/hugo.html"),
                    GetBase(fiche).replace("$body", bodyString)
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier");
        }
    }

    private static String GetBase(String title) {
        File htmlTemplateFile = new File("C:/Users/hugo.tomasi/Desktop/b3_mspr_java/src/main/resources/template.html");
        try {
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            return htmlString.replace("$title", title);
        } catch (Exception e) {
            return "";
        }
    }
}
