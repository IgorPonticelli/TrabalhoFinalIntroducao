import java.util.*;

public class CadastroPacientes {
    static Scanner sc = new Scanner(System.in);

    //cria o vetor com os diagnosticos pre estabelecidos
    static String vDiagnostico[] = {"Covid", "Zica", "Chikungunya", "Dengue"};

    //inicia dez paciente como null
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
    //arameza os pacientes no vetor
    static Object vPacientes[] = {pUm, pDois,  pTres, pQuatro, pCinco, pSeis, pSete, pOito, pNove, pDez};
    
    //cria os medicamentos com estoque inicial de 10 unidades cada
    static Medicamento rUm = new Medicamento("CovixUltra", 10);
    static Medicamento rDois = new Medicamento("Zicox", 10);
    static Medicamento rTres = new Medicamento("ChilkTop", 10);
    static Medicamento rQuatro = new Medicamento("enguit", 10);
    //armazena os medicamentos em um vetor
    static Object vMedicamento[] = {rUm, rDois, rTres, rQuatro};

    //imprime a lista de remedios e estoque
    public static void verRemedio(){
        for(int i=0; i<4; i++){
            System.out.println(vMedicamento[i].toString());
        }
    }

    //atualiza estoque de remedios
    public static void atualizaRemedio(){
        int quant;
        for(int i=0; i<4; i++){
            System.out.println(vMedicamento[i].toString());
            System.out.println("\n Digite a quantia atual:");
            quant = sc.nextInt();
            ((Medicamento) vMedicamento[i]).setQuantia(quant);
        }
    }

    //retorna a quantia de pacientes na upa
    public static int quantiaPacientes(){
        int cont = 0;
        for(int i=0; i<10; i++){
            if(((Paciente) vPacientes[i]).getNome() != null){
                cont++;
            }
        }
        return cont;
    }

    //printa os nomes dos pacientes na upa e a quantidade
    public static void verPacientes(){
        int quantiaPacientes = quantiaPacientes();
        if(quantiaPacientes>0){
            if(quantiaPacientes>1){
                //plural para varios pacientes
                System.out.println(quantiaPacientes+" pacientes encontrados");
            }
            else{
                //singular caso seja apenas um paciente
                System.out.println(quantiaPacientes+" paciente encontrado");
            }
            for(int i=0; i<10; i++){
                //imprime os nomes dos pacientes
                if(((Paciente) vPacientes[i]).getNome() != null){
                    System.out.println("Paciente n° "+(i+1)+": "+((Paciente) vPacientes[i]).getNome());
                }
            }
        }
        else{
            //caso não haja nenhum paciente
            System.out.println("\n **Nenhum paciente encontrado**");
        }
    }

    //imprime os pacientes com todas as informações
    public static void verDetalhadoPacientes(){
        int quantiaPacientes = quantiaPacientes();
        if(quantiaPacientes>0){
            if(quantiaPacientes>1){
                //plural
                System.out.println(quantiaPacientes+" pacientes encontrados");
            }
            else{
                //singular
                System.out.println(quantiaPacientes+" paciente encontrado");
            }

            for(int i=0; i<10; i++){
                //imprime as informações detalhadas de cada paciente
                if(((Paciente) vPacientes[i]).getNome() != null){
                    //System.out.println("\n._________________________.");
                    System.out.println("\n||Paciente n° "+(i+1)+":||");
                    //System.out.println("\n'-------------------------'");
                    System.out.println(((Paciente) vPacientes[i]).toString());
                }
            } 
        }
        else{
            //caso não haja pacientes
            System.out.println("\n Nenhum paciente encontrado");
        }
    }

