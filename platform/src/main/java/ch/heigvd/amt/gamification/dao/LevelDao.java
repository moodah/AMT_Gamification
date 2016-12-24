package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Level;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 20.12.2016
 */
public interface LevelDao extends CrudRepository<Level, Long> {

    Level findByApplicationIdAndId(long applicationId, long id);

    Level findByApplicationIdAndName(long applicationId, String name);

    Level findByName(String name);

    Long deleteByApplicationId(long applicationId);

    List<Level> findAllByApplicationId(long applicationId);

    List<Level> findAllByApplicationIdOrderByPointsAsc(long applicationId);

    Long deleteAllByApplicationId(long applicationId);

    Level findTopByOrderByPointsAsc();

    Level findTopByPointsLessThanEqualOrderByPointsDesc(BigDecimal points);

}
