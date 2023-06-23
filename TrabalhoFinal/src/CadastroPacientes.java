import java.util.*;

public class CadastroPacientes {
    static Scanner sc = new Scanner(System.in);

    static String vDiagnostico[] = {"Covid", "Zica", "Chikungunya", "Dengue"};

    static Paciente pUm = new Paciente(null, null, null, null, null, 0);
    static Paciente pDois = new Paciente(null, null, null, null, null, 0);
    static Paciente pTres = new Paciente(null, null, null, null, null, 0);
    static Paciente pQuatro = new Paciente(null, null, null, null, null, 0);
    static Paciente pCinco = new Paciente(null, null, null, null, null, 0);
    static Paciente pSeis = new Paciente(null, null, null, null, null, 0);
    static Paciente pSete = new Paciente(null, null, null, null, null, 0);
    static Paciente pOito = new Paciente(null, null, null, null, null, 0);
    static Paciente pNove = new Paciente(null, null, null, null, null, 0);
    static Paciente pDez = new Paciente(null, null, null, null, null, 0);
    static Object vPacientes[] = {pUm, pDois,  pTres, pQuatro, pCinco, pSeis, pSete, pOito, pNove, pDez};
    
    static Medicamento rUm = new Medicamento("CovixUltra", 10);
    static Medicamento rDois = new Medicamento("Zicox", 10);
    static Medicamento rTres = new Medicamento("ChilkTop", 10);
    static Medicamento rQuatro = new Medicamento("enguit", 10);
    static Object vMedicamento[] = {rUm, rDois, rTres, rQuatro};

    public static void verRemedio(){
        for(int i=0; i<4; i++){
            System.out.println(vMedicamento[i].toString());
        }
    }

    public static void atualizaRemedio(){
        int quant;
        for(int i=0; i<4; i++){
            System.out.println(vMedicamento[i].toString());
            System.out.println("\n Digite a quantia atual:");
            quant = sc.nextInt();
            ((Medicamento) vMedicamento[i]).setQuantia(quant);
        }
    }

    public static int quantiaPacientes(){
        int cont = 0;
        for(int i=0; i<10; i++){
            if(((Paciente) vPacientes[i]).getNome() != null){
                cont++;
            }
        }
        return cont;
    }

    public static void verPacientes(){
        int quantiaPacientes = quantiaPacientes();
        if(quantiaPacientes>0){
            if(quantiaPacientes>1){
                System.out.println(quantiaPacientes+" pacientes encontrados");
            }
            else{
                System.out.println(quantiaPacientes+" paciente encontrado");
            }
            for(int i=0; i<10; i++){
                if(((Paciente) vPacientes[i]).getNome() != null){
                    System.out.println("Paciente n° "+(i+1)+": "+((Paciente) vPacientes[i]).getNome());
                }
            }
        }
        else{
            System.out.println("\n **Nenhum paciente encontrado**");
        }
    }

    public static void verDetalhadoPacientes(){
        int quantiaPacientes = quantiaPacientes();
        if(quantiaPacientes>0){
            if(quantiaPacientes>1){
                System.out.println(quantiaPacientes+" pacientes encontrados");
            }
            else{
                System.out.println(quantiaPacientes+" paciente encontrado");
            }

            for(int i=0; i<10; i++){
                if(((Paciente) vPacientes[i]).getNome() != null){
                    //System.out.println("\n._________________________.");
                    System.out.println("\n||Paciente n° "+(i+1)+":||");
                    //System.out.println("\n'-------------------------'");
                    System.out.println(((Paciente) vPacientes[i]).toString());
                }
            } 
        }
        else{
            System.out.println("\n Nenhum paciente encontrado");
        }
    }

    public static void cadastroPacientes(){
        if(quantiaPacientes()<10){
            for(int i=0; i<10; i++){
                if(((Paciente) vPacientes[i]).getNome() == null){
                    String nome;
                    do{
                        System.out.println("\n Digite o nome do paciente");
                        nome = sc.next();
                        if(verificaSeTemNumero(nome)){
                            System.out.println("\n O nome deve conter apenas letras");
                        }
                    }while(verificaSeTemNumero(nome));
                    ((Paciente) vPacientes[i]).setNome(nome);

                    String cpf;
                    do{
                        System.out.println("\n Digite o número do cpf do paciente");
                        cpf = sc.next();
                        if(cpf.length() != 11){
                            System.out.println("O CPF deve conter 11 digitos");
                        }
                        if(verificaSeTemLetra(cpf)){
                            System.out.println("O CPF deve conter apenas numeros");
                        }
                    }while(cpf.length() != 11 || verificaSeTemLetra(cpf));
                        ((Paciente) vPacientes[i]).setCpf(cpf);

                    String telefone;
                    do{
                        System.out.println("\n Digite o número de telefone do paciente com codigo de area");
                        telefone = sc.next();
                        if(telefone.length()!=9){
                            System.out.println("\n O telefone deve possuir 11 digitos");
                        }
                        if(verificaSeTemLetra(telefone)){
                            System.out.println("\n O telefone deve possuir apenas numeros");
                        }
                    }while(telefone.length()!=11 || verificaSeTemLetra(telefone));
                        ((Paciente) vPacientes[i]).setTelefone(telefone);
                    
                    int diagnostico;
                    do{
                        System.out.println("\n Digite o número correspondente ao diagnostico");
                        for(int j=0; j<4; j++){
                            System.out.println((j+1)+". "+vDiagnostico[j]);
                        }
                        sc.nextLine();
                        diagnostico = sc.nextInt();
                    }while(diagnostico  <= 0 || diagnostico > 4 );
                        diagnostico = diagnostico - 1;
                        ((Paciente) vPacientes[i]).setDiagnostico(vDiagnostico[diagnostico]);

                    int medicamento;
                    do{
                        System.out.println("\n Digite o numero correspondente ao medicamento");
                        for(int j=0; j<4; j++){
                            System.out.println((j+1)+". "+((Medicamento) vMedicamento[j]).getRemedio());
                        }
                        medicamento = sc.nextInt();
                        if(medicamento  <= 0 || medicamento > 4){
                            System.out.println("\n Digite um numero valido");
                        }
                    }while(medicamento  <= 0 || medicamento > 4);
                        medicamento = medicamento - 1;
                        ((Paciente) vPacientes[i]).setMedicamento(((Medicamento) vMedicamento[medicamento]).getRemedio());

                    int estoqueRemedio = ((Medicamento) vMedicamento[medicamento]).getQuantia();
                    System.out.println("Estoque disponivel de "+((Medicamento) vMedicamento[medicamento]).getRemedio()+": "+estoqueRemedio);
                    System.out.println("\n Digite o numero de caixas receitadas");
                    int caixas = sc.nextInt();
                    while(estoqueRemedio<caixas){
                        System.out.println("\n Estoque indisponivel, digite um valor valido");
                        System.out.println("\n Digite o numero de caixas receitadas");
                        caixas = sc.nextInt();
                    }
                    ((Medicamento) vMedicamento[i]).setQuantia(((Medicamento) vMedicamento[i]).getQuantia() - caixas);
                    ((Paciente) vPacientes[i]).setCaixas(caixas);

                    break;
                }
            }
        }
        else{
            System.out.println("A upa está lotada!!!");
        }
    }

