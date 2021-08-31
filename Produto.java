package entidades;

public class Produto {

    private String nomeProduto;
    private double valorProduto;
    private double custoProduto;
    private int id;

    public Produto(String nome, double valor, double custo) {
        nomeProduto = nome;
        valorProduto = valor;
        custoProduto = custo;
    }

    public Produto () {
        super ();
    }

    //Id
    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    //Nome

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    //Valor prod
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    //Custo prod
    public void setCustoProduto(double custoProduto) {
        this.custoProduto = custoProduto;
    }

    public double getCustoProduto() {
        return custoProduto;
    }

    public double getLucro () {
        return valorProduto - custoProduto;
    }
}
