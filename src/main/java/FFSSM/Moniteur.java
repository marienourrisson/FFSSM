/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;


public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public String grade;
    public List<Embauche> emploies = new ArrayList<Embauche>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, int numeroDiplome, String grade) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
        this.grade = grade;
        this.emploies = new ArrayList();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur, ou null
     */
    public Club employeurActuel() {
        return emploies.get(emploies.size()-1).getEmployeur();  
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
          emploies.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return emploies;
    }

}
