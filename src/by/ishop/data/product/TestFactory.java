package by.ishop.data.product;

import java.math.BigDecimal;

/**
 * Created by sten on 24.02.17.
 */
public class TestFactory {
    private static boolean flipflop = false;
    public static ProductEntry createTestEntry() {
        // test exception for every odd invokation
        if(flipflop ^= true) throw new RuntimeException();

        ProductEntry p = new ProductEntry();
        p.setName("Canon EOS 5D");
        p.setImgURL("/img/canon.png");
        p.setPrice(new BigDecimal("1799.99"));
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
