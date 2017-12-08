package controller;

import static view.Multilingual.rs;

import model.train.RailwayStation;
import model.train.Trains;
import model.train.entity.PassengerWaggon;
import model.train.entity.Train;
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
        selectLanguage();

        Train train = railway.getTrain(0);
        // tasks
        Trains.sort(train, PassengerWaggon.comfortComparator());
        view.printCollection(train.getWaggons());
        view.println("================================================");
        view.println("Number of passengers: " + Trains.countPassengers(train));
        view.println("================================================");
        view.printCollection(Trains.diapason(train, 3, 5));


    }

    private void selectLanguage() {
        String input;
        while ( (sc.hasNextLine() && (input = sc.nextLine())
                .matches(Regexp.SELECT_LANGUAGE_REGEXP))) {
            view.println(ViewText.SELECT_LANGUAGE);
            switch (input) {
                case "-ua":
                    multilingual.switchLanguage(Multilingual.Language.UA);
                    return;
                case "-eng":
                    multilingual.switchLanguage(Multilingual.Language.ENG);
                    return;
                default:
                    view.printerr(rs().getString("incorrect"));
            }
        }
    }
}
