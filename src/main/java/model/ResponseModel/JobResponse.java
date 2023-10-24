package model.ResponseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
    public Date updatedAt;
}
