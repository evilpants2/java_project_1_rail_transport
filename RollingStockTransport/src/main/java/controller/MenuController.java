package controller;

import static view.Regexp.*;
import static view.Multilingual.rs;

import model.train.RailwayStation;
import model.train.SuchTrainNotExist;
import model.train.Trains;
import model.train.Tuple;
import model.train.entity.PassengerWaggon;
import model.train.entity.RailTransport;
import model.train.entity.Train;
import view.Regexp;
import view.View;
import view.ViewText;

import java.util.Scanner;

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
            String input = scanner.nextLine();
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
                    if (input.matches(Regexp.SELECT_REGEX)) {
                        select(input);
                    } else if (input.matches(Regexp.SHOW_TRAIN_REGEX)) {
                        showSelected(input);
                    } else if (input.matches(Regexp.COUNT_IN_RANGE_REGEX)) {
                        inRange(input);
                    } else {
                        view.printerr(rs().getString("incorrect"));
                    }
            }
        }
    }

    private void showHelp() {
        view.println(rs().getString("commands"));
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

    private void count() {
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            Tuple<Integer, Integer> result = Trains.countPassengers(t);
            view.println(rs().getString("quantity_passengers") + result.getX());
            view.println(rs().getString("quantity_baggages") + result.getY());
        } else {
            view.println(rs().getString("not_selected"));
        }
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

    private void showSelected() {
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            view.println(t.toString());
            for (RailTransport rt : t.getWaggons()) {
                view.println(rt.toString());
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

    private void checkIndex(int i) {
        if(i < -1 || i >= railway.numberOfTrains()) {
            throw new SuchTrainNotExist(rs().getString("incorrect_track"), i);
        }
    }

    private void inRange(String cmd) {
        cmd = cmd.substring(16, cmd.length()-1);
        String args[] = cmd.split(",");
        Train t;
        if ((t = userData.getCurrentTrain()) != null) {
            int left = Integer.parseInt(args[0]);
            int right = Integer.parseInt(args[1]);
            view.printCollection(Trains.diapason(t, left, right));
        } else {
            view.println(rs().getString("not_selected"));
        }
    }

    private void show() {
        for (int i = 0; i < railway.numberOfTrains(); i++) {
            view.println(rs().getString("track") + i + ": ");
            view.println(railway.getTrain(i).toString());
            view.println(ViewText.TRAIN_SEPARATOR);
        }
    }
}
