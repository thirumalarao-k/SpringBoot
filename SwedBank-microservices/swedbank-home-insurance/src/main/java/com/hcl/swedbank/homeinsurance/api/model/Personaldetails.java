package com.hcl.swedbank.homeinsurance.api.model;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.swedbank.homeinsurance.api.model.PersonaldetailsOwnerAddresses;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * Personaldetails
 */

public class Personaldetails  implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = -6129447626502255749L;

@JsonProperty("personal-id")
  private Integer personalId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("Owner addresses")
  private List<PersonaldetailsOwnerAddresses> ownerAddresses = null;

  @JsonProperty("Renter addresses")
  private List<PersonaldetailsOwnerAddresses> renterAddresses = null;

  public Personaldetails personalId(Integer personalId) {
    this.personalId = personalId;
    return this;
  }

   /**
   * Get personalId
   * @return personalId
  **/
  @ApiModelProperty(value = "")
  public Integer getPersonalId() {
    return personalId;
  }

  public void setPersonalId(Integer personalId) {
    this.personalId = personalId;
  }

  public Personaldetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Personaldetails ownerAddresses(List<PersonaldetailsOwnerAddresses> ownerAddresses) {
    this.ownerAddresses = ownerAddresses;
    return this;
  }

   /**
   * Get ownerAddresses
   * @return ownerAddresses
  **/
  @ApiModelProperty(value = "")
  public List<PersonaldetailsOwnerAddresses> getOwnerAddresses() {
    return ownerAddresses;
  }

  public void setOwnerAddresses(List<PersonaldetailsOwnerAddresses> ownerAddresses) {
    this.ownerAddresses = ownerAddresses;
  }

  public Personaldetails renterAddresses(List<PersonaldetailsOwnerAddresses> renterAddresses) {
    this.renterAddresses = renterAddresses;
    return this;
  }

   /**
   * Get renterAddresses
   * @return renterAddresses
  **/
  @ApiModelProperty(value = "")
  public List<PersonaldetailsOwnerAddresses> getRenterAddresses() {
    return renterAddresses;
  }

  public void setRenterAddresses(List<PersonaldetailsOwnerAddresses> renterAddresses) {
    this.renterAddresses = renterAddresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Personaldetails personaldetails = (Personaldetails) o;
    return Objects.equals(this.personalId, personaldetails.personalId) &&
        Objects.equals(this.name, personaldetails.name) &&
        Objects.equals(this.ownerAddresses, personaldetails.ownerAddresses) &&
        Objects.equals(this.renterAddresses, personaldetails.renterAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personalId, name, ownerAddresses, renterAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Personaldetails {\n");
    
    sb.append("    personalId: ").append(toIndentedString(personalId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerAddresses: ").append(toIndentedString(ownerAddresses)).append("\n");
    sb.append("    renterAddresses: ").append(toIndentedString(renterAddresses)).append("\n");
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

