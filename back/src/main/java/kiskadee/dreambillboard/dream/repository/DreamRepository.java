package kiskadee.dreambillboard.dream.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kiskadee.dreambillboard.dream.model.Dream;

public interface DreamRepository extends JpaRepository<Dream, Long>{

	Page<Dream> findAllByUserId(Pageable pageable, Long userId);
}
