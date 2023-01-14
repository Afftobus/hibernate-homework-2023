package ru.hh.school.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

//TODO: оформите entity
@Entity
@Table(name = "resume")
public class Resume {
  // TODO: сделать так, чтобы id брался из sequence-а
  // таким образом, мы сможем отправлять в бд запросы батчами.
  // нужно учитывать, что описание sequence при создании таблицы также должно соответствовать
  // хиберовской сущности (см. create_resume.sql)
  //
  // Подробнее:
  // https://vladmihalcea.com/how-to-batch-insert-and-update-statements-with-hibernate/
  // https://vladmihalcea.com/from-jpa-to-hibernates-legacy-and-enhanced-identifier-generators/

  @Id
  @GeneratedValue(
          generator = "resume_seq",
          strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(
          name = "resume_seq",
          sequenceName = "resume_id_seq",
          allocationSize = 10)
  private Integer id;

  @Column(name = "description")
  private String description;

  public Resume() {}

  public Resume(String description) {
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Resume resume = (Resume) o;
    return id != null && Objects.equals(id, resume.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
