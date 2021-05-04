package fr.gosecuri.items;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class HTML {

    public static void GenerateAccueil(ArrayList<String> users) {
        String body = "";

        if (users != null) {
            for (String user : users) {
                body += "<a href='./" + user + ".html'>" + user + "</a>" +
                        "<br>";
            }
        }

        try {
            FileUtils.writeStringToFile(
                    new File("./www/index.html"),
                    GetBase("Accueil").replace("$body", body)
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier");
        }
    }

    public static void GenerateAgent(String fiche, String nom, String prenom, String job, ArrayList<String> items) {
        String listItems = "";

        if (items != null) {
            for (String item : items) {
                listItems += "<p>" + item + "</p>" +
                        "<br>";
            }
        }

        try {
            String bodyString = GetTextFromUrl("https://raw.githubusercontent.com/hugotms/b3_mspr_java/main/src/main/resources/agentBody.html");
            bodyString = bodyString.replace("$identification", nom);
            bodyString = bodyString.replace("$nom", nom);
            bodyString = bodyString.replace("$prenom", prenom);
            bodyString = bodyString.replace("$job", job);
            bodyString = bodyString.replace("$link", "https://raw.githubusercontent.com/hugotms/b3_mspr_sauvegarde/main/" + fiche + ".jpg");
            bodyString = bodyString.replace("$items", listItems);

            FileUtils.writeStringToFile(
                    new File("./www/" + fiche + ".html"),
                    GetBase(fiche).replace("$body", bodyString)
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier");
        }
    }

    private static String GetBase(String title) {
        try {
            String htmlString = GetTextFromUrl("https://raw.githubusercontent.com/hugotms/b3_mspr_java/main/src/main/resources/template.html");
            return htmlString.replace("$title", title);
        } catch (Exception e) {
            return "";
        }
    }

    private static String GetTextFromUrl(String url) {
        StringBuilder sb = new StringBuilder();
        String line;

        InputStream in;
        try {
            in = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            in.close();
        } catch (Exception e) {
            return "";
        }

        return sb.toString();
    }
}
