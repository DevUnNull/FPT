<!-- Git Guide - Team Workflow on GitLab (HTML) -->
<div style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial; line-height:1.5; color:#111;">

  <h1 style="margin-bottom:0.25rem;">Git Guide - Team Workflow on GitLab</h1>
  <p style="margin-top:0; color:#555;">Hướng dẫn quy ước và quy trình làm việc với Git cho team.</p>

  <!-- Table of Contents -->
  <nav aria-label="Table of contents" style="margin:1rem 0;">
    <strong>Mục lục</strong>
    <ul>
      <li><a href="#quy-uoc-chung">1. Quy ước chung</a></li>
      <li><a href="#quy-trinh-lam-viec">2. Quy trình làm việc</a>
        <ul>
          <li><a href="#buoc-1">Bước 1: Cập nhật nhánh dev</a></li>
          <li><a href="#buoc-2">Bước 2: Tạo nhánh feature</a></li>
          <li><a href="#buoc-3">Bước 3: Phát triển tính năng</a></li>
          <li><a href="#buoc-4">Bước 4: Push nhánh lên remote</a></li>
          <li><a href="#buoc-5">Bước 5: Merge feature vào dev</a></li>
          <li><a href="#buoc-6">Bước 6: Merge dev vào main</a></li>
        </ul>
      </li>
      <li><a href="#xu-ly-conflict">3. Quy trình xử lý xung đột (Conflict)</a></li>
      <li><a href="#luu-y">4. Các lưu ý quan trọng</a></li>
      <li><a href="#lenh-gop-nhanh">Lệnh gộp nhanh</a></li>
    </ul>
  </nav>

  <hr>

  <!-- Section 1 -->
  <section id="quy-uoc-chung">
    <h2>1. Quy ước chung</h2>
    <ul>
      <li>
        <strong>Branch chính:</strong>
        <ul>
          <li><code>main</code>: nhánh production, được bảo vệ (protected). Mọi thay đổi vào <code>main</code> cần qua Merge Request (MR) và được review.</li>
          <li><code>dev</code>: nhánh phát triển chung, nơi tập hợp thay đổi từ các feature trước khi merge vào <code>main</code>.</li>
        </ul>
      </li>
      <li>
        <strong>Branch feature:</strong>
        <ul>
          <li>Mỗi feature/task làm trên nhánh riêng, xuất phát từ <code>dev</code>.</li>
          <li>Tên nhánh theo quy tắc: <code>feature/&lt;tên-tính-năng&gt;</code> hoặc <code>bugfix/&lt;mô-tả-ngắn&gt;</code>.</li>
        </ul>
      </li>
    </ul>
  </section>

  <hr>

  <!-- Section 2 -->
  <section id="quy-trinh-lam-viec">
    <h2>2. Quy trình làm việc</h2>

    <h3 id="buoc-1">Bước 1: Cập nhật nhánh <code>dev</code></h3>
    <p>Trước khi bắt đầu làm việc, đảm bảo đang ở phiên bản mới nhất của <code>dev</code>:</p>
    <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git checkout dev
git pull origin dev</code></pre>

    <h3 id="buoc-2">Bước 2: Tạo nhánh <code>feature</code></h3>
    <p>Tạo nhánh mới từ <code>dev</code>:</p>
    <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git checkout -b feature/&lt;feature-name&gt;</code></pre>
    <p>Lưu ý:</p>
    <ul>
      <li>Sử dụng tiền tố <code>feature/</code> cho tính năng mới.</li>
      <li>Sử dụng tiền tố <code>bugfix/</code> cho sửa lỗi.</li>
    </ul>

    <h3 id="buoc-3">Bước 3: Phát triển tính năng</h3>
    <p>Sau khi thay đổi, kiểm tra trạng thái, thêm tệp và commit:</p>
    <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git status    # Kiểm tra trạng thái tệp
git add .       # Thêm tất cả tệp thay đổi
git commit -m "Mô tả rõ ràng về thay đổi"</code></pre>
    <p>Có thể commit nhiều lần trong quá trình phát triển.</p>

    <h3 id="buoc-4">Bước 4: Push nhánh lên remote</h3>
    <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git push origin feature/&lt;feature-name&gt;</code></pre>

    <h3 id="buoc-5">Bước 5: Merge nhánh feature vào <code>dev</code></h3>
    <details>
      <summary><strong>Tự merge (không cần Merge Request)</strong></summary>
      <div style="margin-top:0.5rem;">
        <p>Đảm bảo nhánh <code>dev</code> đã được cập nhật:</p>
        <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git checkout dev
