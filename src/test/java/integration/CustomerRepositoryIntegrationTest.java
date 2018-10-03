package integration;

import com.company.Main;
import com.company.model.Address;
import com.company.model.Customer;
import com.company.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class, CustomerRepository.class})
@ContextConfiguration(classes = CustomerRepository.class) // Fixes no bean error on customerRepository
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CustomerRepositoryIntegrationTest{
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindByNameContainingThenReturnCustomer() throws Exception{
        // given
        Customer c = new Customer();
        c.setName("Michael Schaefer");
        customerRepository.save(c);

        // when
        Customer result = customerRepository.findByNameContaining(c.getName()).stream().findFirst().get();

        // then
        assertEquals(c, result);
    }

    @Test
    public void whenFindByAddressesStateEqualsThenReturnCustomers() throws Exception{
        // given 2 customers residing in the same State

        final String state = "MyTestState";

        Customer c1 = new Customer();
        c1.setName("Michael");

        Address a1 = new Address();
        a1.setStreet("1 My Test Street");
        a1.setCity("MyTestCity");
        a1.setState(state);
        a1.setZipcode("00000");

        c1.addAddress(a1);
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setName("Steve");

        Address a2 = new Address();
        a2.setStreet("2 My Test Street");
        a2.setCity("MyTestCity");
        a2.setState(state);
        a2.setZipcode("00000");

        c2.addAddress(a2);
        customerRepository.save(c2);

        // when
        List<Customer> result = customerRepository.findByAddressesStateEquals(state);

        // then
        assertEquals(2, result.size());
    }

    @Test
    public void whenFindByAddressesCityEqualsThenReturnCustomers() throws Exception {
        // given 2 customers residing in the same State

        final String city = "MyTestCity";

        Customer c1 = new Customer();
        c1.setName("Michael");

        Address a1 = new Address();
        a1.setStreet("1 My Test Street");
        a1.setCity(city);
        a1.setState("MyTestState");
        a1.setZipcode("00000");

        c1.addAddress(a1);
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setName("Steve");

        Address a2 = new Address();
        a2.setStreet("2 My Test Street");
        a2.setCity(city);
        a2.setState("MyTestState");
        a2.setZipcode("00000");

        c2.addAddress(a2);
        customerRepository.save(c2);

        // when
        List<Customer> result = customerRepository.findByAddressesCityEquals(city);

        // then
        assertEquals(2, result.size());

    }

    @Test
    public void whenQueryByNameReturnsCustomer() throws Exception {
        // given
        Customer c = new Customer();
        c.setName("Steve Fraser");
        customerRepository.save(c);

        // when
        Customer result = customerRepository.queryByName(c.getName()).stream().findFirst().get();

        // then
        assertEquals(c, result);
    }
}
