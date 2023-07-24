package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ResponseListResourseData {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;

    public ResponseListResourseData(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }
}
