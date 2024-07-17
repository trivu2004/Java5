CREATE DATABASE J5Shop;
GO
USE J5Shop;
GO

CREATE TABLE Categories (
    id VARCHAR(4) PRIMARY KEY,
    Name NVARCHAR(50)
);

CREATE TABLE Products (
    id INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(50),
    Image NVARCHAR(50),
    Price FLOAT,
    CreateDate DATE,
    Available BIT,
    Qty INT,
    CategoryId VARCHAR(4) REFERENCES Categories(id)
);
GO

CREATE TABLE Account (
    Username NVARCHAR(50) PRIMARY KEY,
    Password NVARCHAR(50),
    Fullname NVARCHAR(50),
    Email NVARCHAR(50),
    Photo NVARCHAR(50),
    Activated BIT,
    Admin BIT
);
GO

CREATE TABLE Orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50),
    CreateDate DATETIME,
    Address NVARCHAR(100),
    FOREIGN KEY (Username) REFERENCES Account(Username)
);
GO

CREATE TABLE OrderDetails (
    id INT IDENTITY(1,1) PRIMARY KEY,
    OrderId INT REFERENCES Orders(id),
    ProductId INT REFERENCES Products(id),
    Price FLOAT,
    Quantity INT
);
GO

INSERT INTO Categories VALUES
    ('CAT1', N'Samsung'),
    ('CAT2', N'Iphone'),
    ('CAT3', N'Huawei'),
    ('CAT4', N'Oppo'),
    ('CAT5', N'Vivo');
GO

INSERT INTO Products VALUES 
    (N'Samsung', 'item1.jfif', 230000, '2024-05-20', 1, 1, 'CAT1'),
    (N'Iphone', 'item2.jfif', 200000, '2024-05-19', 1, 1, 'CAT2'),
    (N'Huawei', 'item3.jfif', 240000, '2024-05-18', 1, 1, 'CAT3'),
    (N'Oppo', 'item4.jfif', 300000, '2024-05-17', 1, 1, 'CAT4'),
    (N'Iphone Black', 'item5.jfif', 430000, '2024-05-16', 1, 1, 'CAT3'),
    (N'Iphone Blue', 'item6.jfif', 270000, '2024-05-15', 1, 1, 'CAT3'),
    (N'Vivo', 'item7.jfif', 280000, '2024-05-14', 1, 1, 'CAT5'),
    (N'Cục gạch', 'item8.jfif', 230000, '2024-05-13', 1, 1, 'CAT3'),
    (N'Samsung color gay', 'item9.jfif', 230000, '2024-05-12', 1, 1, 'CAT5');
GO

INSERT INTO Account VALUES 
    ('user1', 'password1', N'Nguyễn Văn A', 'nguyenvana@example.com', 'nguyenvana.jpg', 1, 0),
    ('user2', 'password2', N'Phạm Thị B', 'phamthib@example.com', 'phamthib.jpg', 1, 0),
    ('admin1', 'adminpass', N'Admin User', 'admin@example.com', 'admin.jpg', 1, 1),
    ('user3', 'password3', N'Trần Thanh C', 'tranthanhc@example.com', 'tranthanhc.jpg', 1, 0), 
    ('user4', 'password4', N'Lê Xuân D', 'lexuand@example.com', 'lexuand.jpg', 1, 0), 
    ('user5', 'password5', N'Bùi Thị E', 'buithie@example.com', 'buithie.jpg', 1, 0), 
    ('user6', 'password6', N'Hoàng Văn F', 'hoangvanf@example.com', 'hoangvanf.jpg', 1, 0),
    ('user7', 'password7', N'Mai Thị G', 'maithig@example.com', 'maithig.jpg', 1, 0),
    ('user8', 'password8', N'Đinh Văn H', 'dinhvanh@example.com', 'dinhvanh.jpg', 1, 0),
    ('user9', 'password9', N'Đặng Thị I', 'dangthii@example.com', 'dangthii.jpg', 1, 0);
GO

INSERT INTO Orders VALUES 
    ('user1', '2024-05-20 08:00:00', N'123 Main St, Anytown'),
    ('user2', '2024-05-19 09:00:00', N'456 Elm St, Othertown');
GO

IF EXISTS (SELECT * FROM sys.triggers WHERE object_id = OBJECT_ID('dbo.XoaTheLoai'))
    DROP TRIGGER dbo.XoaTheLoai;
GO

CREATE OR ALTER TRIGGER XoaTheLoai ON Categories 
INSTEAD OF DELETE
AS
BEGIN
    DELETE FROM Products WHERE CategoryId IN (SELECT id FROM deleted);
    DELETE FROM Categories WHERE id IN (SELECT id FROM deleted);
END;
GO

DROP DATABASE J5Shop;



