package ShoppingCart;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

enum PromotionEnum {
    PromoCode1("FAAVC", "22/05/2017", "22/12/2018"), PromoCode2("FAAVD", "22/06/2018", "22/12/2018"), PromoCode3("FAAVE", "01/06/2018",
        "01/12/2018");
    String code;
    String startDate;
    String endDate;

    PromotionEnum(String code, String startDate, String endDate) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}

interface PromotionOrder {
    public int getMinimumPrice(Products product);

    public void setMinimumPrice(int price);

    public int getFixedDiscount(Products product);

    public void setFixedDiscount(int discount);

    public boolean isPromotionApplicable(String code);
}

class fixedProductPromotion implements PromotionOrder {
    private int discount;
    private int minimumPrice;

    fixedProductPromotion() {
        discount = 0;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getMinimumPrice(Products product) {
        return product.discountOnProduct(minimumPrice);
    }

    public int getFixedDiscount(Products product) {
        return (discount * (product.discountOnProduct(minimumPrice)) / 100);
    }

    public void setFixedDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isPromotionApplicable(String code) {
        Date date = new Date();
        for (PromotionEnum enumValue : PromotionEnum.values()) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            long start = 0;
            long end = 0;
            long current = 0;
            try {
                Date startDate = (Date) formatter.parse(enumValue.getStartDate());
                Date endDate = (Date) formatter.parse(enumValue.getEndDate());
                start = startDate.getTime();
                end = endDate.getTime();
                current = date.getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (enumValue.getCode().equals(code) && current >= start && current <= end) {
                return true;
            }
        }
        return false;
    }
}

class fixedOrderPromotion implements PromotionOrder {
    private int discount;
    private int minimumPrice;

    fixedOrderPromotion() {
        discount = 0;
    }

    public int getMinimumPrice(Products product) {
        return product.totalPrice();
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getFixedDiscount(Products product) {
        return discount * product.totalPrice() / 100;
    }

    public void setFixedDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isPromotionApplicable(String code) {

        Date date = new Date();
        for (PromotionEnum enumValue : PromotionEnum.values()) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            long start = 0;
            long end = 0;
            long current = 0;
            try {
                Date startDate = (Date) formatter.parse(enumValue.getStartDate());
                Date endDate = (Date) formatter.parse(enumValue.getEndDate());
                start = startDate.getTime();
                end = endDate.getTime();
                current = date.getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (enumValue.getCode().equals(code) && current >= start && current <= end) {
                return true;
            }
        }
        return false;
    }
}
