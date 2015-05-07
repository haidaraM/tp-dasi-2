package dao;

import modele.Signe;

/**
 *
 * @author elepeigneu
 */
public interface SigneDao {

    public void createSigne(Signe signe);

    public Signe findSigneByNumMois(int numMois);

}
