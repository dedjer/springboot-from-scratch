package unit;

import com.company.model.Customer;
import com.company.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import java.util.Set;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle vehicle;
    private Set<Customer> customers;

    @Before
    public void setup(){
        vehicle = new Vehicle();
        customers = vehicle.getCustomers();
    }

    // MeanBean POJO Tester
    // https://www.javacodegeeks.com/2014/09/tips-for-unit-testing-javabeans.html
    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Vehicle.class);
    }

    @Test
    public void GetCustomersWorks(){
        Customer c = new Customer();
        c.setId(1);
        c.setName("Test Customer");

        customers.add(c);
        vehicle.setCustomer(c);

        Customer result = vehicle.getCustomers().stream().findFirst().get();

        assertEquals(c, result);
    }
}
