package TPs.Tp6;

import java.io.Serializable;

public class voiture implements Serializable {
    private int carburant;
    private String model;
    private String type;
    private static int capacite = 300;

    voiture(String _type, String _model) {
        type = _type;
        model = _model;
        carburant = 0;
    }

    public void setCarburant(int c) {
        int maxi = capacite - carburant;
        if (c < maxi) {
            carburant += c;
            System.out.println("Le remplissage a été effectué sans problème.");
        } else {
            carburant = capacite;
            System.out.println((c - maxi) + "litre(s) de carburant ont deborde.");
        }
    }

    public int getCarburant() {
        return carburant;
    }

    public int getCapacite() {
        return capacite;
    }
}
