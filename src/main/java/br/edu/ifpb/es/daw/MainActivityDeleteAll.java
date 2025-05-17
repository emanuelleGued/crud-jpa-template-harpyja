package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ActivityDAO;
import br.edu.ifpb.es.daw.dao.impl.ActivityDAOImpl;
import br.edu.ifpb.es.daw.entities.Activity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainActivityDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ActivityDAO activityDAO = new ActivityDAOImpl(emf);
            List<Activity> activities = activityDAO.getAll();
            for (Activity activity : activities) {
                activityDAO.delete(activity.getId());
            }
        }
    }
}
