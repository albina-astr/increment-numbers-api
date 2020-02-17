package api.service;

import api.exception.CheckRequestStringException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NumbersService {

    public String incrementNumbersInString(String data) {

        if (Objects.isNull(data) || data.trim().length() == 0) {
            throw new CheckRequestStringException("Нулевая или пустая строка");
        }

        boolean containsLetters = data.matches(".*[a-zA-Zа-яA-Я].*");
        if (containsLetters) {
            throw new CheckRequestStringException("В запросе не всё числа");
        }

        String[] nums = data.split(" ");
        return Arrays.stream(nums)
                .mapToInt(val -> Integer.parseInt(val) + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

}
