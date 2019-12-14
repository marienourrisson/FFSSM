package FFSSM;

import java.util.Calendar;
import java.util.ArrayList;

public class Plongeur extends Personne {

    private int niveau;
    private ArrayList<Licence> licences = new ArrayList<Licence>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.licences = new ArrayList();
    }

    public void ajouteLicence(Licence L) {
        licences.add(L);
    }

    public Licence dernierLicence() {
        return licences.get(licences.size() - 1);

    }

}
