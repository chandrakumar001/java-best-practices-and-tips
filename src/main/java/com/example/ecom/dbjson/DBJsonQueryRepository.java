package com.example.ecom.dbjson;

import com.example.ecom.entity.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DBJsonQueryRepository extends JpaRepository<UserView, UUID>,
        JpaSpecificationExecutor<UserView> {


    /*
     * select * from partcv.userview where us->>'name' = 'Janse' limit 1;
     *
     *@Query(value = " select pa.* from  partcv.userviewtest as pa, jsonb_array_elements(test->'books') as bks where pa.test->>'name' LIKE %:name% or pa.test->>'email' LIKE %:email% or bks->>'name' LIKE %:bookName% "
     * , nativeQuery = true)
     * Page<UserView> findView(@Param("name") String name,
     *                         @Param("email") String email,
     *                         @Param("bookName") String bookName,
     *                         Pageable pageRequest);
     */
}
