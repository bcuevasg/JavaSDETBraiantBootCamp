package com.braiant.restassured;



import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamCrestExample {

    String favoriteCar;
    List<String> list;
    @Test
    void stringIsEmpty(){
        favoriteCar = "";//null
        assertThat(favoriteCar, emptyString());
    }

    @Test
    void stringIsEmptyorNull(){
        favoriteCar = null;//null
        assertThat(favoriteCar, nullValue());
    }

    @Test
    void stringEqualsTo() {
        favoriteCar = "HONDA";
        assertThat(favoriteCar, equalToIgnoringCase("honda"));//omite lower o upper case
    }

    @Test
    void equalsToIgnoringWhitespaces(){
        favoriteCar = "      Mazda     ";//null
        assertThat(favoriteCar, equalToCompressingWhiteSpace("Mazda"));
    }
    @Test
    void stringContains(){
        favoriteCar = "Mercedez Benz";//null
        assertThat(favoriteCar, containsString("Ben"));
    }
    @Test
    void stringEndsWith(){
        favoriteCar = "Lamborgini";
        assertThat(favoriteCar, endsWith("ini"));
    }

    @Test
    void stringStartsWith(){
        favoriteCar = "Lamborgini";
        assertThat(favoriteCar, startsWith("Lam"));
    }

    @Test
    void stringHasOrder(){
        favoriteCar = "Masserati Lamborgini Mercedez BMW";
        assertThat(favoriteCar,
                stringContainsInOrder(Lists.newArrayList("Masserati","Lamborgini","Mercedez","BMW")));
    }

    //NumberMatches
    @Test
    void greaterThanInteger(){
        assertThat(2, greaterThan(1));
    }

    @Test
    void greaterThanOrEqualInteger(){
        assertThat(10,greaterThanOrEqualTo(10));
    }
    @Test
    void lessThanInteger(){
        assertThat(-1, lessThan(1));
    }

    @Test
    void lessThanOrEqualInteger(){
        assertThat(-1,lessThanOrEqualTo(-1));
    }

    @Test
    void closeToDoubleNumber(){
        //1,0(+/-) 0.8 to 1.2
        assertThat(0.8,closeTo(1.0, 0.2));
    }

    @Test
    void givenBigDecimalCloseTo(){
        //2.0 (+/-) 1.5 to 2.5
        //new BigDecimal converts text to numbers right now decimals but there is BigInteger as well
        assertThat(new BigDecimal("1.5"), is(closeTo(new BigDecimal("2.0"), new BigDecimal("0.5"))));
    }
    @Test
    void listEmpty(){
        List<String> list = new ArrayList<>();
        assertThat(list, empty());
    }

    @Test
    void listSizeMatch(){
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman","Zatana");
        assertThat(list, hasSize(4));
        assertThat(list,iterableWithSize(4));
    }

    @Test
    void listContainssAllValuesInSameOreder(){
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman","Zatana");
        assertThat(list, contains("Superman", "Batman", "Wonder-Woman","Zatana"));
    }

    @Test
    void listContainssAllValuesInAnyOreder(){
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman","Zatana");
        assertThat(list, containsInAnyOrder("Wonder-Woman", "Zatana", "Superman","Batman"));
    }

    @Test
    void listContainsValisInRelativeOrder(){
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman","Zatana");
        assertThat(list, containsInRelativeOrder("Batman","Wonder-Woman"));
    }
    @Test
    void listCWhenContainsGivenValue(){
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman","Zatana");
        assertThat(list, hasItem(equalTo("Batman")));
        assertThat(list, hasItem(startsWith("Sup")));
        assertThat(list, hasItem(startsWith("ana")));
    }

    @Test
    void listCWhenContainsMoreValues() {
        list = Arrays.asList("Superman", "Batman", "Wonder-Woman", "Zatana");
        assertThat(list, hasItems(startsWith("Wond"), endsWith("man"), equalTo("Zatana")));
    }

    @Test
    void mapEmpty(){
        Map<String, String> myMap = new HashMap<>();
        assertThat(myMap,is(anEmptyMap()));
    }

}
