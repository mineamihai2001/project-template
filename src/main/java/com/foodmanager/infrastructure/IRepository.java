package com.foodmanager.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<T> extends JpaRepository<T, Long> {

}
