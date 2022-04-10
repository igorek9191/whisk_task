package enums;

import lombok.Getter;

@Getter
public enum ITEM {
    MILK("Milk"),
    BREAD("Bread"),
    BUTTER("Butter"),
    CHEESE("Cheese"),
    ONION("Onion");

    private String text;

    ITEM(String text){
        this.text = text;
    }
}
