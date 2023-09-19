package ProductControl;
import Messages.Messages;
import ProductEntity.ProductEntity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import org.bson.types.ObjectId;
import java.util.List;
import static ProductEntity.ProductEntity.findByInterval;

/*
   -Product Search operations
   -Endpoints accepts and returns only JSON.
   -Users can reach these enpdoints with Basic Auth.
 */

@Path("/searchProduct")
@RolesAllowed("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductSearch {
    Messages messages = new Messages();
    //Search by name
    @GET
    @Path("/name/{ProductName}")
    public Object searchByName(String ProductName) {
        try{
            List<ProductEntity> products = ProductEntity.findByName(ProductName);
            if (products == null || products.isEmpty()) {
                return messages.ElementNotFound;
            }
            return products;
        }catch (Exception e){
            return new Exception(e);
        }

    }
    //Search by code
    @GET
    @Path("/code/{ProductCode}")
    public Object searchByCode (String ProductCode){
        try{
            List<ProductEntity> products = ProductEntity.findByCode(ProductCode);
            if (products == null || products.isEmpty()) {
                return messages.ElementNotFound;
            }
            return products;
        }catch (Exception e){
            return new Exception(e);
        }

    }
    //Search by brand
    @GET
    @Path("/brand/{ProductBrand}")
    public Object searchByBrand (String ProductBrand) throws Exception {
        try{
            List<ProductEntity> products = ProductEntity.findByBrand(ProductBrand);
            if (products == null || products.isEmpty()) {
                return messages.ElementNotFound;
            }
            return products;
        }catch (Exception e){
            return new Exception(e);
        }

    }

    //Search by id (also known as detailed search)
    @GET
    @Path("/id/{ProductID}")
    public Object detailedSearchByID (String ProductID){
        try{
            ObjectId productID = new ObjectId(ProductID);
            ProductEntity productEntity = ProductEntity.findById(productID);
            if (productEntity == null){
                return messages.ElementNotFound;
            }
            return productEntity;
        }catch (Exception e){
            return new Exception(e);
        }
    }

    //Search by price interval
    @GET
    @Path("/priceInterval/{minPrice}/{maxPrice}")
    public Object detailedSearchByID (Integer minPrice, Integer maxPrice){
        List<ProductEntity> productEntities = findByInterval(minPrice,maxPrice);
        if (productEntities == null || productEntities.isEmpty()){
            return messages.ElementNotFound;
        }else{
            return productEntities;
        }
    }

}
