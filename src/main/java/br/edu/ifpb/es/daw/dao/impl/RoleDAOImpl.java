package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.RoleDAO;
import br.edu.ifpb.es.daw.entities.Role;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class RoleDAOImpl  extends AbstractDAOImpl<Role, UUID> implements RoleDAO {
    public RoleDAOImpl(EntityManagerFactory emf) {
        super(Role.class, emf);
    }
}
