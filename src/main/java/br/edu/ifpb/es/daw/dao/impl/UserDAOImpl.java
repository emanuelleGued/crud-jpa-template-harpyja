package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.entities.User;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class UserDAOImpl extends AbstractDAOImpl<User, UUID> implements UserDAO {
    public UserDAOImpl(EntityManagerFactory emf) {
        super(User.class, emf);
    }
}
