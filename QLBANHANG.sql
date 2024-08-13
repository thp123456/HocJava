select * from employees


CREATE DATABASE QLBANHANG
GO
USE QLBANHANG
GO

drop DATABASE QLBANHANG

CREATE TABLE ACCOUNT
(
  IDUSER VARBINARY(85) NOT NULL,
  USERNAME VARCHAR(20),
  IDEMP VARCHAR(20),
  CONSTRAINT PK_ACCOUNT PRIMARY KEY (IDUSER),
  CONSTRAINT FK_ACCOUNT_EMP FOREIGN KEY(IDEMP) REFERENCES EMPLOYEES(IDEMP),
  );

select * from ACCOUNT

create table EMPLOYEES(
IDEMP VARCHAR(20) NOT NULL,
NAME NVARCHAR(50),
EMAIL VARCHAR(50),
POSITION NVARCHAR(50),
ADDRESS NVARCHAR(100),
BIRTHYEAR INT DEFAULT 2003,
PHONE VARCHAR(20) DEFAULT '0812.XXX.XXX',
CONSTRAINT PK_EMP PRIMARY KEY(IDEMP)
);
select * from EMPLOYEES;

CREATE SEQUENCE EMPLSEQU
START WITH 1
INCREMENT BY 1
MINVALUE 1
NO MAXVALUE
NO CYCLE;

CREATE SEQUENCE MANAGERSEQU
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE;


CREATE TABLE CATEGORY
(
  IDCATEGORY INT IDENTITY(1,1) NOT NULL,
  NAME NVARCHAR(50) UNIQUE,
  CONSTRAINT PK_CATEGORY PRIMARY KEY(IDCATEGORY)
);
CREATE TABLE SUPPLIER
(
  IDSUPPLIER INT IDENTITY(1,1) NOT NULL,
  NAME NVARCHAR(50),
  PHONE VARCHAR(11),
  ADDRESS NVARCHAR(50),
  EMAIL VARCHAR(50),
  CONSTRAINT PK_SUPPLIER PRIMARY KEY (IDSUPPLIER)
  );
 

CREATE TABLE PRODUCT
(
  IDPRODUCT INT IDENTITY(1,1)NOT NULL,
  NAME NVARCHAR(50),
  PRICE FLOAT,
  DATEPRODUCT DATE,
  QUANTITY INT,
  IDCATEGORY INT,
  IDSUPPLIER INT,
  CONSTRAINT PK_PRODUCT PRIMARY KEY (IDPRODUCT),
  CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY(IDSUPPLIER) REFERENCES SUPPLIER(IDSUPPLIER),
  CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY(IDCATEGORY) REFERENCES CATEGORY(IDCATEGORY)
);

create table CUSTOMER(
IDCUS VARCHAR(20) NOT NULL,
NAME NVARCHAR(50),
EMAIL VARCHAR(50),
ADDRESS NVARCHAR(100),
BIRTHYEAR INT DEFAULT 2003,
PHONE VARCHAR(20) DEFAULT '0812.XXX.XXX',
DIEMTHUONG FLOAT,
CONSTRAINT PK_cus PRIMARY KEY(IDCUS)
);

CREATE SEQUENCE KHACHSEQU
START WITH 1
INCREMENT BY 1
MINVALUE 1
NO MAXVALUE
NO CYCLE; 


CREATE TABLE BILL
(
  IDBILL INT NOT NULL,
  DISCOUNT FLOAT,
  TOTALPRICE FLOAT,
  BILLDATE DATE,
  IDEMP VARCHAR(20),
  IDCUS VARCHAR(20),
  CONSTRAINT PK_BILL PRIMARY KEY(IDBILL),
  CONSTRAINT FK_BILL_ACCOUNT FOREIGN KEY(IDEMP) REFERENCES EMPLOYEES(IDEMP),
  CONSTRAINT FK_BILL_CUSTOMER FOREIGN KEY(IDCUS) REFERENCES CUSTOMER(IDCUS)
  );


CREATE SEQUENCE BILLSEQU
START WITH 1
INCREMENT BY 1
MINVALUE 1
NO MAXVALUE
NO CYCLE;


