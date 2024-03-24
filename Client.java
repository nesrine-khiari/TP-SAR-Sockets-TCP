package TPs.Tp6;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connexion au serveur
            Socket socket = new Socket("localhost", 9999);
            System.out.println("Connexion établie avec le serveur.");

            // Flux de sortie pour envoyer les données au serveur
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // Envoi des données sur la personne au serveur
            int age = 30; // Exemple d'âge
            String nom = "John Doe"; // Exemple de nom
            Personne personne = new Personne(age, nom);
            out.writeObject(personne);
            out.flush();

            // Flux d'entrée pour recevoir l'identifiant de client du serveur
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Lecture de l'identifiant de client
            int idClient = in.readInt();
            System.out.println("Identifiant de client reçu : " + idClient);

            // Fermeture de la connexion
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
