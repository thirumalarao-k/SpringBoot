package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * Extra
 */

public class Extra  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = -8661080003013484683L;

@JsonProperty("extra-id")
  private Integer extraId = null;

  @JsonProperty("extra-name")
  private String extraName = null;

  public Extra extraId(Integer extraId) {
    this.extraId = extraId;
    return this;
  }

   /**
   * Get extraId
   * @return extraId
  **/
  @ApiModelProperty(value = "")
  public Integer getExtraId() {
    return extraId;
  }

  public void setExtraId(Integer extraId) {
    this.extraId = extraId;
  }

  public Extra extraName(String extraName) {
    this.extraName = extraName;
    return this;
  }

   /**
   * Get extraName
   * @return extraName
  **/
  @ApiModelProperty(value = "")
  public String getExtraName() {
    return extraName;
  }

  public void setExtraName(String extraName) {
    this.extraName = extraName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Extra extra = (Extra) o;
    return Objects.equals(this.extraId, extra.extraId) &&
        Objects.equals(this.extraName, extra.extraName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extraId, extraName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Extra {\n");
    
    sb.append("    extraId: ").append(toIndentedString(extraId)).append("\n");
    sb.append("    extraName: ").append(toIndentedString(extraName)).append("\n");
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

