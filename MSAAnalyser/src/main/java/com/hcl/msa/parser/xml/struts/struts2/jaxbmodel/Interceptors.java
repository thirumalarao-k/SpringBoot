//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.13 at 04:29:55 PM IST 
//


package com.hcl.msa.parser.xml.struts.struts2.jaxbmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "interceptorOrInterceptorStack"
})
@XmlRootElement(name = "interceptors")
public class Interceptors {

    @XmlElements({
        @XmlElement(name = "interceptor", required = true, type = Interceptor.class),
        @XmlElement(name = "interceptor-stack", required = true, type = InterceptorStack.class)
    })
    protected List<Object> interceptorOrInterceptorStack;

    /**
     * Gets the value of the interceptorOrInterceptorStack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interceptorOrInterceptorStack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterceptorOrInterceptorStack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Interceptor }
     * {@link InterceptorStack }
     * 
     * 
     */
    public List<Object> getInterceptorOrInterceptorStack() {
        if (interceptorOrInterceptorStack == null) {
            interceptorOrInterceptorStack = new ArrayList<Object>();
        }
        return this.interceptorOrInterceptorStack;
    }

}
