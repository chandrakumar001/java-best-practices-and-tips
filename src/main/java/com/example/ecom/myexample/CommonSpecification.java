package com.example.ecom.myexample;


import com.example.ecom.OperatorsConstant;
import com.example.ecom.ValidationUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class CommonSpecification {

    public static Predicate getLike(final CriteriaBuilder cb,
                                    final Path<String> objectPath,
                                    final String value,
                                    final String name) {

        //Extract the local variable
        final boolean valueEndWith = value.endsWith(OperatorsConstant.MULIPLICATION);
        final boolean valueStartWith = value.startsWith(OperatorsConstant.MULIPLICATION);
        final boolean startAndEndWithNumber = valueStartWith && valueEndWith;

        // checkIndex size's less Than,then thrown the e
        ValidationUtils.checkIndexSize(value, name, startAndEndWithNumber, 4);
        ValidationUtils.checkIndexSize(value, name, valueEndWith, 3);
        ValidationUtils.checkIndexSize(value, name, valueStartWith, 3);

        // replace * into %
        final String query = value.replace(
                OperatorsConstant.MULIPLICATION,
                OperatorsConstant.PERCENTAGE
        );
        return cb.like(objectPath, query);
    }
}
