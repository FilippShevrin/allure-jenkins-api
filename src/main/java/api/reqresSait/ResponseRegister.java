package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ResponseRegister {
    private Integer id;
    private String token;

    public ResponseRegister (Integer id, String token){
        this.id = id;
        this.token = token;
    }

}
