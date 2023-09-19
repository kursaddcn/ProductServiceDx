package ProductBoundary;
import java.util.concurrent.atomic.AtomicInteger;
import ProductControl.ProductUpdate;
import com.github.javafaker.Faker;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

//CRON job works and updates stock amounts.
@ApplicationScoped
public class ScheduledProductStockUpdater {
    private AtomicInteger stockAmount = new AtomicInteger();
    public int get() {
        return stockAmount.get();
    }

    //Updated at each 24 Hours
    @Scheduled(every="86400s")
    void generateMockStockData() {
        Faker faker = new Faker();
        int updatedStockAmount = faker.number().numberBetween(0,100);
        ProductUpdate productUpdate = new ProductUpdate();
        productUpdate.updateAllStock(updatedStockAmount);
    }
    //Scheduled at each 02.00
    @Scheduled(cron="0 00 02 * * ?")
    void cronJob(ScheduledExecution execution) {
        System.out.println(execution.getScheduledFireTime());
    }

    @Scheduled(cron = "{cron.expr}")
    void cronJobWithExpressionInConfig() {
        System.out.println("Cron expression reconfigured!");
    }
}
