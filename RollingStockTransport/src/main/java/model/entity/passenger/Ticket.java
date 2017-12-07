package main.java.model.entity.passenger;

import java.time.LocalDate;

public class Ticket {
    private final String from;
    private final String to;
    private final LocalDate dateArrive;
    private final LocalDate dateDeparture;
    private final String train;
    private final String waggon;
    private final String place;

    public Ticket(String from, String to, LocalDate dateArrive,
                  LocalDate dateDeparture, String train,
                  String waggon, String place) {
        this.from = from;
        this.to = to;
        this.dateArrive = dateArrive;
        this.dateDeparture = dateDeparture;
        this.train = train;
        this.waggon = waggon;
        this.place = place;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDate getDateArrive() {
        return dateArrive;
    }

    public LocalDate getDateDeparture() {
        return dateDeparture;
    }

    public String getTrain() {
        return train;
    }

    public String getWaggon() {
        return waggon;
    }

    public String getPlace() {
        return place;
    }

    public static class Builder {
        private String from;
        private String to;
        private LocalDate dateArrive;
        private LocalDate dateDeparture;
        private String train;
        private String waggon;
        private String place;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder dateArrive(LocalDate date) {
            this.dateArrive = date;
            return this;
        }

        public Builder dateDeparture(LocalDate date) {
            this.dateDeparture = date;
            return this;
        }

        public Builder train(String train) {
            this.train = train;
            return this;
        }

        public Builder waggon(String waggon) {
            this.waggon = waggon;
            return this;
        }

        public Builder place(String place) {
            this.place = place;
            return this;
        }

        public Ticket build() {
            return new Ticket(
                    from, to, dateArrive,
                    dateDeparture, train,
                    waggon, place
            );
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
