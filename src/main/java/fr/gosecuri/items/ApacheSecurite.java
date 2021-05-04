package fr.gosecuri.items;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

public class ApacheSecurite {
    public static void GenerateHTPaswd(ArrayList<User> list) {
        String logs = "";

        if (list != null) {
            for (User user: list) {
                logs += user.getUsername() + ":" + user.getPwd() + System.lineSeparator();
            }
        }

        try {
            FileUtils.writeStringToFile(
                    new File("./www/.htpasswd"),
                    logs
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier htpasswd");
        }
    }
}
