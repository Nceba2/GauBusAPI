package Controller;

import Model.*;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RequestController {
//this class has all request that can be done over the application or browser
//this comments will split the class into sections, guiding you which request belongs where

    @GetMapping("/")
    String home() {
        return "welcome to GauBus API";
    }

//Bus Stop section
    @GetMapping("/BusStops/all")
    JSONObject allBusStops() {
        BusStop_interface iBusStop = new BusStop();
        return iBusStop.allBusStops();
    }
//Bus Stop section ends


//Trips Section
    //all trips for user id key
    @GetMapping("/trips/all/{userIk}")
    String allTrips() {
        return "";
    }

    //get a trip by its id
    @GetMapping("/trips/{id}")
    String singleTrip(@PathVariable Long id) {
        return "";
    }

    //create a new trip
    @PostMapping("/trips/new/{userIK}")
    String newTrip(@RequestBody JSONObject newTrip, @PathVariable Long Ik) {
        return "new trip created";
    }

    //reschedule trip by its id
    @PostMapping("/trips/reschedule/{id}")
    String rescheduleTrip(@RequestBody JSONObject Trip, @PathVariable Long id) {
        return "trip rescheduled";
    }
    //delete a trip using its id
    @DeleteMapping("/trips/{id}")
    String cancelTrip(@PathVariable Long id) {
        return "trip deleted";
    }
//Trip section ends

//user Authorization section
    //register user
    @PostMapping("/Auth/register/")
    JSONObject register(@RequestBody JSONObject newUser) {
        UserAuth_interface iUserAuth = new UserAuth();
        return iUserAuth.Register(newUser);
    }

    //login user
    @PostMapping("/Auth/login/")
    JSONObject login(@RequestBody JSONObject user) {
        UserAuth_interface iUserAuth = new UserAuth();
        return iUserAuth.Login(user);
    }

    //verify user
    @PostMapping("/Auth/verify/")
    JSONObject verify(@RequestBody JSONObject token) {
        UserAuth_interface iUserAuth = new UserAuth();
        return iUserAuth.Register(token);
    }
//user Authorization section ends
}