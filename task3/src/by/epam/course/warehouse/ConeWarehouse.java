package by.epam.course.warehouse;

import by.epam.course.entity.ConeParameters;

import java.util.HashMap;
import java.util.Map;

public class ConeWarehouse {
  private final static ConeWarehouse INSTANCE = new ConeWarehouse();
  private Map<Integer, ConeParameters> coneParametersMap = new HashMap<>();
  
  public static ConeWarehouse getInstance() {
    return INSTANCE;
  }
  
  public ConeParameters getConeParameters(int coneId) {
    return coneParametersMap.get(coneId);
  }
  
  public void putConeParameters(int coneId, ConeParameters coneParameters) {
    coneParametersMap.put(coneId, coneParameters);
  }
  
  public void setConeParametersMap(Map<Integer, ConeParameters> coneParametersMap) {
    this.coneParametersMap = coneParametersMap;
  }
  
  public void removeConeParameters(Integer coneId) {
    coneParametersMap.remove(coneId);
  }
}
