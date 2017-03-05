package by.ishop;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import by.ishop.data.DataAccess;
import by.ishop.data.product.ProductEntry;

import java.util.List;

@Path("/")
public class RESTMain {

    // default query parameters
    private static final String DEFAULT_START_LIST_FROM = "1";
    private static final String DEFAULT_LIST_SIZE = "4";


    @GET
    @Path("entry/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ProductEntry getEntry(@PathParam("id") String id) {

        try {
            Integer numId = Integer.parseInt(id);
            if(numId < 0) throw new NumberFormatException("Product id cannot be negative");
            return DataAccess.INSTANCE.getEntryDAO().getById(numId);
        } catch(NumberFormatException e) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(
                    e.getMessage()).build());
        } catch(RuntimeException e) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(
                    e.getMessage()).build());
        }
    }

    // TODO move to a separate class
    @GET
    @Path("entries/")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProductEntry> getEntries(@DefaultValue(DEFAULT_START_LIST_FROM)@QueryParam("from") String from,
                                         @DefaultValue(DEFAULT_LIST_SIZE)@QueryParam("count") String count) {

        try {
            Integer fromId = Integer.parseInt(from);
            if(fromId < 0) throw new NumberFormatException("Product id cannot be negative");
            Integer countInt = Integer.parseInt(count);
            if(countInt < 1) throw new NumberFormatException("Count of products must be a natural number");
            return DataAccess.INSTANCE.getAllEntriesListDAO().getNStartFromId(fromId, countInt);
        } catch(NumberFormatException e) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(
                    e.getMessage()).build());
        } catch(RuntimeException e) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(
                    e.getMessage()).build());
        }
    }


}