package ru.hh.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * // не используйте java.util.Date
 * // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic-datetime-java8
 * <p>
 * // статьи на тему реализации equals() и hashCode():
 * //
 * // https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
 * // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
 */
@Entity
public class Employer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employer_id")
  private Integer id;
  @Column(name = "company_name")
  private String companyName;

  @Column(name = "creation_time")
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

  public Employer() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Employer employer = (Employer) o;

    if (!companyName.equals(employer.companyName)) return false;
    return creationTime.equals(employer.creationTime);
  }

  @Override
  public int hashCode() {
    int result = companyName.hashCode();
    result = 31 * result + creationTime.hashCode();
    return result;
  }
}
