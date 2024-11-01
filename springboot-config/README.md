### Các nơi có thể config
Thứ tự ưu tiên theo danh sách sau.
1. /config/application.properties
2. /application.properties
3. /src/main/resources/config/application.properties
4. /src/main/resources/application.properties

### Các loại file cấu hình
Có 2 loại là application.properties và application.yaml
 
So sánh `application.properties` và `application.yaml` trong Spring Boot

| Đặc điểm                   | application.properties                   | application.yaml                         |
|----------------------------|------------------------------------------|------------------------------------------|
| **Định dạng**              | Key-value, mỗi dòng một cặp key-value    | Dạng YAML, hỗ trợ cấu trúc lồng nhau     |
| **Nested Configuration**   | Sử dụng dấu chấm để phân tách các trường | Hỗ trợ lồng nhau tự nhiên bằng cách thụt dòng |
| **Hỗ trợ Arrays**          | Không có cú pháp trực tiếp cho mảng      | Hỗ trợ mảng bằng dấu `-`                 |
| **Độ phổ biến**            | Phổ biến, được nhiều công cụ hỗ trợ      | Ngày càng phổ biến, dễ đọc, dễ quản lý   |
| **Khi nào nên dùng**       | Cấu hình đơn giản                        | Cấu hình phức tạp hoặc nhiều nested cấu trúc |

> **Chọn `application.properties`** nếu cấu hình đơn giản, hoặc chọn **`application.yaml`** nếu cần cấu trúc lồng nhau dễ đọc hơn.
