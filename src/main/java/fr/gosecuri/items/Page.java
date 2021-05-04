package fr.gosecuri.items;

import java.util.ArrayList;

public class Page {
    private String type;
    private ArrayList<String> list;
    private String fiche;
    private String nom;
    private String prenom;
    private String job;
    private ArrayList<User> listUser;

    public Page(String type, ArrayList<String> list) {
        this.type = type;
        this.list = list;
    }

    public Page(ArrayList<User> listUser, String type) {
        this.type = type;
        this.listUser = listUser;
    }

    public Page(String type, String fiche, String nom, String prenom, String job, ArrayList<String> list) {
        this.type = type;
        this.fiche = fiche;
        this.nom = nom;
        this.prenom = prenom;
        this.job = job;
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

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getJob() {
        return job;
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }
}
