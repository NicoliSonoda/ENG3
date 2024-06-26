package Dominio;

public class Fornecedor extends EntidadeDominio{
    private String CNPJ;
    private String razaoSocial;

    public Fornecedor(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Fornecedor(String CNPJ, String razaoSocial) {
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
