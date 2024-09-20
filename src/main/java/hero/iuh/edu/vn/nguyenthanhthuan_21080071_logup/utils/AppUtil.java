/*
 * @ (#) AppUtil.java    1.0    9/15/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.utils;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 9/15/2024
 * @Version: 1.0
 *
 */

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppUtil {
    private static final String name_Persistence_Unit = "my-app";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(name_Persistence_Unit);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
