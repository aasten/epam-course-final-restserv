package by.ishop.data.persists;
import by.ishop.data.DAO;
import by.ishop.data.product.EntryPrice;
import by.ishop.data.product.ProductEntry;
import by.ishop.soapservice.NoEntryPricingInfo_Exception;
import by.ishop.soapservice.PricingEndpoint_Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.ws.WebServiceRef;
import java.util.List;

/**
 * Created by sten on 21.02.17.
 */
public class JPADAOProductEntry implements DAO<ProductEntry, Integer> {

    @WebServiceRef(wsdlLocation = "http://localhost:7000/soapservice/pricing?wsdl")
    private static PricingEndpoint_Service service;


    public ProductEntry getById(Integer id) { // throws RuntimeException

        EntityManager manager = JPAStuff.INSTANCE.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = manager.getTransaction();
            transaction.begin();

            PersistedProductEntry ppe = manager.find(PersistedProductEntry.class, id);
            if(null == ppe) {
                throw new RuntimeException("Product " + id + " was not found");
            }
            return persistedToDTOAddPrice(ppe);
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

    static ProductEntry persistedToDTOAddPrice(PersistedProductEntry ppe) {
        ProductEntry p = persistedToDTO(ppe);
        // TODO setting characteristics here
        if(null == service) {
            service = new PricingEndpoint_Service();
        }
        try {
            p.setPrice(entryPricePackageMismatchFix(
                    service.getPricingEndpointPort().getEntryPrice(Integer.toString(ppe.getId()))));
        } catch (NoEntryPricingInfo_Exception e) {
            // TODO slf4j
            e.printStackTrace();
        }
        return p;
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
