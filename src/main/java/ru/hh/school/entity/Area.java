package ru.hh.school.entity;

import org.hibernate.Hibernate;

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
  @Column(name = "name", nullable = false)
  private String name;
  @Deprecated
  public Area() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Area area = (Area) o;
    return id != null && Objects.equals(id, area.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