    public static boolean verificaSeTemLetra(String s){
        if(s != null && s.matches("^[0-9]*$")){
            return false;
        }
        return true;
    }

    public static boolean verificaSeTemNumero(String s){
        if(s != null && s.matches("^[a-zA-Z]*$")){
            return false;
        }
        return true;
    }

    public static void darAutaPaciente(){
        for(int i=0; i<10; i++){
            if(((Paciente) vPacientes[i]).getNome() != null){
                System.out.println("Paciente n° "+(i+1)+":");
                System.out.println(((Paciente) vPacientes[i]).toString());
            }
        }

        int paciente;
        do{
            System.out.println("Digite o numero do paciente a receber alta ");
            paciente = sc.nextInt();

            if(paciente == 0 || paciente > 10){
                System.out.println("Digite um numero de paciente valido");
            }
        }while(paciente == 0 || paciente > 10);
        ((Paciente) vPacientes[paciente-1]).setAll(null, null, null, null, null, 0);
        organizaVetor(paciente-1);
    }

    public static void organizaVetor(int posicaoVetor){
        for(int i = posicaoVetor; i<9; i++){
            String nome = ((Paciente) vPacientes[i+1]).getNome();
            String diagnostico = ((Paciente) vPacientes[i+1]).getDiagnostico();
            String medicamento = ((Paciente) vPacientes[i+1]).getMedicamento();
            String cpf = ((Paciente) vPacientes[i+1]).getCpf();
            String telefone = ((Paciente) vPacientes[i+1]).getTelefone();
            int caixas = ((Paciente) vPacientes[i+1]).getCaixas();
            ((Paciente) vPacientes[i]).setAll(nome, diagnostico, medicamento, cpf, telefone, caixas);
        }
        ((Paciente) vPacientes[9]).setAll(null, null, null, null, null, posicaoVetor);
    }

    public static void escreveTodoVetor(){
        for(int i=0; i<10; i++){
            System.out.println("\n ============");
            System.out.println("\n Posição "+(i)+":");
            System.out.println("\n ============");
            System.out.println(((Paciente) vPacientes[i]).toString());
        } 
    }

    public static void escreveOcupadosNoVetor(){
        for(int i=0; i<10; i++){
            if(((Paciente) vPacientes[i]).getNome() != null){
                System.out.println("Posição "+(i)+":");
                System.out.println(((Paciente) vPacientes[i]).toString());
            }
        } 
    }

    public static String[] ordemAlfabetica(){
        String[] aux = new String[quantiaPacientes()];
        for(int i=0; i<quantiaPacientes(); i++){
            aux[i] = (((Paciente) vPacientes[i]).getNome()).toUpperCase();
        }
        Arrays.sort(aux);
        return aux;
    }

    public static void relatorioDoencas() {
        //vDiagnostico[] = {"Covid", "Zica", "Chikungunya", "Dengue"};
        int[] vQuantiaDiagnostico = vetorQuantiaDiagnosticos();
        double porcentagem;
        for(int i=0; i<4; i++){
            if(quantiaPacientes() == 0){
                porcentagem = 0;
            }else{
                porcentagem = (double) ((100/quantiaPacientes()) * vQuantiaDiagnostico[i]);
            }
            System.out.println(" **Diagnostico: "+vDiagnostico[i]+"**");
            System.out.println("   Quantia: "+vQuantiaDiagnostico[i]);
            System.out.println("   Porcentagem: "+porcentagem+"%");
            System.out.println("\n             ");
        }
    }

    private static int[] vetorQuantiaDiagnosticos() {
        int[] quantia = {0, 0, 0, 0};

        for(int i=0; i<quantiaPacientes(); i++){
            for(int j=0; j<4; j++){
                if(((Paciente) vPacientes[i]).getDiagnostico().equals(vDiagnostico[j])){
                    quantia[j]++;
                    break;
                }
            }
        }
        return quantia;
    }
}