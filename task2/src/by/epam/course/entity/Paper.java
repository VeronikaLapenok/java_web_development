package by.epam.course.entity;

public class Paper {
  private boolean isGloss;
  private int density;
  
  private PaperSize size;
  
  public Paper() {
    size = new PaperSize();
  }
  
  public Paper(Boolean isGloss, int density, PaperSize size) {
    this.isGloss = isGloss;
    this.density = density;
    this.size = size;
  }
  
  public boolean getIsGloss() {
    return isGloss;
  }
  
  public void setIsGloss(Boolean isGloss) {
    this.isGloss = isGloss;
  }
  
  public int getDensity() {
    return density;
  }
  
  public void setDensity(int density) {
    this.density = density;
  }
  
  public PaperSize getSize() {
    return size;
  }
  
  public void setSize(PaperSize size) {
    this.size = size;
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
    
    Paper other = (Paper) object;
    
    if (density != other.density) {
      return false;
    }
    
    if (isGloss != other.isGloss) {
      return false;
    }
     return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    
    result = PRIME * result + density;
    result = PRIME * result + (isGloss ? 1231 : 1237);
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("\nDensity: ");
    stringBuilder.append(density).append("\nIs gloss: ").append(isGloss);
    stringBuilder.append(size);
    
    return stringBuilder.toString();
  }
}
