package ru.hh.school.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO: оформите entity
@Entity
@Table(name = "employer", schema = "public")
public class Employer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employer_id", nullable = false, updatable = false)
  private Integer id;

  @Column(name = "company_name", nullable = false)
  private String companyName;

  // не используйте java.util.Date
  // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic-datetime-java8
  @CreationTimestamp
  @Column(name = "creation_time", nullable = false, updatable = false)
  private LocalDateTime creationTime;

  @OneToMany(mappedBy = "employer",
          cascade = {CascadeType.ALL},
          orphanRemoval = true)
  private List<Vacancy> vacancies = new ArrayList<>();

  @Column(name = "block_time")
  private LocalDateTime blockTime;

  public List<Vacancy> getVacancies() {
    return vacancies;
  }

  public Integer getId() {
    return id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public LocalDateTime getBlockTime() {
    return blockTime;
  }

  public void setBlockTime(LocalDateTime blockTime) {
    this.blockTime = blockTime;
  }

  // статьи на тему реализации equals() и hashCode():
  //
  // https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
  // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Employer otherEmployer = (Employer) other;
    return id.equals(otherEmployer.getId());
  }

  @Override
  public int hashCode() {
    return (31 * id) ^ 2 + 31 * Objects.hash(companyName);
  }

}
