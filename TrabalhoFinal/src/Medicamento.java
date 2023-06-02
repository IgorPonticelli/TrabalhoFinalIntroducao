public class Medicamento {
    private String remedio;
    private int quantia;
    
    public Medicamento(String remedio, int quantia) {
        this.remedio = remedio;
        this.quantia = quantia;
    }

    public String getRemedio() {return remedio;}
    public int getQuantia() {return quantia;}

    public void setRemedio(String remedio) {this.remedio = remedio;}
    public void setQuantia(int quantia) {this.quantia = quantia;}

    public String toString()
    {
        return(
        " Medicamento: " + remedio +
        "\n Estoque: " + quantia
        );    
    }

    public int getMedicamento() {
        return 0;
    }
}
