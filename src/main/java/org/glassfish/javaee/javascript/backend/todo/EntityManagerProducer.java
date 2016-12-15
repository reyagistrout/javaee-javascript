package org.glassfish.javaee.javascript.backend.todo;

import org.glassfish.jersey.process.internal.RequestScoped;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;


/**
 * Created by Marilia Portela on 14/12/2016.
 */
@ApplicationScoped
public class EntityManagerProducer {

//    //or manual bootstrapping
//    @PersistenceContext(unitName="hsqldb")
//    private EntityManager entityManager;
//
//    @Produces
//    @RequestScoped
//    protected EntityManager createEntityManager()
//    {
//        return this.entityManager;
//    }
//
//    protected void closeEntityManager(@Disposes EntityManager entityManager)
//    {
//        if (entityManager.isOpen())
//        {
//            entityManager.close();
//        }
//    }
}
