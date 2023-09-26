package com.ecommerce.account.repository;

import com.ecommerce.account.dto.request.UserQueryRequest;
import com.ecommerce.account.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseUserRepositoryImpl implements BaseUserRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<User> getUserByConditions(UserQueryRequest userQuery) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if (userQuery.getUsername() != null) {
            predicates.add(cb.like(user.get("username"), "%" + userQuery.getUsername() + "%"));
        }
        if (userQuery.getCreatedAt() != null) {
            predicates.add(cb.greaterThanOrEqualTo(user.get("createdAt"), userQuery.getCreatedAt()));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}

