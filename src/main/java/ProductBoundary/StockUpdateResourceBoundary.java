package ProductBoundary;
import ProductControl.ProductUpdate;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//This boundary class provides a public endpoint to track stock status.
@Path("/stockTracking")
public class StockUpdateResourceBoundary {

    @Inject
    ScheduledProductStockUpdater stockAmount;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String displayUpdatedStock() {
        return "Updated: " + stockAmount.get();
    }
}
