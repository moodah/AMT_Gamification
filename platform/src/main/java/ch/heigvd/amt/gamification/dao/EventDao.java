package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 24.12.2016
 */
public interface EventDao extends CrudRepository<Event, Long> {

    List<Event> findAllByApplicationIdAndUserId(long appId, long userId);

    List<Event> findAllByApplicationId(long appId);

}
