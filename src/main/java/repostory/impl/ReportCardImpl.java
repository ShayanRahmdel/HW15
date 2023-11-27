package repostory.impl;

import lombok.RequiredArgsConstructor;
import repostory.ReportCardRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class ReportCardImpl implements ReportCardRepository {
    EntityManager entityManager;
    @Override
    public ReportCard saveOrUpdate(ReportCard reportCard) {
        beginTransaction();
        reportCard = saveWithoutTransaction(reportCard);
        commitTransaction();
        entityManager.clear();
        return reportCard;
    }

    private ReportCard saveWithoutTransaction(ReportCard reportCard) {
        if (reportCard.getId() == null)
            entityManager.persist(reportCard);
        else
            reportCard = entityManager.merge(reportCard);
        return reportCard;
    }

    @Override
    public Optional<ReportCard> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(ReportCard.class, id));
    }

    @Override
    public void deleteById(Integer id) {
        beginTransaction();
        ReportCard reportCard = entityManager.find(ReportCard.class, id);
        entityManager.remove(reportCard);
        commitTransaction();
    }


    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    @Override
    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }


}
