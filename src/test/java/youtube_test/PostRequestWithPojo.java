package youtube_test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import youtube_base_url_store.HerokuappBaseURL;
import youtube_pojos.Booking;
import youtube_pojos.Booking_Dates_Pojos;
import youtube_pojos.Bookingid;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequestWithPojo extends HerokuappBaseURL {
    /*
        {
        "firstname": "John",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
        }
     */
    @Test
    public void test(){
    specHerokuapp.pathParam("pp1", "booking");

        Booking_Dates_Pojos bookingDatesPojos = new Booking_Dates_Pojos("2018-01-01", "2019-01-01");
        System.out.println("bookingDatesPojos = " + bookingDatesPojos);

        Booking booking = new Booking("John", "Smith", 111, true,bookingDatesPojos);
        System.out.println("booking = " + booking);

        Response response = given(specHerokuapp).
                contentType(ContentType.JSON).
                when().
                body(booking).
                post("{pp1}");

        response.prettyPrint();

        Bookingid responseBody = response.as(Bookingid.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(booking.getFirstname(), responseBody.getBooking().getFirstname());
        assertEquals(booking.getLastname(), responseBody.getBooking().getLastname());
        assertEquals(booking.getTotalprice(), responseBody.getBooking().getTotalprice());
        assertEquals(booking.isDepositpaid(), responseBody.getBooking().isDepositpaid());
        assertEquals(booking.getBookingdates().getCheckin(), responseBody.getBooking().getBookingdates().getCheckin());
        assertEquals(booking.getBookingdates().getCheckout(), responseBody.getBooking().getBookingdates().getCheckout());

    }
}
