package api.reqresSait;
import java.util.ArrayList;

public class ResponseUserRootPage2 {
        private Integer page;
        private Integer per_page;
        private Integer total;
        private Integer total_pages;
        private ArrayList<ResponseUserDataPage2> data;

        public ResponseUserRootPage2(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<ResponseUserDataPage2> data) {
                this.page = page;
                this.per_page = per_page;
                this.total = total;
                this.total_pages = total_pages;
                this.data = data;
        }

        public Integer getPage() {
                return page;
        }

        public Integer getPer_page() {
                return per_page;
        }

        public Integer getTotal() {
                return total;
        }

        public Integer getTotal_pages() {
                return total_pages;
        }

        public ArrayList<ResponseUserDataPage2> getData() {
                return data;
        }
}
