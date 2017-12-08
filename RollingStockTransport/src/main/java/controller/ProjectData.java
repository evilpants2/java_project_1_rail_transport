package controller;

import model.train.ComfortLevel;
import model.train.Engine;
import model.train.RailwayStation;
import model.train.entity.*;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProjectData {

    private static PassengerWaggon getWaggon(int id, ComfortLevel comfort) {
        return new PassengerWaggon(id, 70, 30, "WG",
                    LocalDate.of(1996, 5, 30), "blue",
                    42, comfort);
    }

    private static Ticket getTicket(int p, int w) {
        return Ticket.newTicket().from("Kiev").to("Odessa")
                .dateArrive(LocalDateTime.of(2017,12,
                        10, 18, 10))
                .dateDeparture(LocalDateTime.of(2017, 12, 11,
                        8,27))
                .train("KIEV_PASS").trainID(0)
                .waggon("WGG").waggonNumber(w)
                .place(p).build();
    }

    public static void init(RailwayStation railway) {
        RailTransport head;
        RailTransport tail;
        List<RailTransport> waggons = new ArrayList<>();
        // initialize
        head = new Locomotive(1, 50, 30, "EL",
                            LocalDate.of(1996, 5, 30),
                            "red", 140, Engine.DIESEL);
        waggons.add(getWaggon(2, ComfortLevel.COUPE)); // 0
        waggons.add(getWaggon(3, ComfortLevel.ECONOMY)); // 1
        waggons.add(getWaggon(4,ComfortLevel.LUXE)); // 2
        waggons.add(getWaggon(5,ComfortLevel.BUSINESS)); // 3
        waggons.add(getWaggon(6,ComfortLevel.COUPE)); // 4
        waggons.add(getWaggon(7,ComfortLevel.LUXE)); //5
        waggons.add(getWaggon(8,ComfortLevel.BUSINESS)); // 6
        waggons.add(getWaggon(9,ComfortLevel.VIP)); // 7
        waggons.add(getWaggon(10,ComfortLevel.BUSINESS)); // 8
        waggons.add(getWaggon(11,ComfortLevel.LUXE)); // 9
        waggons.add(getWaggon(12,ComfortLevel.ECONOMY)); // 10
        waggons.add(getWaggon(13,ComfortLevel.VIP)); // 11
        waggons.add(getWaggon(14,ComfortLevel.COUPE)); // 12
        waggons.add(getWaggon(15,ComfortLevel.VIP)); // 13
        waggons.add(getWaggon(16,ComfortLevel.ECONOMY)); // 14
        tail = new Locomotive(2, 50, 30, "EL",
                LocalDate.of(1996, 5, 30),
                "green", 140, Engine.DIESEL);

        Passenger p1 = new Passenger("victor");
        Passenger p2 = new Passenger("alex");
        Passenger p3 = new Passenger("john");
        Passenger p4 = new Passenger("oleg");
        Passenger p5 = new Passenger("cris");
        Passenger p6 = new Passenger("mike");
        Passenger p7 = new Passenger("vlad");
        Passenger p8 = new Passenger("olya");
        Passenger p9 = new Passenger("victoria");
        Passenger p10 = new Passenger("nika");
        Passenger p11 = new Passenger("anton");
        Passenger p12 = new Passenger("ivan");
        Passenger p13 = new Passenger("lex");
        Passenger p14 = new Passenger("jordan");
        Passenger p15 = new Passenger("john");

        p1.setTicket(getTicket(12,5));
        p2.setTicket(getTicket(11,4)); //
        p3.setTicket(getTicket(10,4)); //
        p4.setTicket(getTicket(9,4)); //
        p5.setTicket(getTicket(5,3));
        p6.setTicket(getTicket(6,3));
        p7.setTicket(getTicket(7,2));
        p8.setTicket(getTicket(7,1));
        p9.setTicket(getTicket(19,2));
        p10.setTicket(getTicket(42,5));
        p11.setTicket(getTicket(50,11));
        p12.setTicket(getTicket(3,4)); //
        p13.setTicket(getTicket(8,8));
        p14.setTicket(getTicket(1,2));
        p15.setTicket(getTicket(13,5));

        railway.addTrain(new Train(head, tail, waggons));
        railway.takeTrain(p1, 0);
        railway.takeTrain(p2, 0);
        railway.takeTrain(p3, 0);
        railway.takeTrain(p4, 0);
        railway.takeTrain(p5, 0);
        railway.takeTrain(p6, 0);
        railway.takeTrain(p7, 0);
        railway.takeTrain(p8, 0);
        railway.takeTrain(p9, 0);
        railway.takeTrain(p10, 0);
        railway.takeTrain(p11, 0);
        railway.takeTrain(p12, 0);
        railway.takeTrain(p13, 0);
        railway.takeTrain(p14, 0);
        railway.takeTrain(p15, 0);
    }


}
