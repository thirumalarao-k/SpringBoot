//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.13 at 04:09:38 PM IST 
//


package com.hcl.msa.parser.xml.struts.struts13.jaxbmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icon",
    "displayName",
    "description",
    "setProperty",
    "exception",
    "forward"
})
@XmlRootElement(name = "action")
public class Action {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(name = "attribute")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String attribute;
    @XmlAttribute(name = "cancellable")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cancellable;
    @XmlAttribute(name = "catalog")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String catalog;
    @XmlAttribute(name = "className")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String className;
    @XmlAttribute(name = "command")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String command;
    @XmlAttribute(name = "extends")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String _extends;
    @XmlAttribute(name = "include")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String include;
    @XmlAttribute(name = "input")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String input;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "parameter")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parameter;
    @XmlAttribute(name = "path", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String path;
    @XmlAttribute(name = "prefix")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String prefix;
    @XmlAttribute(name = "roles")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String roles;
    @XmlAttribute(name = "scope")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String scope;
    @XmlAttribute(name = "suffix")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String suffix;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "unknown")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String unknown;
    @XmlAttribute(name = "validate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String validate;
    protected Icon icon;
    @XmlElement(name = "display-name")
    protected DisplayName displayName;
    protected Description description;
    @XmlElement(name = "set-property")
    protected List<SetProperty> setProperty;
    protected List<Exception> exception;
    protected List<Forward> forward;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute(String value) {
        this.attribute = value;
    }

    /**
     * Gets the value of the cancellable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancellable() {
        return cancellable;
    }

    /**
     * Sets the value of the cancellable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancellable(String value) {
        this.cancellable = value;
    }

    /**
     * Gets the value of the catalog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * Sets the value of the catalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalog(String value) {
        this.catalog = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the command property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the value of the command property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommand(String value) {
        this.command = value;
    }

    /**
     * Gets the value of the extends property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtends() {
        return _extends;
    }

    /**
     * Sets the value of the extends property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtends(String value) {
        this._extends = value;
    }

    /**
     * Gets the value of the include property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInclude() {
        return include;
    }

    /**
     * Sets the value of the include property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInclude(String value) {
        this.include = value;
    }

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInput(String value) {
        this.input = value;
    }

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
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameter(String value) {
        this.parameter = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoles(String value) {
        this.roles = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the unknown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnknown() {
        return unknown;
    }

    /**
     * Sets the value of the unknown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnknown(String value) {
        this.unknown = value;
    }

    /**
     * Gets the value of the validate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidate() {
        return validate;
    }

    /**
     * Sets the value of the validate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidate(String value) {
        this.validate = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link Icon }
     *     
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Icon }
     *     
     */
    public void setIcon(Icon value) {
        this.icon = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayName }
     *     
     */
    public DisplayName getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayName }
     *     
     */
    public void setDisplayName(DisplayName value) {
        this.displayName = value;
    }

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
     * Gets the value of the setProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the setProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSetProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SetProperty }
     * 
     * 
     */
    public List<SetProperty> getSetProperty() {
        if (setProperty == null) {
            setProperty = new ArrayList<SetProperty>();
        }
        return this.setProperty;
    }

    /**
     * Gets the value of the exception property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exception property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getException().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Exception }
     * 
     * 
     */
    public List<Exception> getException() {
        if (exception == null) {
            exception = new ArrayList<Exception>();
        }
        return this.exception;
    }

    /**
     * Gets the value of the forward property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forward property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForward().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Forward }
     * 
     * 
     */
    public List<Forward> getForward() {
        if (forward == null) {
            forward = new ArrayList<Forward>();
        }
        return this.forward;
    }

}