    //cadastra novos pacientes
    public static void cadastroPacientes(){
        //testa se tem capacidade na upa
        if(quantiaPacientes()<10){
            for(int i=0; i<10; i++){
                if(((Paciente) vPacientes[i]).getNome() == null){
                    //recebe o nome com tratamento somente letras
                    String nome;
                    do{
                        System.out.println("\n Digite o nome do paciente");
                        nome = sc.next();
                        if(verificaSeTemNumero(nome)){
                            System.out.println("\n O nome deve conter apenas letras");
                        }
                    }while(verificaSeTemNumero(nome));
                    ((Paciente) vPacientes[i]).setNome(nome);

                    //recebe o cpf com tratamento de tamanho e somente numeros
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

                    //recebe o telefone com tratamento de tamanho e somente numeros
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
                    
                    //recebe um diagnostico com tratamento de opcoes
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

                    //recebe um medicamento com tratamento de opcoes
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

                    //pega o estoque disponivel de remedios
                    int estoqueRemedio = ((Medicamento) vMedicamento[medicamento]).getQuantia();
                    //printa a lista de remedios
                    System.out.println("Estoque disponivel de "+((Medicamento) vMedicamento[medicamento]).getRemedio()+": "+estoqueRemedio);
                    System.out.println("\n Digite o numero de caixas receitadas");
                    int caixas = sc.nextInt();
                    //verifica se existe estoque disponivel
                    while(estoqueRemedio<caixas){
                        System.out.println("\n Estoque indisponivel, digite um valor valido");
                        System.out.println("\n Digite o numero de caixas receitadas");
                        caixas = sc.nextInt();
                    }
                    //atualiza o estoque de remedios
                    ((Medicamento) vMedicamento[i]).setQuantia(((Medicamento) vMedicamento[i]).getQuantia() - caixas);
                    //registra as caixas receitadas ao paciente
                    ((Paciente) vPacientes[i]).setCaixas(caixas);

                    break;
                }
            }
        }
        else{
            //caso todas as posições do vetor esteja ocupadas
            System.out.println("A upa está lotada!!!");
        }
    }

    //verifica se a string tem letras usando metodo .matches
    public static boolean verificaSeTemLetra(String s){
        if(s != null && s.matches("^[0-9]*$")){
            return false;
        }
        return true;
    }

    //verifica se a string tem numeros usando .matches
    public static boolean verificaSeTemNumero(String s){
        if(s != null && s.matches("^[a-zA-Z]*$")){
            return false;
        }
        return true;
    }

    //remove o paciente desejado do vetor
    public static void darAutaPaciente(){
        for(int i=0; i<quantiaPacientes(); i++){
            //mostra os pacientes na upa
            System.out.println("Paciente n° "+(i+1)+":");
            System.out.println(((Paciente) vPacientes[i]).toString());
        }

        //recebe o paciente a receber auta com tratamento de opções 
        int paciente;
        do{
            System.out.println("Digite o numero do paciente a receber alta ");
            paciente = sc.nextInt();

            if(paciente < 1 || paciente > quantiaPacientes()){
                System.out.println("Digite um numero de paciente valido");
            }
        }while(paciente < 1 || paciente > quantiaPacientes());
        ((Paciente) vPacientes[paciente-1]).setAll(null, null, null, null, null, 0);
        organizaVetor(paciente-1);
    }

    //organiza o vetor aops um paciente receber auta
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

    //escreve todo o vetor
    public static void escreveTodoVetor(){
        for(int i=0; i<10; i++){
            System.out.println("\n ============");
            System.out.println("\n Posição "+(i)+":");
            System.out.println("\n ============");
            System.out.println(((Paciente) vPacientes[i]).toString());
        } 
    }

    //escreve todos os pacientes com informações completas
    public static void escreveOcupadosNoVetor(){
        for(int i=0; i<10; i++){
            if(((Paciente) vPacientes[i]).getNome() != null){
                System.out.println("Posição "+(i)+":");
                System.out.println(((Paciente) vPacientes[i]).toString());
            }
        } 
    }

    //escreve os nomes dos pacientes em ordem alfabetica
    public static String[] ordemAlfabetica(){
        String[] aux = new String[quantiaPacientes()];
        for(int i=0; i<quantiaPacientes(); i++){
            aux[i] = (((Paciente) vPacientes[i]).getNome()).toUpperCase();
        }
        Arrays.sort(aux);
        return aux;
    }

    //imprime o relatorio das doenças
    public static void relatorioDoencas() {
        int[] vQuantiaDiagnostico = vetorQuantiaDiagnosticos();
        double porcentagem;
        for(int i=0; i<4; i++){
            if(quantiaPacientes() == 0){
                //define porcentagem como zero, pois não é possivel dividir por zero
                porcentagem = 0;
            }else{
                //calcula a porcentagem
                porcentagem = (double) ((100/quantiaPacientes()) * vQuantiaDiagnostico[i]);
            }

            //imprime as informações
            System.out.println(" **Diagnostico: "+vDiagnostico[i]+"**");
            System.out.println("   Quantia: "+vQuantiaDiagnostico[i]);
            System.out.println("   Porcentagem: "+porcentagem+"%");
            System.out.println("\n             ");
        }
    }

    //monta um vetor com a quantia de diagnosticos de cada doença
    //posição do vetor correspondente a posição do vetor doenças
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