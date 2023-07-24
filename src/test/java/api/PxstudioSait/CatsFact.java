package api.PxstudioSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
public class CatsFact {
    private String fact;
    private Integer length;

    public CatsFact(String fact, Integer length) {
        this.fact = fact;
        this.length = length;
    }
}

