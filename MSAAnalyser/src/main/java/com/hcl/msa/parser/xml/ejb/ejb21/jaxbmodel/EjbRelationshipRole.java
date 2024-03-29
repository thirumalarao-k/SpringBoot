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
 * 
 * 	  The ejb-relationship-roleType describes a role within a
 * 	  relationship. There are two roles in each relationship.
 * 
 * 	  The ejb-relationship-roleType contains an optional
 * 	  description; an optional name for the relationship role; a
 * 	  specification of the multiplicity of the role; an optional
 * 	  specification of cascade-delete functionality for the role;
 * 	  the role source; and a declaration of the cmr-field, if any,
 * 	  by means of which the other side of the relationship is
 * 	  accessed from the perspective of the role source.
 * 
 * 	  The multiplicity and role-source element are mandatory.
 * 
 * 	  The relationship-role-source element designates an entity
 * 	  bean by means of an ejb-name element. For bidirectional
 * 	  relationships, both roles of a relationship must declare a
 * 	  relationship-role-source element that specifies a cmr-field
 * 	  in terms of which the relationship is accessed. The lack of
 * 	  a cmr-field element in an ejb-relationship-role specifies
 * 	  that the relationship is unidirectional in navigability and
 * 	  the entity bean that participates in the relationship is
 * 	  "not aware" of the relationship.
 * 
 * 	  Example:
 * 
 * 	  <ejb-relation>
 * 	      <ejb-relation-name>Product-LineItem</ejb-relation-name>
 * 	      <ejb-relationship-role>
 * 		  <ejb-relationship-role-name>product-has-lineitems
 * 		  </ejb-relationship-role-name>
 * 		  <multiplicity>One</multiplicity>
 * 		  <relationship-role-source>
 * 		  <ejb-name>ProductEJB</ejb-name>
 * 		  </relationship-role-source>
 * 	       </ejb-relationship-role>
 * 	  </ejb-relation>
 * 
 * 	  
 *       
 * 
 * <p>Java class for ejb-relationship-role complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ejb-relationship-role">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/j2ee}description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ejb-relationship-role-name" type="{http://java.sun.com/xml/ns/j2ee}string" minOccurs="0"/>
 *         &lt;element name="multiplicity" type="{http://java.sun.com/xml/ns/j2ee}multiplicity"/>
 *         &lt;element name="cascade-delete" type="{http://java.sun.com/xml/ns/j2ee}empty" minOccurs="0"/>
 *         &lt;element name="relationship-role-source" type="{http://java.sun.com/xml/ns/j2ee}relationship-role-source"/>
 *         &lt;element name="cmr-field" type="{http://java.sun.com/xml/ns/j2ee}cmr-field" minOccurs="0"/>
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
@XmlType(name = "ejb-relationship-role", propOrder = {
    "description",
    "ejbRelationshipRoleName",
    "multiplicity",
    "cascadeDelete",
    "relationshipRoleSource",
    "cmrField"
})
public class EjbRelationshipRole {

    protected List<Description> description;
    @XmlElement(name = "ejb-relationship-role-name")
    protected com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String ejbRelationshipRoleName;
    @XmlElement(required = true)
    protected Multiplicity multiplicity;
    @XmlElement(name = "cascade-delete")
    protected Empty cascadeDelete;
    @XmlElement(name = "relationship-role-source", required = true)
    protected RelationshipRoleSource relationshipRoleSource;
    @XmlElement(name = "cmr-field")
    protected CmrField cmrField;
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
     * Gets the value of the ejbRelationshipRoleName property.
     * 
     * @return
     *     possible object is
     *     {@link com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String }
     *     
     */
    public com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String getEjbRelationshipRoleName() {
        return ejbRelationshipRoleName;
    }

    /**
     * Sets the value of the ejbRelationshipRoleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String }
     *     
     */
    public void setEjbRelationshipRoleName(com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String value) {
        this.ejbRelationshipRoleName = value;
    }

    /**
     * Gets the value of the multiplicity property.
     * 
     * @return
     *     possible object is
     *     {@link Multiplicity }
     *     
     */
    public Multiplicity getMultiplicity() {
        return multiplicity;
    }

    /**
     * Sets the value of the multiplicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Multiplicity }
     *     
     */
    public void setMultiplicity(Multiplicity value) {
        this.multiplicity = value;
    }

    /**
     * Gets the value of the cascadeDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getCascadeDelete() {
        return cascadeDelete;
    }

    /**
     * Sets the value of the cascadeDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setCascadeDelete(Empty value) {
        this.cascadeDelete = value;
    }

    /**
     * Gets the value of the relationshipRoleSource property.
     * 
     * @return
     *     possible object is
     *     {@link RelationshipRoleSource }
     *     
     */
    public RelationshipRoleSource getRelationshipRoleSource() {
        return relationshipRoleSource;
    }

    /**
     * Sets the value of the relationshipRoleSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationshipRoleSource }
     *     
     */
    public void setRelationshipRoleSource(RelationshipRoleSource value) {
        this.relationshipRoleSource = value;
    }

    /**
     * Gets the value of the cmrField property.
     * 
     * @return
     *     possible object is
     *     {@link CmrField }
     *     
     */
    public CmrField getCmrField() {
        return cmrField;
    }

    /**
     * Sets the value of the cmrField property.
     * 
     * @param value
     *     allowed object is
     *     {@link CmrField }
     *     
     */
    public void setCmrField(CmrField value) {
        this.cmrField = value;
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
