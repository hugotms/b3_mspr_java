package fr.gosecuri.items;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

public class ApacheSecurite {
    public static void GenerateHTPaswd(ArrayList<User> list) {
        GenerateHTAccess();

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

    private static void GenerateHTAccess() {
        try {
            FileUtils.writeStringToFile(
                    new File("./www/.htaccess"),
                    "AuthType Basic" + System.lineSeparator() +
                            "AuthName \"Restricted Content\"" + System.lineSeparator() +
                            "AuthUserFile /var/www/html/.htpasswd" + System.lineSeparator() +
                            "Require valid-user"
            );
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier htaccess");
        }
    }
}
