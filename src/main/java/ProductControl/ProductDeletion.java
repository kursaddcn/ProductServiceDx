package ProductControl;
import Messages.Messages;
import ProductEntity.ProductEntity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.bson.types.ObjectId;

/*
   -Product Delete operations, takes is as parameter and applys soft-delete with added extra isDeleted flag.
   -Endpoints accepts and returns only JSON.
   -Users can reach these enpdoints with Basic Auth.
*/


@Path("/deleteProduct")
@RolesAllowed("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductDeletion {
    //Soft-delete
    @PUT
    @Path("/softDelete/{id}")
    public void update(String id) {
        ProductEntity.update("isDeleted", true).where("_id", new ObjectId(id));
    }
    //Hard-delete
    @DELETE
    @Path("/hardDelete/{id}")
    public Object delete(String id) throws Exception {

        ObjectId productID = new ObjectId(id);
        ProductEntity productEntity = ProductEntity.findById(productID);
        if (productEntity == null){
            return new Messages().ElementNotFound;
        }else if (!productEntity.isDeleted) {
            return new Messages().DeletionOrderWarning;
        }
        try{
            productEntity.delete();
        }catch (Exception e){
            return new Exception(e);
        }
        return new Messages().ProductSuccessfullyHardDeleted;
    }

}

