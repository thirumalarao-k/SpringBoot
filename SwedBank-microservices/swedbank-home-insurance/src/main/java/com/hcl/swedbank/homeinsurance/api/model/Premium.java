package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * Premium
 */

public class Premium  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 3558666598506040340L;

@JsonProperty("monthly-premium")
  private double monthlyPremium;

  @JsonProperty("yearly-premium")
  private double yearlyPremium;

  public Premium monthlyPremium(double monthlyPremium) {
    this.monthlyPremium = monthlyPremium;
    return this;
  }

   /**
   * Get monthlyPremium
   * @return monthlyPremium
  **/
  @ApiModelProperty(value = "")
  public double getMonthlyPremium() {
    return monthlyPremium;
  }

  public void setMonthlyPremium(double monthlyPremium) {
    this.monthlyPremium = monthlyPremium;
  }

  public Premium yearlyPremium(double yearlyPremium) {
    this.yearlyPremium = yearlyPremium;
    return this;
  }

   /**
   * Get yearlyPremium
   * @return yearlyPremium
  **/
  @ApiModelProperty(value = "")
  public double getYearlyPremium() {
    return yearlyPremium;
  }

  public void setYearlyPremium(double yearlyPremium) {
    this.yearlyPremium = yearlyPremium;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Premium premium = (Premium) o;
    return Objects.equals(this.monthlyPremium, premium.monthlyPremium) &&
        Objects.equals(this.yearlyPremium, premium.yearlyPremium);
  }

  @Override
  public int hashCode() {
    return Objects.hash(monthlyPremium, yearlyPremium);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Premium {\n");
    
    sb.append("    monthlyPremium: ").append(toIndentedString(monthlyPremium)).append("\n");
    sb.append("    yearlyPremium: ").append(toIndentedString(yearlyPremium)).append("\n");
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

