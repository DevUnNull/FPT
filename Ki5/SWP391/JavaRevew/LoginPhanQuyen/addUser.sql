-- Thêm dữ liệu mẫu vào bảng roles
INSERT INTO roles (role_name) VALUES
('ADMIN'),
('USER'),
('MANAGER');

-- Thêm dữ liệu mẫu vào bảng users
INSERT INTO users (username, password_hash, full_name, email, status)
VALUES
('admin', 'hashed_password_admin', 'Quản Trị Viên', 'admin@example.com', 1),
('user1', 'hashed_password_user1', 'Nguyễn Văn A', 'user1@example.com', 1),
('user2', 'hashed_password_user2', 'Trần Thị B', 'user2@example.com', 0);

-- Gán quyền cho user
-- admin → ADMIN
INSERT INTO user_roles (user_id, role_id)
SELECT u.user_id, r.role_id
FROM users u
JOIN roles r ON r.role_name = 'ADMIN'
WHERE u.username = 'admin';

-- user1 → USER
INSERT INTO user_roles (user_id, role_id)
SELECT u.user_id, r.role_id
FROM users u
JOIN roles r ON r.role_name = 'USER'
WHERE u.username = 'user1';

-- user2 → USER + MANAGER
INSERT INTO user_roles (user_id, role_id)
SELECT u.user_id, r.role_id
FROM users u
JOIN roles r ON r.role_name = 'USER'
WHERE u.username = 'user2';

INSERT INTO user_roles (user_id, role_id)
SELECT u.user_id, r.role_id
FROM users u
JOIN roles r ON r.role_name = 'MANAGER'
WHERE u.username = 'user2';
