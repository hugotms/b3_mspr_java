package fr.gosecuri.items;

import java.util.ArrayList;

public class Page {
    private String type;
    private ArrayList<String> list;
    private String fiche;

    public Page(String type, ArrayList<String> list) {
        this.type = type;
        this.list = list;
    }

    public Page(String type, String fiche, ArrayList<String> list) {
        this.type = type;
        this.fiche = fiche;
        this.list = list;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public String getFiche() {
        return fiche;
    }
}
