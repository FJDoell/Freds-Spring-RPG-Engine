package com.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepo extends JpaRepository<Action, Integer> {

}
