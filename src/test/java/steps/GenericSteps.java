package steps;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import utils.RestUtils;

public class GenericSteps {
    @Entao("valido que recebo o status {int} no response")
    public void validoQueReceboOStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().getStatusCode());
    }

}
