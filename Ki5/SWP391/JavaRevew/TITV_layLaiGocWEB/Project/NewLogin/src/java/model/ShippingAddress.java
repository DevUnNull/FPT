package model;

import java.io.Serializable;

public class ShippingAddress implements Serializable {
    private Integer addressId;     // PK
    private Integer userId;        // FK -> users.user_id
    private String recipientName;
    private String phone;
    private String addressDetail;
    private String city;
    private String postalCode;

    public ShippingAddress() {}

    public ShippingAddress(Integer addressId, Integer userId, String recipientName,
                           String phone, String addressDetail, String city, String postalCode) {
        this.addressId = addressId;
        this.userId = userId;
        this.recipientName = recipientName;
        this.phone = phone;
        this.addressDetail = addressDetail;
        this.city = city;
        this.postalCode = postalCode;
    }

    // Convenience constructor (khi insert, chưa có addressId)
    public ShippingAddress(Integer userId, String recipientName, String phone,
                           String addressDetail, String city, String postalCode) {
        this(null, userId, recipientName, phone, addressDetail, city, postalCode);
    }

    public Integer getAddressId() { return addressId; }
    public void setAddressId(Integer addressId) { this.addressId = addressId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddressDetail() { return addressDetail; }
    public void setAddressDetail(String addressDetail) { this.addressDetail = addressDetail; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", recipientName='" + recipientName + '\'' +
                ", phone='" + phone + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
