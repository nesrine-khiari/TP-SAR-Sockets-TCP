package TPs.Tp6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientVoiture {
    public static void main(String[] args) {
        try {
            // Création de l'objet voiture
            voiture maVoiture = new voiture("Berline", "Toyota");
            // Connexion au serveur
            Socket socket = new Socket("localhost", 9999);

            // Flux de sortie pour envoyer l'objet voiture
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // Envoyer l'objet voiture au serveur
            out.writeObject(maVoiture);
            out.flush();

            // Fermeture de la connexion
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
