package api.reqresSait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ResponseUserDataPage2 {
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public ResponseUserDataPage2(Integer id, String email, String first_name, String last_name, String avatar) {
                this.id = id;
                this.email = email;
                this.first_name = first_name;
                this.last_name = last_name;
                this.avatar = avatar;
        }

        @Override
        public String toString() {
                return "UserDataPage2{" +
                        "id=" + id +
                        ", email='" + email + '\'' +
                        ", first_name='" + first_name + '\'' +
                        ", last_name='" + last_name + '\'' +
                        ", avatar='" + avatar + '\'' +
                        '}';
        }
}
