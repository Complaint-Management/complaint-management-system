package com.complainmanagement.repository;

import com.complainmanagement.pojo.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface ComplainRepository extends CrudRepository<Complaint,Integer> {
}
