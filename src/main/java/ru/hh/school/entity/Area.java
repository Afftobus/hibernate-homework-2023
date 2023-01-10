package ru.hh.school.entity;

import javax.persistence.*;
import java.util.Objects;

//TODO: оформите entity
@Entity
@Table(name = "area")
public class Area {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id")
  private Integer id;

  @Column(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Area() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Area area = (Area) o;
    return Objects.equals(id, area.id) && Objects.equals(name, area.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
