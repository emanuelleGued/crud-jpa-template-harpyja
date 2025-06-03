package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ActivityDAO;
import br.edu.ifpb.es.daw.dao.impl.ActivityDAOImpl;
import br.edu.ifpb.es.daw.entities.Activity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainActivityDeleteAll {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ActivityDAO activityDao = new ActivityDAOImpl(emf);

            System.out.println("Deletando todas as Activities...");
            List<Activity> activities = activityDao.getAll();
            for (Activity activity : activities) {
                System.out.println("Deletando Activity: " + activity.getId() +
                        " - Session: " + (activity.getSession() != null ? activity.getSession().getId() : "null"));
                activityDao.delete(activity.getId());
            }
            System.out.println("Todas as Activities foram deletadas. Total: " + activities.size());
        }
    }
}
