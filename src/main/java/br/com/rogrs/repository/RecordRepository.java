package br.com.rogrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rogrs.domain.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
