package by.ishop;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import by.ishop.data.product.ProductEntry;
import by.ishop.data.product.TestFactory;

@Path("/")
public class RESTMain {


    @GET
    @Path("entry/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ProductEntry getEntry(@PathParam("id") String id) {
        try {
            return TestFactory.createTestEntry(id);
        } catch(RuntimeException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}