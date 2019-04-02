package vue;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * La vue du menu.
 */
public class MenuVue extends JPanel {

    private String levels;
    private JList<String> list;

    /**
     * Créé une liste des niveaux qui sont dans le String passé en paramètre
     * @param levels Niveaux présent dans le fichier des Niveaux
     */
    public MenuVue(String levels) {
        this.levels = levels;
        Matcher m = Pattern.compile(";(.*)\n").matcher(levels);
        List<String> matches = new ArrayList<>();
        while (m.find()) {
            matches.add(m.group(1));
        }
        list = new JList<String>(matches.toArray(new String[0]));

        this.add(list);
    }

    /**
     * Retourne la liste des numéros et les Noms de Niveaux
     * @return la liste des numéros et nom de niveau
     */
    public JList<String> getList() {
        return list;
    }
}
