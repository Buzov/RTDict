package com.barracuda.rtdict.yandex.translate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author RT
 */
public abstract class YandexAbstract implements YandexInterface {
    
    /*
    https://dictionary.yandex.net/api/v1/dicservice/lookup?key=APIkey&lang=en-ru&text=time
    https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=APIkey&lang=en-ru&text=time77
    
    
    https://translate.yandex.net/api/v1.5/tr.json/translate?key=&lang=en-ru&text=To+be,+or+not+to+be%3F&text=That+is+the+question.
    https://translate.yandex.net/api/v1.5/tr/translate?key=&lang=en-ru&text=To be, or not to be%3F&text=That+is+the+question.
    */

    protected URL getUrl() throws URISyntaxException, MalformedURLException {
        URI uri = new URI("http", "example.com", "/hello world/", "");
        URL url = uri.toURL();
        return url;
    }
}
