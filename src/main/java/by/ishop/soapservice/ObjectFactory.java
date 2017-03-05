
package by.ishop.soapservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.ishop.soapservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EntryPrice_QNAME = new QName("http://soapservice.ishop.by/", "entryPrice");
    private final static QName _NoEntryPricingInfo_QNAME = new QName("http://soapservice.ishop.by/", "NoEntryPricingInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.ishop.soapservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NoEntryPricingInfo }
     * 
     */
    public NoEntryPricingInfo createNoEntryPricingInfo() {
        return new NoEntryPricingInfo();
    }

    /**
     * Create an instance of {@link EntryPrice }
     * 
     */
    public EntryPrice createEntryPrice() {
        return new EntryPrice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntryPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservice.ishop.by/", name = "entryPrice")
    public JAXBElement<EntryPrice> createEntryPrice(EntryPrice value) {
        return new JAXBElement<EntryPrice>(_EntryPrice_QNAME, EntryPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoEntryPricingInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservice.ishop.by/", name = "NoEntryPricingInfo")
    public JAXBElement<NoEntryPricingInfo> createNoEntryPricingInfo(NoEntryPricingInfo value) {
        return new JAXBElement<NoEntryPricingInfo>(_NoEntryPricingInfo_QNAME, NoEntryPricingInfo.class, null, value);
    }

}
