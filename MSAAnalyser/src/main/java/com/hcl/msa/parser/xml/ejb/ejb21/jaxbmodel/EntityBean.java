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
 * 	The entity-beanType declares an entity bean. The declaration
 * 	consists of:
 * 
 * 	    - an optional description
 * 	    - an optional display name
 * 	    - an optional icon element that contains a small and a large
 * 	      icon file name
 * 	    - a unique name assigned to the enterprise bean
 * 	      in the deployment descriptor
 * 	    - the names of the entity bean's remote home
 * 	      and remote interfaces, if any
 * 	    - the names of the entity bean's local home and local
 * 	      interfaces, if any
 * 	    - the entity bean's implementation class
 * 	    - the entity bean's persistence management type
 * 	    - the entity bean's primary key class name
 * 	    - an indication of the entity bean's reentrancy
 * 	    - an optional specification of the
 * 	      entity bean's cmp-version
 * 	    - an optional specification of the entity bean's
 * 	      abstract schema name
 * 	    - an optional list of container-managed fields
 * 	    - an optional specification of the primary key
 * 	      field
 * 	    - an optional declaration of the bean's environment
 * 	      entries
 * 	    - an optional declaration of the bean's EJB
 * 	      references
 * 	    - an optional declaration of the bean's local
 * 	      EJB references
 * 	    - an optional declaration of the bean's web
 * 	      service references
 * 	    - an optional declaration of the security role
 * 	      references
 * 	    - an optional declaration of the security identity
 * 	      to be used for the execution of the bean's methods
 * 	    - an optional declaration of the bean's
 * 	      resource manager connection factory references
 * 	    - an optional declaration of the bean's
 * 	      resource environment references
 * 	    - an optional declaration of the bean's message
 * 	      destination references
 * 	    - an optional set of query declarations
 * 	      for finder and select methods for an entity
 * 	      bean with cmp-version 2.x.
 * 
 * 	The optional abstract-schema-name element must be specified
 * 	for an entity bean with container-managed persistence and
 * 	cmp-version 2.x.
 * 
 * 	The optional primkey-field may be present in the descriptor
 * 	if the entity's persistence-type is Container.
 * 
 * 	The optional cmp-version element may be present in the
 * 	descriptor if the entity's persistence-type is Container. If
 * 	the persistence-type is Container and the cmp-version
 * 	element is not specified, its value defaults to 2.x.
 * 
 * 	The optional home and remote elements must be specified if
 * 	the entity bean cmp-version is 1.x.
 * 
 * 	The optional home and remote elements must be specified if
 * 	the entity bean has a remote home and remote interface.
 * 
 * 	The optional local-home and local elements must be specified
 * 	if the entity bean has a local home and local interface.
 * 
 * 	Either both the local-home and the local elements or both
 * 	the home and the remote elements must be specified.
 * 
 * 	The optional query elements must be present if the
 * 	persistence-type is Container and the cmp-version is 2.x and
 * 	query methods other than findByPrimaryKey have been defined
 * 	for the entity bean.
 * 
 * 	The other elements that are optional are "optional" in the
 * 	sense that they are omitted if the lists represented by them
 * 	are empty.
 * 
 * 	At least one cmp-field element must be present in the
 * 	descriptor if the entity's persistence-type is Container and
 * 	the cmp-version is 1.x, and none must not be present if the
 * 	entity's persistence-type is Bean.
 * 
 *       
 * 
 * <p>Java class for entity-bean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entity-bean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://java.sun.com/xml/ns/j2ee}descriptionGroup"/>
 *         &lt;element name="ejb-name" type="{http://java.sun.com/xml/ns/j2ee}ejb-name"/>
 *         &lt;element name="home" type="{http://java.sun.com/xml/ns/j2ee}home" minOccurs="0"/>
 *         &lt;element name="remote" type="{http://java.sun.com/xml/ns/j2ee}remote" minOccurs="0"/>
 *         &lt;element name="local-home" type="{http://java.sun.com/xml/ns/j2ee}local-home" minOccurs="0"/>
 *         &lt;element name="local" type="{http://java.sun.com/xml/ns/j2ee}local" minOccurs="0"/>
 *         &lt;element name="ejb-class" type="{http://java.sun.com/xml/ns/j2ee}ejb-class"/>
 *         &lt;element name="persistence-type" type="{http://java.sun.com/xml/ns/j2ee}persistence-type"/>
 *         &lt;element name="prim-key-class" type="{http://java.sun.com/xml/ns/j2ee}fully-qualified-class"/>
 *         &lt;element name="reentrant" type="{http://java.sun.com/xml/ns/j2ee}true-false"/>
 *         &lt;element name="cmp-version" type="{http://java.sun.com/xml/ns/j2ee}cmp-version" minOccurs="0"/>
 *         &lt;element name="abstract-schema-name" type="{http://java.sun.com/xml/ns/j2ee}java-identifier" minOccurs="0"/>
 *         &lt;element name="cmp-field" type="{http://java.sun.com/xml/ns/j2ee}cmp-field" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="primkey-field" type="{http://java.sun.com/xml/ns/j2ee}string" minOccurs="0"/>
 *         &lt;group ref="{http://java.sun.com/xml/ns/j2ee}jndiEnvironmentRefsGroup"/>
 *         &lt;element name="security-role-ref" type="{http://java.sun.com/xml/ns/j2ee}security-role-ref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="security-identity" type="{http://java.sun.com/xml/ns/j2ee}security-identity" minOccurs="0"/>
 *         &lt;element name="query" type="{http://java.sun.com/xml/ns/j2ee}query" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "entity-bean", propOrder = {
    "description",
    "displayName",
    "icon",
    "ejbName",
    "home",
    "remote",
    "localHome",
    "local",
    "ejbClass",
    "persistenceType",
    "primKeyClass",
    "reentrant",
    "cmpVersion",
    "abstractSchemaName",
    "cmpField",
    "primkeyField",
    "envEntry",
    "ejbRef",
    "ejbLocalRef",
    "serviceRef",
    "resourceRef",
    "resourceEnvRef",
    "messageDestinationRef",
    "securityRoleRef",
    "securityIdentity",
    "query"
})
public class EntityBean {

