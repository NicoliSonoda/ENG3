package Dominio;

import java.util.Date;

public class Log extends EntidadeDominio{
    private Date dataHora;

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
