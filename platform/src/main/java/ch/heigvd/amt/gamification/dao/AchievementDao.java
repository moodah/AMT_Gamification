package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Achievement;

import ch.heigvd.amt.gamification.model.Eventtype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AchievementDao extends CrudRepository<Achievement, Long> {

    List<Achievement> findAllByApplicationId(Long appId);

    Achievement findByApplicationIdAndId(Long appId, Long id);

    List<Achievement> findAllByApplicationIdAndEventtype(long appId, Eventtype eventtype);

    @Transactional
    Long deleteByApplicationId(long appId);
}
