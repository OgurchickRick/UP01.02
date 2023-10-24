package model.ResponseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponse {
    public Integer page;
    @JsonProperty("per_page")
    public Integer perPage;
    public Integer total;
    @JsonProperty("total_pages")
    public Integer totalPages;
    public List<DataUserResponse> data;
    public SupportResponse support;
}
