package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Christopher Browne
 * @version 1.0
 */
public interface BadgeDao extends CrudRepository<Badge, Long> {

    Badge findByName(String name);

    Badge findById(Long id);

    List<Badge> findAllByApplicationId(long id);
}
