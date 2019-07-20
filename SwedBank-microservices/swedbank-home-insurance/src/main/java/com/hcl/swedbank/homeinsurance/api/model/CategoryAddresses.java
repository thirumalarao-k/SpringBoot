package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.swedbank.homeinsurance.api.model.CategoryAddressesAddress;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * CategoryAddresses
 */

public class CategoryAddresses  implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 5277811415091000769L;

@JsonProperty("id")
  private Integer id = null;

  @JsonProperty("address")
  private CategoryAddressesAddress address = null;

  @JsonProperty("latitude")
  private String latitude = null;

  @JsonProperty("longitude")
  private String longitude = null;

  @JsonProperty("totalarea")
  private String totalarea = null;

  public CategoryAddresses id(Integer id) {
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

  public CategoryAddresses address(CategoryAddressesAddress address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public CategoryAddressesAddress getAddress() {
    return address;
  }

  public void setAddress(CategoryAddressesAddress address) {
    this.address = address;
  }

  public CategoryAddresses latitude(String latitude) {
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

  public CategoryAddresses longitude(String longitude) {
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

  public CategoryAddresses totalarea(String totalarea) {
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
    CategoryAddresses categoryAddresses = (CategoryAddresses) o;
    return Objects.equals(this.id, categoryAddresses.id) &&
        Objects.equals(this.address, categoryAddresses.address) &&
        Objects.equals(this.latitude, categoryAddresses.latitude) &&
        Objects.equals(this.longitude, categoryAddresses.longitude) &&
        Objects.equals(this.totalarea, categoryAddresses.totalarea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, latitude, longitude, totalarea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAddresses {\n");
    
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

