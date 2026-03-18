import base.BaseTest;
import org.testng.annotations.Test;

public class Checkboxes extends BaseTest {
    final String CHECKBOX_ENDPOINT = "/checkboxes";

    @Test
    public void openCheckboxPage(){
        navigate(CHECKBOX_ENDPOINT);

    }
}
