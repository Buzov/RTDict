package com.barracuda.rtdict.yandex.translate;

/**
 *
 * @author RT
 */
public class YandexTranslate extends YandexAbstract {
    private static final String HOST = "translate.yandex.net";
    private static final String PATH_XML = "api/v1.5/tr/translate";
    private static final String PATH_JSON = "api/v1.5/tr.json/translate";

    public YandexTranslate(String key, String lang) {
        super(HOST, PATH_XML, PATH_JSON, key, lang);
    }
    
    public YandexTranslate(String key) {
        super(HOST, PATH_XML, PATH_JSON, key, LANG);
    }

}
