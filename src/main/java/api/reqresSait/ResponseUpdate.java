package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUpdate extends RequestUpdate {


    private String updatedAt;


    public ResponseUpdate(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }
}
