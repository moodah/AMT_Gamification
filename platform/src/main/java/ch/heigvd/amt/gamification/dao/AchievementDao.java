package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Achievement;

import ch.heigvd.amt.gamification.model.Eventtype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AchievementDao extends CrudRepository<Achievement, Long> {

    List<Achievement> findAllByApplicationId(long appId);

    Achievement findByApplicationIdAndId(long appId, long id);

    List<Achievement> findAllByApplicationIdAndEventtype(long appId, Eventtype eventtype);

    @Transactional
    long deleteByApplicationId(long appId);
}
