package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Achievement;
import org.springframework.data.repository.CrudRepository;

public interface AchievementDao extends CrudRepository<Achievement, Long> {
}
