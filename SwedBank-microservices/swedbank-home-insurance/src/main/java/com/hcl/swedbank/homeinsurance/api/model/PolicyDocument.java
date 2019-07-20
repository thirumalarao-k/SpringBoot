package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * PolicyDocument
 */

public class PolicyDocument  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6913146597319377803L;

@JsonProperty("policy-id")
  private Integer policyId = null;

  @JsonProperty("policy-name")
  private String policyName = null;

  @JsonProperty("policy-doc-url")
  private String policyDocUrl = null;

  public PolicyDocument policyId(Integer policyId) {
    this.policyId = policyId;
    return this;
  }

   /**
   * Get policyId
   * @return policyId
  **/
  @ApiModelProperty(value = "")
  public Integer getPolicyId() {
    return policyId;
  }

  public void setPolicyId(Integer policyId) {
    this.policyId = policyId;
  }

  public PolicyDocument policyName(String policyName) {
    this.policyName = policyName;
    return this;
  }

   /**
   * Get policyName
   * @return policyName
  **/
  @ApiModelProperty(value = "")
  public String getPolicyName() {
    return policyName;
  }

  public void setPolicyName(String policyName) {
    this.policyName = policyName;
  }

  public PolicyDocument policyDocUrl(String policyDocUrl) {
    this.policyDocUrl = policyDocUrl;
    return this;
  }

   /**
   * Get policyDocUrl
   * @return policyDocUrl
  **/
  @ApiModelProperty(value = "")
  public String getPolicyDocUrl() {
    return policyDocUrl;
  }

  public void setPolicyDocUrl(String policyDocUrl) {
    this.policyDocUrl = policyDocUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyDocument policyDocument = (PolicyDocument) o;
    return Objects.equals(this.policyId, policyDocument.policyId) &&
        Objects.equals(this.policyName, policyDocument.policyName) &&
        Objects.equals(this.policyDocUrl, policyDocument.policyDocUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyId, policyName, policyDocUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyDocument {\n");
    
    sb.append("    policyId: ").append(toIndentedString(policyId)).append("\n");
    sb.append("    policyName: ").append(toIndentedString(policyName)).append("\n");
    sb.append("    policyDocUrl: ").append(toIndentedString(policyDocUrl)).append("\n");
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

