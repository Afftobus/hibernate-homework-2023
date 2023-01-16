package ru.hh.school.entity;

import javax.persistence.*;

//Оформите entity.
@Entity
@Table(name = "area")
public class Area {
  @Id
  @Column(name = "area_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(mappedBy = "area", cascade = CascadeType.ALL)
  private Vacancy vacancy;

  @Column(nullable = false)
  private String name;

  public Area() {}
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
