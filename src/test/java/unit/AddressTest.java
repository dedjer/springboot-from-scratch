package unit;

import com.company.model.Address;
import org.junit.Test;
import org.meanbean.test.BeanTester;

public class AddressTest {

    // MeanBean POJO Tester
    // https://www.javacodegeeks.com/2014/09/tips-for-unit-testing-javabeans.html
    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Address.class);
    }

}
