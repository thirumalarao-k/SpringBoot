//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.17 at 04:45:32 PM IST 
//


package com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 
 * 	The queryType defines a finder or select
 * 	query. It contains
 * 	    - an optional description of the query
 * 	    - the specification of the finder or select
 * 	      method it is used by
 * 		- an optional specification of the result type
 * 		  mapping, if the query is for a select method
 * 		  and entity objects are returned.
 * 		- the EJB QL query string that defines the query.
 * 
 * 	Queries that are expressible in EJB QL must use the ejb-ql
 * 	element to specify the query. If a query is not expressible
 * 	in EJB QL, the description element should be used to
 * 	describe the semantics of the query and the ejb-ql element
 * 	should be empty.
 * 
 * 	The result-type-mapping is an optional element. It can only
 * 	be present if the query-method specifies a select method
 * 	that returns entity objects.  The default value for the
 * 	result-type-mapping element is "Local".
 * 
 *       
 * 
 * <p>Java class for query complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="query">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/j2ee}description" minOccurs="0"/>
 *         &lt;element name="query-method" type="{http://java.sun.com/xml/ns/j2ee}query-method"/>
 *         &lt;element name="result-type-mapping" type="{http://java.sun.com/xml/ns/j2ee}result-type-mapping" minOccurs="0"/>
 *         &lt;element name="ejb-ql" type="{http://java.sun.com/xml/ns/j2ee}xsdString"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query", propOrder = {
    "description",
    "queryMethod",
    "resultTypeMapping",
    "ejbQl"
})
public class Query {

    protected Description description;
    @XmlElement(name = "query-method", required = true)
    protected QueryMethod queryMethod;
    @XmlElement(name = "result-type-mapping")
    protected ResultTypeMapping resultTypeMapping;
    @XmlElement(name = "ejb-ql", required = true)
    protected XsdString ejbQl;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

    /**
     * Gets the value of the queryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link QueryMethod }
     *     
     */
    public QueryMethod getQueryMethod() {
        return queryMethod;
    }

    /**
     * Sets the value of the queryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryMethod }
     *     
     */
    public void setQueryMethod(QueryMethod value) {
        this.queryMethod = value;
    }

    /**
     * Gets the value of the resultTypeMapping property.
     * 
     * @return
     *     possible object is
     *     {@link ResultTypeMapping }
     *     
     */
    public ResultTypeMapping getResultTypeMapping() {
        return resultTypeMapping;
    }

    /**
     * Sets the value of the resultTypeMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultTypeMapping }
     *     
     */
    public void setResultTypeMapping(ResultTypeMapping value) {
        this.resultTypeMapping = value;
    }

    /**
     * Gets the value of the ejbQl property.
     * 
     * @return
     *     possible object is
     *     {@link XsdString }
     *     
     */
    public XsdString getEjbQl() {
        return ejbQl;
    }

    /**
     * Sets the value of the ejbQl property.
     * 
     * @param value
     *     allowed object is
     *     {@link XsdString }
     *     
     */
    public void setEjbQl(XsdString value) {
        this.ejbQl = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}