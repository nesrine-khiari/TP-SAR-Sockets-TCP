package TPs.Tp6;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);

        // Demander à l'utilisateur le port d'écoute
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            // Attendre qu'une connexion soit établie avec un client
            Socket socket = serverSocket.accept();

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Lire un message envoyé par le client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);

            // Afficher l'adresse IP et le port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() +
                    ":" + socket.getPort());

            // Envoyer une réponse au client
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
