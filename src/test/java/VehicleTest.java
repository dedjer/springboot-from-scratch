import com.company.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle v;

    @Before
    public void setup(){
        v = new Vehicle();
    }

    @Test
    public void GetMakeWorks(){
        v.setMake("Nissan");
        assertEquals("Nissan", v.getMake());
    }
}
