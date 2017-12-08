package controller;

import model.train.ComfortLevel;
import model.train.Engine;
import model.train.RailwayStation;
import model.train.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class ProjectData implements java.io.Serializable {

    private static final long serialVersionUID = -3056760678953206590L;
    private List<Train> trains;
    private List<Passenger> passengers;

    private ProjectData() {
        trains = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    // save
    public static void main(String[] args) {
        DataController controller = new DataController();
        ProjectData projectData = new ProjectData();
        projectData.initTrains();
        projectData.initPassengers();
        controller.save(projectData, ControllerConst.filepath);
    }

    static void init(RailwayStation railway) {
        DataController controller = new DataController();
        ProjectData projectData = controller.load(ControllerConst.filepath);
        railway.setTrains(projectData.trains);
        List<Passenger> passengers = projectData.passengers;
        for (Passenger p : passengers) {
            int id = p.getTicket().getTrainID();
            if (id == 1) {
                railway.takeTrain(p, 0);
            } else {
                railway.takeTrain(p, 1);
            }
        }
    }

    private void initPassengers() {
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

        //tracks
        p1.setTicket(getTicket1(12,5));
        p2.setTicket(getTicket2(11,4));
        p3.setTicket(getTicket1(10,4));
        p4.setTicket(getTicket2(9,4));
        p5.setTicket(getTicket1(5,3));
        p6.setTicket(getTicket2(6,3));
        p7.setTicket(getTicket1(7,2));
        p8.setTicket(getTicket2(7,1));
        p9.setTicket(getTicket1(19,2));
        p10.setTicket(getTicket2(42,5));
        p11.setTicket(getTicket1(50,11));
        p12.setTicket(getTicket2(3,4));
        p13.setTicket(getTicket1(8,8));
        p14.setTicket(getTicket2(1,2));
        p15.setTicket(getTicket1(13,5));

        Item item = new Item("Food",1);
        Item item1 = new Item("Clothes", 2);
        Item item2 = new Item("Books",1);
        Item item3 = new Item("Other", 6);
        p1.add(item);
        p1.add(item3);
        p2.add(item);
        p3.add(item1);
        p4.add(item2);
        p4.add(item3);
        p5.add(item3);
        p6.add(item3);
        p6.add(item1);
        p7.add(item);
        p8.add(item);
        p9.add(item1);
        p10.add(item2);
        p11.add(item);
        p11.add(item2);
        p11.add(item2);
        p12.add(item3);
        p12.add(item1);
        p13.add(item2);
        p13.add(item3);
        p14.add(item2);
        p14.add(item);
        p14.add(item3);
        p14.add(item1);

        passengers.add(p1);
        passengers.add(p2);
        passengers.add(p3);
        passengers.add(p4);
        passengers.add(p5);
        passengers.add(p6);
        passengers.add(p7);
        passengers.add(p8);
        passengers.add(p9);
        passengers.add(p10);
        passengers.add(p11);
        passengers.add(p12);
        passengers.add(p13);
        passengers.add(p14);
        passengers.add(p15);
    }

    private void initTrains() {
        RailTransport head;
        RailTransport tail;
        List<RailTransport> waggons = new ArrayList<>();

        // train 1
        head = getLocomotive(1,140, Engine.ELECTRIC_MOTOR);
        tail = getLocomotive(2, 120, Engine.DIESEL);
        for (int i = 0; i < 8; i++) {
            waggons.add(getWaggonEconomy());
        }
        for (int i = 0; i < 6; i++) {
            waggons.add(getWaggonCoupe());
        }
        for (int i = 0; i < 4; i++) {
            waggons.add(getWaggonLuxe());
        }
        waggons.add(getWaggonVip());
        Train train1 = new Train(head, tail, waggons);
        trains.add(train1);

        //train 2
        waggons = new ArrayList<>();
        head = getLocomotive(1,160, Engine.PETROL);
        for (int i = 0; i < 5; i++) {
            waggons.add(getWaggonEconomy());
        }
        for (int i = 0; i < 10; i++) {
            waggons.add(getWaggonCoupe());
        }
        for (int i = 0; i < 2; i++) {
            waggons.add(getWaggonLuxe());
        }
        Train train2 = new Train(head, waggons);
        trains.add(train2);
    }

    private static Locomotive getLocomotive(int id, int speed, Engine engine) {
        return new Locomotive(id, 50, 30, "EL",
                            LocalDate.of(1996, 5, 30), "green",
                            speed, engine);
    }

    private static PassengerWaggon getWaggonEconomy() {
        return new PassengerWaggon(3, 70, 30, "WG",
                LocalDate.of(1996, 5, 30), "red",
                52, ComfortLevel.ECONOMY);
    }

    private static PassengerWaggon getWaggonCoupe() {
        return new PassengerWaggon(4, 70, 30, "WG",
                LocalDate.of(1996, 5, 30), "green",
                42, ComfortLevel.COUPE);
    }

    private static PassengerWaggon getWaggonLuxe() {
        return new PassengerWaggon(5, 70, 30, "WG",
                LocalDate.of(1996, 5, 30), "grey",
                30, ComfortLevel.LUXE);
    }

    private static PassengerWaggon getWaggonVip() {
        return new PassengerWaggon(6, 70, 30, "WG",
                LocalDate.of(2016, 5, 30), "blue",
                24, ComfortLevel.VIP);
    }

    private static Ticket getTicket1(int p, int w) {
        return Ticket.newTicket().from("Kiev").to("Odessa")
                .dateArrive(LocalDateTime.of(2017,12,
                        10, 18, 10))
                .dateDeparture(LocalDateTime.of(2017, 12, 11,
                        8,27))
                .train("KIEV_PASS").trainID(1)
                .waggon("WGG").waggonNumber(w)
                .place(p).build();
    }

    private static Ticket getTicket2(int p, int w) {
        return Ticket.newTicket().from("Lviv").to("Charkiv")
                .dateArrive(LocalDateTime.of(2017,12,
                        11, 15, 0))
                .dateDeparture(LocalDateTime.of(2017, 12, 12,
                        5,34))
                .train("LVIV_PASS").trainID(2)
                .waggon("WG").waggonNumber(w)
                .place(p).build();
    }



}
