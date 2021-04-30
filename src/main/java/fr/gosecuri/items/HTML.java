package fr.gosecuri.items;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

public class HTML {

    public static void GenerateAccueil(ArrayList<String> users) {
        String body = "";


        for (String user: users) {
            body += "<a href='" + user + ".html' />" +
                    "<br>";
        }

        try {
            FileUtils.writeStringToFile(
                    new File("D:/EPSI/B3annee2020-2021/Integration Continue/mspr java/b3_mspr_java/src/main/resources/new.html"),
                    GetBase("Accueil").replace("$body", body)
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier");
        }
    }

    public static void GenerateAgent(String fiche) {
        System.out.println("test 2");
    }

    private static String GetBase(String title) {
        File htmlTemplateFile = new File("D:/EPSI/B3annee2020-2021/Integration Continue/mspr java/b3_mspr_java/src/main/resources/template.html");
        try {
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            return htmlString.replace("$title", title);
        } catch (Exception e) {
            return "";
        }
    }
}