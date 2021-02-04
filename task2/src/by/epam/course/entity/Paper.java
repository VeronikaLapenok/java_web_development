package by.epam.course.entity;

public class Paper {
  private boolean isGloss;
  private int density;
  
  private Size size;
  
  public Paper() {
    size = new Size();
  }
  
  public Paper(Boolean isGloss, int density, Size size) {
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
  
  public Size getSize() {
    return size;
  }
  
  public void setSize(Size size) {
    this.size = size;
  }
  
  
  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return true;
  }
  
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }
  
  
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("\nDensity: ");
    stringBuilder.append(density).append("\nIs gloss: ").append(isGloss);
    stringBuilder.append(size);
    
    return stringBuilder.toString();
  }
}
