package Controller;

import Model.*;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
@RequestMapping("/api")
public class RequestController {
//this class has all request that can be done over the application or browser
//i use ik = identification key instead of id, they serve the same purpose
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
    JSONObject allTrips(@PathVariable int userIK) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.viewTripByUser(userIK);
    }

    //get a trip by its id
    @GetMapping("/trips/{ik}")
    JSONObject singleTrip(@PathVariable int ik) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.viewTrip(ik);
    }

    //create a new trip
    @PostMapping("/trips/new/{userIK}")
    JSONObject newTrip(@RequestBody JSONObject newTrip, @PathVariable int userIK) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.bookTrip(newTrip,userIK);
    }

    //reschedule trip by its id
    @PostMapping("/trips/reschedule/{ik}")
    JSONObject rescheduleTrip(@RequestBody JSONObject trip, @PathVariable int ik) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.rescheduleTrip(trip,ik);
    }

    //delete a trip using its id
    @DeleteMapping("/trips/{ik}")
    JSONObject cancelTrip(@PathVariable int ik) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.cancelTrip(ik);
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
        return iUserAuth.Verify(token);
    }
//user Authorization section ends
}