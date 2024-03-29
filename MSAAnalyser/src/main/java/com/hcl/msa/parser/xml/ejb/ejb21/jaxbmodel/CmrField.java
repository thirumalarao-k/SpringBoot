//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.17 at 04:45:32 PM IST 
//


package com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel;

import java.util.ArrayList;
import java.util.List;
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
 * 	The cmr-fieldType describes the bean provider's view of
 * 	a relationship. It consists of an optional description, and
 * 	the name and the class type of a field in the source of a
 * 	role of a relationship. The cmr-field-name element
 * 	corresponds to the name used for the get and set accessor
 * 	methods for the relationship. The cmr-field-type element is
 * 	used only for collection-valued cmr-fields. It specifies the
 * 	type of the collection that is used.
 * 
 *       
 * 
 * <p>Java class for cmr-field complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cmr-field">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/j2ee}description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cmr-field-name" type="{http://java.sun.com/xml/ns/j2ee}string"/>
 *         &lt;element name="cmr-field-type" type="{http://java.sun.com/xml/ns/j2ee}cmr-field-type" minOccurs="0"/>
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
@XmlType(name = "cmr-field", propOrder = {
    "description",
    "cmrFieldName",
    "cmrFieldType"
})
public class CmrField {

    protected List<Description> description;
    @XmlElement(name = "cmr-field-name", required = true)
    protected com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String cmrFieldName;
    @XmlElement(name = "cmr-field-type")
    protected CmrFieldType cmrFieldType;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description }
     * 
     * 
     */
    public List<Description> getDescription() {
        if (description == null) {
            description = new ArrayList<Description>();
        }
        return this.description;
    }

    /**
     * Gets the value of the cmrFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String }
     *     
     */
    public com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String getCmrFieldName() {
        return cmrFieldName;
    }

    /**
     * Sets the value of the cmrFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String }
     *     
     */
    public void setCmrFieldName(com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String value) {
        this.cmrFieldName = value;
    }

    /**
     * Gets the value of the cmrFieldType property.
     * 
     * @return
     *     possible object is
     *     {@link CmrFieldType }
     *     
     */
    public CmrFieldType getCmrFieldType() {
        return cmrFieldType;
    }

    /**
     * Sets the value of the cmrFieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CmrFieldType }
     *     
     */
    public void setCmrFieldType(CmrFieldType value) {
        this.cmrFieldType = value;
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
