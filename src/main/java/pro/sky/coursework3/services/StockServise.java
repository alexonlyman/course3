package pro.sky.coursework3.services;

import pro.sky.coursework3.model.Colour;
import pro.sky.coursework3.model.Size;
import pro.sky.coursework3.model.Socks;

public interface StockServise {


    void addPartyOfSocks(Socks socks);

    void sellSocks(Socks socks);

    Integer getParamsSocks(Size size, Colour colour, Integer cottonCompositionMin, Integer cottonCompositionMax);

    void removeDefectiveSocks(Socks socks);
}
