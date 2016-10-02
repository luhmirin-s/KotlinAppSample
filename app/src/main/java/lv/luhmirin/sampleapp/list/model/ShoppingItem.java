package lv.luhmirin.sampleapp.list.model;


import android.support.annotation.NonNull;

public class ShoppingItem {

    private final String name;
    private final String description;
    private final float price;

    public ShoppingItem(@NonNull String name, @NonNull String description, float priceInCent) {
        this.name = name;
        this.description = description;
        this.price = priceInCent;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingItem that = (ShoppingItem) o;

        return price == that.price
                && name.equals(that.name)
                && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }
}
