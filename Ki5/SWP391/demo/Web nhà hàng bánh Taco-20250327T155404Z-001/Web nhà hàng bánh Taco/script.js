document.addEventListener('DOMContentLoaded', function() {
    // Tìm nút "Join" trong subscribe-form
    const joinButton = document.querySelector('.subscribe-form button[type="submit"]');
    const emailInput = document.querySelector('.subscribe-form input[type="email"]');

    // Thêm sự kiện click cho nút "Join"
    joinButton.addEventListener('click', function(event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định (nếu có)

        // Lấy giá trị email
        const email = emailInput.value;

        // Kiểm tra email có hợp lệ không
        if (email && email.includes('@')) {
            // Tạo popup
            createPopup('Đã nhận thông tin', 'Cảm ơn bạn đã đăng ký nhận tin từ Tica\'s Tacos!');

            // Reset ô input
            emailInput.value = '';
        } else {
            // Thông báo lỗi nếu email không hợp lệ
            createPopup('Lỗi', 'Vui lòng nhập địa chỉ email hợp lệ');
        }
    });

    // Hàm tạo popup (giữ nguyên)
    function createPopup(title, message) {
        const overlay = document.createElement('div');
        overlay.className = 'popup-overlay';

        const popup = document.createElement('div');
        popup.className = 'popup';

        const popupTitle = document.createElement('h3');
        popupTitle.textContent = title;

        const popupMessage = document.createElement('p');
        popupMessage.textContent = message;

        const okButton = document.createElement('button');
        okButton.textContent = 'OK';
        okButton.className = 'popup-button';

        okButton.addEventListener('click', function() {
            document.body.removeChild(overlay);
        });

        popup.appendChild(popupTitle);
        popup.appendChild(popupMessage);
        popup.appendChild(okButton);
        overlay.appendChild(popup);

        document.body.appendChild(overlay);
    }
});