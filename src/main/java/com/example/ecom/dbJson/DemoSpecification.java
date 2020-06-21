package com.example.ecom.dbJson;

import com.example.ecom.entity.UserView;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class DemoSpecification implements Specification<UserView> {

    public static final String JSONB_EXTRACT_PATH_TEXT = "jsonb_extract_path_text";
    public static final String TEST = "test";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String JSONB_EXTRACT_ARRAY_ELEMENT_TEXT = "jsonb_extract_array_element_text";

    private UserViewSearch userViewSearch;

    public DemoSpecification(UserViewSearch userViewSearch) {
        this.userViewSearch = userViewSearch;
    }

    @Override
    public Predicate toPredicate(final Root<UserView> root,
                                 final CriteriaQuery<?> query,
                                 final CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicateList = new ArrayList<>();

        final String name = userViewSearch.getName();

        if (!StringUtils.isEmpty(name)) {

            Expression<String> function = criteriaBuilder.function(
                    JSONB_EXTRACT_PATH_TEXT,
                    String.class,
                    root.get(TEST),
                    criteriaBuilder.literal(NAME));

            Predicate hasBirthday = criteriaBuilder.like(
                    function,
                    "%" + name + "%");
            predicateList.add(hasBirthday);

        }

        final String email = userViewSearch.getEmail();

        if (!StringUtils.isEmpty(email)) {

            Expression<String> function = criteriaBuilder.function(
                    JSONB_EXTRACT_PATH_TEXT,
                    String.class,
                    root.get(TEST),
                    criteriaBuilder.literal(EMAIL));

            Predicate hasBirthday = criteriaBuilder.like(
                    function,
                    "%" + email + "%");

            predicateList.add(hasBirthday);

        }

        final String bookName = userViewSearch.getBookName();

        if (!StringUtils.isEmpty(bookName)) {

            Expression<String> function = criteriaBuilder.function(
                    JSONB_EXTRACT_PATH_TEXT,
                    String.class,
                    root.get(TEST),
                    criteriaBuilder.literal("books")
            );
            Predicate hasBirthday = criteriaBuilder.like(
                    function,
                    "%" + bookName + "%");

            predicateList.add(hasBirthday);

        }
        final Predicate[] predicates = new Predicate[predicateList.size()];
        return criteriaBuilder.and(predicateList.toArray(predicates));

    }
}