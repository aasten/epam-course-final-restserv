package by.ishop.data.persists;
import by.ishop.data.DAO;
import by.ishop.data.DAOList;
import by.ishop.data.product.EntryPrice;
import by.ishop.data.product.ProductEntry;
import by.ishop.soapservice.PricingEndpoint_Service;

import javax.persistence.*;
import javax.xml.ws.WebServiceRef;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sten on 21.02.17.
 */
public class JPADAOListProductEntriesAll implements DAOList<ProductEntry, Integer> {



    @Override
    public List<ProductEntry> getNStartFromId(Integer id, Integer N) { // throws RuntimeException

        EntityManager manager = JPAStuff.INSTANCE.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = manager.getTransaction();
            transaction.begin();

            TypedQuery<PersistedProductEntry> qpe = manager.createQuery(
                    "SELECT s FROM PersistedProductEntry s WHERE s.id >= :arg1",
                    PersistedProductEntry.class);
            qpe.setParameter("arg1",id);
            qpe.setMaxResults(N);

            List<ProductEntry> retList = new ArrayList<>();
            for(PersistedProductEntry ppe : qpe.getResultList()) {
                retList.add(JPADAOProductEntry.persistedToDTOAddPrice(ppe));
            }
            return retList;
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
}
