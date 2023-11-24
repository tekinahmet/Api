package youtube_pojos;

public class Booking {
    /*
{
"firstname": "Josh",
"lastname": "Allen",
"totalprice": 111,
"depositpaid": true,
"bookingdates": {
    "checkin": "2018-01-01",
    "checkout": "2019-01-01"
},
"additionalneeds": "midnight snack"
}
     */
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Booking_Dates_Pojos bookingdates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Booking_Dates_Pojos getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Booking_Dates_Pojos bookingdates) {
        this.bookingdates = bookingdates;
    }

    public Booking() {
    }

    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, Booking_Dates_Pojos bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
