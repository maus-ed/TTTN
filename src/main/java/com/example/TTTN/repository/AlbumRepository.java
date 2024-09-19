package com.example.TTTN.repository;

import com.example.TTTN.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
