//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.05 at 05:49:25 PM MSK 
//


package by.ishop.data.product;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Specification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Specification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="propName" type="{http://www.example.com/ProductSpecifications}PropName"/&gt;
 *         &lt;element name="propValue" type="{http://www.example.com/ProductSpecifications}PropValue"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Specification", namespace = "http://www.example.com/ProductSpecifications", propOrder = {
    "propName",
    "propValue"
})
public class Specification
    implements Serializable
{

    @XmlElement(namespace = "", required = true)
    protected String propName;
    @XmlElement(namespace = "", required = true)
    protected String propValue;

    /**
     * Gets the value of the propName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropName() {
        return propName;
    }

    /**
     * Sets the value of the propName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropName(String value) {
        this.propName = value;
    }

    /**
     * Gets the value of the propValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropValue() {
        return propValue;
    }

    /**
     * Sets the value of the propValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropValue(String value) {
        this.propValue = value;
    }

}
