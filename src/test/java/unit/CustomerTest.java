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
    private Customer c;
    private Set<Vehicle> vehicles;

    @Before
    public void setup(){
        c = new Customer();
        vehicles = c.getVehicles();
    }

    // MeanBean POJO Tester
    // https://www.javacodegeeks.com/2014/09/tips-for-unit-testing-javabeans.html
    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Customer.class);
    }

    @Test
    public void GetAddressesWorks(){
        List<Address> addresses = new ArrayList<>();

        Address a = new Address();
        a.setStreet("Michigan Ave.");
        a.setCity("Chicago");
        a.setState("Illinois");
        a.setZipcode("60625");

        addresses.add(a);
        c.setAddresses(addresses);

        assertEquals(a, c.getAddresses().get(0));
    }

    @Test
    public void GetVehiclesWorks(){
        Vehicle v = new Vehicle();
        v.setId(1);
        v.setMake("Hummer");

        vehicles.add(v);
        c.setVehicles(vehicles);

        Vehicle result = c.getVehicles().stream().findFirst().get();

        assertEquals(v, result);
    }
}
