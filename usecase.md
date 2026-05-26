left to right direction

actor "Quản trị viên (Admin)" as admin
actor "Cán bộ / Kế toán" as canbo
actor "Cư dân" as cudan

package "Hệ thống Quản lý Hộ dân & Thu phí" {
  usecase "UC01: Đăng nhập" as uc_login
  usecase "UC02: Quản lý tài khoản cán bộ" as uc_qltk
  usecase "UC03: Quản lý hộ gia đình" as uc_qlhg
  usecase "UC04: Quản lý khoản thu" as uc_qlkt
  usecase "UC05: Ghi nhận đóng phí" as uc_thuphi
  usecase "UC06: Tra cứu & Thống kê" as uc_thongke
  usecase "UC07: Gửi phản ánh/khiếu nại" as uc_phananh
  
  usecase "In biên lai" as uc_inbienlai
}

%% Phân quyền sử dụng
admin --> uc_login
canbo --> uc_login
cudan --> uc_login

admin --> uc_qltk
admin --> uc_qlhg
admin --> uc_qlkt

canbo --> uc_qlhg
canbo --> uc_qlkt
canbo --> uc_thuphi
canbo --> uc_thongke

cudan --> uc_phananh

%% Quan hệ đặc biệt
uc_thuphi <.. uc_inbienlai : <<extend>>
