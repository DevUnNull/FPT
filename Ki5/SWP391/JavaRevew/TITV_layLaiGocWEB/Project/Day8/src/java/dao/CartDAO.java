package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import model.CartItem;

public class CartDAO {
    private final List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() { return items; }

    public CartItem findLine(int productId) {
        for (CartItem ci : items) {
            if (ci.getProductId() == productId) return ci;
        }
        return null;
    }

    public int getQuantityOf(int productId) {
        CartItem ci = findLine(productId);
        return (ci != null) ? ci.getQuantity() : 0;
    }

    // Thêm như hiện tại (gộp cùng productId)
    public void addItem(CartItem item) {
        CartItem line = findLine(item.getProductId());
        if (line != null) {
            line.setQuantity(line.getQuantity() + item.getQuantity());
        } else {
            items.add(item);
        }
    }

    // Xoá cả dòng
    public void removeItem(int productId) {
        items.removeIf(i -> i.getProductId() == productId);
    }

    // ↓↓↓ NEW: đặt số lượng tuyệt đối
    public boolean updateQuantity(int productId, int newQty) {
        CartItem line = findLine(productId);
        if (line == null) {
            if (newQty > 0) return false; // tuỳ bạn: có thể auto add nếu muốn
            return false;
        }
        if (newQty > 0) {
            line.setQuantity(newQty);
        } else {
            removeItem(productId); // newQty <= 0 thì xoá dòng
        }
        return true;
    }

    // ↓↓↓ NEW: tăng theo delta (>0)
    public void increaseQuantity(int productId, int delta) {
        if (delta <= 0) return;
        CartItem line = findLine(productId);
        if (line != null) {
            line.setQuantity(line.getQuantity() + delta);
        }
    }

    // ↓↓↓ NEW: giảm theo delta (>0), nếu về 0 thì xoá
    public void decreaseQuantity(int productId, int delta) {
        if (delta <= 0) return;
        CartItem line = findLine(productId);
        if (line == null) return;
        int q = line.getQuantity() - delta;
        if (q > 0) line.setQuantity(q);
        else removeItem(productId);
    }

    public int getTotalQuantity() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public double getTotal() {
        return items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
    }
}
