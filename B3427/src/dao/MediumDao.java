package dao;

import java.util.List;
import modele.Medium;

/**
 *
 * @author elepeigneu
 */
public interface MediumDao {

    public Medium findMediumById(long id);

    public Medium findMediumByName(String name);

    public void createMedium(Medium medium);

    public List<Medium> getAllMedium();
}
