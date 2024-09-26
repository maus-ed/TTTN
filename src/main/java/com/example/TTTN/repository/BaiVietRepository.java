package com.example.TTTN.repository;

import com.example.TTTN.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaiVietRepository extends JpaRepository<BaiViet,Integer>, JpaSpecificationExecutor<BaiViet> {
}
