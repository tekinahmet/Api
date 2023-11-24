package youtube_pojos;

public class Bookingid {
    /*
    {
    "bookingid": 919,
    "booking": {
        "firstname": "John",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        }
    }
}
     */

    private int bookingid;
    private Booking booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Bookingid() {
    }

    public Bookingid(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Bookingid{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
