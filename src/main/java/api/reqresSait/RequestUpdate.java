package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class RequestUpdate {

    private String name;
    private String job;

    public RequestUpdate(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
