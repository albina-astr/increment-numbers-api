package api;

import api.model.IncrementNumbersDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void incrementNumbers_Test_SuccessfulCase1() {
        String expected = "{\"errorMessage\":null,\"response\":\"13 15 1000\"}";
        IncrementNumbersDto requestDto = IncrementNumbersDto.builder().request("12 14 999").build();

        ResponseEntity<String> response = restTemplate.postForEntity("/numbers/increment", requestDto, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    public void incrementNumbers_Test_SuccessfulCase2() {
        String expected = "{\"errorMessage\":null,\"response\":\"1000\"}";
        IncrementNumbersDto requestDto = IncrementNumbersDto.builder().request("999").build();

        ResponseEntity<String> response = restTemplate.postForEntity("/numbers/increment", requestDto, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    public void incrementNumbers_Test_500ErrorStringWithLetters() {
        String expected = "{\"errorMessage\":\"В запросе не всё числа\",\"response\":null}";
        IncrementNumbersDto requestDto = IncrementNumbersDto.builder().request("12в 13 1445").build();

        ResponseEntity<String> response = restTemplate.postForEntity("/numbers/increment", requestDto, String.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    public void incrementNumbers_Test_500ErrorNullString() {
        String expected = "{\"errorMessage\":\"Нулевая или пустая строка\",\"response\":null}";
        IncrementNumbersDto requestDto = IncrementNumbersDto.builder().build();

        ResponseEntity<String> response = restTemplate.postForEntity("/numbers/increment", requestDto, String.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    public void incrementNumbers_Test_500ErrorEmptyString() {
        String expected = "{\"errorMessage\":\"Нулевая или пустая строка\",\"response\":null}";
        IncrementNumbersDto requestDto = IncrementNumbersDto.builder().request("      ").build();

        ResponseEntity<String> response = restTemplate.postForEntity("/numbers/increment", requestDto, String.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

}
