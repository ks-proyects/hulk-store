package com.gio.hs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gio.hs.entity.Employed;

@Repository
public interface EmployedRepo extends JpaRepository<Employed, Integer>, PagingAndSortingRepository<Employed, Integer> {

	public Employed findByUsernameAndActivo(String username,Boolean activo);
}
