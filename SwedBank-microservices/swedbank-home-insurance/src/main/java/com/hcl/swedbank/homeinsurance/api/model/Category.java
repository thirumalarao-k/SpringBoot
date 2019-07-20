package com.hcl.swedbank.homeinsurance.api.model;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.swedbank.homeinsurance.api.model.CategoryAddresses;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * Category
 */

public class Category  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 4327537734561623815L;

/**
	 * 
	 */

@JsonProperty("category")
  private String category = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("addresses")
  private List<CategoryAddresses> addresses = null;

  public Category category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Category name(String name) {
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

  public Category addresses(List<CategoryAddresses> addresses) {
    this.addresses = addresses;
    return this;
  }

   /**
   * Get addresses
   * @return addresses
  **/
  @ApiModelProperty(value = "")
  public List<CategoryAddresses> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<CategoryAddresses> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.category, category.category) &&
        Objects.equals(this.name, category.name) &&
        Objects.equals(this.addresses, category.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, name, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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

