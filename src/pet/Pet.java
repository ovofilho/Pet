package pet;


import java.util.Objects;
import java.util.Scanner;

public class Pet {
    
    public Pet() {
		produtos[0] = new String[] {"001", "Ração cães p carne", "S", "20.00", "60"};
		produtos[1] = new String[] {"002", "Ração cães g frango", "S", "35.00", "100"};
		produtos[2] = new String[] {"003", "Ração gatos p peixe", "S", "25.00", "20"};
		produtos[3] = new String[] {"004", "coleira para cães p",  "S", "5.00", "20"};
		produtos[4] = new String[] {"005", "brinquedo cenoura mordedor","N", "8.00", "0"};
		produtos[5] = new String[] {"006", "gaiola para passaros",  "S", "80.00", "4"};
		produtos[6] = new String[] {"007", "escova de pelos kit 2x","N", "12.50", "24"};    
       
	}
	
	//USADOS AQUI OU PRECISA DE GET
	private String codigo_barra;
	private String active;
	
	// IRAO SER USADOS NA PROX CLASSE
	private String nome;
	private String valor;
	private String estoque;
	
	//DEFINE DIMENSOES DO ARRAY
	public static int quantProdutos = 20;
	public static int prodMax = 5;
	public int ULTIMOLUGAR;
	public 	int posicao = 7;
        
	//ARRAYS DE ARMAZENAMENTO
	protected String[][] produtos = new String[quantProdutos][prodMax];
	
	// GETS PARA OS PARAMETROS
	public void getCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}
	
	public void getNome(String nome) {
		this.nome = nome;
	}
	
	public void getValor(String valor) {
		this.valor = valor;
	}
	
	public void getEstoque(String estoque) {
		this.estoque = estoque;
	}
	
	public void getActive(String active) {
		this.active = active;
	}
	
	// SETS PARA OS PARAMETROS
	public String setCodigo_barra(){
		return codigo_barra;
	}
	
	public String setNome(){
		return nome;
	}
	
	public String setValor(){
		return valor;
	}
	
	public String setEstoque(){
		return estoque;
	}
	
	public String setActive(){
		return active;
	}
	
	
	public static void main(String[] args) {
	 Pet pet = new Pet();
         boolean RUN = true;
         
         while(true) {
            RUN = pet.menu();
            if(RUN == false) break;
         }

	}
	
        public boolean menu() {
            Scanner scan = new Scanner(System.in);
            int op = 0;
            boolean shut = true;
            
            System.out.print("\n\n1.Visualizar todos os produtos."
                    + "\n2.Visualizar caracteristicas de um produto."
                    + "\n3.Cadastrar novos produtos."
                    + "\n4.Alterar estoque de um produto."
                    + "\n5.Alterar situação do produto."
                    + "\n6. Encerrar.\n");
            op = scan.nextInt();
            
            switch(op) {
                case 1:
                    printArray();
                    break;
                case 2:
                    visualizar();
                    break;
                case 3:
                    cadastro();
                    break;
                case 4:
                    alterarEstoque();
                    break;
                case 5:
                    mudarSituacao();
                    break;
                case 6:
                    shut = false;
                    break;
                default:
                    System.err.println("\nEscolha opção valida!\n");
            }
            
            return shut;
        }
        
        public String getCodigo() {
             Scanner scan = new Scanner(System.in);
            
            System.out.print("\n Digite o codigo do produto: ");
            String codigo = scan.next();
            
            return codigo;
        }
	public void cadastro() {
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("\nFazer cadastro? (S/N)");
				String valid = scan.nextLine();
				
				if(valid.equals("S") ||valid.equals("s") ){
	
				System.out.print("\nCodigo de Barras: ");
				getCodigo_barra(scan.nextLine());
				
				System.out.print("\nNome do Produto: ");
				getNome(scan.nextLine());
				
				System.out.print("\nAtivo para vendas? S/N");
				getActive(scan.nextLine());

				System.out.print("\nValor do Produto: ");
				getValor(scan.nextLine());
				
				System.out.print("\nQuantidade em Estoque: ");
				getEstoque(scan.nextLine());
				
				adicionarProduto();
			}
				else break;

		}
		
	}
	
	private void adicionarProduto() {
             
		produtos[posicao] = new String[] {setCodigo_barra(), setNome(), 
                    setActive().toUpperCase(), setValor(), setEstoque()};
                posicao++;
        }
        
        public void printArray() {
            
            System.out.printf("\n\n%-5s %20s %23s %n", "CODIGO", "NOME", "SITUAÇÃO");
		System.out.println("--------------------------------------------------------");
            for(int i = 0; i < quantProdutos; i++) {
                    if(produtos[i][0] != null)
                   System.out.printf("%-5s | %-30s | %10s %n", produtos[i][0],
                           produtos[i][1], produtos[i][2]);
            }
        }
        
        public void visualizar() {
            Scanner scan = new Scanner(System.in);
            
            String codigo = getCodigo();
            
            System.out.printf("\n\n%-5s %20s %22s %13s %13s %n", "CODIGO", "NOME",
                    "SITUAÇÃO", "PREÇO", "QUANTIDADE");
		System.out.println("-------------------------------------------"
                        + "-------------------------------------");
            for(int i = 0; i < produtos.length; i++) {
                if(codigo.equals(produtos[i][0])){
                    System.out.printf("%-5s | %-30s | %10s | %10s | %10s %n",
                            produtos[i][0], produtos[i][1], produtos[i][2],
                            produtos[i][3], produtos[i][4]);
                }
            }
        }
        
        public void mudarSituacao() {
            Scanner scan = new Scanner(System.in);
            
           
            String codigo = getCodigo();
            System.out.print("\nQual a situação do produto?  ");
            String situacao = scan.next();
            
            String MOD = "";
            if(situacao.equals("S")) MOD = "ativo";
            if(situacao.equals("N")) MOD = "desativado";
            
            for(int i = 0; i < produtos.length; i++) {
                if(codigo.equals(produtos[i][0])){
                    if(situacao.equals(produtos[i][2])) {
                        System.out.println("Produto já está " + MOD);
                    }
                    produtos[i][2] = situacao.toUpperCase();
                }
            }
        }       
        
        public void alterarEstoque() {
            Scanner scan = new Scanner(System.in);
            
            String codigo = getCodigo();
            System.out.print("\n Alterar estoque: \n1.Adicionar\n2.Subtrair\n");
            int op = scan.nextInt();
            
                System.out.print("Digite a quantidade : ");
                int add_estoque = scan.nextInt();
                
             for(int i = 0; i < produtos.length; i++) {
                if(codigo.equals(produtos[i][0])){
                    int valor_estoque = Integer.parseInt(produtos[i][4]);
                    if(op == 1) valor_estoque = valor_estoque + add_estoque;
                    if(op == 2) valor_estoque = valor_estoque - add_estoque;
                    produtos[i][4] = Integer.toString(valor_estoque);
                }
                }
        }
}

