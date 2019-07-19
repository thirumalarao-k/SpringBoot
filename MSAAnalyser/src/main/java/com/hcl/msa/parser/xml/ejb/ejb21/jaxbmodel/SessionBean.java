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
 * 	The session-beanType declares an session bean. The
 * 	declaration consists of:
 * 
 * 	    - an optional description
 * 	    - an optional display name
 * 	    - an optional icon element that contains a small and a large
 * 	      icon file name
 * 	    - a name assigned to the enterprise bean
 * 	      in the deployment description
 * 	    - the names of the session bean's remote home and
 * 	      remote interfaces, if any
 * 	    - the names of the session bean's local home and
 * 	      local interfaces, if any
 * 	    - the name of the session bean's web service endpoint
 * 	      interface, if any
 * 	    - the session bean's implementation class
 * 	    - the session bean's state management type
 * 	    - the session bean's transaction management type
 * 	    - an optional declaration of the bean's
 * 	      environment entries
 * 	    - an optional declaration of the bean's EJB references
 * 	    - an optional declaration of the bean's local
 * 	      EJB references
 * 	    - an optional declaration of the bean's web
 * 	      service references
 * 	    - an optional declaration of the security role
 * 	      references
 * 	    - an optional declaration of the security identity
 * 	      to be used for the execution of the bean's methods
 * 	    - an optional declaration of the bean's resource
 * 	      manager connection factory references
 * 	    - an optional declaration of the bean's resource
 * 	      environment references.
 * 	    - an optional declaration of the bean's message
 * 	      destination references
 * 
 * 	The elements that are optional are "optional" in the sense
 * 	that they are omitted when if lists represented by them are
 * 	empty.
 * 
 * 	Either both the local-home and the local elements or both
 * 	the home and the remote elements must be specified for the
 * 	session bean.
 * 
 * 	The service-endpoint element may only be specified if the
 * 	bean is a stateless session bean.
 * 
 *       
 * 
 * <p>Java class for session-bean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="session-bean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://java.sun.com/xml/ns/j2ee}descriptionGroup"/>
 *         &lt;element name="ejb-name" type="{http://java.sun.com/xml/ns/j2ee}ejb-name"/>
 *         &lt;element name="home" type="{http://java.sun.com/xml/ns/j2ee}home" minOccurs="0"/>
 *         &lt;element name="remote" type="{http://java.sun.com/xml/ns/j2ee}remote" minOccurs="0"/>
 *         &lt;element name="local-home" type="{http://java.sun.com/xml/ns/j2ee}local-home" minOccurs="0"/>
 *         &lt;element name="local" type="{http://java.sun.com/xml/ns/j2ee}local" minOccurs="0"/>
 *         &lt;element name="service-endpoint" type="{http://java.sun.com/xml/ns/j2ee}fully-qualified-class" minOccurs="0"/>
 *         &lt;element name="ejb-class" type="{http://java.sun.com/xml/ns/j2ee}ejb-class"/>
 *         &lt;element name="session-type" type="{http://java.sun.com/xml/ns/j2ee}session-type"/>
 *         &lt;element name="transaction-type" type="{http://java.sun.com/xml/ns/j2ee}transaction-type"/>
 *         &lt;group ref="{http://java.sun.com/xml/ns/j2ee}jndiEnvironmentRefsGroup"/>
 *         &lt;element name="security-role-ref" type="{http://java.sun.com/xml/ns/j2ee}security-role-ref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="security-identity" type="{http://java.sun.com/xml/ns/j2ee}security-identity" minOccurs="0"/>
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
@XmlType(name = "session-bean", propOrder = {
    "description",
    "displayName",
    "icon",
    "ejbName",
    "home",
    "remote",
    "localHome",
    "local",
    "serviceEndpoint",
    "ejbClass",
    "sessionType",
    "transactionType",
    "envEntry",
    "ejbRef",
    "ejbLocalRef",
    "serviceRef",
    "resourceRef",
    "resourceEnvRef",
    "messageDestinationRef",
    "securityRoleRef",
    "securityIdentity"
})
public class SessionBean {

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
    @XmlElement(name = "service-endpoint")
    protected FullyQualifiedClass serviceEndpoint;
    @XmlElement(name = "ejb-class", required = true)
    protected EjbClass ejbClass;
    @XmlElement(name = "session-type", required = true)
    protected SessionType sessionType;
    @XmlElement(name = "transaction-type", required = true)
    protected TransactionType transactionType;
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
     * Gets the value of the serviceEndpoint property.
     * 
     * @return
     *     possible object is
     *     {@link FullyQualifiedClass }
     *     
     */
    public FullyQualifiedClass getServiceEndpoint() {
        return serviceEndpoint;
    }

    /**
     * Sets the value of the serviceEndpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullyQualifiedClass }
     *     
     */
    public void setServiceEndpoint(FullyQualifiedClass value) {
        this.serviceEndpoint = value;
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
     * Gets the value of the sessionType property.
     * 
     * @return
     *     possible object is
     *     {@link SessionType }
     *     
     */
    public SessionType getSessionType() {
        return sessionType;
    }

    /**
     * Sets the value of the sessionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionType }
     *     
     */
    public void setSessionType(SessionType value) {
        this.sessionType = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
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