    protected List<Description> description;
    @XmlElement(name = "display-name")
    protected List<DisplayName> displayName;
    protected List<Icon> icon;
    @XmlElement(name = "ejb-name", required = true)
    protected EjbName ejbName;
    protected Home home;
    protected Remote remote;
    @XmlElement(name = "local-home")
    protected LocalHome localHome;
    protected Local local;
    @XmlElement(name = "ejb-class", required = true)
    protected EjbClass ejbClass;
    @XmlElement(name = "persistence-type", required = true)
    protected PersistenceType persistenceType;
    @XmlElement(name = "prim-key-class", required = true)
    protected FullyQualifiedClass primKeyClass;
    @XmlElement(required = true)
    protected TrueFalse reentrant;
    @XmlElement(name = "cmp-version")
    protected CmpVersion cmpVersion;
    @XmlElement(name = "abstract-schema-name")
    protected JavaIdentifier abstractSchemaName;
    @XmlElement(name = "cmp-field")
    protected List<CmpField> cmpField;
    @XmlElement(name = "primkey-field")
    protected com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String primkeyField;
    @XmlElement(name = "env-entry")
    protected List<EnvEntry> envEntry;
    @XmlElement(name = "ejb-ref")
    protected List<EjbRef> ejbRef;
    @XmlElement(name = "ejb-local-ref")
    protected List<EjbLocalRef> ejbLocalRef;
    @XmlElement(name = "service-ref")
    protected List<ServiceRef> serviceRef;
    @XmlElement(name = "resource-ref")
    protected List<ResourceRef> resourceRef;
    @XmlElement(name = "resource-env-ref")
    protected List<ResourceEnvRef> resourceEnvRef;
    @XmlElement(name = "message-destination-ref")
    protected List<MessageDestinationRef> messageDestinationRef;
    @XmlElement(name = "security-role-ref")
    protected List<SecurityRoleRef> securityRoleRef;
    @XmlElement(name = "security-identity")
    protected SecurityIdentity securityIdentity;
    protected List<Query> query;
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
     * Gets the value of the displayName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayName }
     * 
     * 
     */
    public List<DisplayName> getDisplayName() {
        if (displayName == null) {
            displayName = new ArrayList<DisplayName>();
        }
        return this.displayName;
    }

    /**
     * Gets the value of the icon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Icon }
     * 
     * 
     */
    public List<Icon> getIcon() {
        if (icon == null) {
            icon = new ArrayList<Icon>();
        }
        return this.icon;
    }

    /**
     * Gets the value of the ejbName property.
     * 
     * @return
     *     possible object is
     *     {@link EjbName }
     *     
     */
    public EjbName getEjbName() {
        return ejbName;
    }

    /**
     * Sets the value of the ejbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link EjbName }
     *     
     */
    public void setEjbName(EjbName value) {
        this.ejbName = value;
    }

    /**
     * Gets the value of the home property.
     * 
     * @return
     *     possible object is
     *     {@link Home }
     *     
     */
    public Home getHome() {
        return home;
    }

    /**
     * Sets the value of the home property.
     * 
     * @param value
     *     allowed object is
     *     {@link Home }
     *     
     */
    public void setHome(Home value) {
        this.home = value;
    }

    /**
     * Gets the value of the remote property.
     * 
     * @return
     *     possible object is
     *     {@link Remote }
     *     
     */
    public Remote getRemote() {
        return remote;
    }

    /**
     * Sets the value of the remote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Remote }
     *     
     */
    public void setRemote(Remote value) {
        this.remote = value;
    }

    /**
     * Gets the value of the localHome property.
     * 
     * @return
     *     possible object is
     *     {@link LocalHome }
     *     
     */
    public LocalHome getLocalHome() {
        return localHome;
    }

    /**
     * Sets the value of the localHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalHome }
     *     
     */
    public void setLocalHome(LocalHome value) {
        this.localHome = value;
    }

    /**
     * Gets the value of the local property.
     * 
     * @return
     *     possible object is
     *     {@link Local }
     *     
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Sets the value of the local property.
     * 
     * @param value
     *     allowed object is
     *     {@link Local }
     *     
     */
    public void setLocal(Local value) {
        this.local = value;
    }

    /**
     * Gets the value of the ejbClass property.
     * 
     * @return
     *     possible object is
     *     {@link EjbClass }
     *     
     */
    public EjbClass getEjbClass() {
        return ejbClass;
    }

    /**
     * Sets the value of the ejbClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link EjbClass }
     *     
     */
    public void setEjbClass(EjbClass value) {
        this.ejbClass = value;
    }

    /**
     * Gets the value of the persistenceType property.
     * 
     * @return
     *     possible object is
     *     {@link PersistenceType }
     *     
     */
    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    /**
     * Sets the value of the persistenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersistenceType }
     *     
     */
    public void setPersistenceType(PersistenceType value) {
        this.persistenceType = value;
    }

    /**
     * Gets the value of the primKeyClass property.
     * 
     * @return
     *     possible object is
     *     {@link FullyQualifiedClass }
     *     
     */
    public FullyQualifiedClass getPrimKeyClass() {
        return primKeyClass;
    }

    /**
     * Sets the value of the primKeyClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullyQualifiedClass }
     *     
     */
    public void setPrimKeyClass(FullyQualifiedClass value) {
        this.primKeyClass = value;
    }

    /**
     * Gets the value of the reentrant property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalse }
     *     
     */
    public TrueFalse getReentrant() {
        return reentrant;
    }

    /**
     * Sets the value of the reentrant property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalse }
     *     
     */
    public void setReentrant(TrueFalse value) {
        this.reentrant = value;
    }

    /**
     * Gets the value of the cmpVersion property.
     * 
     * @return
     *     possible object is
     *     {@link CmpVersion }
     *     
     */
    public CmpVersion getCmpVersion() {
        return cmpVersion;
    }

    /**
     * Sets the value of the cmpVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CmpVersion }
     *     
     */
    public void setCmpVersion(CmpVersion value) {
        this.cmpVersion = value;
    }

    /**
     * Gets the value of the abstractSchemaName property.
     * 
     * @return
     *     possible object is
     *     {@link JavaIdentifier }
     *     
     */
    public JavaIdentifier getAbstractSchemaName() {
        return abstractSchemaName;
    }

    /**
     * Sets the value of the abstractSchemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JavaIdentifier }
     *     
     */
    public void setAbstractSchemaName(JavaIdentifier value) {
        this.abstractSchemaName = value;
    }

    /**
     * Gets the value of the cmpField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmpField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCmpField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CmpField }
     * 
     * 
     */
    public List<CmpField> getCmpField() {
        if (cmpField == null) {
            cmpField = new ArrayList<CmpField>();
        }
        return this.cmpField;
    }

    /**
     * Gets the value of the primkeyField property.
     * 
     * @return
     *     possible object is
     *     {@link com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String }
     *     
     */
    public com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String getPrimkeyField() {
        return primkeyField;
    }

    /**
     * Sets the value of the primkeyField property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String }
     *     
     */
    public void setPrimkeyField(com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.String value) {
        this.primkeyField = value;
    }

    /**
     * Gets the value of the envEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the envEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvEntry }
     * 
     * 
     */
    public List<EnvEntry> getEnvEntry() {
        if (envEntry == null) {
            envEntry = new ArrayList<EnvEntry>();
        }
        return this.envEntry;
    }

    /**
     * Gets the value of the ejbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ejbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEjbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EjbRef }
     * 
     * 
     */
    public List<EjbRef> getEjbRef() {
        if (ejbRef == null) {
            ejbRef = new ArrayList<EjbRef>();
        }
        return this.ejbRef;
    }

    /**
     * Gets the value of the ejbLocalRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ejbLocalRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEjbLocalRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EjbLocalRef }
     * 
     * 
     */
    public List<EjbLocalRef> getEjbLocalRef() {
        if (ejbLocalRef == null) {
            ejbLocalRef = new ArrayList<EjbLocalRef>();
        }
        return this.ejbLocalRef;
    }

    /**
     * Gets the value of the serviceRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRef }
     * 
     * 
     */
    public List<ServiceRef> getServiceRef() {
        if (serviceRef == null) {
            serviceRef = new ArrayList<ServiceRef>();
        }
        return this.serviceRef;
    }

    /**
     * Gets the value of the resourceRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceRef }
     * 
     * 
     */
    public List<ResourceRef> getResourceRef() {
        if (resourceRef == null) {
            resourceRef = new ArrayList<ResourceRef>();
        }
        return this.resourceRef;
    }

    /**
     * Gets the value of the resourceEnvRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceEnvRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceEnvRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceEnvRef }
     * 
     * 
     */
    public List<ResourceEnvRef> getResourceEnvRef() {
        if (resourceEnvRef == null) {
            resourceEnvRef = new ArrayList<ResourceEnvRef>();
        }
        return this.resourceEnvRef;
    }

    /**
     * Gets the value of the messageDestinationRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageDestinationRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageDestinationRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageDestinationRef }
     * 
     * 
     */
    public List<MessageDestinationRef> getMessageDestinationRef() {
        if (messageDestinationRef == null) {
            messageDestinationRef = new ArrayList<MessageDestinationRef>();
        }
        return this.messageDestinationRef;
    }

    /**
     * Gets the value of the securityRoleRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securityRoleRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurityRoleRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecurityRoleRef }
     * 
     * 
     */
    public List<SecurityRoleRef> getSecurityRoleRef() {
        if (securityRoleRef == null) {
            securityRoleRef = new ArrayList<SecurityRoleRef>();
        }
        return this.securityRoleRef;
    }

    /**
     * Gets the value of the securityIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityIdentity }
     *     
     */
    public SecurityIdentity getSecurityIdentity() {
        return securityIdentity;
    }

    /**
     * Sets the value of the securityIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityIdentity }
     *     
     */
    public void setSecurityIdentity(SecurityIdentity value) {
        this.securityIdentity = value;
    }

    /**
     * Gets the value of the query property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the query property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Query }
     * 
     * 
     */
    public List<Query> getQuery() {
        if (query == null) {
            query = new ArrayList<Query>();
        }
        return this.query;
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