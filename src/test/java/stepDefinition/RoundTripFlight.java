package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.FlightBooking;
import pages.HomePage;
import resources.BaseClass;

public class RoundTripFlight extends BaseClass{
	RoundTripFlight rt;
	HomePage HP;
	FlightBooking FB;
	int count = 0;
	
	@Given("I setup browser and utilities")
	public void i_setup_browser_and_utilities(){
		rt = new RoundTripFlight();
		rt.BrowserSetup();
	}
	
	@Given("I navigate to flight booking page")
	public void i_navigate_to_flight_booking_page() {
		HP = new HomePage(rt.driver,rt.utils);
		HP.MakeMyTrip();
		HP.MakeMyTrip_checkSite(count++);
	}

	@And("I select round trip")
	public void i_select_round_trip() {
		HP.roundTrip();
	}

	@And("I select from city")
	public void i_select_from_city() {
		HP.fromCity();
	}

	@And("I select to city")
	public void i_select_to_city() {
		HP.toCity();
	}

	@And("I select departure date")
	public void i_select_departure_date() {
		HP.departureDate();
	}

	@And("I select return date")
	public void i_select_return_date() {
		HP.returnDate();
		
	}

	@And("I select travellers")
	public void i_select_travellers() {
		HP.travellers();
	}

	@And("I select type of passenger")
	public void i_select_type_of_passenger() {
		HP.passengerType();
	}

	@Then("I book my flight")
	public void i_book_my_flight() throws InterruptedException {
		FB = new FlightBooking(rt.driver,rt.utils);
		FB.flightPage_Validate(count++);
		rt.teardown();
	}
}
