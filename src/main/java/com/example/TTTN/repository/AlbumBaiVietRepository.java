package com.example.TTTN.repository;


import com.example.TTTN.entity.AlbumBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumBaiVietRepository extends JpaRepository<AlbumBaiViet,Integer> {
}
