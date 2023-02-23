package pro.sky.coursework3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.coursework3.model.Colour;
import pro.sky.coursework3.model.Size;
import pro.sky.coursework3.model.Socks;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockServise {
    private final Map<Socks, Integer> socksMap = new HashMap<>();



    @Override
    public void addPartyOfSocks(Socks socks) {
        Socks sock = new Socks(socks.getColour(), socks.getSize(), socks.getCottonComposition());
        if (socksMap.containsKey(sock)) {
            socksMap.put(sock, socksMap.get(sock) + socks.getQuantity());
        } else {
            socksMap.put(sock, socks.getQuantity());
        }

    }

    @Override
    public void sellSocks(Socks socks) {
        Socks sock = new Socks(socks.getColour(), socks.getSize(), socks.getCottonComposition());
        Integer sockQuantity = socksMap.getOrDefault(sock, 0);
        if (sockQuantity >= socks.getQuantity()) {
            socksMap.put(sock, sockQuantity - socks.getQuantity());
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public Integer getParamsSocks(Size size, Colour colour, Integer cottonCompositionMin, Integer cottonCompositionMax) {
        Integer count = 0;
        for (Map.Entry<Socks, Integer> entry : socksMap.entrySet()) {
            if (colour!=null && entry.getKey().getColour().equals(colour)
                    && (size != null) && entry.getKey().getSize().equals(size)
                    && (cottonCompositionMin <= entry.getKey().getCottonComposition())
                    && (cottonCompositionMax >= entry.getKey().getCottonComposition())) {
                count += entry.getValue();
            }
        }
        return count;
    }


    @Override
    public void removeDefectiveSocks(Socks socks) {
        sellSocks(socks);

    }
}


