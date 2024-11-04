package com.example.TTTN.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

public class AlbumBaiVietId implements Serializable {
    private Integer album;  // Tên thuộc tính phải giống với tên thuộc tính trong entity AlbumBaiViet
    private Integer baiViet;

    public AlbumBaiVietId() {}

    public AlbumBaiVietId(Integer album, Integer baiViet) {
        this.album = album;
        this.baiViet = baiViet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumBaiVietId that = (AlbumBaiVietId) o;
        return Objects.equals(album, that.album) &&
               Objects.equals(baiViet, that.baiViet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, baiViet);
    }
}
