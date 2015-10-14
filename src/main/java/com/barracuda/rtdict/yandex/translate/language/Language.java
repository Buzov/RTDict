package com.barracuda.rtdict.yandex.translate.language;

/**
 * Language - это перечисление языков и их сокращений, которые поддерживает
 * Yandex API
 *
 * @author artur RT
 */
public enum Language {

    AFRIKAANS("af"),
    ALBANIAN("sq"),
    ARABIAN("ar"),
    ARMENIAN("hy"),
    AZERI("az"),
    BASQUE("eu"),
    BELARUSIAN("be"),
    BULGARIAN("bg"),
    CATALAN("ca"),
    CROATIAN("hr"),
    CZECH("cs"),
    CHINESE("zh"),
    DANISH("da"),
    DUTCH("nl"),
    ENGLISH("en"),
    ESTONIAN("et"),
    FINNISH("fi"),
    FRENCH("fr"),
    GALICIAN("gl"),
    GEORGIAN("ka"),
    GERMAN("de"),
    GREEK("el"),
    HAITIAN("ht"),
    HEBREW("he"),
    HUNGARIAN("hu"),
    ICELANDIC("is"),
    INDONESIAN("id"),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KAZAKH("kk"),
    KOREAN("ko"),
    KYRGYZ("ky"),
    LATIN("la"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    MACEDONIAN("mk"),
    MALAGASY("mg"),
    MALAY("ms"),
    MALTESE("mt"),
    MONGOLIAN("mn"),
    NORWEGIAN("no"),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SPANISH("es"),
    SERBIAN("sr"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SWAHILI("sw"),
    SWEDISH("sv"),
    TAGALOG("tl"),
    TAJIK("tg"),
    TATAR("tt"),
    THAI("th"),
    TURKISH("tr"),
    UZBEK("uz"),
    UKRAINIAN("uk"),
    VIETNAMESE("vi"),
    WELSH("cy");

    /**
     * Строковое представление языка.
     */
    private final String language;

    /**
     * Коснтруктор
     *
     * @param language Строковое представление языка
     */
    private Language(final String language) {
        this.language = language;
    }

    /**
     * Возращает объект по строковому представлению языка
     *
     * @param language Строковое представление языка
     * @return
     */
    public static Language fromString(final String language) {
        for (Language l : values()) {
            if (l.language.equals(language)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Возвращает строковое представление языка
     *
     * @return Строковое представление языка
     */
    @Override
    public String toString() {
        return language;
    }

}
