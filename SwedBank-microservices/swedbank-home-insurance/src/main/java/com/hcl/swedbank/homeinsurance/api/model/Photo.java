package com.hcl.swedbank.homeinsurance.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * Photo
 */

public class Photo  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5989717065530806899L;

@JsonProperty("property-id")
  private Integer propertyId = null;

  @JsonProperty("extra-id")
  private Integer extraId = null;

  @JsonProperty("photo-name")
  private String photoName = null;

  @JsonProperty("photo-url")
  private String photoUrl = null;

  public Photo propertyId(Integer propertyId) {
    this.propertyId = propertyId;
    return this;
  }

   /**
   * Get propertyId
   * @return propertyId
  **/
  @ApiModelProperty(value = "")
  public Integer getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(Integer propertyId) {
    this.propertyId = propertyId;
  }

  public Photo extraId(Integer extraId) {
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

  public Photo photoName(String photoName) {
    this.photoName = photoName;
    return this;
  }

   /**
   * Get photoName
   * @return photoName
  **/
  @ApiModelProperty(value = "")
  public String getPhotoName() {
    return photoName;
  }

  public void setPhotoName(String photoName) {
    this.photoName = photoName;
  }

  public Photo photoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
    return this;
  }

   /**
   * Get photoUrl
   * @return photoUrl
  **/
  @ApiModelProperty(value = "")
  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Photo photo = (Photo) o;
    return Objects.equals(this.propertyId, photo.propertyId) &&
        Objects.equals(this.extraId, photo.extraId) &&
        Objects.equals(this.photoName, photo.photoName) &&
        Objects.equals(this.photoUrl, photo.photoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyId, extraId, photoName, photoUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Photo {\n");
    
    sb.append("    propertyId: ").append(toIndentedString(propertyId)).append("\n");
    sb.append("    extraId: ").append(toIndentedString(extraId)).append("\n");
    sb.append("    photoName: ").append(toIndentedString(photoName)).append("\n");
    sb.append("    photoUrl: ").append(toIndentedString(photoUrl)).append("\n");
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

