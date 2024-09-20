/*
 * @ (#) AccountRepositry.java    1.0    9/8/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.repositories;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 9/8/2024
 * @Version: 1.0
 *
 */

import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.entities.Account;
import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.utils.AppUtil;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.Optional;

public class AccountRepositry {
    //Login
    public Optional<Account> login(String email, String password) throws SQLException, ClassNotFoundException {
        EntityManager entityManager = null;

        try {
            entityManager = AppUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            Account account = (Account) entityManager.createNamedQuery("Account.findByEmailAndPassword")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();

            entityManager.getTransaction().commit();
            return Optional.of(account);
        } catch (Exception e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return Optional.empty();
    }

    //add account
    public boolean add(Account account){
        EntityManager em = null;
        try{
            em = AppUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null){
                em.close();
            }
        }
        return false;
    }



}
