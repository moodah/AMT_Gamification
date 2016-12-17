package ch.heigvd.amt.gamification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 14.12.2016
 */
@RestController
public class ExampleUserController {

    @Autowired
    private ExampleUserDao userDao;

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        String userId = "";
        try {
            ExampleUser user = new ExampleUser(email, name);
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "HttpErrorResponse creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    /**
     * /delete  --> Delete the user having the passed id.
     *
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            ExampleUser user = new ExampleUser(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "HttpErrorResponse deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            ExampleUser user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * /update  --> Update the email and the name for the user in the database 
     * having the passed id.
     *
     * @param id The id for the user to update.
     * @param email The new email.
     * @param name The new name.
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            ExampleUser user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "HttpErrorResponse updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
}
