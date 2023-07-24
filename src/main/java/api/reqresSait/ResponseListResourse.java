package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ResponseListResourse {
    private Integer page;
    private Integer per_page;
    private Integer  total;
    private Integer total_pages;
    private ArrayList<ResponseListResourseData> data;
    private Support support;

    public ResponseListResourse(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<ResponseListResourseData> data, Support support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }
}

class Support {
    private String url;
    private String text;
}
