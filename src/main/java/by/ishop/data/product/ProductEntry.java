//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.01 at 07:35:15 PM MSK 
//


package by.ishop.data.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.example.com/ProductEntry}Name"/&gt;
 *         &lt;element name="imgURL" type="{http://www.example.com/ProductEntry}ImgURL"/&gt;
 *         &lt;element name="price" type="{http://soapservice.ishop.by/}entryPrice"/&gt;
 *         &lt;element name="characteristics" type="{http://www.example.com/ProductSpecifications}Specification" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductEntry", namespace = "http://www.example.com/ProductEntry", propOrder = {
    "name",
    "imgURL",
    "price",
    "characteristics"
})
@XmlRootElement(name = "productEntry", namespace = "http://www.example.com/ProductEntry")
public class ProductEntry
    implements Serializable
{

    @XmlElement(namespace = "http://www.example.com/ProductEntry", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.example.com/ProductEntry", required = true)
    protected String imgURL;
    @XmlElement(namespace = "http://www.example.com/ProductEntry", required = true)
    protected EntryPrice price;
    @XmlElement(namespace = "http://www.example.com/ProductEntry", required = true)
    protected List<Specification> characteristics;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the imgURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * Sets the value of the imgURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgURL(String value) {
        this.imgURL = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link EntryPrice }
     *     
     */
    public EntryPrice getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryPrice }
     *     
     */
    public void setPrice(EntryPrice value) {
        this.price = value;
    }

    /**
     * Gets the value of the characteristics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characteristics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacteristics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Specification }
     * 
     * 
     */
    public List<Specification> getCharacteristics() {
        if (characteristics == null) {
            characteristics = new ArrayList<Specification>();
        }
        return this.characteristics;
    }

}
