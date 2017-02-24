package by.ishop;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import by.ishop.data.product.ObjectFactory;
import by.ishop.data.product.ProductEntry;
import by.ishop.data.product.TestFactory;

@Path("/")
public class RESTMain {


    final String test = "{\"name\":\"Canon EOS 5D\",\"imgURL\":\"/img/canon.png\",\"price\":2000,\"characteristics\":[{\"propName\":\"prop name 1\",\"propValue\":\"prop value 1\"},{\"propName\":\"prop name 2\",\"propValue\":\"prop value 2\"}]}";

    @GET
    @Path("entry/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ProductEntry getEntry(@PathParam("id") String id) {
        try {
            return TestFactory.createTestEntry();
            //return Response.status(200).entity(Entest).build();
        } catch(RuntimeException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
            //return Response.status(404).entity("Entry with id " + id + " is not found").build();
        }
    }

}