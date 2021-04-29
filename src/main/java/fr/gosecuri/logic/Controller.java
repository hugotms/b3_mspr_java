package fr.gosecuri.logic;

public class Controller extends Thread {
    //Lorsque un thread est démarré avec la méthode start, c'est la méthode run qui prend le relais
    @Override
    public void run() {
        System.out.println("Coucou depuis un thread");
    }
}