CREATE TABLE BILLDETAILS
(
  IDPRODUCT INT,
  COUNT INT,
  DISCOUNT FLOAT,
  TOTAL FLOAT,
  IDBILL INT
  CONSTRAINT PK_BILLDETAILS PRIMARY KEY(IDPRODUCT,IDBILL),
  CONSTRAINT FK_BILLDETAILS_PRODUCT FOREIGN KEY(IDPRODUCT) REFERENCES PRODUCT(IDPRODUCT),
  CONSTRAINT FK_BILLDETAILS_BILL FOREIGN KEY(IDBILL) REFERENCES BILL(IDBILL)
);
 


INSERT INTO CUSTOMER (IDCUS, NAME, EMAIL, ADDRESS, BIRTHYEAR, PHONE, DIEMTHUONG)
VALUES
    (NEXT VALUE FOR KHACHSEQU, N'Nguyễn Văn Anh', 'nguyenvana@example.com', N'123 Đường ABC, Quận 1, Thành phố Hồ Chí Minh', 1990, '0812345678', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Trần Thị Bảy', 'tranthib@example.com', N'456 Đường XYZ, Quận 2, Thành phố Hồ Chí Minh', 1985, '0812345679', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Lê Văn Chinh', 'levanc@example.com', N'789 Đường KLM, Quận 3, Thành phố Hồ Chí Minh', 1992, '0812345680', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Phạm Thị Diễm', 'phamthid@example.com', N'101 Đường DEF, Quận 4, Thành phố Hồ Chí Minh', 1988, '0812345681', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Hoàng Văn Em', 'hoangvane@example.com', N'202 Đường GHI, Quận 5, Thành phố Hồ Chí Minh', 1995, '0812345682', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Đỗ Thị Phí', 'dothif@example.com', N'303 Đường JKL, Quận 6, Thành phố Hồ Chí Minh', 1983, '0812345683', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Vũ Văn Gia', 'vuvang@example.com', N'404 Đường MNO, Quận 7, Thành phố Hồ Chí Minh', 1998, '0812345684', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Trương Thị Hồng', 'truongthih@example.com', N'505 Đường PQR, Quận 8, Thành phố Hồ Chí Minh', 1980, '0812345685', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Ngô Văn Lợi', 'ngovani@example.com', N'606 Đường STU, Quận 9, Thành phố Hồ Chí Minh', 1993, '0812345686', 100000),
    (NEXT VALUE FOR KHACHSEQU, N'Lý Thị Kim', 'lythik@example.com', N'707 Đường VWX, Quận 10, Thành phố Hồ Chí Minh', 1987, '0812345687', 100000);
	
	delete CUSTOMER


INSERT INTO CUSTOMER (IDCUS, NAME, EMAIL, ADDRESS, BIRTHYEAR, PHONE, DIEMTHUONG)
VALUES
    ('0', N'Khách Lẻ', 'nguyenvanLe@example.com', N'Thành phố Hồ Chí Minh', 1990, '0812345678', 0)
	-- Đặt lại sequence KHACHSEQU về giá trị 1
ALTER SEQUENCE KHACHSEQU RESTART WITH 1;
delete CUSTOMER where IDCUS =

INSERT INTO CATEGORY
VALUES
(N'Đồ ăn'),
(N'Đồ uống');
  
 
INSERT INTO SUPPLIER (NAME, PHONE, ADDRESS, EMAIL)
VALUES
(N'Tập đoàn Masan Consumer', '0123456789', N'123 Đường ABC, Thành phố HCM', 'masanconsumer@example.com'),
(N'Vinamilk', '0987654321', N'456 Đường XYZ, Thành phố Hà Nội', 'vinamilk@example.com'),
(N'Nestlé', '0321654987', N'789 Đường DEF, Thành phố Đà Nẵng', 'nestle@example.com'),
(N'Coca-Cola', '0123456789', N'123 Đường Coca-Cola, Thành phố A', 'cocacola@example.com'),
(N'PepsiCo', '0987654321', N'456 Đường Pepsi, Thành phố B', 'pepsico@example.com'),
(N'Unilever', '0321654987', N'789 Đường Unilever, Thành phố C', 'unilever@example.com'),
(N'Công ty Cổ phần Hàng tiêu dùng', '0987654321', N'456 Đường XYZ, Thành phố HCM', 'hangtieudung@example.com'),
(N'Tập đoàn Thực phẩm Kinh Đô', '0123456788', N'789 Đường DEF, Thành phố HCM', 'kinhdo@example.com');


