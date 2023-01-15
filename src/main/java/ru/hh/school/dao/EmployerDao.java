package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.entity.Employer;

import java.time.LocalDateTime;

public class EmployerDao extends GenericDao {

  public EmployerDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  /**
   * TODO: здесь нужен метод, позволяющий сразу загрузить вакасии, связанные с работодателем и в некоторых случаях
   * избежать org.hibernate.LazyInitializationException
   * Также в запрос должен передаваться параметр employerId
   * <p>
   * https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/
   */
  public Employer getEager(int employerId) {
    return getSession()
        .createQuery("select employer " +
                "from Employer employer " +
                "left join fetch employer.vacancies " +
                "where employer.id = :employerId", Employer.class)
            .setParameter("employerId", employerId)
        .getSingleResult();
  }

  public void block(int employerId) {
    getSession().createQuery("update Employer employer " +
                    "set employer.blockTime = :blockTime " +
                    "where employer.id = :id")
            .setParameter("blockTime", LocalDateTime.now())
            .setParameter("id", employerId)
            .executeUpdate();
    getSession().createQuery("update Vacancy vac " +
                    "set vac.archivingTime = :archivingTime " +
                    "where vac.employer.id = :employerId")
            .setParameter("archivingTime", LocalDateTime.now())
            .setParameter("employerId", employerId)
            .executeUpdate();
  }

}
