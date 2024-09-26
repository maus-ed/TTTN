package com.example.TTTN.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data@AllArgsConstructor@NoArgsConstructor
public class AlbumBaiVietId implements Serializable{
    private Integer album;   // Phải trùng với kiểu của thuộc tính album_id
    private Integer baiViet; // Phải trùng với kiểu của thuộc tính bai_viet_id

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
