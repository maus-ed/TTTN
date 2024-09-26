package com.example.TTTN.entity;
import java.io.Serializable;
import java.util.Objects;
public class AlbumBaiVietId implements Serializable{
    private Integer album;   // Phải trùng với kiểu của thuộc tính album_id
    private Integer baiViet; // Phải trùng với kiểu của thuộc tính bai_viet_id

    public AlbumBaiVietId() {}

    public AlbumBaiVietId(Integer album, Integer baiViet) {
        this.album = album;
        this.baiViet = baiViet;
    }

    // Phải override equals() và hashCode() cho khóa chính phức hợp
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
