package com.barracuda.rtdict.dao.hiber_util;

import com.barracuda.rtdict.yandex.translate.parser.word.gson.*;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {

            boolean initFromXML = true;

            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
            prop.setProperty("hibernate.connection.url", "jdbc:h2:./test");
            prop.setProperty("hibernate.connection.username", "admin");
            prop.setProperty("hibernate.connection.password", "admin");
            prop.setProperty("hibernate.default_schema", "PUBLIC");
            // SQL dialect
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            // Drop and re-create the database schema on startup
            prop.setProperty("hbm2ddl.auto", "create"); // update
            // JDBC connection pool (use the built-in)
            prop.setProperty("connection.pool_size", "1");
            // Disable the second-level cache
            prop.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
            // Echo all executed SQL to stdout
            prop.setProperty("show_sql", "true");
            prop.setProperty("hibernate.format_sql", "true");

            Configuration configuration = new Configuration();

            if (initFromXML) {

                configuration.configure();
                //configuration.setProperty("hibernate.connection.url", "jdbc:h2:./test");
                //При вызове метода configure() без параметров, настройки беруться из файла nibernate.cfg.xml
                // new Configuration().addResource("hibernate.cfg.xml").configure();
                // configuration.configure("/com/rtw/test/hiber/hibernate.cfg.xml");
                System.out.println("______________________________________");
                System.out.println(configuration.getProperties());
            } else {
                // we can set mapping file or class with annotation
                // addClass(Employee1.class) will look for resource
                // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
                configuration
                        .addProperties(prop)
                        .addAnnotatedClass(Word.class)
                        .addAnnotatedClass(Def.class)
                        .addAnnotatedClass(Tr.class)
                        .addAnnotatedClass(Syn.class)
                        .addAnnotatedClass(Mean.class)
                        .addAnnotatedClass(Ex.class)
                        .addAnnotatedClass(TrSecond.class);
            }

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            serviceRegistry = builder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            //sessionFactory = new Configuration().configure().buildSessionFactory(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
