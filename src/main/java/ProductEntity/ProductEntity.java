package ProductEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.util.List;

//Product Entity
@MongoEntity(collection="ProductEntity")
public class ProductEntity extends PanacheMongoEntity {
    @BsonProperty("name")
    public String name;
    @BsonProperty("code")
    public String code;
    @BsonProperty("description")
    public String description;
    @BsonProperty("brand")
    public String brand;
    @BsonProperty("currency")
    public String currency;
    @BsonProperty("price")
    public int price;
    @BsonProperty("stock")
    public int stock;
    @BsonProperty("isDeleted")
    public boolean isDeleted;

    //Queries
    public static List<ProductEntity> findByName(String name){
        return list("name = ?1 and isDeleted = ?2", name,false);
    }
    public static List<ProductEntity> findByCode(String code){
        return list("code = ?1 and isDeleted = ?2", code,false);
    }
    public static List<ProductEntity> findByBrand(String brand){
        return list("brand = ?1 and isDeleted = ?2", brand,false);
    }
    public static List<ProductEntity> findByInterval(Integer min, Integer max){
        return list("price >= ?1 and price <= ?2 and isDeleted = ?3", min, max,false);
    }

}
