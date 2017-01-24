package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Eventtype;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 22.12.2016
 */
public interface EventtypeDao extends CrudRepository<Eventtype, Long> {

    Eventtype findByApplicationIdAndCode(long applicationId, BigDecimal code);

    List<Eventtype> findAllByApplicationId(long applicationId);
}
