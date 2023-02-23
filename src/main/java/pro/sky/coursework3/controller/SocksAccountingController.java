package pro.sky.coursework3.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursework3.model.Colour;
import pro.sky.coursework3.model.Size;
import pro.sky.coursework3.model.Socks;
import pro.sky.coursework3.services.StockServise;

import javax.validation.Valid;

@RestController
@RequestMapping("/sockswarehouse")
@RequiredArgsConstructor
public class SocksAccountingController {
    private final StockServise stockServise;

    @PostMapping
    @Operation(summary = "добавление носков на склад")
    public ResponseEntity<Socks> addPartyOfSocks(@Valid @RequestBody Socks socks) {
        stockServise.addPartyOfSocks(socks);
        return ResponseEntity.ok().body(socks);
    }

    @GetMapping
    @Operation(summary = "получение количества носков по параметрам")
    public Integer getSocksByParams(@RequestParam(required = false, name = "colour") Colour colour,
                                    @RequestParam(required = false, name = "size") Size size,
                                    @RequestParam(required = false, name = "cottonCompositionMin") Integer cottonCompositionMin,
                                    @RequestParam(required = false, name = "cottonCompositionMax") Integer cottonCompositionMax) {
        return stockServise.getParamsSocks(size, colour, cottonCompositionMin, cottonCompositionMax);
    }

    @PutMapping
    @Operation(summary = "отгрузка носков")
    public ResponseEntity<Socks> salePartyOfSocks(@RequestBody Socks socks) {
        stockServise.sellSocks(socks);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Operation(summary = "удаление бракованных носков")
    public ResponseEntity<Socks> deleteSocks(@RequestBody Socks socks) {
        stockServise.removeDefectiveSocks(socks);
        return ResponseEntity.ok().build();
    }
}
