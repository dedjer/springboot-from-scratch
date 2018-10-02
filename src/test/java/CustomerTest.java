import com.company.model.Address;
import com.company.model.Customer;
import com.company.model.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//Test classes must end with the name "Test" or "Tests" to ensure maven picks them up
//I renamed classes to see if mvn would still pick the mun
public class CustomerTest {
    private Customer c;

    @Before
    public void setup(){
        c = new Customer();
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
}
