package ru.hh.school.entity;

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
  //@GeneratedValue(/* здесь место для вашего кода */)
  @GeneratedValue(generator = "resumeIdSeq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "resumeIdSeq", sequenceName = "resume_id_seq", allocationSize = 10)
  private Integer id;
  @Column
  private String description;
  @Deprecated
  Resume() {}

  public Resume(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Resume resume = (Resume) o;
    return Objects.equals(id, resume.id) && Objects.equals(description, resume.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }
}
