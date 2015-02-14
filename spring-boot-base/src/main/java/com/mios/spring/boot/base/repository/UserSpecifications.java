package com.mios.spring.boot.base.repository;

import org.springframework.data.jpa.domain.Specification;
import com.mios.spring.boot.base.domain.User;
import com.mios.spring.boot.base.domain.User_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecifications {

    /**
     * Builds a specification which ensures that the User email
     * contains a domain or the User age accomplish a condition.
     * @param searchTerm    The used search term.
     * @return
     */
    public static Specification<User> emailOrAgeCondition(final String likeEmailPattern1, 
    												      final String likeEmailPattern2,
    												      final Integer greaterThanAgeValue) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, 
            		                     CriteriaQuery<?> criteriaQuery, 
            		                     CriteriaBuilder criteriaBuilder) {
            	            	
            	return criteriaBuilder.and(criteriaBuilder.greaterThan(root.<Integer>get(User_.age), greaterThanAgeValue), 
            			                   criteriaBuilder.or(
				                    			criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(User_.email)), 
				                    			  										   likeEmailPattern1), 
				                    			criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(User_.email)), 
				                          			  									   likeEmailPattern2)));            	
            }
        };
    }
}
