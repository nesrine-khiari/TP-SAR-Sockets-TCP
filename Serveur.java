package TPs.Tp6;

import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Création d'une ServerSocket pour écouter les connexions des clients
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Serveur en attente de connexions...");

            // Attente de la connexion d'un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion établie avec " + clientSocket.getInetAddress());

            // Flux d'entrée pour recevoir les données du client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            // Lecture des données sur la personne envoyées par le client
            Personne personne = (Personne) in.readObject();

            // Traitement des données sur la personne (pour l'exemple, juste affichage)
            System.out.println("Données reçues du client : ");
            System.out.println("Nom : " + personne.getNom());
            System.out.println("Âge : " + personne.getAge());

            // Génération d'un identifiant de client (pour l'exemple, un nombre aléatoire)
            int idClient = (int) (Math.random() * 1000);

            // Flux de sortie pour envoyer l'identifiant de client au client
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeInt(idClient);
            out.flush();

            // Fermeture des flux et de la connexion
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
