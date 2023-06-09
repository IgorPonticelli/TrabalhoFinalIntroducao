public class Paciente {
    private String nome, medicamento, diagnostico, cpf, telefone;
    private int caixas;
    
    public Paciente(String nome, String diagnostico, String medicamento,
    String cpf, String telefone, int caixas)
    {
        this.nome = nome;
        this.diagnostico = diagnostico;
        this.medicamento = medicamento;
        this.cpf = cpf;
        this. telefone = telefone;
        this. caixas = caixas;
    }
    
    public String getNome() {return nome;}
    public String getDiagnostico() {return diagnostico;}
    public String getMedicamento() {return medicamento;}
    public String getCpf() {return cpf;}
    public String getTelefone() {return telefone;}
    public int getCaixas() {return caixas;}

    public void setNome(String nome) {this.nome = nome;}
    public void setDiagnostico(String diagnostico) {this.diagnostico = diagnostico;}
    public void setMedicamento(String medicamento) {this.medicamento = medicamento;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setCaixas(int caixas) {this.caixas = caixas;}

    public String toString(){
        return(
        " Nome: " + nome +
        "\n Diagnostico: " + diagnostico +
        "\n Medicamento: " + medicamento +
        "\n CPF: " + cpf + 
        "\n Telefone: " + telefone +
        "\n Quantia de caixas: " + caixas
        );    
    }
}