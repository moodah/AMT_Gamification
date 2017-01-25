package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

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

    List<Level> findAllByApplicationId(long applicationId);

    List<Level> findAllByApplicationIdOrderByPointsAsc(long applicationId);

    Level findTopByOrderByPointsAsc();

    Level findTopByPointsLessThanEqualOrderByPointsDesc(long points);

    @Transactional
    Long deleteByApplicationId(long appId);
}
