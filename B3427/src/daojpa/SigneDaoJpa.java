package daojpa;

import dao.SigneDao;
import java.util.List;
import javax.persistence.Query;
import modele.Signe;

/**
 *
 * @author elepeigneu
 */
public class SigneDaoJpa implements SigneDao {

    @Override
    public void createSigne(Signe signe) {
        JpaUtil.obtenirEntityManager().persist(signe);
    }

    @Override
    public Signe findSigneByNumMois(int numMois) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Signe s where s.numMois= :sig");
        query.setParameter("sig", numMois);
        List<Signe> result = (List<Signe>) query.getResultList();
        return (result.isEmpty() ? null : result.get(0));
    }

}
