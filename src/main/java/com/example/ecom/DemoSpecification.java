package com.example.ecom;

import com.example.ecom.entity.UserView;
import com.example.ecom.myexample.CommonSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class DemoSpecification implements Specification<UserView> {

    private static final String PARTCV_QUERY = "partcv.query.";

    @Override
    public Predicate toPredicate(final Root<UserView> root,
                                 final CriteriaQuery<?> query,
                                 final CriteriaBuilder cb) {

//          return builder.equal(
//          builder.function("jsonb_extract_path_text", String.class,
//          root.<String>get("title"), builder.literal(locale)),
//          titleToSearch);

        Predicate hasBirthday = cb.like(cb.function(
                "jsonb_extract_path_text",
                String.class,
                root.get("test"),
                cb.literal("name")),
                "%Janse%");
        return hasBirthday;

    }


    private Predicate getPredicate(final Root<UserView> root,
                                   final CriteriaBuilder criteriaBuilder,
                                   final String input,
                                   final String nameOfField) {

        final Path<String> stringPath = root.get(nameOfField);
        final String message = PARTCV_QUERY + nameOfField;
        return CommonSpecification.getLike(
                criteriaBuilder,
                stringPath,
                input,
                message
        );
    }
}