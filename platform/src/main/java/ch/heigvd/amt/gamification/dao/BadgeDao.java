package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Christopher Browne
 * @version 1.0
 */
public interface BadgeDao extends CrudRepository<Badge, Long> {

    Badge findByApplicationIdAndName(long id, String name);

    Badge findByApplicationIdAndId(long appId, long id);

    List<Badge> findAllByApplicationId(long id);

    @Transactional
    Long deleteByApplicationId(long appId);
}
