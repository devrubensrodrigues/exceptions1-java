package model.entities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    public Reservation() {

    }
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }
    @Override
    public String toString() {
        return "Reservation: Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", " + duration()
                + " nights";
    }
    public long duration() {
        long duration = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkIn, Date checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
    }
}
