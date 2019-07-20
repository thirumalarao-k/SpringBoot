package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.swedbank.homeinsurance.api.model.PersonaldetailsOwnerAddressesAddress;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * PersonaldetailsOwnerAddresses
 */

public class PersonaldetailsOwnerAddresses  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = -1761643642374413098L;

@JsonProperty("id")
  private Integer id = null;

  @JsonProperty("address")
  private PersonaldetailsOwnerAddressesAddress address = null;

  @JsonProperty("latitude")
  private String latitude = null;

  @JsonProperty("longitude")
  private String longitude = null;

  @JsonProperty("totalarea")
  private String totalarea = null;

  public PersonaldetailsOwnerAddresses id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PersonaldetailsOwnerAddresses address(PersonaldetailsOwnerAddressesAddress address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public PersonaldetailsOwnerAddressesAddress getAddress() {
    return address;
  }

  public void setAddress(PersonaldetailsOwnerAddressesAddress address) {
    this.address = address;
  }

  public PersonaldetailsOwnerAddresses latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

   /**
   * Get latitude
   * @return latitude
  **/
  @ApiModelProperty(value = "")
  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public PersonaldetailsOwnerAddresses longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }

   /**
   * Get longitude
   * @return longitude
  **/
  @ApiModelProperty(value = "")
  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public PersonaldetailsOwnerAddresses totalarea(String totalarea) {
    this.totalarea = totalarea;
    return this;
  }

   /**
   * Get totalarea
   * @return totalarea
  **/
  @ApiModelProperty(value = "")
  public String getTotalarea() {
    return totalarea;
  }

  public void setTotalarea(String totalarea) {
    this.totalarea = totalarea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaldetailsOwnerAddresses personaldetailsOwnerAddresses = (PersonaldetailsOwnerAddresses) o;
    return Objects.equals(this.id, personaldetailsOwnerAddresses.id) &&
        Objects.equals(this.address, personaldetailsOwnerAddresses.address) &&
        Objects.equals(this.latitude, personaldetailsOwnerAddresses.latitude) &&
        Objects.equals(this.longitude, personaldetailsOwnerAddresses.longitude) &&
        Objects.equals(this.totalarea, personaldetailsOwnerAddresses.totalarea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, latitude, longitude, totalarea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaldetailsOwnerAddresses {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    totalarea: ").append(toIndentedString(totalarea)).append("\n");
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

