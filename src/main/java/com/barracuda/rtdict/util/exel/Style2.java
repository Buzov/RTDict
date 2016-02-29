package com.barracuda.rtdict.util.exel;

/**
 *
 * @author artur
 */
public class Style2 {
    /*
    Начнём с выравнивания по вертикали и горизонтали в excel ячейках посредством POI.

Для этого у  CellStyle есть специальные методы принимающие short-значение стиля выравнивания.
Стиль выравнивания по вертикали начинается с  VERTICAL_ , по горизонтали - ALIGN_
Например:
CellStyle style =…
short vAlignment=CellStyle.VERTICAL_TOP;
short hAlignment=CellStyle.ALIGN_JUSTIFY;
style.setAlignment(hAlignment); - стиль выравнивания по горизонтале
style.setVerticalAlignment(vAlignment); - стиль выравивания по вертикали
cell.setCellStyle(style);


Из всех стилей выравнивания отмечу один – наиболее интересный CellStyle.ALIGN_FILL  дающий интересный эффект повторения текста ячейки по горизонтали, чтобы занималось вся длинна ячейки.

Разворот текста в excel ячейках посредством POI.

style.setRotation((short)угол в градусах на который необходимо повернуть текст в ячейке);

Назначение цвета границам excel ячейки посредством POI.

Для примера назначу цвет нижней и левой границе.
 style.setBottomBorderColor(IndexedColors.AQUA.getIndex()); - принимается short-значение цвета на вход
style.setLeftBorderColor(IndexedColors.AQUA.getIndex());

Перенос  текста в excel ячейках посредством POI.

style.setWrapText(true);

Установка  числового формата excel ячеек посредством POI.

style.setDataFormat(wb.createDataFormat().getFormat("m/d/yy h:mm")); - формат даты
style.setDataFormat(wb.createDataFormat().getFormat("#.###")); - формат числа с 3-мя знаками после точки
К примеру задайте текст ячейки
cell.setCellValue(new Date());
и теперь назначая различные форматы, можно увидеть какие изменения будут происходить в отображение числа в ячейке.

Назначение стиля и цвета заливки excel ячейки посредством POI.

//Назначаем цвет  узора
style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
//Назначаем цвет фона при назначение узора
style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
//Назначаем стиль узора ячейки
style.setFillPattern(CellStyle.SOLID_FOREGROUND); //сплошной, один из наиболее востребованных узоров
Если setFillForegroundColor задан не будет при назначенном setFillPattern, то заливка произойдёт цветом по умолчанию – чёрным.
Я предпочитаю не искать нужный мне узор, перебирая CellStyle. , а пользуясь числовым их представлением.
1-сплошной,

 2	

3
Полную табличку создам отдельно и потом установлю ссылку на неё.

Назначение стиля текста в excel ячейках посредством POI.

style.setFont(font);
Достаточно обширная тема, которая будет в отдельной публикации.

Назначение отступа в excel ячейках посредством POI.

style.setIndention((short)20); - отступ от левого края ячейки на 20-ть единиц.
Как сделать отступ от верхнего края пока не знаю. Записал себе как то над чем надо подумать.
    */
}
