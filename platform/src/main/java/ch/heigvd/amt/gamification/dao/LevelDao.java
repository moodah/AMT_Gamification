package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Level;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 20.12.2016
 */
public interface LevelDao extends CrudRepository<Level, Long> {

    Level findByName(long applicationId, String levelName);
}
