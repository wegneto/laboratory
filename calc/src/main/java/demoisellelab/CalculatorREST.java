package demoisellelab;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("calculator")
public class CalculatorREST {

	@POST
	@Path("sum")
	@Consumes("application/json")
    @Produces("text/plain")
	@ValidatePayload
	public Integer sum(Data data) {
        return data.a + data.b;
    }
 
    public static class Data {
 
    	@NotNull
        public Integer a;
 
    	@NotNull
        public Integer b;
    }
}