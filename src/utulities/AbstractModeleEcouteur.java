package utulities;

import java.util.ArrayList;

abstract public class AbstractModeleEcouteur implements ModeleEcouteur {

    private ArrayList<EcouteurModele> ecouteurModeles = new ArrayList<>();

    @Override
    public void ajoutEcouteur(EcouteurModele e) {
        ecouteurModeles.add(e);
    }

    @Override
    public void retraitEcouteur(EcouteurModele e) {
        ecouteurModeles.remove(e);
    }

    protected void fireChangement() {
        for (EcouteurModele e : ecouteurModeles) {
            e.modeleMisAJour(this);
        }
    }
}