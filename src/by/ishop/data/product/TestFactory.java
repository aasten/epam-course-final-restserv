package by.ishop.data.product;

import by.ishop.soapservice.NoEntryPricingInfo_Exception;
import by.ishop.soapservice.PricingEndpoint_Service;

import java.math.BigDecimal;

/**
 * Created by sten on 24.02.17.
 */
public class TestFactory {
    private static boolean flipflop = false;
    private static PricingEndpoint_Service service = new PricingEndpoint_Service();
    public static ProductEntry createTestEntry(String id) {
        // test exception for every odd invocation
        if(flipflop ^= true) id = "-1";

        ProductEntry p = new ProductEntry();
        p.setName("Canon EOS 5D");
        p.setImgURL("/img/canon.png");
        try {
            p.setPrice(service.getPricingEndpointPort().getEntryPrice(id).getValue());
        } catch (NoEntryPricingInfo_Exception e) {
            throw new RuntimeException(e);
        }
        {
            Specification s = new Specification();
            s.setPropName("Sensor");
            s.setPropValue("35.8 x 23.9 mm CMOS (full-frame)");
            p.getCharacteristics().add(s);
        }
        {
            Specification s = new Specification();
            s.setPropName("Weight");
            s.setPropValue("810 g");
            p.getCharacteristics().add(s);
        }
        return p;
    }
}
