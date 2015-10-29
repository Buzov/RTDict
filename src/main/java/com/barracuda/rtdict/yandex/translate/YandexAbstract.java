package com.barracuda.rtdict.yandex.translate;

/**
 *
 * @author RT
 */
public abstract class YandexAbstract implements YandexInterface {

    
    
    abstract protected String getUrl(DocType docType);

    protected String getUrl(String text, DocType docType) {
 //       URI uri = new URI("http", "example.com", "/hello world/", "");
   //     URL url = uri.toURL();
        return String.format(getUrl(docType), text);
    }
}
