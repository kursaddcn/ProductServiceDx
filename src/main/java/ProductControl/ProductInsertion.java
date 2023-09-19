package ProductControl;
import ProductEntity.ProductEntity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;

/*
    -New Product addition
 */
@Path("/addProduct")
@RolesAllowed("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductInsertion {
    @POST
    public Object addProduct(ProductEntity requestProduct) throws Exception {
        try{
            requestProduct.persist();
        }catch (Exception e){
            throw new Exception();
        }
        return Response.created(URI.create("/addProduct" + requestProduct.id)).build();
    }

}
