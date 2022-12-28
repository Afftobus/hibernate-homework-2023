package ru.hh.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * // DONE: сделать так, чтобы id брался из sequence-а
 * // таким образом, мы сможем отправлять в бд запросы батчами.
 * // нужно учитывать, что описание sequence при создании таблицы также должно соответствовать
 * // хиберовской сущности (см. create_resume.sql)
 * //
 * // Подробнее:
 * // https://vladmihalcea.com/how-to-batch-insert-and-update-statements-with-hibernate/
 * // https://vladmihalcea.com/from-jpa-to-hibernates-legacy-and-enhanced-identifier-generators/
 */
@Entity
public class Resume {
  @Id
  @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "sequence", sequenceName = "resume_id_seq", allocationSize = 10)
  private Integer id;

  private String description;

  public Resume() {
  }

  public Resume(String description) {
    this.description = description;
  }

}
