package controller;

import static view.CommandsRegexp.ENG;
import static view.CommandsRegexp.UA;
import static view.Multilingual.rs;

import model.RailwayStation;
import view.Multilingual;
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
        Database.init(railway);
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
            input = input.trim().replaceAll("\\s+", " ");
            switch (input) {
                case UA:
                    multilingual.switchLanguage(Multilingual.Language.UA);
                    return;
                case ENG:
                    multilingual.switchLanguage(Multilingual.Language.ENG);
                    return;
                default:
                    if(input.equals(" ") || input.isEmpty()) {
                        break;
                    }
                    view.println(rs().getString("incorrect"));
                    view.println(ViewText.SELECT_LANGUAGE);
            }
        }
    }
}
