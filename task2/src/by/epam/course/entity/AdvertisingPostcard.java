package by.epam.course.entity;

import java.time.LocalDate;

public class AdvertisingPostcard extends Postcard {
  String company;
  String webSite;
  
  public AdvertisingPostcard() {
    
  }
  
  public AdvertisingPostcard(String id, String name, String country, 
                             LocalDate year, String author, Paper paper) {
    super (id, name, country, year, author, paper);
  }
  
  public String getCompany() {
    return company;
  }
  
  public void setCompany(String company) {
    this.company = company;
  }
  
  public String getWebSite() {
    return webSite;
  }
  
  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }
  
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    
    if (object == null) {
      return false;
    }
    
    if (getClass() != object.getClass()) {
      return false;
    }
    
    AdvertisingPostcard other = (AdvertisingPostcard) object;
    
    if (company == null) {
      if (other.company != null) {
        return false;
      }
    } else if (!company.equals(other.company)) {
      return false;
    }
    
    if (webSite == null) {
      if (other.webSite != null) {
        return false;
      }
    } else if (!webSite.equals(other.webSite)) {
      return false;
    }
    
     return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    
    result = PRIME * result + ((company == null) ? 0 : company.hashCode());
    result = PRIME * result + ((webSite == null) ? 0 : webSite.hashCode());
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append(super.toString());
    stringBuilder.append("\nCompany: ").append(company);
    stringBuilder.append("\nweb-site: ").append(webSite).append("\n");
    
    return stringBuilder.toString();
  }

}
