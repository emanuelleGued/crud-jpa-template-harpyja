package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.UserOrganizationDAO;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class UserOrganizationDAOImpl extends AbstractDAOImpl<UserOrganization, UUID> implements UserOrganizationDAO {
    public UserOrganizationDAOImpl(EntityManagerFactory emf) {
        super(UserOrganization.class, emf);
    }
}
