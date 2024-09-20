/*
 * @ (#) GrantAccessRepository.java    1.0    9/20/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.repositories;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 9/20/2024
 * @Version: 1.0
 *
 */

import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.entities.GrantAccessId;
import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.entities.Role;
import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.utils.AppUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class GrantAccessRepository {
    private EntityManager em = null;

    public GrantAccessRepository() {
        em = AppUtil.getEntityManagerFactory().createEntityManager();
    }

    //find role by account id from database
    public String findRoleIdByAccountId(String accountId) {
        String roleId = "";
        try {
            Query query = em.createQuery("SELECT ga.id.roleId FROM GrantAccess ga WHERE ga.id.accountId = :accountId");
            query.setParameter("accountId", accountId);
            roleId = (String) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleId;
    }
}
