package com.walmart.offersservice.domain;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import lombok.Getter;

import java.util.List;
import java.util.function.ToLongFunction;

import static java.util.Arrays.asList;

@Getter
public class Description {

    private static final List<Character> VOCALS = asList(
            'a', 'e', 'i', 'o', 'u',
            'á', 'é', 'í', 'ó', 'ú',
            'A', 'E', 'I', 'O', 'U',
            'Á', 'É', 'Í', 'Ó', 'Ú');

    private String text;
    private Integer vocalsRepeated;

    private Description(String text, Integer vocalsRepeated) {
        this.text = text;
        this.vocalsRepeated = vocalsRepeated;
    }

    public static Description createDescriptionBy(ProductData data) {
        return new Description(data.getDescription(), calculateVocalsRepeated(data).intValue());
    }

    private static Long calculateVocalsRepeated(ProductData productData) {
        return VOCALS.stream()
                .mapToLong(countRepeatedVocal(productData))
                .filter(vocalRepeat -> vocalRepeat > 1)
                .count();
    }

    private static ToLongFunction<Character> countRepeatedVocal(ProductData productData) {
        return vocal -> (productData.getDescription()
                .chars()
                .filter(character -> character == vocal)
                .count());
    }

}
