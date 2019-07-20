package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * PersonaldetailsOwnerAddressesAddress
 */

public class PersonaldetailsOwnerAddressesAddress  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = -3344568722606414322L;

@JsonProperty("line1")
  private String line1 = null;

  @JsonProperty("line2")
  private String line2 = null;

  @JsonProperty("line3")
  private String line3 = null;

  @JsonProperty("city")
  private String city = null;
  
  @JsonProperty("country")
  private String country = null;

  @JsonProperty("code")
  private String code = null;

  public PersonaldetailsOwnerAddressesAddress line1(String line1) {
    this.line1 = line1;
    return this;
  }

   /**
   * Get line1
   * @return line1
  **/
  @ApiModelProperty(value = "")
  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public PersonaldetailsOwnerAddressesAddress line2(String line2) {
    this.line2 = line2;
    return this;
  }

   /**
   * Get line2
   * @return line2
  **/
  @ApiModelProperty(value = "")
  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public PersonaldetailsOwnerAddressesAddress line3(String line3) {
    this.line3 = line3;
    return this;
  }

   /**
   * Get line3
   * @return line3
  **/
  @ApiModelProperty(value = "")
  public String getLine3() {
    return line3;
  }

  public void setLine3(String line3) {
    this.line3 = line3;
  }

  public PersonaldetailsOwnerAddressesAddress city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
  
  @ApiModelProperty(value = "")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
  
  @ApiModelProperty(value = "")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaldetailsOwnerAddressesAddress personaldetailsOwnerAddressesAddress = (PersonaldetailsOwnerAddressesAddress) o;
    return Objects.equals(this.line1, personaldetailsOwnerAddressesAddress.line1) &&
        Objects.equals(this.line2, personaldetailsOwnerAddressesAddress.line2) &&
        Objects.equals(this.line3, personaldetailsOwnerAddressesAddress.line3) &&
        Objects.equals(this.city, personaldetailsOwnerAddressesAddress.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line1, line2, line3, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaldetailsOwnerAddressesAddress {\n");
    
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    line3: ").append(toIndentedString(line3)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

