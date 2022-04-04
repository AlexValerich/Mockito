import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

class AdviceServiceTest {
    @Test
    void test_get_advice_in_bad_weather() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);


        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesService.get("Петя"))
                .thenReturn(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS, Preference.READING));
        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        Set<Preference> preferences = adviceService.getAdvice("Петя");
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
        Assertions.assertEquals(expected, preferences);

    }


//        @Test
//        void test_get_advice_in_bad_weather() {
//            WeatherServiceMock weatherService = new WeatherServiceMock();
//            weatherService.setValue(Weather.STORMY);
//            PreferencesServiceMock preferencesService = new PreferencesServiceMock();
//            preferencesService.setValue(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS,
//                    Preference.READING));
//            AdviceService adviceService = new AdviceService(preferencesService, weatherService);
//            Set<Preference> preferences = adviceService.getAdvice("user1");
//            Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
//            Assertions.assertEquals(expected, preferences);
//        }
    }

