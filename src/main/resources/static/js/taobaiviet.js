const postModal = document.getElementById('postDetailsModal');
const btnSubmit = document.getElementById('btnSubmit');
const cancelButton = document.getElementById('cancelButton');
const postForm = document.getElementById('postDetailsForm');

// Hàm để load chủ đề
function loadChuDe() {
    fetch('/api/chude') // Đảm bảo URL chính xác
        .then(response => {
            if (!response.ok) {
                throw new Error('Phản hồi mạng không hợp lệ');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            const chuDeSelect = document.getElementById('chu_de');
            chuDeSelect.innerHTML = '';

            if (Array.isArray(data)) {
                data.forEach(chuDe => {
                    const option = document.createElement('option');
                    option.value = chuDe.id;
                    option.textContent = chuDe.ten;
                    chuDeSelect.appendChild(option);
                });
            } else {
                console.error("Dữ liệu nhận được không phải là mảng:", data);
            }
        })
        .catch(error => console.error('Lỗi khi tải Chủ Đề:', error));
}

// Hàm để load đợt viết bài
function loadDotVietBai() {
    fetch('/api/dot-bai-viet')
        .then(response => {
            if (!response.ok) {
                throw new Error('Phản hồi mạng không hợp lệ');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            const dotVietBaiSelect = document.getElementById('dot_viet_bai');
            dotVietBaiSelect.innerHTML = ''; // Xóa các tùy chọn hiện có

            if (Array.isArray(data)) {
                data.forEach(dotVietBai => {
                    const option = document.createElement('option');
                    option.value = dotVietBai.id;

                    // Chuyển đổi chuỗi ngày tháng sang định dạng ngày tháng năm
                    const startDate = new Date(dotVietBai.tuNgay);
                    const endDate = new Date(dotVietBai.denNgay);

                    // Định dạng ngày tháng năm
                    const formattedStartDate = startDate.toLocaleDateString('vi-VN');
                    const formattedEndDate = endDate.toLocaleDateString('vi-VN');

                    option.textContent = `${dotVietBai.ten} (${formattedStartDate} -> ${formattedEndDate})`;
                    dotVietBaiSelect.appendChild(option);
                });
            } else {
                console.error("Dữ liệu nhận được không phải là mảng:", data);
            }
        })
        .catch(error => console.error('Lỗi khi tải Đợt Viết Bài:', error));
}

// Mở modal để tạo bài viết
btnSubmit.addEventListener('click', () => {
    postModal.style.display = 'block';
});

// Đóng modal
cancelButton.addEventListener('click', () => {
    postModal.style.display = 'none';
});

// Đóng modal khi nhấp bên ngoài modal
window.onclick = function(event) {
    if (event.target === postModal) {
        postModal.style.display = 'none';
    }
};

// Xử lý khi submit form
postForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const tieuDe = document.getElementById('tieu_de').value;
    const chuDe = document.getElementById('chu_de').value;
    const noiDung = document.getElementById('noiDungBaiViet').innerHTML; // Lấy nội dung từ div

    if (!tieuDe || !chuDe || !noiDung) {
        alert('Vui lòng điền đầy đủ thông tin!');
        return;
    }

    const today = new Date();
    const ngayTao = today.toISOString().split('T')[0];

    const formData = new FormData();
    formData.append('tieuDe', tieuDe);
    formData.append('chuDe', chuDe);
    formData.append('ngayTao', ngayTao);
    formData.append('noiDung', noiDung);

    fetch('/api/luu-bai-viet', {
        method: 'POST',
        body: formData,
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Phản hồi mạng không hợp lệ');
            }
            return response.text();
        })
        .then(result => {
            alert(result);
            postModal.style.display = 'none';
            // Reset form sau khi thêm thành công
            postForm.reset(); // Đặt lại các trường input
            document.getElementById('noiDungBaiViet').innerHTML = ''; // Đặt lại nội dung bài viết
        })
        .catch(error => {
            console.error('Lỗi:', error);
            alert('Có lỗi xảy ra. Vui lòng thử lại.');
        });
});

// Tải dữ liệu khi cửa sổ tải xong
window.onload = function() {
    loadChuDe();
    loadDotVietBai();
};
