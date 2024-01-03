import java.util.Scanner;

/*

OBSERVAÇÕES

1. Vamos desenvolver a funcionalidade de voltar jogada.


*/

public class JogoDaVelha {

    char[][] tabuleiro = new char[3][3];
    Scanner scanner = new Scanner(System.in);
    boolean jogoEmAndamento = true;
    int jogadas = 0;

    public JogoDaVelha(){

        for(int i =0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tabuleiro[i][j]=' ';

            }
        }
    }


    public void jogarJogo(){
                    
            do {
                desenhoTabuleiro();
                System.out.println(jogadas);
                entradaJogadorX();
        
                // Verifica se o jogador X venceu
                if (verificarVitoria()) {
                    System.out.println("Jogador X venceu!");
                    break;
                }
        
                if (jogadas == 9) {
                    desenhoTabuleiro();
                    System.out.println("Empate!");
                    break;
                }
        
                desenhoTabuleiro();
                System.out.println(jogadas);
                entradaJogadorO();
        
                // Verifica se o jogador O venceu
                if (verificarVitoria()) {
                    System.out.println("Jogador O venceu!");
                    break;
                }
        
                if (jogadas == 9) {
                    System.out.println("Empate!");
                    break;
                }
            } while (jogoEmAndamento);
        }
        

    public void entradaJogadorO() {
        int linhaO;
        int colunaO;
    
        do {
            System.out.println("Jogador O, escolha uma linha:");
            linhaO = scanner.nextInt();
    
            System.out.println("Jogador O, escolha uma coluna:");
            colunaO = scanner.nextInt();
    
            if (tabuleiro[linhaO][colunaO] == ' ') {
                jogadorO(linhaO, colunaO);
                jogadas ++;
            } else {
                System.out.println("Essa posição já está ocupada. Tente novamente.");
                entradaJogadorO();

            }
        } while (tabuleiro[linhaO][colunaO] == ' ');
    }
    

    public void entradaJogadorX() {
        int linhaX;
        int colunaX;
    
        do {
            System.out.println("Jogador X, escolha uma linha:");
            linhaX = scanner.nextInt();
    
            System.out.println("Jogador X, escolha uma coluna:");
            colunaX = scanner.nextInt();
    
            if (tabuleiro[linhaX][colunaX] == ' ') {
                jogadorX(linhaX, colunaX);
                jogadas ++;
            } else {
                System.out.println("Essa posição já está ocupada. Tente novamente.");
                entradaJogadorX();
            
            }
        } while (tabuleiro[linhaX][colunaX] == ' ');
    }


    public void jogadorX(int linha, int coluna){
        if(tabuleiro[linha][coluna]== ' '){
            tabuleiro[linha][coluna]='X';
            verificarVitoria();
            if(verificarVitoria()){
                jogoEmAndamento=false;
            }
        }else{
            System.out.println("Essa posição já está ocupada. Tente novamente.");
            
        }
    }


    public void jogadorO(int linha, int coluna){
        if(tabuleiro[linha][coluna]== ' '){
            tabuleiro[linha][coluna]='O';
            verificarVitoria();
            if(verificarVitoria()){
                jogoEmAndamento=false;
            }
        }else{
            System.out.println("Essa posição já está ocupada. Tente novamente.");
            
        }
    }


    public void desenhoTabuleiro(){

        System.out.println("  " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | "+ tabuleiro[0][2] + "  ");
        System.out.println("-------------");
        System.out.println("  " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | "+ tabuleiro[1][2] + "  ");
        System.out.println("-------------");
        System.out.println("  " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | "+ tabuleiro[2][2] + "  ");
        

    }

    public boolean verificarVitoria() {
        // Verificação de linhas horizontais
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
                return true;
            }
        }
        
        // Verificação de colunas verticais
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j] && tabuleiro[0][j] != ' ') {
                return true;
            }
        }
        
        // Verificação de diagonal principal
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ') {
            return true;
        }
        
        // Verificação de diagonal secundária
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ') {
            return true;
        }
        
        return false;

        
        
    }
    

}