# NMCNPM-Nhom16

Phần Source code bài tập lớn môn học NMCNPM của nhóm 16</br>
Website sử dụng IDE Neatbean, webserver glassfish 4.0, database: sqlserver


## Để demo web, cần thực hiện các bước sau:

  - Restore database tải ở đây: [SalesWebsite.bak](https://drive.google.com/file/d/1gEYIV4J0USCaRQO1ntoBwAa7zwy2Y07B/view?usp=sharing)
  
  - Tải 2 file [jstl-1.2.jar](https://drive.google.com/file/d/1C4tFNimev5tOioIzTYASBmVGgEdh5QbW/view?usp=sharing) và [sqljdbc4-2.0.jar](https://drive.google.com/file/d/1HVrNOwQALe88e_c72DHn1nWd0_3VGVHs/view?usp=sharing), copy vào thư mục ..\glassfish-4.0\glassfish\lib trong glassfish4.0 của bạn.
  
  - Tạo Ressources JDBC: jdbc/SalesWebsite trong giao diện Domain Admin Console (http://localhost:4848)


## Để đăng nhập vào giao diện admin, vào link http://localhost:8080/NMCNPM-Nhom16/admin </br>
Phần admin có thể đăng nhập vào một trong các tài khoản sau.
- Tên đăng nhập: VanTrung, Mật khẩu: 1
- Tên đăng nhập: MinhTuan, Mật khẩu: 1
- Tên đăng nhập: PhoBen, Mật khẩu: 1
- Tên đăng nhập: VanHiep, Mật khẩu: 1


## Website có các chức năng:

Phần front-end
  - Tìm kiếm theo tên sản phẩm 
  - Lọc theo hãng, tầm giá 
  - Sắp xếp theo tên, theo giá
  - Lọc theo khuyến mãi
  - Đăng nhập, đăng xuất
  - Giỏ hàng, thanh toán

Phần back-end
  - Xem thông số bán hàng (số máy bán ra trong 7 ngày gần nhất, top 3 nhãn hiệu bán chạy, ...)
  - Quản lý đơn hàng (xem đơn hàng, xóa đơn hàng)
  - Quản lý sản phẩm (thêm sản phẩm, sửa đổi thông tin sản phẩm)
  - Quản lý người dùng (thiết lập trạng thái hoạt động, chặn cho người dùng)


