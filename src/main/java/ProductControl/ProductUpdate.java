package ProductControl;
import ProductEntity.ProductEntity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.bson.types.ObjectId;

import java.util.concurrent.atomic.AtomicInteger;

/*
   -Product Update operations.
   -Endpoints accepts and returns only JSON.
   -Users can reach these enpdoints with Basic Auth.
 */
@Path("/updateProduct")
@RolesAllowed("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductUpdate {
    //Update Name
    @PUT
    @Path("/name/{id}/{name}")
    public void updateName(String id,String name) {
        ProductEntity.update("name", name).where("_id", new ObjectId(id));
    }
    //Update Code
    @PUT
    @Path("/code/{id}/{code}")
    public void updateCode(String id,String code) {
        ProductEntity.update("code", code).where("_id", new ObjectId(id));
    }
    //Update Description
    @PUT
    @Path("/description/{id}/{description}")
    public void updateDescription(String id, String description) {
        ProductEntity.update("description", description).where("_id", new ObjectId(id));
    }
    //Update Brand
    @PUT
    @Path("/brand/{id}/{brand}")
    public void updateBrand(String id,String brand) {
        ProductEntity.update("brand", brand).where("_id", new ObjectId(id));
    }

    //Update Currency
    @PUT
    @Path("/currency/{id}/{currency}")
    public void updateCurrency(String id,String currency) {
        ProductEntity.update("currency", currency).where("_id", new ObjectId(id));
    }
    //Update Price
    @PUT
    @Path("/price/{id}/{price}")
    public void updatePrice(String id,String price) {
        ProductEntity.update("price", price).where("_id", new ObjectId(id));
    }

    //Update Stock
    @PUT
    @Path("/stock/{id}/{stock}")
    public void updateStock(String id,String stock) {
        ProductEntity.update("stock", stock).where("_id", new ObjectId(id));
    }
    //Update All Products Stock
    public void updateAllStock(int stock) {
        ProductEntity.update("stock", stock).where("isDeleted", false);
    }

}

