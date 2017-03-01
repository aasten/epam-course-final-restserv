package by.ishop.data;
import by.ishop.data.product.ProductEntry;

/**
 * Created by sten on 21.02.17.
 */
public class JPADAOProductEntry implements DAO<ProductEntry, Long> {

    public Long addNew(ProductEntry entry) {
        // TODO
        return Long.valueOf(0);
    }
    public ProductEntry getById(Long id) { // throws RuntimeException
        return null;
    }

    public void delete(Long id) {

    }
    public void update(Long id, ProductEntry t) {

    }

}
