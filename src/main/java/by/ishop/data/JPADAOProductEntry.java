package by.ishop.data;
import by.ishop.data.persists.PersistedProductEntry;
import by.ishop.data.product.EntryPrice;
import by.ishop.data.product.ProductEntry;
import by.ishop.soapservice.PricingEndpoint_Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceRef;

/**
 * Created by sten on 21.02.17.
 */
public class JPADAOProductEntry implements DAO<ProductEntry, Integer> {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("IShop");

    @WebServiceRef(wsdlLocation = "http://localhost:7000/soapservice/pricing?wsdl")
    private static PricingEndpoint_Service service;


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
            // TODO setting characteristics here
            if(null == service) {
                service = new PricingEndpoint_Service();
            }
            try {
                p.setPrice(entryPricePackageMismatchFix(
                        service.getPricingEndpointPort().getEntryPrice(id.toString())));
            } catch(RuntimeException e) {
                // TODO slf4j
                e.printStackTrace();
            }
            return p;
        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            // TODO slf4j
//            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    private static ProductEntry persistedToDTO(PersistedProductEntry pe) {
        ProductEntry p = new ProductEntry();
        p.setImgURL(pe.getImgURL());
        p.setName(pe.getName());
        p.setRate(pe.getRate());
        return p;
    }

    private static EntryPrice entryPricePackageMismatchFix(by.ishop.soapservice.EntryPrice ps) {
        EntryPrice p = new EntryPrice();
        p.setValue(ps.getValue());
        p.setCurrencyCodeISO4217(ps.getCurrencyCodeISO4217());
        return p;
    }


}
