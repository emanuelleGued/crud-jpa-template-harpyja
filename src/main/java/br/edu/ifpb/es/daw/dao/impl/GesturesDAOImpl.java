package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.GesturesDAO;
import br.edu.ifpb.es.daw.entities.Gestures;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class GesturesDAOImpl extends AbstractDAOImpl<Gestures, UUID> implements GesturesDAO {
    public GesturesDAOImpl(EntityManagerFactory emf) {
        super(Gestures.class, emf);
    }
}
