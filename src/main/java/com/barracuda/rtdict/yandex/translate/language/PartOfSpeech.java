package com.barracuda.rtdict.yandex.translate.language;

/**
 *
 * @author RT
 */
public enum PartOfSpeech {
    
    ADJECTIVE("Adjective", "Прилагательное"),
    ADVERB("Adverb", "Наречие"),
    CONJUNCTION("Conjunction", "Союз"),
    INTERJECTION("Interjection", "Междометие"),
    NOUN("Noun", "Существительное"),
    NUMERAL("Numeral", "Числительное"),
    PARTICLE("Particle", "Частица"),
    PREPOSITION("Preposition", "Предлог"),
    PRONOUN("Pronoun", "Местоимение"),
    VERB("Verb", "Глагол");
    
    private final String nameEn;
    private final String nameRu;
    
    /**
     * 
     * @param nameEn Название части речи на английском
     * @param nameRu Название части речи на русском
     */
    private PartOfSpeech(String nameEn, String nameRu) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
    }
    
    /**
     * Возращает объект по строковому представление части речи
     *
     * @param name Строковое представление части речи
     * @return
     */
    public static PartOfSpeech fromString(final String name) {
        for (PartOfSpeech pos : values()) {
            if (pos.nameEn.toLowerCase().equals(name.toLowerCase())) {
                return pos;
            } else if(pos.nameRu.toLowerCase().equals(name.toLowerCase())) {
                return pos;
            }
        }
        return null;
    }
        

    /**
     * Возвращает строковое представление части речи
     *
     * @return Строковое представление языка
     */
    @Override
    public String toString() {
        return nameEn + " " + nameRu;
    }
    
}
