package vue;

import modele.Modele;
import utulities.LevelMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

    MenuVue menuVue;
    GameVue gameVue;
    String levels;

    public GUI(String levels) throws HeadlessException {
        super("Sokoban");
        this.levels = levels;
        menuVue = new MenuVue(levels);
        menuVue.getList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println();
                gameVue = new GameVue(new Modele(
                        LevelMaker.setLevel(
                                levels,
                                menuVue.getList().locationToIndex(e.getPoint()) + 1)
                ));
                remove(menuVue);
                add(gameVue);
                gameVue.requestFocus();
                pack();
            }
        });

        add(menuVue);
        pack();
        setVisible(true);
    }
}
