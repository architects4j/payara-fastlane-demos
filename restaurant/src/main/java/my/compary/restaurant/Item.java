package my.compary.restaurant;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

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
    @NotNull
    private LocalDate expires;


    public void checkId() {
        if (Objects.isNull(id)) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public void update(Item item, RestaurantRepository repository) {
        this.description = item.description;
        this.expires = item.expires;
        this.type = item.type;
        this.name = item.name;
        repository.save(item);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ItemType getType() {
        return type;
    }

    public LocalDate getExpires() {
        return expires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", expires=" + expires +
                '}';
    }

}
