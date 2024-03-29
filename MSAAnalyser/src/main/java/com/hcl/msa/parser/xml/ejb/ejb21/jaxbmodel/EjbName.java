//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.17 at 04:45:32 PM IST 
//


package com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 	
 * 
 * 	  The ejb-nameType specifies an enterprise bean's name. It is
 * 	  used by ejb-name elements. This name is assigned by the
 * 	  ejb-jar file producer to name the enterprise bean in the
 * 	  ejb-jar file's deployment descriptor. The name must be
 * 	  unique among the names of the enterprise beans in the same
 * 	  ejb-jar file.
 * 
 * 	  There is no architected relationship between the used
 * 	  ejb-name in the deployment descriptor and the JNDI name that
 * 	  the Deployer will assign to the enterprise bean's home.
 * 
 * 	  The name for an entity bean must conform to the lexical
 * 	  rules for an NMTOKEN.
 * 
 * 	  Example:
 * 
 * 	  <ejb-name>EmployeeService</ejb-name>
 * 
 * 	  
 *       
 * 
 * <p>Java class for ejb-name complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ejb-name">
 *   &lt;simpleContent>
 *     &lt;restriction base="&lt;http://java.sun.com/xml/ns/j2ee>xsdNMTOKEN">
 *     &lt;/restriction>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ejb-name")
public class EjbName
    extends XsdNMTOKEN
{


}
