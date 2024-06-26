package Strategy;

import Dominio.EntidadeDominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerarLog implements IStrategy{
    @Override
    public String processsar(EntidadeDominio entidade) {

        StringBuilder sb = new StringBuilder();

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);

        String msg = sb.toString();

        if(msg.isEmpty()) {
            return null;

        }else {
            return sb.toString();
        }
    }




}