INSERT INTO PRODUCT (NAME, PRICE, DATEPRODUCT, QUANTITY, IDCATEGORY, IDSUPPLIER)
VALUES
(N'Phin sữa đá', 15000, '2025-04-06', 100, 1, 1),
(N'Bạc xỉu', 20000, '2025-04-06', 100, 1, 1),
(N'Latte', 45000, '2025-04-06', 100, 1, 1),
(N'Cappuccino', 50000, '2025-04-06', 100, 1, 1),
(N'Trá đá', 10000, '2025-04-06', 100, 1, 1),
(N'Bánh mì ốp la', 30000, '2025-04-06', 50, 2, 1),
(N'Bánh mì thịt nướng', 35000, '2025-04-06', 50, 2, 1),
(N'Phở bò', 45000, '2025-04-06', 50, 2, 1),
(N'Bún chả', 40000, '2025-04-06', 50, 2, 1),
(N'Bánh cuốn', 30000, '2025-04-06', 50, 2, 1);



INSERT INTO PRODUCT (NAME, PRICE, DATEPRODUCT, QUANTITY, IDCATEGORY, IDSUPPLIER)
VALUES
(N'Coca-Cola', 10000, '2025-04-06', 150, 2, 4),
(N'Pepsi', 8000, '2025-04-06', 120, 2, 5),
(N'Sprite', 12000, '2025-04-06', 130, 2, 6),
(N'Fanta', 20000, '2025-04-06', 100, 2, 4),
(N'7Up', 15000, '2025-04-06', 90, 2, 5),
(N'Cà phê đen', 12000, '2025-04-06', 100, 1, 1),
(N'Cà phê sữa', 18000, '2025-04-06', 100, 1, 1),
(N'Bánh mì pate', 25000, '2025-04-06', 50, 2, 1),
(N'Bánh mì chả lụa', 28000, '2025-04-06', 50, 2, 1),
(N'Bánh mì cá mòi', 32000, '2025-04-06', 50, 2, 1);
GO


CREATE  PROCEDURE CreateUserStaff
    @Username NVARCHAR(50),
    @Password NVARCHAR(50),
	@NAME NVARCHAR(50),
	@EMAIL VARCHAR(50),
	@POSITION NVARCHAR(50),
	@ADDRESS NVARCHAR(100),
	@BIRTHYEAR INT,
	@PHONE VARCHAR(20)
AS
BEGIN
    -- Tạo đăng nhập và gán quyền truy cập cho cơ sở dữ liệu
    DECLARE @DangNhapSID VARBINARY(85);
    EXEC sp_addlogin @Username, @Password, QLBANHANG;-- kết nối server
	EXEC sp_adduser @Username,@Username -- kết database
	EXEC sp_addrolemember 'Staff', @Username;
    SELECT @DangNhapSID = sid FROM sys.server_principals WHERE name = @Username;
    -- Thêm bản ghi vào bảng Account với thông tin đăng nhập và SID
	DECLARE @ID VARCHAR(20);
	SET @ID = 'NVBH0' + CAST(NEXT VALUE FOR dbo.EMPLSEQU AS VARCHAR(10));
	INSERT INTO EMPLOYEES
	VALUES (@ID, @NAME, @EMAIL,@POSITION,@ADDRESS,@BIRTHYEAR,@PHONE)
    INSERT INTO Account 
    VALUES (@DangNhapSID,@Username,@ID);
END;
GO


-- Gọi thủ tục để thêm nhân viên mới
EXEC CreateUserStaff
    @Username = N'phuc',
    @Password = N'123',
    @NAME = N'Tran Huu Phuc',
    @EMAIL = 'johndoe@example.com',
    @POSITION = N'Staff',
    @ADDRESS = N'123 Đường ABC, Quận 1, TP.HCM',
    @BIRTHYEAR = 1985,
    @PHONE = '0912.345.678';

