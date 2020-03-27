package com.complainmanagement.repository;

import com.complainmanagement.pojo.Complaint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface ComplainRepository extends CrudRepository<Complaint,Integer> {
    @Query("SELECT c from Complaint c where c.rollNumber = :roll and c.resolved=0")
    Iterable<Complaint> findByRollNumber(@Param("roll") Integer roll);

    @Query("SELECT c from Complaint c where c.rollNumber = :roll and c.resolved=1")
    Iterable<Complaint> findByRollNumberAndResolved(@Param("roll") Integer roll);
}
