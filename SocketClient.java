package TPs.Tp6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);

        // Demander à l'utilisateur le nom du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        // Demander à l'utilisateur le port du serveur
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }

        try {
            InetAddress adr = InetAddress.getByName(host);
            Socket socket = new Socket(adr, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Envoyer un message au serveur
            output.writeObject(new String("ma première socket"));

            // Lire la réponse du serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
