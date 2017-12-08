package controller;

import model.train.RailwayStation;
import view.View;

import java.util.Scanner;

public class InputController {
    private RailwayStation railway;
    private View view;
    private Scanner sc;

    public InputController(RailwayStation railway, View view,
                           Scanner sc) {
        this.railway = railway;
        this.view = view;
        this.sc = sc;
    }
}
