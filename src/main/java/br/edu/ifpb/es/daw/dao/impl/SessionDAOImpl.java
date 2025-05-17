package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.SessionDAO;
import br.edu.ifpb.es.daw.entities.SessionEntity;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class SessionDAOImpl extends AbstractDAOImpl<SessionEntity, UUID> implements SessionDAO {
    public SessionDAOImpl(EntityManagerFactory emf) {
        super(SessionEntity.class, emf);
    }
}
