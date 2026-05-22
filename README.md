# Hệ Thống Quản Lý Hộ Dân Và Thu Phí 🏢💰

Dự án đồ án môn học Kỹ nghệ phần mềm - Phát triển ứng dụng quản lý thông tin cư dân, hộ khẩu và tối ưu hóa quy trình đóng góp, thu các khoản phí tại khu dân cư/tổ dân phố.

---

## 👥 Thành viên nhóm và Vai trò

| STT | Họ và tên | Mã sinh viên | Vai trò trong dự án | Công việc đảm nhiệm |
|---|---|---|---|---|
| 1 | [Nguyễn Quang Minh] | [202416566] | **Nhóm trưởng / BA** | Điều phối nhóm, quản lý GitHub (Sprint/Backlog), phân tích yêu cầu hệ thống (SRS, Use Case, Activity Diagram), tổng hợp báo cáo. |
| 2 | [Mouen Malang] | [20239706] | **Frontend Developer** | Thiết kế giao diện (Mockup), hiện thực hóa UI các Form (Đăng nhập, Hộ dân, Khoản thu, Thu phí, Thống kê), validate dữ liệu đầu vào. |
| 3 | [Nguyễn Trung Dũng] | [20235055] | **Backend Developer** | Thiết lập cấu trúc nguồn, viết logic nghiệp vụ (CRUD, Login, Tính toán phí), kết nối MySQL qua JDBC, tích hợp hệ thống. |
| 4 | [Nguyễn Hoàng Phong] | [202416586] | **System & DB Designer** | Thiết kế kiến trúc MVC, thiết kế cơ sở dữ liệu MySQL (ERD, Table, Relation), vẽ Class/Sequence Diagram, hỗ trợ dữ liệu cho Backend. |
| 5 | [Vũ Đức Hiệp] | [202416487] | **QA / Tester** | Quản lý rủi ro dự án, lập kịch bản kiểm thử (Test Case), thực hiện Black-box/White-box testing, theo dõi và báo cáo lỗi (Bug tracking). |

---

## 🛠️ Công nghệ sử dụng

* **Ngôn ngữ lập trình:** Java (OOP)
* **Kiến trúc hệ thống:** MVC (Model - View - Controller)
* **Cơ sở dữ liệu:** MySQL
* **Công nghệ kết nối:** JDBC (Java Database Connectivity)
* **Quản lý mã nguồn:** Git & GitHub (Mô hình Agile/Scrum)

---

## 📌 Các chức năng cốt lõi

1.  **Đăng nhập & Phân quyền:** Xác thực tài khoản Admin/Cán bộ quản lý để bảo mật thông tin.
2.  **Quản lý Hộ dân & Nhân khẩu:** Thực hiện các tác vụ Thêm, Sửa, Xóa, Tìm kiếm thông tin chủ hộ, thành viên và số nhân khẩu.
3.  **Quản lý Khoản thu:** Khởi tạo các khoản phí bắt buộc (vệ sinh, an ninh...) hoặc các khoản đóng góp tự nguyện.
4.  **Quản lý Thu phí:** Tính toán số tiền cần nộp theo từng hộ (dựa trên diện tích hoặc số nhân khẩu), ghi nhận lịch sử giao dịch.
5.  **Thống kê & Báo cáo:** Xuất số liệu tổng hợp về các hộ đã hoàn thành, chưa hoàn thành hoặc danh sách tiền thu theo tháng.

---

## 📂 Cấu trúc thư mục dự án (Kiến trúc MVC)

```text
├── database/               # Chứa script khởi tạo cơ sở dữ liệu (.sql)
├── src/
│   ├── model/              # Chứa các lớp đối tượng (User, HoDan, KhoanThu...)
│   ├── view/               # Giao diện người dùng (Form giao diện, Component UI)
│   ├── controller/         # Xử lý luồng dữ liệu giữa Model và View
│   └── util/               # Các hàm tiện ích (Kết nối DB, Mã hóa, Định dạng...)
├── .env.example            # File cấu hình môi trường mẫu
├── .gitignore              # Bộ lọc chặn file rác khi push code
└── README.md               # Hướng dẫn dự án này
