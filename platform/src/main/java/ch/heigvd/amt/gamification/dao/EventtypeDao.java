package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Eventtype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 22.12.2016
 */
public interface EventtypeDao extends CrudRepository<Eventtype, Long> {

    Eventtype findByApplicationIdAndId(long applicationId, long id);

    List<Eventtype> findAllByApplicationId(long applicationId);

    @Transactional
    Long deleteByApplicationId(long appId);
}
