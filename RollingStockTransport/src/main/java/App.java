package main.java;

import main.java.model.entity.rail.ComfortLevel;
import main.java.model.entity.rail.PassengerWaggon;
import main.java.model.entity.rail.RailTransport;
import main.java.model.Train;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(5 << 1);
        List<RailTransport> transports = new ArrayList<>();
/*        RailTransport locomotive  = Locomotive.newLocomotive()
                                .name("ВЛ80")
                                .color("Blue")
                                .description("Механическую часть, тяговые двигатели,\n" +
                                        "вспомогательные электромашины завод изготавливал сам.")
                                .weight(50)
                                .wheelDiameter(100)
                                .engine(Engine.DIESEL)
                                .speed(120).build();*/
        RailTransport waggon  = PassengerWaggon.newPassengerWaggon()
                                .name("ВЛ80")
                                .color("Blue")
                                .description("Механическую часть, тяговые двигатели,\n" +
                                        "вспомогательные электромашины завод изготавливал сам.")
                                .weight(50)
                                .wheelDiameter(100)
                                .comfort(ComfortLevel.BUSINESS)
                                .numberOfSeats(52).build();
        System.out.println(waggon.getIdentifierName());
        Train train = new Train(waggon, transports);

    }
}
