package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 24.12.2016
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAllByApplicationId(long applicationId);

    List<User> findLimitedByApplicationId(long applicationId, Pageable pageable);

    User findByApplicationIdAndId(long applicationId, long id);
}
