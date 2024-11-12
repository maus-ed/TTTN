package com.example.TTTN.repository;


import com.example.TTTN.entity.Album;
import com.example.TTTN.entity.AlbumBaiViet;
import com.example.TTTN.entity.AlbumBaiVietId;
import com.example.TTTN.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumBaiVietRepository extends JpaRepository<AlbumBaiViet, AlbumBaiVietId> {
    Optional<AlbumBaiViet> findByAlbumAndBaiViet(Album album, BaiViet baiViet);
}

