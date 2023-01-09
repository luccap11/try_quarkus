package com.example;

import com.oracle.svm.core.annotate.Inject;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GreetingService {
    @Inject
    @PersistenceContext
    EntityManager em;

    public String greeting(String name) {
        return "Service: hello " + name;
    }

    public List<UserDto> getListGreeting() {
        return em.createQuery("from UserDto ", UserDto.class).getResultList();
    }

    @Transactional
    public void addGreeting(String name) {
        UserDto user = new UserDto();
        user.setUsername(name);
        user.setPassword("admin");
        em.persist(user);
    }

}
