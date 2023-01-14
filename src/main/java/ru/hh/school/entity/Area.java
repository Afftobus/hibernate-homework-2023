package ru.hh.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO: оформите entity
@Entity
@Table(name = "area")
public class Area {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id")
  private Integer id;
  @Column(name = "name", nullable = false)
  private String name;

  public Area() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Area area = (Area) o;

    return name.equals(area.getName());
  }

  @Override
  public int hashCode() {
    int hash = id * id;
    hash = 31 * hash + (name == null ? 0 : name.hashCode());
    return 31 * hash;
  }
}
