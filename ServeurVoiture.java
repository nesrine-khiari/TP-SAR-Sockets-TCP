package TPs.Tp6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurVoiture {
    public static void main(String[] args) {
        try {
            // Création d'une ServerSocket pour écouter les connexions des clients
            ServerSocket serverSocket = new ServerSocket(9999);

            // Attente de la connexion d'un client
            System.out.println("Attente de connexion...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion établie avec " + clientSocket.getInetAddress());

            // Flux d'entrée pour recevoir l'objet voiture envoyé par le client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            // Lecture de l'objet voiture
            voiture voitureRecue = (voiture) in.readObject();

            // Traitement de l'objet voiture reçu (par exemple, fixer la quantité de
            // carburant)
            voitureRecue.setCarburant(50); // Exemple de fixer la quantité de carburant

            // Affichage de la quantité de carburant après réception
            System.out.println("Quantité de carburant après réception : " + voitureRecue.getCarburant());

            // Fermeture des flux et de la connexion
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
