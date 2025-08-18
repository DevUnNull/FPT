-- quản lý sản phẩm 
CREATE TABLE products (
    product_id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    description NVARCHAR(500),
    price DECIMAL(18,2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    image_url NVARCHAR(255),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME NULL
);

CREATE TABLE categories (
    category_id INT PRIMARY KEY IDENTITY(1,1),
    category_name NVARCHAR(100) NOT NULL,
    description NVARCHAR(500)
);

-- Nếu sản phẩm thuộc nhiều loại
CREATE TABLE product_categories (
    product_id INT,
    category_id INT,
    PRIMARY KEY (product_id, category_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

-- Nếu sản phẩm có nhiều ảnh
CREATE TABLE product_images (
    image_id INT PRIMARY KEY IDENTITY(1,1),
    product_id INT,
    image_url NVARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
-- giỏ hàng & đặt hàng
CREATE TABLE carts (
    cart_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE cart_items (
    cart_item_id INT PRIMARY KEY IDENTITY(1,1),
    cart_id INT,
    product_id INT,
    quantity INT NOT NULL,
    price_at_add_time DECIMAL(18,2) NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES carts(cart_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    total_amount DECIMAL(18,2) NOT NULL,
    order_status NVARCHAR(50) DEFAULT 'pending',
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY IDENTITY(1,1),
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    unit_price DECIMAL(18,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- thanh toán & vận chuyển 
CREATE TABLE payment_methods (
    payment_id INT PRIMARY KEY IDENTITY(1,1),
    payment_name NVARCHAR(50) NOT NULL
);

CREATE TABLE order_payments (
    order_id INT,
    payment_id INT,
    paid_amount DECIMAL(18,2) NOT NULL,
    paid_at DATETIME DEFAULT GETDATE(),
    PRIMARY KEY (order_id, payment_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (payment_id) REFERENCES payment_methods(payment_id)
);

CREATE TABLE shipping_addresses (
    address_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    recipient_name NVARCHAR(100) NOT NULL,
    phone NVARCHAR(20) NOT NULL,
    address_detail NVARCHAR(255) NOT NULL,
    city NVARCHAR(100),
    postal_code NVARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE shipping_methods (
    shipping_id INT PRIMARY KEY IDENTITY(1,1),
    shipping_name NVARCHAR(100) NOT NULL,
    shipping_fee DECIMAL(18,2) NOT NULL
);
-- hỗ trợ maketing và vận chuyển 
CREATE TABLE discounts (
    discount_id INT PRIMARY KEY IDENTITY(1,1),
    code NVARCHAR(50) NOT NULL,
    description NVARCHAR(255),
    discount_percent DECIMAL(5,2) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL
);

CREATE TABLE product_reviews (
    review_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    product_id INT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment NVARCHAR(1000),
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

