//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.01 at 07:27:14 PM MSK 
//


package by.ishop.data.product;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.ishop.data.product package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.ishop.data.product
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductEntry }
     * 
     */
    public ProductEntry createProductEntry() {
        return new ProductEntry();
    }

    /**
     * Create an instance of {@link EntryPrice }
     * 
     */
    public EntryPrice createEntryPrice() {
        return new EntryPrice();
    }

    /**
     * Create an instance of {@link Specification }
     * 
     */
    public Specification createSpecification() {
        return new Specification();
    }

    /**
     * Create an instance of {@link NoEntryPricingInfo }
     * 
     */
    public NoEntryPricingInfo createNoEntryPricingInfo() {
        return new NoEntryPricingInfo();
    }

}