package model.train.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ticket implements java.io.Serializable {
    private static final long serialVersionUID = -3056760678953206590L;

    private final String from;
    private final String to;
    private final LocalDateTime dateArrive;
    private final LocalDateTime dateDeparture;
    private final String waggon;
    private final String train;
    private final int trainID;
    private final int waggonNumber;
    private final int place;

    private Ticket(String from, String to, LocalDateTime dateArrive,
           LocalDateTime dateDeparture, String waggon, String train,
                   int trainID, int waggonNumber, int place) {
        this.from = from;
        this.to = to;
        this.dateArrive = dateArrive;
        this.dateDeparture = dateDeparture;
        this.train = train;
        this.waggon = waggon;
        this.trainID = trainID;
        this.waggonNumber = waggonNumber;
        this.place = place;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getDateArrive() {
        return dateArrive;
    }

    public LocalDateTime getDateDeparture() {
        return dateDeparture;
    }

    public int getTrainID() {
        return trainID;
    }

    public String getTrain() {
        return train;
    }

    public String getWaggon() {
        return waggon;
    }

    public int getWaggonNumber() {
        return waggonNumber;
    }

    public int getPlace() {
        return place;
    }

    public static Builder newTicket() {
        return new Builder();
    }

    public static class Builder {
        private String from;
        private String to;
        private LocalDateTime dateArrive;
        private LocalDateTime dateDeparture;
        private String train;
        private String waggon;
        private int trainID;
        private int waggonNumber;
        private int place;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder dateArrive(LocalDateTime date) {
            this.dateArrive = date;
            return this;
        }

        public Builder dateDeparture(LocalDateTime date) {
            this.dateDeparture = date;
            return this;
        }

        public Builder train(String train) {
            this.train = train;
            return this;
        }

        public Builder trainID(int trainID) {
            this.trainID = trainID;
            return this;
        }

        public Builder waggon(String waggon) {
            this.waggon = waggon;
            return this;
        }

        public Builder waggonNumber(int waggonNumber) {
            this.waggonNumber = waggonNumber;
            return this;
        }

        public Builder place(int place) {
            this.place = place;
            return this;
        }

        public Ticket build() {
            return new Ticket(
                    from, to, dateArrive,
                    dateDeparture, waggon,
                    train, trainID,
                    waggonNumber, place
            );
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
