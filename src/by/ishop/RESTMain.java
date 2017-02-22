package by.ishop;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import by.ishop.data.product.ObjectFactory;

@Path("/")
public class RESTMain {


    @GET
    @Path("entry/{id}")
    @Produces("application/json")
    public Response getEntry(@PathParam("id") String id) {
        try {
            return Response.status(200).entity(ObjectFactory.createProductEntry()).build();
        } catch(RuntimeException e) {
            return Response.status(404).entity("Entry with id " + id + " is not found").build();
        }
    }

}