package api.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncrementNumberResponse {

    private String errorMessage;
    private String response;

}
