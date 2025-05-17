package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.UserProjectDAO;
import br.edu.ifpb.es.daw.entities.UserProject;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class UserProjectDAOImpl extends AbstractDAOImpl<UserProject, UUID> implements UserProjectDAO {
    public UserProjectDAOImpl(EntityManagerFactory emf) {
        super(UserProject.class, emf);
    }
}
