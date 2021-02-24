package by.epam.course.repository;

import by.epam.course.entity.Cone;
import by.epam.course.specification.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository {
  private List<Cone> cones = new ArrayList<>();
  
  public boolean add(Cone cone) {
    return cones.add(cone);
  }
  
  public boolean addAll(Collection<? extends Cone> c) {
    return cones.addAll(c);
  }
  
  public boolean remove(Cone cone) {
    return cones.remove(cone);
  }
  
  public boolean removeAll(Collection<?> c) {
    return cones.removeAll(c);
  }
  
  public Cone get(int index) {
    return cones.get(index);
  }
  
  public Cone set(int index, Cone cone) {
    return cones.set(index, cone);
  }

  public List<Cone> query(Specification specification) {
    List<Cone> list = cones.stream().filter(o -> specification.specify(o)).collect(
        Collectors.toList());
    return list;
  }
  
  public List<Cone> sort(Comparator<Cone> comparator) {
    List<Cone> list = cones.stream().sorted(comparator).collect(Collectors.toList());
    return list;
  }
}
