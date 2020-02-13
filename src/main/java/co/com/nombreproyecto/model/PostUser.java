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
//@ToString()
//@ToString( includeFieldNames=false,exclude = {"createdAt","id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "job",
    "id",
    "createdAt"
})
public class    PostUser {

    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;
    @JsonProperty("id")
    public String id;
    @JsonProperty("createdAt")
    public String createdAt;

    @Override public String toString() {
        return  this.getId() + ", " + this.job ;
    }
}



