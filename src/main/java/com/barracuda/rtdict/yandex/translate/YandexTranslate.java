package com.barracuda.rtdict.yandex.translate;

/**
 *
 * @author RT
 */
public class YandexTranslate extends YandexAbstract {
    private static final String HTTP_XML = "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YandexKeys.YANDEX_API_KEY + "&lang=en-ru&text=%s";
    private static final String HTTP_JSON = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + YandexKeys.YANDEX_API_KEY + "&lang=en-ru&text=%s";

    @Override
    protected String getUrl(DocType docType) {
        switch(docType) {
            case XML: return HTTP_XML;
            case JSON: return  HTTP_JSON;
        }
        return null;
    }

    @Override
    public String getXml(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJson(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
