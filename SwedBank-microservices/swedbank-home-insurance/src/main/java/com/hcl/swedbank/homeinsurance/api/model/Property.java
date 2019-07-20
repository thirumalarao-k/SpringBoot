package com.hcl.swedbank.homeinsurance.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * Property
 */

public class Property  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 828371290578387167L;

@JsonProperty("id")
  private Integer id = null;

  @JsonProperty("address-id")
  private Integer addressId = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("bedrooms")
  private Integer bedrooms = null;

  @JsonProperty("livingroom")
  private Integer livingroom = null;

  @JsonProperty("bathroom")
  private Integer bathroom = null;

  @JsonProperty("base-monthly-premium")
  private double baseMonthlyPremium = 0.0;

  @JsonProperty("base-yearly-premium")
  private double baseYearlyPremium = 0.0;

  public Property id(Integer id) {
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

  public Property addressId(Integer addressId) {
    this.addressId = addressId;
    return this;
  }

   /**
   * Get addressId
   * @return addressId
  **/
  @ApiModelProperty(value = "")
  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Property currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Property bedrooms(Integer bedrooms) {
    this.bedrooms = bedrooms;
    return this;
  }

   /**
   * Get bedrooms
   * @return bedrooms
  **/
  @ApiModelProperty(value = "")
  public Integer getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(Integer bedrooms) {
    this.bedrooms = bedrooms;
  }

  public Property livingroom(Integer livingroom) {
    this.livingroom = livingroom;
    return this;
  }

   /**
   * Get livingroom
   * @return livingroom
  **/
  @ApiModelProperty(value = "")
  public Integer getLivingroom() {
    return livingroom;
  }

  public void setLivingroom(Integer livingroom) {
    this.livingroom = livingroom;
  }

  public Property bathroom(Integer bathroom) {
    this.bathroom = bathroom;
    return this;
  }

   /**
   * Get bathroom
   * @return bathroom
  **/
  @ApiModelProperty(value = "")
  public Integer getBathroom() {
    return bathroom;
  }

  public void setBathroom(Integer bathroom) {
    this.bathroom = bathroom;
  }

  public Property baseMonthlyPremium(double baseMonthlyPremium) {
    this.baseMonthlyPremium = baseMonthlyPremium;
    return this;
  }

   /**
   * Get monthlyPremium
   * @return monthlyPremium
  **/
  @ApiModelProperty(value = "")
  public double getBaseMonthlyPremium() {
    return baseMonthlyPremium;
  }

  public void setMonthlyPremium(double d) {
    this.baseMonthlyPremium = d;
  }

  public Property baseYearlyPremium(double yearlyPremium) {
    this.baseYearlyPremium = yearlyPremium;
    return this;
  }

   /**
   * Get yearlyPremium
   * @return yearlyPremium
  **/
  @ApiModelProperty(value = "")
  public double getBaseYearlyPremium() {
    return baseYearlyPremium;
  }

  public void setBaseYearlyPremium(double baseYearlyPremium) {
    this.baseYearlyPremium = baseYearlyPremium;
  }
}

