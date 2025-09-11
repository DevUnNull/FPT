# Git Guide - Team Workflow on GitLab

## **1. Quy ước chung**
- **Branch chính:**
  - `main`: Đây là nhánh chính, chứa mã nguồn production. Được bảo vệ (protected branch). Mọi thay đổi vào `main` cần thông qua **Merge Request (MR)** và phải được review.
  - `dev`: Đây là nhánh phát triển chung. Là nơi tập hợp các thay đổi từ các nhánh feature trước khi được merge vào `main`.
- **Branch feature:**
  - Mỗi tính năng hoặc task sẽ được làm trên một nhánh riêng, bắt đầu từ `dev`.
  - Tên nhánh cần đặt theo quy tắc: `feature/<tên-tính-năng>` hoặc `bugfix/<mô-tả-ngắn>`.

---

## **2. Quy trình làm việc**
### **Bước 1: Cập nhật nhánh `dev`**
Trước khi bắt đầu làm việc, đảm bảo đang làm việc với phiên bản mới nhất của nhánh `dev`:

```bash
git checkout dev
git pull origin dev
```

### **Bước 2: Tạo nhánh `feature`**
Tạo một nhánh mới từ dev để làm việc::
```bash
git checkout -b feature/<feature-name>
```

Lưu ý đặt tên nhánh:
+ Sử dụng tiền tố feature/ cho các tính năng mới.
+ Sử dụng tiền tố bugfix/ cho các lỗi cần sửa.

### **Bước 3: Phát triển tính năng**
Sau khi thực hiện các thay đổi, kiểm tra trạng thái, thêm tệp và commit.
```bash
git status    # Kiểm tra trạng thái tệp
git add .     # Thêm tất cả tệp thay đổi
git commit -m "Mô tả rõ ràng về thay đổi"
```

Nếu cần thực hiện nhiều commit, có thể commit nhiều lần trong quá trình phát triển.

### **Bước 4: Push nhánh lên remote**
Khi hoàn thành công việc hoặc cần chia sẻ code, đẩy nhánh lên remote để đồng đội có thể xem xét:
```bash
git push origin feature/<feature-name>
```

### **Bước 5: Merge nhánh feature vào dev**
**Tự merge (không cần Merge Request)**
Đảm bảo nhánh dev đã được cập nhật mới nhất:
```bash
git checkout dev  # Cần di chuyển sanh nhánh dev
git pull origin dev   # Cập nhật dev mới nhất
```
Merge nhánh feature vào dev
```bash
git merge feature/<feature-name>   # Merge những thay đổi từ feature vào dev
git push origin dev  # Push các thay đổi lên remote dev
```

**Nếu muốn sử dụng Merge Request (không bắt buộc)**
Nếu muốn sử dụng MR cho việc merge vào dev:
+ Tạo Merge Request từ feature/<feature-name> vào dev.
+ Merge trực tiếp (không cần review) sau khi kiểm tra.

### **Bước 6: Merge dev vào main**
Mọi thay đổi chỉ được merge từ nhánh dev vào main thông qua Merge Request (MR).
**Quy trình:**
+ Đảm bảo nhánh dev đã ổn định (được kiểm tra và test đầy đủ).
+ Tạo một Merge Request từ dev vào main.
+ Người review kiểm tra code, test kỹ càng trước khi đồng ý merge.
+ Sau khi MR được duyệt, merge vào main.

## **3. Quy trình xử lý xung đột (Conflict)**
+ Nếu xảy ra xung đột khi merge, Git sẽ thông báo.
+ Chuyển sang nhánh feature hoặc nhánh dev (tùy thuộc vào tình huống).
+ Kéo các thay đổi mới nhất từ nhánh cần thiết:
```bash
git pull origin dev # hoặc nhánh feature
```
+ Giải quyết xung đột trong code.
+ Khi đã giải quyết xung đột, commit lại:
```bash
git add .
git commit -m "Resolve conflict với dev"
```

+ Push lại nhánh đã giải quyết xung đột:
```bash
git push origin feature/<feature-name>
```

## **4. Các lưu ý quan trọng**
+ Không commit trực tiếp vào main hoặc dev:
+ Luôn cập nhật nhánh dev trước khi tạo nhánh feature.
+ Kiểm tra kỹ code trước khi merge:
    - Code phải chạy được và không có lỗi.
    - Đảm bảo các thay đổi đã được kiểm tra (test) đầy đủ.

```bash
git checkout dev ; git merge --no-ff --no-edit feature/branch-name ; git push origin dev --force-with-lease
```