EXEC CreateUserStaff
    @Username = N'thi',
    @Password = N'123',
    @NAME = N'Do Anh Thi',
    @EMAIL = 'janesmith@example.com',
    @POSITION = N'Staff',
    @ADDRESS = N'456 Đường XYZ, Quận 2, TP.HCM',
    @BIRTHYEAR = 1990,
    @PHONE = '0922.876.543';

EXEC CreateUserStaff
    @Username = N'ngoc',
    @Password = N'123',
    @NAME = N'Thanh Ngoc',
    @EMAIL = 'michaeljohnson@example.com',
    @POSITION = N'Staff',
    @ADDRESS = N'789 Đường DEF, Quận 3, TP.HCM',
    @BIRTHYEAR = 1995,
    @PHONE = '0933.456.789';




-- Thủ tục tạo 1 Manager
CREATE PROCEDURE CreateUserManager
    @Username NVARCHAR(50),
    @Password NVARCHAR(50),
	@NAME NVARCHAR(50),
	@EMAIL VARCHAR(50),
	@POSITION NVARCHAR(50),
	@ADDRESS NVARCHAR(100),
	@BIRTHYEAR INT,
	@PHONE VARCHAR(20)
AS
BEGIN
    -- Tạo đăng nhập và gán quyền truy cập cho cơ sở dữ liệu
    DECLARE @DangNhapSID VARBINARY(85);
    EXEC sp_addlogin @Username, @Password, QLBANHANG;-- kết nối server
	EXEC sp_adduser @Username,@Username -- kết database
	EXEC sp_addrolemember 'Manager', @Username;
    SELECT @DangNhapSID = sid FROM sys.server_principals WHERE name = @Username;
    -- Thêm bản ghi vào bảng Account với thông tin đăng nhập và SID
	DECLARE @ID VARCHAR(20);
	SET @ID = 'QLST0' + CAST(NEXT VALUE FOR dbo.MANAGERSEQU AS VARCHAR(10));
	INSERT INTO EMPLOYEES
	VALUES (@ID, @NAME, @EMAIL,@POSITION,@ADDRESS,@BIRTHYEAR,@PHONE)
    INSERT INTO Account 
    VALUES (@DangNhapSID,@Username,@ID);
END;

EXEC CreateUserManager
    @Username = N'hang',
    @Password = N'123',
    @NAME = N'Nguyen Thi Hang',
    @EMAIL = 'hang@example.com',
    @POSITION = N'Manager',
    @ADDRESS = N'75 Đường Lý Thường Kiệt, Quận 10, TP.HCM',
    @BIRTHYEAR = 1980,
    @PHONE = '0944.567.890';


-- Hàm trả về quyền của user
go
CREATE FUNCTION CheckLoginAccess ( @LoginName NVARCHAR(100))
RETURNS NVARCHAR(20)
AS
BEGIN
    DECLARE @Result NVARCHAR(20);
	
        SELECT @Result = r.name
        FROM sys.database_role_members m
        INNER JOIN sys.database_principals r ON m.role_principal_id = r.principal_id
        INNER JOIN sys.database_principals u ON m.member_principal_id = u.principal_id
        WHERE u.name = @LoginName;
    RETURN @Result;
END
go

declare @roleUser varchar(20)
set @roleUser = dbo.CheckLoginAccess('sa')
select @roleUser as role
go
go


create function getUsernamebyID(@id varchar(20))
returns varchar(20)
as
begin
	declare @username varchar(20)
		select @username =USERNAME from ACCOUNT where IDEMP = @id
		return @username;
end
go
-- Xoa 1 nhan vien
create PROCEDURE deleteNhanVien
	@manv varchar(20)
