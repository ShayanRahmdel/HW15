package repostory;

import java.util.Optional;

public interface ReportCardRepository {
    ReportCard saveOrUpdate(ReportCard reportCard);

    Optional<ReportCard> findById(Integer id);

    void deleteById(Integer id);


    void beginTransaction();

    void commitTransaction();

    void rollBack();


}
