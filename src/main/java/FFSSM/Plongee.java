/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.ArrayList;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;

    public ArrayList<Plongeur> Plongeurs = new ArrayList<Plongeur>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        Plongeurs.add(participant);

    }

    public Calendar getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        int a = 0;
        for (Plongeur P : Plongeurs) {
            boolean b = P.dernierLicence().estValide(date);
            if (b == false) {
                a = a + 1;
            }
        }
        if (a == 0) {
            return true;
        } else {
            return false;
        }
    }
}
