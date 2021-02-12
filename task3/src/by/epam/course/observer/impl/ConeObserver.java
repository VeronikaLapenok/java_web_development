package by.epam.course.observer.impl;

import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.Cone;
import by.epam.course.entity.ConeParameters;
import by.epam.course.observer.ConeEvent;
import by.epam.course.observer.Observer;
import by.epam.course.warehouse.ConeWarehouse;

public class ConeObserver implements Observer {
  @Override
  public void parameterChanged(ConeEvent event) {
    Cone cone = event.getSource();
    ConeAction coneAction = new ConeAction();
    ConeParameters coneParameters = new ConeParameters(coneAction.findSquare(cone),
        coneAction.findVolume(cone));
    ConeWarehouse warehouse = ConeWarehouse.getInstance();
    warehouse.putConeParameters(cone.getConeId(), coneParameters);
  }
}
