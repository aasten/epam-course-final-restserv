package by.ishop.data;
import by.ishop.data.persists.PersistedProductEntry;
import by.ishop.data.product.ProductEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by sten on 21.02.17.
 */
public class JPADAOProductEntry implements DAO<ProductEntry, Integer> {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("IShop");


    public ProductEntry getById(Integer id) { // throws RuntimeException

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = manager.getTransaction();
            transaction.begin();

            PersistedProductEntry ppe = manager.find(PersistedProductEntry.class, id);
            if(null == ppe) {
                throw new RuntimeException("Product with id=" + id + " was not found");
            }
            ProductEntry p = persistedToDTO(ppe);
            // TODO setting price and characteristics here
            return p;
        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            // TODO slf4j
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    private static ProductEntry persistedToDTO(PersistedProductEntry pe) {
        ProductEntry p = new ProductEntry();
        p.setImgURL(pe.getImgURL());
        p.setName(pe.getName());
        return p;
    }


}
