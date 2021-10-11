package my.compary.restaurant;

import my.compary.restaurant.infra.FieldPropertyVisibilityStrategy;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbVisibility;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Schema(name = "Ingredient", description = "The ingredient of an item")
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Ingredient {

    @NotBlank
    @Size(min = 3, max = 20, message = "The name size should be between 3 and 10 chars")
    private String name;

    @NotBlank
    private String unit;

    @PositiveOrZero(message = "a quantity cannot be negative")
    private double quantity;

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
