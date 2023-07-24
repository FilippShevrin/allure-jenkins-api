package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class RequestRegister {
    private String email;
    private String password;

    public RequestRegister(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
