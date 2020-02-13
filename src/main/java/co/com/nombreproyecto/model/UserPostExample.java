package co.com.nombreproyecto.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "salary",
    "age"
})
public class UserPostExample {

    @JsonProperty("name")
    public String name;
    @JsonProperty("salary")
    public String salary;
    @JsonProperty("age")
    public String age;

}
