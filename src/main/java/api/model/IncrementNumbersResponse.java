package api.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncrementNumbersResponse {

    private String errorMessage;
    private String response;

}
