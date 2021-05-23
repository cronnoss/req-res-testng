package api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class UserPayload{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;
}