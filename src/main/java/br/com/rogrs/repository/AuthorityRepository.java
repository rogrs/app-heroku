package br.com.rogrs.repository;

import br.com.rogrs.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
