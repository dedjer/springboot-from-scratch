package unit;

import com.company.model.Address;
import com.company.model.Customer;
import com.company.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import java.util.*;

import static org.junit.Assert.assertEquals;

//Test classes must end with the name "Test" or "Tests" to ensure maven picks them up
//I renamed classes to see if mvn would still pick the mun
public class CustomerTest {
    private Customer customer;
    private List<Address> addresses;
    private Set<Vehicle> vehicles;

    @Before
    public void setup(){
        customer = new Customer();
        addresses = customer.getAddresses();
        vehicles = customer.getVehicles();
    }

    // MeanBean POJO Tester
    // https://www.javacodegeeks.com/2014/09/tips-for-unit-testing-javabeans.html
    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Customer.class);
    }

    @Test
    public void getAddressesWorks(){
        Address a = new Address();
        a.setStreet("Michigan Ave.");
        a.setCity("Chicago");
        a.setState("Illinois");
        a.setZipcode("60625");

        addresses.add(a);
        customer.setAddresses(addresses);

        assertEquals(a, customer.getAddresses().get(0));
    }

    @Test
    public void getVehiclesWorks(){
        Vehicle v = new Vehicle();
        v.setId(1);
        v.setMake("Hummer");

        vehicles.add(v);
        customer.setVehicles(vehicles);

        Vehicle result = customer.getVehicles().stream().findFirst().get();

        assertEquals(v, result);
    }
}
