package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.UserOrganizationDAO;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import br.edu.ifpb.es.daw.entities.UserOrganizationId;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class UserOrganizationDAOImpl extends AbstractDAOImpl<UserOrganization, UserOrganizationId> implements UserOrganizationDAO {
    public UserOrganizationDAOImpl(EntityManagerFactory emf) {
        super(UserOrganization.class, emf);
    }
}
