package br.com.brunobs.bswvendas.modulo.util;

import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "HibernateSession";

    static {
        try {

            Configuration configuration = new Configuration().configure();
            configuration
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(DescricaoPreco.class)
                    .addAnnotatedClass(Precos.class)
                    .addAnnotatedClass(Produto.class)
                    .addAnnotatedClass(Unidade.class);
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao iniciar a Session Factory\n" + ex);
            throw new ExceptionInInitializerError(ex);
        }
            System.out.println("SessionFactory Criada com sucesso!");
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
