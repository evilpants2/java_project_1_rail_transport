package controller;

import static view.CommandsRegexp.*;
import static view.Multilingual.rs;

import model.RailwayStation;
import model.SuchTrainNotExist;
import model.Trains;
import model.Tuple;
import model.entity.PassengerWaggon;
import model.entity.Train;
import view.CommandsRegexp;
import view.View;
import view.ViewText;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MenuController {
    private final RailwayStation railway;
    private final View view;
    private final Scanner scanner;
    private UserData userData;

    MenuController(RailwayStation railway, View view,
                   Scanner scanner) {
        this.railway = railway;
        this.view = view;
        this.scanner = scanner;
        this.userData = UserData.getInstances();
    }

    void execute() {
        while (true) {
            String input = scanner.nextLine().replaceAll("\\s+", " ").trim();
            switch (input) {
                case CMD_HELP:
                    showHelp();
                    break;
                case CMD_SHOW:
                    show();
                    break;
                case CMD_SELECTED:
                    showSelected();
                    break;
                case CMD_SORT:
                    sort();
                    break;
                case CMD_COUNT:
                    count();
                    break;
                case CMD_QUIT:
                    return;
                default:
                    if (input.matches(CommandsRegexp.SELECT_REGEX)) {
                        select(input);
                    } else if (input.matches(CommandsRegexp.SHOW_TRAIN_REGEX)) {
                        showSelected(input);
                    } else if (input.matches(CommandsRegexp.COUNT_IN_RANGE_REGEX)) {
                        inRange(input);
                    } else if (input.equals(" ") || input.isEmpty()) {
                        break;
                    } else {
                        view.println(rs().getString("incorrect"));
                    }
            }
        }
    }

    private void count() {
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            Tuple<Integer, Integer> result = Trains.count(t);
            view.println(rs().getString("quantity_passengers") + result.getX());
            view.println(rs().getString("quantity_baggages") + result.getY());
        } else {
            view.println(rs().getString("not_selected"));
        }
    }

    private void checkIndex(int i) {
        if(i < -1 || i >= railway.numberOfTrains()) {
            throw new SuchTrainNotExist(rs().getString("incorrect_track"), i);
        }
    }

    private String findNumber(String input) {
        Pattern p = Pattern.compile("-?\\d+");
        StringBuilder b = new StringBuilder();
        Matcher m = p.matcher(input);
        while (m.find()) {
            b.append(m.group()).append(",");
        }
        return b.substring(0, b.length() - 1);
    }

    private void inRange(String input) {
        String args[] = findNumber(input).split(",");
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            int left = Integer.parseInt(args[0]);
            int right = Integer.parseInt(args[1]);
            view.printCollection(Trains.diapason(t, left, right));
        } else {
            view.println(rs().getString("not_selected"));
        }
    }

    private void select(String i) {
        int index = Integer.parseInt((i.split("\\s"))[1]);
        try {
            checkIndex(index);
        } catch (SuchTrainNotExist e){
            view.printerr(e.getMessage() + " " + e.getIndex());
            return;
        }
        userData.setCurrentTrain(railway.getTrain(index));
        view.println(rs().getString("selected"));
    }

    private void showHelp() {
        view.println(rs().getString("commands"));
    }


    private void show() {
        for (int i = 0; i < railway.numberOfTrains(); i++) {
            view.println(rs().getString("track") + i + ": ");
            view.println(railway.getTrain(i).toString());
            view.println(ViewText.TRAIN_SEPARATOR);
        }
    }

    private void showSelected() {
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            view.println(t.toString());
            for (int i = 0; i < t.getWaggons().size(); i++) {
                view.println( t.getWaggons().get(i).toString());
            }
        } else {
            view.println(rs().getString("not_selected"));
        }
    }

    private void showSelected(String i) {
        int index = Integer.parseInt((i.split("\\s"))[2]);
        try {
            checkIndex(index);
        } catch (SuchTrainNotExist e){
            view.printerr(e.getMessage() + " " + e.getIndex());
            return;
        }
        view.println(railway.getTrain(index).toString());
    }

    private void sort() {
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            Trains.sort(t, PassengerWaggon.comfortComparator());
            view.println(rs().getString("sort"));
        } else {
            view.println(rs().getString("not_selected"));
        }
    }
}
