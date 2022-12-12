import java.util.Scanner;
public class Projeto {public static void main(String[] args) {
    char[][] tabuleiro = tabuleiro();
    boolean jogoFinalizado = false;
    boolean velha = false;
    char jogador = 'o';
    int qtdJogadas = 0;

    do{
        System.out.printf("Quem vai jogar agora é o jogador: %s.\n", jogador);
        System.out.print("    a   b   c   \n");
        for(int i = 0; i < 3; i++){
            System.out.printf("%d | %s | %s | %s \n", i + 1, tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]);
        }
        int horizontal;
        int vertical = 0;
        String entrada = respostaUsuario();
        horizontal = switch(entrada.charAt(0)){
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            default -> -1;
        };
        try{
            vertical = switch(entrada.charAt(1)){
                case '1' -> 0;
                case '2' -> 1;
                case '3' -> 2;
                default -> -1;
            };
        } catch (Exception e){
            System.out.println("Você tem que digitar duas posições para poder jogar! Ex: b3");
        }
        if(horizontal == -1 || vertical == -1){
            System.out.printf("Posição inválida! \n");
        } else if(tabuleiro[vertical][horizontal] != '_') {
            System.out.println("Esse espaço já está ocupado!");
        } else {
            qtdJogadas++;
            tabuleiro[vertical][horizontal] = jogador;
            if(tabuleiro[0][0] != '_' && tabuleiro[0][0] == tabuleiro[0][1] &&
                    tabuleiro[0][1] == tabuleiro[0][2]){
                System.out.println("Vitória na primeira linha.");
                jogoFinalizado = true;
            } else if(tabuleiro[1][0] != '_' && tabuleiro[1][0] == tabuleiro[1][1] &&
                    tabuleiro[1][1] == tabuleiro[1][2]){
                System.out.println("Vitória na segunda linha.");
                jogoFinalizado = true;
            } else if(tabuleiro[2][0] != '_' && tabuleiro[2][0] == tabuleiro[2][1] &&
                    tabuleiro[2][1] == tabuleiro[2][2]){
                System.out.println("Vitória na terceira linha.");
                jogoFinalizado = true;
            } else if(tabuleiro[0][0] != '_' && tabuleiro[0][0] == tabuleiro[1][0] &&
                    tabuleiro[1][0] == tabuleiro[2][0]) {
                System.out.println("Vitória na primeira coluna.");
                jogoFinalizado = true;
            } else if(tabuleiro[0][1] != '_' && tabuleiro[0][1] == tabuleiro[1][1] &&
                    tabuleiro[1][1] == tabuleiro[2][1]) {
                System.out.println("Vitória na segunda coluna.");
                jogoFinalizado = true;
            } else if(tabuleiro[0][2] != '_' && tabuleiro[0][2] == tabuleiro[1][2] &&
                    tabuleiro[1][2] == tabuleiro[2][2]) {
                System.out.println("Vitória na terceira coluna.");
                jogoFinalizado = true;
            } else if(tabuleiro[0][0] != '_' && tabuleiro[0][0] == tabuleiro[1][1] &&
                    tabuleiro[1][1] == tabuleiro[2][2]){
                System.out.println("Vitória na primeira diagonal.");
                jogoFinalizado = true;
            } else if(tabuleiro[2][2] != '_' && tabuleiro[2][2] == tabuleiro[1][1] &&
                    tabuleiro[1][1] == tabuleiro[0][2]){
                System.out.println("Vitória na ultima diagonal.");
                jogoFinalizado = true;
            } else if(qtdJogadas == 9){
                System.out.println("Deu velha! Não houveram vencedores.");
                jogoFinalizado = true;
                velha = true;
            } else{
                if(jogador == 'o'){
                    jogador = 'x';
                } else{
                    jogador = 'o';
                }
            }
        }
    } while(!jogoFinalizado);
    System.out.print("   a   b   c   \n");
    for(int i = 0; i < 3; i++){
        System.out.printf("%d | %s | %s | %s \n", i + 1, tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]);
    }
    if(!velha){
        System.out.printf("O jogador vencedor foi: %s.", jogador);
    }
}
    static char[][] tabuleiro(){
        char[][] tabuleiro = new char[3][3];
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = '_';
            }
        }
        return tabuleiro;
    }
    static String respostaUsuario(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a posição que quer jogar: (ex: a1) ");
        String entrada = ler.nextLine().trim();
        entrada = entrada.toLowerCase();
        return entrada;
    }
}
