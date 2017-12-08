package controller;

import static view.Multilingual.rs;

import model.train.RailwayStation;
import view.Multilingual;
import view.Regexp;
import view.View;
import view.ViewText;

import java.util.Scanner;

public class Controller {
    private final RailwayStation railway;
    private final View view;
    private final Multilingual multilingual;
    private Scanner sc;

    public Controller(RailwayStation railway, View view) {
        this.railway = railway;
        this.view = view;
        multilingual = Multilingual.getInstances();
    }

    public void userProcess() {
        ProjectData.init(railway);
        sc = new Scanner(System.in);
        final MenuController menu = new MenuController(railway, view, sc);
        view.println(ViewText.SELECT_LANGUAGE);
        selectLanguage();
        view.println(rs().getString("help_msg"));
        menu.execute();
    }

    private void selectLanguage() {
        while (true) {
            String input = sc.nextLine();
            switch (input) {
                case "-ua":
                    multilingual.switchLanguage(Multilingual.Language.UA);
                    return;
                case "-eng":
                    multilingual.switchLanguage(Multilingual.Language.ENG);
                    return;
                default:
                    view.printerr(rs().getString("incorrect"));
                    view.println(ViewText.SELECT_LANGUAGE);
            }
        }
    }
}