git pull origin dev</code></pre>
        <p>Merge và push:</p>
        <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git merge feature/&lt;feature-name&gt;
git push origin dev</code></pre>
      </div>
    </details>

    <details style="margin-top:0.5rem;">
      <summary><strong>Sử dụng Merge Request (không bắt buộc)</strong></summary>
      <div style="margin-top:0.5rem;">
        <ul>
          <li>Tạo Merge Request từ <code>feature/&lt;feature-name&gt;</code> vào <code>dev</code>.</li>
          <li>Có thể merge trực tiếp (không cần review) nếu đã kiểm tra kỹ.</li>
        </ul>
      </div>
    </details>

    <h3 id="buoc-6">Bước 6: Merge <code>dev</code> vào <code>main</code></h3>
    <p>Mọi thay đổi chỉ được merge từ <code>dev</code> sang <code>main</code> qua Merge Request (MR).</p>
    <ul>
      <li>Đảm bảo <code>dev</code> ổn định, được test đầy đủ.</li>
      <li>Tạo MR từ <code>dev</code> → <code>main</code>.</li>
      <li>Người review kiểm tra code, test kỹ rồi duyệt MR.</li>
    </ul>
  </section>

  <hr>

  <!-- Section 3 -->
  <section id="xu-ly-conflict">
    <h2>3. Quy trình xử lý xung đột (Conflict)</h2>
    <ol>
      <li>Nếu xảy ra xung đột khi merge, Git sẽ báo.</li>
      <li>Chuyển sang nhánh feature hoặc dev (tùy tình huống).</li>
      <li>Kéo các thay đổi mới nhất từ nhánh cần thiết:
        <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.5rem;border-radius:6px;overflow:auto;"><code>git pull origin dev   # hoặc nhánh feature</code></pre>
      </li>
      <li>Giải quyết xung đột trong code bằng cách chỉnh sửa file.</li>
      <li>Khi đã xong, commit lại:
        <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.5rem;border-radius:6px;overflow:auto;"><code>git add .
git commit -m "Resolve conflict với dev"</code></pre>
      </li>
      <li>Push lại nhánh đã giải quyết:
        <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.5rem;border-radius:6px;overflow:auto;"><code>git push origin feature/&lt;feature-name&gt;</code></pre>
      </li>
    </ol>
  </section>

  <hr>

  <!-- Section 4 -->
  <section id="luu-y">
    <h2>4. Các lưu ý quan trọng</h2>
    <ul>
      <li>Không commit trực tiếp vào <code>main</code> hoặc <code>dev</code>.</li>
      <li>Luôn cập nhật <code>dev</code> trước khi tạo nhánh <code>feature</code>.</li>
      <li>Kiểm tra kỹ code trước khi merge:
        <ul>
          <li>Code phải chạy được và không có lỗi.</li>
          <li>Đảm bảo thay đổi đã được test đầy đủ.</li>
        </ul>
      </li>
    </ul>
  </section>

  <hr>

  <!-- Quick merge command -->
  <section id="lenh-gop-nhanh">
    <h3>Lệnh gộp nhanh</h3>
    <p>Ví dụ lệnh gộp nhanh (sử dụng khi bạn hiểu rủi ro):</p>
    <pre style="background:#f6f8fa;border:1px solid #e1e4e8;padding:0.75rem;border-radius:6px;overflow:auto;"><code>git checkout dev ; git merge --no-ff --no-edit feature/branch-name ; git push origin dev --force-with-lease</code></pre>
    <p style="color:#a00;"><strong>Lưu ý:</strong> Lệnh trên có thể dùng <code>--force-with-lease</code> khi cần; hãy cẩn thận để tránh ghi đè nhánh của người khác.</p>
  </section>

  <hr>

  <footer style="font-size:0.9rem; color:#555; margin-top:1rem;">
    <p>Document by team — điều chỉnh cho phù hợp với workflow của dự án.</p>
  </footer>

</div>
