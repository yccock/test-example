
package com.test.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloServiceWs", targetNamespace = "http://test.com/", wsdlLocation = "http://127.0.0.1:9000/webserviceDemo?wsdl")
public class HelloServiceWs
    extends Service
{

    private final static URL HELLOSERVICEWS_WSDL_LOCATION;
    private final static WebServiceException HELLOSERVICEWS_EXCEPTION;
    private final static QName HELLOSERVICEWS_QNAME = new QName("http://test.com/", "HelloServiceWs");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:9000/webserviceDemo?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOSERVICEWS_WSDL_LOCATION = url;
        HELLOSERVICEWS_EXCEPTION = e;
    }

    public HelloServiceWs() {
        super(__getWsdlLocation(), HELLOSERVICEWS_QNAME);
    }

    public HelloServiceWs(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOSERVICEWS_QNAME, features);
    }

    public HelloServiceWs(URL wsdlLocation) {
        super(wsdlLocation, HELLOSERVICEWS_QNAME);
    }

    public HelloServiceWs(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOSERVICEWS_QNAME, features);
    }

    public HelloServiceWs(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloServiceWs(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloService
     */
    @WebEndpoint(name = "HelloServiceImplPort")
    public HelloService getHelloServiceImplPort() {
        return super.getPort(new QName("http://test.com/", "HelloServiceImplPort"), HelloService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloService
     */
    @WebEndpoint(name = "HelloServiceImplPort")
    public HelloService getHelloServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://test.com/", "HelloServiceImplPort"), HelloService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOSERVICEWS_EXCEPTION!= null) {
            throw HELLOSERVICEWS_EXCEPTION;
        }
        return HELLOSERVICEWS_WSDL_LOCATION;
    }

}