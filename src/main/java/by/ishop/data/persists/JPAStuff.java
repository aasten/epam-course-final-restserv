package by.ishop.data.persists;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by sten on 05.03.17.
 */
public enum JPAStuff {
    INSTANCE;

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("IShop");

    EntityManagerFactory getEntityManagerFactory() { return ENTITY_MANAGER_FACTORY; }
}
