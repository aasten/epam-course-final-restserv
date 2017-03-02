package by.ishop;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import by.ishop.data.DataAccess;
import by.ishop.data.product.ProductEntry;
import by.ishop.data.TestFactory;

@Path("/")
public class RESTMain {


    @GET
    @Path("entry/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ProductEntry getEntry(@PathParam("id") String id) {

        try {
            Integer numId = Integer.parseInt(id);
            if(numId < 0) throw new NumberFormatException("Product id cannot be negative");
            return DataAccess.INSTANCE.getEntryDAO().getById(numId);
//            return TestFactory.createTestEntry(id);
        } catch(NumberFormatException e) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(
                    e.getMessage()).build());
        } catch(RuntimeException e) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(
                    "Product " + id + " not found").build());
        }
    }

}