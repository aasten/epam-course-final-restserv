
package by.ishop.soapservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PricingEndpoint", targetNamespace = "http://soapservice.ishop.by/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PricingEndpoint {


    /**
     * 
     * @param entryId
     * @return
     *     returns by.ishop.soapservice.EntryPrice
     * @throws NoEntryPricingInfo_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soapservice.ishop.by/PricingEndpoint/getEntryPriceRequest", output = "http://soapservice.ishop.by/PricingEndpoint/getEntryPriceResponse", fault = {
        @FaultAction(className = NoEntryPricingInfo_Exception.class, value = "http://soapservice.ishop.by/PricingEndpoint/getEntryPrice/Fault/NoEntryPricingInfo")
    })
    public EntryPrice getEntryPrice(
        @WebParam(name = "entryId", partName = "entryId")
        String entryId)
        throws NoEntryPricingInfo_Exception
    ;

}
