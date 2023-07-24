package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ResponseErrorRegister {
    private String error;

    public ResponseErrorRegister(String error) {
        this.error = error;
    }
}
