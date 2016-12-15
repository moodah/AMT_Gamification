package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Application;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 15.12.2016
 */
public interface ApplicationDao extends CrudRepository<Application, Long> {
    /**
     * This method will find an Application instance in the database by its name and password.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */
    public Application findByNameAndPassword(String name, String password);
}
