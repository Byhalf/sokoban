/**
 * L'interface ModeleEcouteur permet à une instance l'implémantant
 * de se faire écouter par un écouteurs
 */

package utulities;

public interface ModeleEcouteur {

    /**
     * permet d'ajouté un écouteur
     * @param e instance d'un objet implémentant EcouteurModele
     */
    void ajoutEcouteur(utulities.EcouteurModele e);

    /**
     * Permet de rettirer un écouteur
     * @param e
     */
    void retraitEcouteur(utulities.EcouteurModele e);


}
