package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Christopher Browne
 * @version 1.0
 */
public interface BadgeDao extends CrudRepository<Badge, Long> {

    Badge findByName(String name);

    Badge findById(Long id);
}
