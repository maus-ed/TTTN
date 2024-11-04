package com.example.TTTN.repository;

import com.example.TTTN.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
    @Query("SELECT abv.album FROM AlbumBaiViet abv WHERE abv.baiViet.id = :baiVietId")
    List<Album> findAlbumsByBaiVietId(@Param("baiVietId") Integer baiVietId);

}
