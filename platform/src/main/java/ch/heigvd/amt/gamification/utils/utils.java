package ch.heigvd.amt.gamification.utils;

import ch.heigvd.amt.gamification.dao.AchievementDao;
import ch.heigvd.amt.gamification.dao.BadgeDao;
import ch.heigvd.amt.gamification.dao.EventDao;
import ch.heigvd.amt.gamification.dao.LevelDao;
import ch.heigvd.amt.gamification.dto.BadgePresentationDTO;
import ch.heigvd.amt.gamification.dto.LevelPresentationDTO;
import ch.heigvd.amt.gamification.dto.UserPresentationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.*;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * utils
 */
public class utils {
    public static UserPresentationDTO getUserInfo(long appId, long id, AchievementDao achievementDao, BadgeDao badgeDao, EventDao eventDao, LevelDao levelDao){

        List<Event> events = eventDao.findAllByApplicationIdAndUserId(appId, id);

        if (events == null || events.size() == 0){
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("User", String.valueOf(id)));
        }

        HashMap<Eventtype, Integer> eventtypeIntegerHashMap = new HashMap<>();

        long points = 0;

        for (Event event : events) {
            points += event.getEventtype().getPoints().longValue();
            Integer count = eventtypeIntegerHashMap.get(event.getEventtype());
            if (count == null) {
                eventtypeIntegerHashMap.put(event.getEventtype(), 1);
            } else {
                count = count + 1;
            }
        }

        List<Achievement> potentialAchievements = new ArrayList<>();
        eventtypeIntegerHashMap.forEach((eventtype, integer) -> {
            achievementDao.findAllByApplicationIdAndEventtype(appId, eventtype).forEach(achievement -> {
                if (!potentialAchievements.contains(achievement)) {
                    potentialAchievements.add(achievement);
                }
            });
        });

        List<Achievement> achievements = new ArrayList<>();
        potentialAchievements.forEach(achievement -> {
            eventtypeIntegerHashMap.forEach((eventtype, integer) -> {
                if (achievement.getEventtype() == eventtype && achievement.getCount() <= integer) {
                    achievements.add(achievement);
                }
            });
        });

        List<Badge> potentialBadges = badgeDao.findAllByApplicationId(appId);
        List<Badge> badges = new ArrayList<>();

        potentialBadges.forEach(badge -> {
            int c = badge.getAchievements().size();
            for (Achievement achievement : badge.getAchievements()) {
                if (achievements.contains(achievement)) {
                    c--;
                }
            }
            if (c == 0) {
                badges.add(badge);
            }
        });

        Level level = levelDao.findTopByPointsLessThanEqualOrderByPointsDesc(new BigDecimal(points));

        LevelPresentationDTO levelPresentationDTO;

        if (level == null) {
            levelPresentationDTO = new LevelPresentationDTO(0, "none", new BigDecimal(0));
        } else {
            levelPresentationDTO = new LevelPresentationDTO(level);
        }

        List<BadgePresentationDTO> badgePresentationDTOList = new ArrayList<>();
        badges.forEach(badge -> {
            badgePresentationDTOList.add(new BadgePresentationDTO(badge));
        });

        return new UserPresentationDTO(id,
                points,
                levelPresentationDTO,
                badgePresentationDTOList);
    }
}
