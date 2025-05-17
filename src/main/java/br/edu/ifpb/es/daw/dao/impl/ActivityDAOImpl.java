package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.ActivityDAO;
import br.edu.ifpb.es.daw.entities.Activity;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class ActivityDAOImpl extends AbstractDAOImpl<Activity, UUID> implements ActivityDAO {

    public ActivityDAOImpl(EntityManagerFactory emf) {
        super(Activity.class, emf);
    }
}
