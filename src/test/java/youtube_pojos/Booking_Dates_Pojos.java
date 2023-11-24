package youtube_pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking_Dates_Pojos {
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
    private String checkin;
    private String checkout;

//    public String getCheckin() {
//        return checkin;
//    }
//
//    public void setCheckin(String checkin) {
//        this.checkin = checkin;
//    }
//
//    public String getCheckout() {
//        return checkout;
//    }
//
//    public void setCheckout(String checkout) {
//        this.checkout = checkout;
//    }
//
//    public Booking_Dates_Pojos() {
//    }
//
//    public Booking_Dates_Pojos(String checkin, String checkout) {
//        this.checkin = checkin;
//        this.checkout = checkout;
//    }
//
//    @Override
//    public String toString() {
//        return "Booking_Dates_Pojos{" +
//                "checkin='" + checkin + '\'' +
//                ", checkout='" + checkout + '\'' +
//                '}';
//    }
}