as
begin
	declare @username varchar(20)
	set @username = dbo.getUsernamebyID(@manv)
	print @username
	DECLARE @sql NVARCHAR(MAX);
	SET @sql = N'DROP SCHEMA ' + QUOTENAME(@username) + N'; DROP USER ' + QUOTENAME(@username) + N'; DROP LOGIN ' + QUOTENAME(@username);
	EXEC sp_executesql @sql;
	delete ACCOUNT where IDEMP = @manv
	delete EMPLOYEES where IDEMP = @manv
end
 go

 select * from EMPLOYEES
 select count(*) from ACCOUNT where USERNAME ='hang'


-- SP doi mat khau
go
CREATE PROCEDURE ChangeUserPassword
    @Username NVARCHAR(50),
    @NewPassword NVARCHAR(50)
AS
BEGIN
   DECLARE @Sql NVARCHAR(50);
    SET @Sql = 'ALTER LOGIN ' + QUOTENAME(@Username) + ' WITH PASSWORD = ''' + @NewPassword + '''';
    EXEC sp_executesql @Sql;
END;
go

Create procedure findEmployee
@thongtin nvarchar(100)
as
begin
	select * from EMPLOYEES 
	where IDEMP like '%'+@thongtin+'%' or NAME like '%'+@thongtin+'%'or EMAIL like '%'+@thongtin+'%'
end
go
-- Xoa 1 sản phẩm
CREATE PROCEDURE deleteProduct
    @productID INT
AS
BEGIN
    BEGIN TRY
        -- Start a transaction
        BEGIN TRANSACTION;

        -- Delete from BILLDETAILS referencing the product
        DELETE FROM BILLDETAILS WHERE IDPRODUCT = @productID;

        -- Delete from PRODUCT
        DELETE FROM PRODUCT WHERE IDPRODUCT = @productID;

        -- Commit the transaction
        COMMIT TRANSACTION;
        
        PRINT 'Product deleted successfully.';
    END TRY
    BEGIN CATCH
        -- If an error occurs, rollback the transaction
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        -- Print error message
        PRINT ERROR_MESSAGE();
    END CATCH;
END;
--Xoá 1 loại sản phẩm
CREATE PROCEDURE deleteCategory
    @categoryID INT
AS
BEGIN
    BEGIN TRY
        -- Start a transaction
        BEGIN TRANSACTION;

        -- Delete from BILLDETAILS referencing products in the category
        DELETE FROM BILLDETAILS WHERE IDPRODUCT IN (SELECT IDPRODUCT FROM PRODUCT WHERE IDCATEGORY = @categoryID);

        -- Delete from PRODUCT
        DELETE FROM PRODUCT WHERE IDCATEGORY = @categoryID;

        -- Delete from CATEGORY
        DELETE FROM CATEGORY WHERE IDCATEGORY = @categoryID;

        -- Commit the transaction
        COMMIT TRANSACTION;
        
        PRINT 'Category and associated products deleted successfully.';
    END TRY
    BEGIN CATCH
        -- If an error occurs, rollback the transaction
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        -- Print error message
        PRINT ERROR_MESSAGE();
    END CATCH;
END;
--Tìm sản phẩm
create PROCEDURE findProduct
    @searchInfo NVARCHAR(100)
AS
BEGIN
    SELECT * 
    FROM PRODUCT
    WHERE NAME LIKE '%' + @searchInfo + '%' 
       OR IDPRODUCT LIKE '%' + @searchInfo + '%' 
    
END
GO
--Tìm loại sản phẩm
CREATE PROCEDURE findCategory
    @searchInfo NVARCHAR(100)
AS
BEGIN
    SELECT * 
    FROM CATEGORY
    WHERE NAME LIKE '%' + @searchInfo + '%';
END
GO

exec findEmployee 'hang'
go
select * from ACCOUNT
select * from EMPLOYEES
select * from sys.database_principals

ALTER SEQUENCE MANAGERSEQU
RESTART WITH 1;
Exec CreateUserManager'chicong','123',N'Trần Chí Công','tranchicong@gmail.com','Manager',N'TP. Hồ Chí Minh',2003,'0812865723' ;
Exec CreateUserStaff 'thihang','123',N'Nguyễn Thị Hằng','vanhoang@gmail.com','Staff',N'TP. Hồ Chí Minh',2003,'0812834655' ;
go
 exec deleteNhanVien 'NVBH08'

 go
 use qlbanhang
 go
 select POSITION from employees where IDEMP = 'NVBH01';
 select IDEMP from ACCOUNT where USERNAME = 'hang';
 Insert into BILLDETAILS(IDBILL,IDPRODUCT,COUNT) values(5,9,2);
 select * from BILLDETAILS where IDBILL = 7;
 select * from BILL;
 select * from PRODUCT;

 select IDPRODUCT from PRODUCT where NAME = N'Trá đá';
SELECT *    FROM CUSTOMER    WHERE NAME LIKE '%0812345686%'      OR IDCUS LIKE '%0812345686%'     OR PHONE LIKE   '%0812345686%';

INSERT INTO BILL(IDBILL,DISCOUNT,TOTALPRICE,BILLDATE,IDEMP,IDCUS) VALUES (NEXT VALUE FOR BILLSEQU, 10000, 100000, '2024-05-21', 'QLST01','10');
go
INSERT INTO BILL(IDBILL,DISCOUNT,TOTALPRICE,BILLDATE,IDEMP,IDCUS) VALUES (NEXT VALUE FOR BILLSEQU, 20000, 100000, '2024-05-21', 'QLST01','10');
go
INSERT INTO BILL(IDBILL,DISCOUNT,TOTALPRICE,BILLDATE,IDEMP,IDCUS) VALUES (NEXT VALUE FOR BILLSEQU, 30000, 100000, '2024-05-21', 'QLST01','10');
go
SELECT * FROM BILL;
INSERT INTO BILLDETAILS(IDBILL,IDPRODUCT,COUNT,DISCOUNT,TOTAL) VALUES (3,1,2,10,190000);
SELECT * FROM BILLDETAILS;


SELECT 
    E.NAME AS EmployeeName,
    P.NAME AS ProductName,
    BD.COUNT AS Quantity,
    P.PRICE AS UnitPrice,
    BD.TOTAL,
	 RIGHT(REPLICATE('0', 9) + CAST(B.IDBILL AS VARCHAR(9)), 9) AS BillNumber,
	BD.TOTAL *(1 - BD.DISCOUNT/100) as discountProduct,
	p.PRICE  *(1 - BD.DISCOUNT/100) as discountPrice,
    B.BILLDATE AS BillDate,
    B.TOTALPRICE AS TotalBillPrice,
	K.IDCUS as CustomerID,
	K.NAME as CustomerName,
	B.TOTALPRICE - B.DISCOUNT as discountBill
FROM 
    BILL B
JOIN 
    BILLDETAILS BD ON B.IDBILL = BD.IDBILL
JOIN 
    EMPLOYEES E ON B.IDEMP = E.IDEMP
JOIN 
    PRODUCT P ON BD.IDPRODUCT = P.IDPRODUCT
JOIN 
    CUSTOMER K ON B.IDCUS = K.IDCUS
WHERE B.IDBILL = 3;

select * from BILLDETAILS

SELECT bd.*, p.NAME AS ProductName
FROM BILLDETAILS bd
JOIN PRODUCT p ON bd.IDPRODUCT = p.IDPRODUCT where IDBILL in (select IDBILL from BILLDETAILS where IDPRODUCT = 1)
order by bd.IDBILL;
go

select * from CUSTOMER where IDCUS= 10;

CREATE TRIGGER UPDATE_PRODUCT_QUANTITY
ON BILLDETAILS
AFTER INSERT
AS
BEGIN
    DECLARE @PRODUCT_ID INT;
    DECLARE @QUANTITY INT;

    -- Lấy ID sản phẩm và số lượng từ dòng mới được thêm vào bảng BILLDETAILS
    SELECT @PRODUCT_ID = IDPRODUCT, @QUANTITY = COUNT
    FROM INSERTED;

    -- Giảm số lượng sản phẩm trong bảng PRODUCT
    UPDATE PRODUCT
    SET QUANTITY = QUANTITY - @QUANTITY
    WHERE IDPRODUCT = @PRODUCT_ID;
END;

select * from EMPLOYEES
select * from CUSTOMER