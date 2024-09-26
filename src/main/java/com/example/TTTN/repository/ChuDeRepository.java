package com.example.TTTN.repository;


import com.example.TTTN.entity.ChuDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepository extends JpaRepository<ChuDe,Integer> {
}
