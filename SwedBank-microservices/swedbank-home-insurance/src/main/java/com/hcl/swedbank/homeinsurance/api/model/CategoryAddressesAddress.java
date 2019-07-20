package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * CategoryAddressesAddress
 */

public class CategoryAddressesAddress  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 662477614608519314L;

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

  public CategoryAddressesAddress line1(String line1) {
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

  public CategoryAddressesAddress line2(String line2) {
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

  public CategoryAddressesAddress line3(String line3) {
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

  public CategoryAddressesAddress city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public CategoryAddressesAddress country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CategoryAddressesAddress code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
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
    CategoryAddressesAddress categoryAddressesAddress = (CategoryAddressesAddress) o;
    return Objects.equals(this.line1, categoryAddressesAddress.line1) &&
        Objects.equals(this.line2, categoryAddressesAddress.line2) &&
        Objects.equals(this.line3, categoryAddressesAddress.line3) &&
        Objects.equals(this.city, categoryAddressesAddress.city) &&
        Objects.equals(this.country, categoryAddressesAddress.country) &&
        Objects.equals(this.code, categoryAddressesAddress.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line1, line2, line3, city, country, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAddressesAddress {\n");
    
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    line3: ").append(toIndentedString(line3)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

