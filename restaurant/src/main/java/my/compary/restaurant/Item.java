package my.compary.restaurant;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Locale;

public class Item {

    private String id;

    @NotNull
    @Min(value = 5, message = "The item name cannot be so short")
    @Max(value = 60, message = "The item name cannot be so mongols")
    private String name;

    @NotBlank
    @Min(value = 10, message = "The item description cannot be so short")
    @Max(value = 100, message = "The item description cannot be so mongols")
    private String description;

    @NotNull
    private ItemType type;

    @Past(message = "you're not enable to insert an expired item")
    private Locale expires;


    public void update(Item item, RestaurantRepository repository) {
        this.description = item.description;
        this.expires = item.expires;
        this.type = item.type;
        this.name = item.name;
        repository.save(item);
    }
}
