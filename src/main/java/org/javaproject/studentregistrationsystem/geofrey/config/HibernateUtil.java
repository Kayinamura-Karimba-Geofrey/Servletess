package org.javaproject.studentregistrationsystem.geofrey.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            // 🔥 FORCE DISABLE BEAN VALIDATION (code-level)
            cfg.setProperty("hibernate.validator.apply_to_ddl", "false");
            cfg.setProperty("hibernate.validator.autoregister_listeners", "false");

            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("❌ SessionFactory initialization failed.");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
