package ch.heigvd.amt.gamification;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 14.12.2016
 */
public interface ExampleUserDao extends CrudRepository<ExampleUser, Long> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */
    public ExampleUser findByEmail(String email);
}
