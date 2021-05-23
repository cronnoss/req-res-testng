package api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Support{

	@JsonProperty("text")
	private String text;

	@JsonProperty("url")
	private String url;
}