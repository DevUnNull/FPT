-- Tạo database (SQL Server không dùng IF EXISTS trong CREATE DATABASE)
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'LoginPhanQuyen')
BEGIN
    CREATE DATABASE LoginPhanQuyen;
END
GO

USE LoginPhanQuyen;
GO

-- Bảng users
CREATE TABLE users (
    user_id INT IDENTITY(1,1) PRIMARY KEY, -- SQL Server dùng IDENTITY thay AUTO_INCREMENT
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    status TINYINT DEFAULT 1, -- 1: active, 0: inactive
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);
GO

-- Bảng roles
CREATE TABLE roles (
    role_id INT IDENTITY(1,1) PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL -- ADMIN, USER, MANAGER,...
);
GO

-- Bảng user_roles
CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE
);
GO
